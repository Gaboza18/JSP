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

		String num = request.getParameter("num"); // �Խñ� ��ȣ�� �о�´�

		BoardDAO bDao = BoardDAO.getInstance(); // �̱��� Ŭ������ ��ü �����´�
		bDao.deleteBoard(num);

		// �Խñ� ��� ���

		new BoardListAction().execute(request, response); // �Խù� ��ȸ�ϴ� �޼ҵ� �ҷ��´�

	}
}