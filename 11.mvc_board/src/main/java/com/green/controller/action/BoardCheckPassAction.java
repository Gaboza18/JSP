package com.green.controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.green.dao.BoardDAO;
import com.green.dto.BoardVO;

public class BoardCheckPassAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String num = request.getParameter("num");
		String pass = request.getParameter("pass");
		String url = "";

		BoardDAO bDao = BoardDAO.getInstance();
		BoardVO board = bDao.selectOneBoardByNum(num);

		// ȭ�鿡�� �Է��� ��й�ȣ�� DB ���̺��� ��й�ȣ�� ��ġ�ϴ��� Ȯ��
		if (pass.equals(board.getPass())) { // ��й�ȣ ��ġ
			url = "board/checkSuccess.jsp";
		} else {
			request.setAttribute("message", "��й�ȣ�� ��ġ���� �ʽ��ϴ�!");
			url = "board/boardCheckPass.jsp";
		}

		request.getRequestDispatcher(url).forward(request, response);

	}

}