package com.green.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.green.dao.MemberDAO;

/**
 * Servlet implementation class idCheckServlet
 */
@WebServlet("/idCheck.do")
public class idCheckServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public idCheckServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		/*
		 *  1. 화면에서 입력 파라미터 읽어온다.
		 *  2. 사용자ID를 가지고 DB에서 조회: confirmID() 사용
		 *  3. request 내장객체에 userid, result를 저장
		 *  4. member/idCheck.jsp forward
		 *  
		 */
			request.setCharacterEncoding("UTF-8");
			String url = "member/idCheck.jsp";
			
		// 1번
			String userid = request.getParameter("userid");
		// 2번
			MemberDAO mDao = MemberDAO.getInstance(); // 객체 호출
			int result = mDao.confirmID(userid);	
		// 3번	
			request.setAttribute("userid", userid);
			request.setAttribute("result", result);
		// 4번
			RequestDispatcher rd = request.getRequestDispatcher(url);
			rd.forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
