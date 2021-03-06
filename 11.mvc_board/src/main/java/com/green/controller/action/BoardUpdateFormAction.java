package com.green.controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.green.dao.BoardDAO;
import com.green.dto.BoardVO;

public class BoardUpdateFormAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String num = request.getParameter("num");
		String url = "board/boardUpdate.jsp";

		BoardDAO bDao = BoardDAO.getInstance();
		BoardVO board = bDao.selectOneBoardByNum(num);

		request.setAttribute("board", board);
		request.getRequestDispatcher(url).forward(request, response);

	}

}
