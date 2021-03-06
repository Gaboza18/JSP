package com.green.dao;

import java.util.*;
import java.sql.*;
import com.green.dto.BoardVO;

import util.DBManager;

/*
 *  게시판 테이블에서 조회, 삽입, 수정을 수행하는 클래스
 */

// 싱글톤 생성
public class BoardDAO {

	private BoardDAO() { // 싱글톤 생성
	}

	private static BoardDAO instance = new BoardDAO(); // BoardDAO 타입의 instance 객체생성

	public static BoardDAO getInstance() {
		return instance;
	}

	/*
	 * 게시글 목록 조회(최근 등록한 게시글이 앞에 나옴)
	 */

	public List<BoardVO> selectAllBoards() { // 테이블의 내용을 리스트 형식으로 출력한다 List<테이블 내용 get,set> -> 테이블의 모든내용을 조회하는 메소드

		// 데이터 베이스 연결
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String sql = "SELECT * FROM board ORDER BY num DESC"; // 테이블 에서 실행할 SQL문(마지막에 작성한 게시물이 맨위로 올라오게)

		List<BoardVO> boardList = new ArrayList<BoardVO>(); // 결과값을 저장하기 위한 변수

		try {

			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);

			rs = pstmt.executeQuery(); // 조회 SQL문 쿼리

			while (rs.next()) { // 하나씩 조회한다

				BoardVO board = new BoardVO(); // 조회할 내용의 객체 선언

				board.setNum(rs.getInt("num"));
				board.setName(rs.getString("name"));
				board.setEmail(rs.getString("email"));
				board.setPass(rs.getString("pass"));
				board.setTitle(rs.getString("title"));
				board.setContent(rs.getString("content"));
				board.setReadcount(rs.getInt("readcount"));
				board.setWritedate(rs.getTimestamp("writedate"));

				boardList.add(board); // 조회내용을 저장한다
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		return boardList;
	}

	/*
	 * 게시글 입력 정보를 DB에 저장
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
	 * 게시글 클릭시 상세보기 + 조회수 증가 입력 파라메터: num : 게시글 번호
	 */

	public void updateReadCount(String num) {

		Connection conn = null;
		PreparedStatement pstmt = null;

		String sql = "UPDATE board SET readcount=readcount+1 WHERE num=?"; // 게시글 번호가 들어오면 조회수 +1 업데이트

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
	 * 게시글 번호를 조건으로 게시글 한건 조회
	 */

	public BoardVO selectOneBoardByNum(String num) {

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String sql = "SELECT * FROM board WHERE num=?"; // 테이블 에서 실행할 SQL문
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
	 * 게시글 수정(게시글 번호와 비밀번호가 일치하는 게시글을 테이블에서 조회)
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
	 * 게시글 삭제
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
