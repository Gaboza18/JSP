package com.green.controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.green.dao.BoardDAO;
import com.green.dto.BoardVO;

public class BoardUpdateAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		BoardVO board = new BoardVO();

		board.setNum(Integer.parseInt(request.getParameter("num")));
		board.setName(request.getParameter("name"));
		board.setEmail(request.getParameter("email"));
		board.setPass(request.getParameter("pass"));
		board.setTitle(request.getParameter("title"));
		board.setContent(request.getParameter("content"));

		BoardDAO bDao = BoardDAO.getInstance();
		bDao.updateBoard(board);

		// 게시글 목록 확인
		new BoardListAction().execute(request, response);

	}

}
