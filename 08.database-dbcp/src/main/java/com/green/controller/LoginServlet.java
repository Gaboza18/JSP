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

		String url = "member/login.jsp"; // ����ڰ� ��û�� JSP ������(�α��� ��)�� url ������ �����Ѵ�
		
		// �̹� �α��ε� ������̸� main.jsp�� ������ �̵�
		HttpSession session = request.getSession();
		MemberVO member = (MemberVO) session.getAttribute("loginUser");
		
		if(member != null) {
			url = "main.jsp";
		}
		
		
		
		RequestDispatcher rd = request.getRequestDispatcher(url); // ��û�� �������� Dispatcher�� ���� �ѱ��
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String url = "member/login.jsp"; // �α��� ����������� �ٽ� �α���â
		request.setCharacterEncoding("UTF-8"); //post ����� ��� �ѱ��� �Է¹ޱ� ���� ����

		// ȭ�鿡�� �Է��� �Ķ���� �о����(����ڰ� �Է��� ����)
		String userid = request.getParameter("userid"); // ����ڰ� �Է��� '���̵�'�� 
		String userpwd = request.getParameter("userpwd"); // ����ڰ� �Է��� '��ȣ' ��

		MemberDAO mDao = MemberDAO.getInstance(); // ��ü ȣ��(MemberDAO Ÿ���� mDao ������ �ν��Ͻ� ��ü ȣ���Ѱ� �����Ѵ�)
		int result = mDao.userCheck(userid, userpwd); // userCheck() �޼ҵ� ȣ���Ͽ� ������� �����Ѵ�

		if (result == 1) {
			System.out.println("�α��� ����!");

			// ���� �α��� �� ����� ���� ��ȸ
			MemberVO member = mDao.getMember(userid); // MemberVO Ÿ���� member ������ ����� ���� ����

			// ���� ���尴ü�� ����� ���� ����
			HttpSession session = request.getSession();
			session.setAttribute("loginUser", member);

			// ���� ������ ����(���� �α��ν�)
			url = "main.jsp";

		} else if (result == 0) {
			// System.out.println("��й�ȣ�� ��ġ ���� �ʽ��ϴ�!");
			request.setAttribute("message", "��й�ȣ�� ��ġ ���� �ʽ��ϴ�!"); // ${message}
		} else if (result == -1) {
			request.setAttribute("message", "����� ���̵� �������� �ʽ��ϴ�!"); // ${message}
		}

		request.getRequestDispatcher(url).forward(request, response); // �����϶�:"main.jsp", ������: "member/login.jsp" �ѱ��
	}

}
