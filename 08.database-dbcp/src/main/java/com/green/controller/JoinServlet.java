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
 * Servlet implementation class JoinServlet
 */
@WebServlet("/join.do")
public class JoinServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public JoinServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String url = "member/join.jsp"; // 회원가입 입력 폼 작성하는 페이지
		
		RequestDispatcher rd = request.getRequestDispatcher(url); // 사용자가 요청한 페이지 
		rd.forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		MemberVO member = new MemberVO(); // 회원정보 저장 변수
		String url ="member/login.jsp"; // 회원가입이 끝나면 로그인 창으로 돌아간다
		
		request.setCharacterEncoding("UTF-8"); // 한글입력을 받기 위한 선언
		
		// 화면 입력 정보를 member 객체에 저장
		member.setName(request.getParameter("name")); // 회원가입 하기 위해 입력하는 '이름'
		member.setUserid(request.getParameter("userid")); // 회원가입 하기 위해 입력하는 '아이디'
		member.setPwd(request.getParameter("pwd")); // 회원가입 하기 위해 입력하는 '비밀번호'
		member.setEmail(request.getParameter("email")); // 회원가입 하기 위해 입력하는 '메일주소'
		member.setPhone(request.getParameter("phone")); // 회원가입 하기 위해 입력하는 '전화번호'
		member.setAdmin(Integer.parseInt(request.getParameter("admin"))); // 회원등급 숫자형으로 변환(문자로 입력받기 떄문)
		
		MemberDAO mDao = MemberDAO.getInstance(); // MemberDAO 의 인스턴스 불러와 변수에 저장
		int result = mDao.insertMember(member);
		
		if(result == 1) {
			HttpSession session = request.getSession();
			session.setAttribute("userid", member.getUserid());
			request.setAttribute("message", "회원가입 성공!"); // 회원가입이 끝나고 로그인 페이지에 출력한다
		}else {
			request.setAttribute("message", "회원가입에 실패했습니다");
		}
		
		request.getRequestDispatcher(url).forward(request, response); // 회원가입이 끝나고 로그인 페이지
	}

}
