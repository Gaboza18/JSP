package com.green.controller;

import com.green.controller.action.*;

/*
 *  command�� ���뿡 ���� Action Ŭ������ ã�� �׼� ��ü�� ������ �ִ� Ŭ����
 *  �̱��� Ŭ������ ���� 
 */

public class ActionFactory {

	private ActionFactory() { // �̱��� ������
	}

	private static ActionFactory instance = new ActionFactory(); // �ν��Ͻ� ����

	public static ActionFactory getInstance() {
		return instance;
	}

	/*
	 * command�� ���뿡 ���� Action ��ü ����
	 */

	public Action getAction(String command) {

		Action action = null;

		System.out.println("ActionFactory: " + command);

		if (command.equals("board_list")) { // �Խù� ��ȸ
			action = new BoardListAction();
		} else if (command.equals("board_write_form")) { // �Խù� �Է�
			action = new BoardWriteFormAction();
		} else if (command.equals("board_write")) { // �Խù� ���
			action = new BoardWriteAction();
		} else if (command.equals("board_view")) { // �Խù� ��ȸ �� ��ȸ��++
			action = new BoardViewAction();
		} else if (command.equals("board_check_pass_form")) { // �Խù� ���� Ȯ���ϴ� ������
			action = new BoardCheckPassFormAction();
		} else if (command.equals("board_check_pass")) { // �Խù� ���� �ϱ� ���� ��й�ȣ Ȯ��
			action = new BoardCheckPassAction();
		} else if (command.equals("board_update_form")) { // �Խù� ������Ʈ �ϴ� ������
			action = new BoardUpdateFormAction();
		} else if (command.equals("board_update")) { // �Խù� ������Ʈ
			action = new BoardUpdateAction();
		} else if (command.equals("board_delete")) { // �Խù� ����
			action = new BoardDeleteAction();
		}

		return action;
	}
}