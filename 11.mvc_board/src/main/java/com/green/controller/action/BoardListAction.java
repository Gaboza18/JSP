package com.green.controller.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.green.dao.BoardDAO;
import com.green.dto.BoardVO;

public class BoardListAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		BoardDAO bDao = BoardDAO.getInstance();
		String url = "board/boardList.jsp";
		
		/*
		 *  DB���� ��ü �Խñ� ��ȸ
		 */
		
		List<BoardVO> boardList = bDao.selectAllBoards();
		
		request.setAttribute("boardList", boardList);
		request.getRequestDispatcher(url).forward(request,response);
		
	}

}
