package com.green.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.green.dao.MemberDAO;
import com.green.dto.MemberVO;

/**
 * Servlet implementation class MemberUpdateServlet
 */
@WebServlet("/memberUpdate.do")
public class MemberUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public MemberUpdateServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// 회원정보 수정 메소드

		String url = "member/memberUpdate.jsp";

		String userid = request.getParameter("userid");

		MemberDAO mDao = MemberDAO.getInstance();
		MemberVO member = mDao.getMember(userid);

		request.setAttribute("member", member);
		request.getRequestDispatcher(url).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// 수정 요청의 처리
		/*
		 * (1) 수정 화면에서 입력한 회원 정보를 MemberVO 객체에 저장한다
		 * 
		 * (2) MemberDAO 객체를 생성하고 updateMember() 메소드를 호출하여 정보를 변경한다
		 * 
		 * (3) login.do로 페이지 전환
		 * 
		 */
		request.setCharacterEncoding("UTF-8");

		MemberVO updatemember = new MemberVO(); // MemberVO 객체 생성 (1)

		updatemember.setUserid(request.getParameter("userid"));
		updatemember.setName(request.getParameter("name"));
		updatemember.setPwd(request.getParameter("pwd"));
		updatemember.setEmail(request.getParameter("email"));
		updatemember.setPhone(request.getParameter("phone"));
		updatemember.setAdmin(Integer.parseInt(request.getParameter("admin")));

		MemberDAO mDao = MemberDAO.getInstance(); // (2)
		int result = mDao.updateMember(updatemember); // (2)

		// session 객체에 member 정보 업데이트
		if (result > 0) {
			HttpSession session = request.getSession();
			session.setAttribute("loginUser", updatemember);
		}

		// (3)
		response.sendRedirect("login.do"); // get 방식으로 LoginServlet에 요청 (3)

	}

}
