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
		
		String url = "member/join.jsp"; // ȸ������ �Է� �� �ۼ��ϴ� ������
		
		RequestDispatcher rd = request.getRequestDispatcher(url); // ����ڰ� ��û�� ������ 
		rd.forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		MemberVO member = new MemberVO(); // ȸ������ ���� ����
		String url ="member/login.jsp"; // ȸ�������� ������ �α��� â���� ���ư���
		
		request.setCharacterEncoding("UTF-8"); // �ѱ��Է��� �ޱ� ���� ����
		
		// ȭ�� �Է� ������ member ��ü�� ����
		member.setName(request.getParameter("name")); // ȸ������ �ϱ� ���� �Է��ϴ� '�̸�'
		member.setUserid(request.getParameter("userid")); // ȸ������ �ϱ� ���� �Է��ϴ� '���̵�'
		member.setPwd(request.getParameter("pwd")); // ȸ������ �ϱ� ���� �Է��ϴ� '��й�ȣ'
		member.setEmail(request.getParameter("email")); // ȸ������ �ϱ� ���� �Է��ϴ� '�����ּ�'
		member.setPhone(request.getParameter("phone")); // ȸ������ �ϱ� ���� �Է��ϴ� '��ȭ��ȣ'
		member.setAdmin(Integer.parseInt(request.getParameter("admin"))); // ȸ����� ���������� ��ȯ(���ڷ� �Է¹ޱ� ����)
		
		MemberDAO mDao = MemberDAO.getInstance(); // MemberDAO �� �ν��Ͻ� �ҷ��� ������ ����
		int result = mDao.insertMember(member);
		
		if(result == 1) {
			HttpSession session = request.getSession();
			session.setAttribute("userid", member.getUserid());
			request.setAttribute("message", "ȸ������ ����!"); // ȸ�������� ������ �α��� �������� ����Ѵ�
		}else {
			request.setAttribute("message", "ȸ�����Կ� �����߽��ϴ�");
		}
		
		request.getRequestDispatcher(url).forward(request, response); // ȸ�������� ������ �α��� ������
	}

}
