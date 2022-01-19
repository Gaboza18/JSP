package com.green.dao;

import java.util.*;
import java.sql.*;
import com.green.dto.BoardVO;

import util.DBManager;

/*
 *  �Խ��� ���̺��� ��ȸ, ����, ������ �����ϴ� Ŭ����
 */

// �̱��� ����
public class BoardDAO {

	private BoardDAO() { // �̱��� ����
	}

	private static BoardDAO instance = new BoardDAO(); // BoardDAO Ÿ���� instance ��ü����

	public static BoardDAO getInstance() {
		return instance;
	}

	/*
	 * �Խñ� ��� ��ȸ(�ֱ� ����� �Խñ��� �տ� ����)
	 */

	public List<BoardVO> selectAllBoards() { // ���̺��� ������ ����Ʈ �������� ����Ѵ� List<���̺� ���� get,set> -> ���̺��� ��系���� ��ȸ�ϴ� �޼ҵ�

		// ������ ���̽� ����
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String sql = "SELECT * FROM board ORDER BY num DESC"; // ���̺� ���� ������ SQL��(�������� �ۼ��� �Խù��� ������ �ö����)

		List<BoardVO> boardList = new ArrayList<BoardVO>(); // ������� �����ϱ� ���� ����

		try {

			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);

			rs = pstmt.executeQuery(); // ��ȸ SQL�� ����

			while (rs.next()) { // �ϳ��� ��ȸ�Ѵ�

				BoardVO board = new BoardVO(); // ��ȸ�� ������ ��ü ����

				board.setNum(rs.getInt("num"));
				board.setName(rs.getString("name"));
				board.setEmail(rs.getString("email"));
				board.setPass(rs.getString("pass"));
				board.setTitle(rs.getString("title"));
				board.setContent(rs.getString("content"));
				board.setReadcount(rs.getInt("readcount"));
				board.setWritedate(rs.getTimestamp("writedate"));

				boardList.add(board); // ��ȸ������ �����Ѵ�
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		return boardList;
	}

	/*
	 * �Խñ� �Է� ������ DB�� ����
	 */

	public void insertBoard(BoardVO board) {

		Connection conn = null;
		PreparedStatement pstmt = null;

		String sql = "INSERT INTO board(num, pass, email, name, title, content) "
				+ "VALUES(board_seq.NEXTVAL,?,?,?,?,?)";

		try {

			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, board.getPass());
			pstmt.setString(2, board.getEmail());
			pstmt.setString(3, board.getName());
			pstmt.setString(4, board.getTitle());
			pstmt.setString(5, board.getContent());

			pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}
	}

	/*
	 * �Խñ� Ŭ���� �󼼺��� + ��ȸ�� ���� �Է� �Ķ����: num : �Խñ� ��ȣ
	 */

	public void updateReadCount(String num) {

		Connection conn = null;
		PreparedStatement pstmt = null;

		String sql = "UPDATE board SET readcount=readcount+1 WHERE num=?"; // �Խñ� ��ȣ�� ������ ��ȸ�� +1 ������Ʈ

		try {

			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, num);

			pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}
	}

	/*
	 * �Խñ� ��ȣ�� �������� �Խñ� �Ѱ� ��ȸ
	 */

	public BoardVO selectOneBoardByNum(String num) {

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String sql = "SELECT * FROM board WHERE num=?"; // ���̺� ���� ������ SQL��
		BoardVO board = new BoardVO();

		try {

			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, num);

			rs = pstmt.executeQuery();

			if (rs.next()) {

				board.setNum(rs.getInt("num"));
				board.setName(rs.getString("name"));
				board.setEmail(rs.getString("email"));
				board.setPass(rs.getString("pass"));
				board.setTitle(rs.getString("title"));
				board.setContent(rs.getString("content"));
				board.setReadcount(rs.getInt("readcount"));
				board.setWritedate(rs.getTimestamp("writedate"));

			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}

		return board;
	}

	/*
	 * �Խñ� ����(�Խñ� ��ȣ�� ��й�ȣ�� ��ġ�ϴ� �Խñ��� ���̺��� ��ȸ)
	 */
	public void updateBoard(BoardVO board) {

		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "UPDATE board SET pass=?, name=?, email=?, " 
		+ "title=?, content=? WHERE num=?";

		try {

			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, board.getPass());
			pstmt.setString(2, board.getName());
			pstmt.setString(3, board.getEmail());
			pstmt.setString(4, board.getTitle());
			pstmt.setString(5, board.getContent());
			pstmt.setInt(6, board.getNum());

			pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}
	}

	/*
	 * �Խñ� ����
	 */

	public void deleteBoard(String num) {

		Connection conn = null;
		PreparedStatement pstmt = null;
		
		String sql = "DELETE FROM board WHERE num=?";

		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, num);

			pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}
	}
}
