package com.green.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.green.dao.MemberDAO;
import com.green.dto.MemberVO;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login.do")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String url = "member/login.jsp"; // 사용자가 요청할 JSP 페이지(로그인 폼)를 url 변수에 저장한다
		
		// 이미 로그인된 사용자이면 main.jsp로 페이지 이동
		HttpSession session = request.getSession();
		MemberVO member = (MemberVO) session.getAttribute("loginUser");
		
		if(member != null) {
			url = "main.jsp";
		}
		
		
		
		RequestDispatcher rd = request.getRequestDispatcher(url); // 요청할 페이지를 Dispatcher를 통해 넘긴다
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String url = "member/login.jsp"; // 로그인 실패했을경우 다시 로그인창
		request.setCharacterEncoding("UTF-8"); //post 방식일 경우 한글을 입력받기 위한 선언

		// 화면에서 입력한 파라미터 읽어오기(사용자가 입력할 내용)
		String userid = request.getParameter("userid"); // 사용자가 입력한 '아이디'값 
		String userpwd = request.getParameter("userpwd"); // 사용자가 입력한 '암호' 값

		MemberDAO mDao = MemberDAO.getInstance(); // 객체 호출(MemberDAO 타입의 mDao 변수에 인스턴스 객체 호출한걸 저장한다)
		int result = mDao.userCheck(userid, userpwd); // userCheck() 메소드 호출하여 결과값을 저장한다

		if (result == 1) {
			System.out.println("로그인 성공!");

			// 정상 로그인 시 사용자 정보 조회
			MemberVO member = mDao.getMember(userid); // MemberVO 타입의 member 변수에 사용자 정보 저장

			// 세션 내장객체에 사용자 정보 저장
			HttpSession session = request.getSession();
			session.setAttribute("loginUser", member);

			// 메인 페이지 오픈(정상 로그인시)
			url = "main.jsp";

		} else if (result == 0) {
			// System.out.println("비밀번호가 일치 하지 않습니다!");
			request.setAttribute("message", "비밀번호가 일치 하지 않습니다!"); // ${message}
		} else if (result == -1) {
			request.setAttribute("message", "사용자 아이디가 존재하지 않습니다!"); // ${message}
		}

		request.getRequestDispatcher(url).forward(request, response); // 정상일때:"main.jsp", 비정상: "member/login.jsp" 넘긴다
	}

}
