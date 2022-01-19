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

		// ȭ�鿡�� �Խñ� ��ȣ�� ���´�
		String num = request.getParameter("num");

		// �Խñ� ��ȸ���� ������Ų��
		BoardDAO bDao = BoardDAO.getInstance();
		bDao.updateReadCount(num);

		// �Խñ� ������ ��ȸ
		BoardVO board = bDao.selectOneBoardByNum(num);
		
		request.setAttribute("board", board);
		request.getRequestDispatcher(url).forward(request, response);

	}

}