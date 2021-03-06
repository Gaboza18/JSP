package com.green.controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.green.dao.BoardDAO;

public class BoardDeleteAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String url = "board/boardDelete.jsp";

		String num = request.getParameter("num"); // 게시글 번호를 읽어온다

		BoardDAO bDao = BoardDAO.getInstance(); // 싱글톤 클래스의 객체 가져온다
		bDao.deleteBoard(num);

		// 게시글 목록 출력

		new BoardListAction().execute(request, response); // 게시물 조회하는 메소드 불러온다

	}
}