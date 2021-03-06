package com.green.controller;

import com.green.controller.action.*;

/*
 *  command의 내용에 따라 Action 클래스를 찾아 액션 객체를 생성해 주는 클래스
 *  싱글톤 클래스로 구현 
 */

public class ActionFactory {

	private ActionFactory() { // 싱글톤 생성자
	}

	private static ActionFactory instance = new ActionFactory(); // 인스턴스 생성

	public static ActionFactory getInstance() {
		return instance;
	}

	/*
	 * command의 내용에 따라 Action 객체 생성
	 */

	public Action getAction(String command) {

		Action action = null;

		System.out.println("ActionFactory: " + command);

		if (command.equals("board_list")) { // 게시물 조회
			action = new BoardListAction();
		} else if (command.equals("board_write_form")) { // 게시물 입력
			action = new BoardWriteFormAction();
		} else if (command.equals("board_write")) { // 게시물 등록
			action = new BoardWriteAction();
		} else if (command.equals("board_view")) { // 게시물 조회 및 조회수++
			action = new BoardViewAction();
		} else if (command.equals("board_check_pass_form")) { // 게시물 수정 확인하는 페이지
			action = new BoardCheckPassFormAction();
		} else if (command.equals("board_check_pass")) { // 게시물 수정 하기 위한 비밀번호 확인
			action = new BoardCheckPassAction();
		} else if (command.equals("board_update_form")) { // 게시물 업데이트 하는 페이지
			action = new BoardUpdateFormAction();
		} else if (command.equals("board_update")) { // 게시물 업데이트
			action = new BoardUpdateAction();
		} else if (command.equals("board_delete")) { // 게시물 삭제
			action = new BoardDeleteAction();
		}

		return action;
	}
}
