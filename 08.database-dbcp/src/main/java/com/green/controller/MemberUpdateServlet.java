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

		// ȸ������ ���� �޼ҵ�

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

		// ���� ��û�� ó��
		/*
		 * (1) ���� ȭ�鿡�� �Է��� ȸ�� ������ MemberVO ��ü�� �����Ѵ�
		 * 
		 * (2) MemberDAO ��ü�� �����ϰ� updateMember() �޼ҵ带 ȣ���Ͽ� ������ �����Ѵ�
		 * 
		 * (3) login.do�� ������ ��ȯ
		 * 
		 */
		request.setCharacterEncoding("UTF-8");

		MemberVO updatemember = new MemberVO(); // MemberVO ��ü ���� (1)

		updatemember.setUserid(request.getParameter("userid"));
		updatemember.setName(request.getParameter("name"));
		updatemember.setPwd(request.getParameter("pwd"));
		updatemember.setEmail(request.getParameter("email"));
		updatemember.setPhone(request.getParameter("phone"));
		updatemember.setAdmin(Integer.parseInt(request.getParameter("admin")));

		MemberDAO mDao = MemberDAO.getInstance(); // (2)
		int result = mDao.updateMember(updatemember); // (2)

		// session ��ü�� member ���� ������Ʈ
		if (result > 0) {
			HttpSession session = request.getSession();
			session.setAttribute("loginUser", updatemember);
		}

		// (3)
		response.sendRedirect("login.do"); // get ������� LoginServlet�� ��û (3)

	}

}
