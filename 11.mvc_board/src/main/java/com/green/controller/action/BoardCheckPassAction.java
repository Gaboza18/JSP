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

		// 화면에서 입력한 비밀번호와 DB 테이블의 비밀번호가 일치하는지 확인
		if (pass.equals(board.getPass())) { // 비밀번호 일치
			url = "board/checkSuccess.jsp";
		} else {
			request.setAttribute("message", "비밀번호가 일치하지 않습니다!");
			url = "board/boardCheckPass.jsp";
		}

		request.getRequestDispatcher(url).forward(request, response);

	}

}
