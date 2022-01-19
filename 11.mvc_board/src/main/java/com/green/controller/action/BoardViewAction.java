package com.green.controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.green.dao.BoardDAO;
import com.green.dto.BoardVO;

public class BoardViewAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String url = "board/boardView.jsp";

		// 화면에서 게시글 번호를 얻어온다
		String num = request.getParameter("num");

		// 게시글 조회수를 증가시킨다
		BoardDAO bDao = BoardDAO.getInstance();
		bDao.updateReadCount(num);

		// 게시글 상세정보 조회
		BoardVO board = bDao.selectOneBoardByNum(num);
		
		request.setAttribute("board", board);
		request.getRequestDispatcher(url).forward(request, response);

	}

}
