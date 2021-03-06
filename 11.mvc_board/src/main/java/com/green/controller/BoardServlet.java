package com.green.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.green.controller.action.Action;

/**
 * Servlet implementation class BoardServlet
 */
@WebServlet("/BoardServlet")
public class BoardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public BoardServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String command = request.getParameter("command");
		System.out.println("BoardServlet 에서 요청 수신: " + command);
		
		/*
		 *  서블릿에서 받은 command를 ActionFactory에 전달하여 어떤 비즈니스 로직(Action 클래스)을 수행할지 결정한다
		 */
		ActionFactory factory = ActionFactory.getInstance(); // 싱글톤 객체
		Action action = factory.getAction(command);
		
		if(action != null) { // action 객체를 할당받았는지 체크
			action.execute(request, response); // 동일한 각 액션 클래스의 업무 로직을 수행
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		doGet(request, response);
	}

}
