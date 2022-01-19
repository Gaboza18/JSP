package com.green.javabeans;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MemberServlet
 */
@WebServlet("/MemberServlet")
public class MemberServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		MemberBean member = new MemberBean("�̼���","sslee");
		
		request.setAttribute("member", member); // �Ӽ�, ����
		
		RequestDispatcher rd = request.getRequestDispatcher("08_member_el.jsp"); // Ŭ���̾�Ʈ�κ��� ���ʷ� ���� ��û�� JSP ���Ϸ� ������ ���� ����
		rd.forward(request,response); // ������ ���� ��û�� Dispatcher �� JSP ���Ϸ� ��û����, ���� ���� ������
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
