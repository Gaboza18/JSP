package com.green.dao;

import java.sql.*;
import javax.naming.*;
import javax.sql.*;

import com.green.dto.MemberVO;

public class MemberDAO { // DB 데이터를 VO 객체로 얻어오거나 VO 객체에 저장된 값을 DB에 추가

	// 싱글톤 클래스는 외부에서 객체를 생성하지 못하도록 생성자를 private로 설정
	private MemberDAO() {
	}

	// 내부적으로 객체를 생성해 둔다
	private static MemberDAO instance = new MemberDAO();

	// 내부에서 생성한 인스턴스를 외부에 제공하는 메소드
	public static MemberDAO getInstance() {
		return instance;
	}

	// DB 연결을 수행하는(DBCP 이용) 메소드
	public Connection getConnection() throws Exception {

		// JNDI 초기화(객체 생성)
		Context initContext = new InitialContext();

		// lookup() - 지정된 이름으로 등록된 서비스 자원을 찾을 때 사용
		Context envContext = (Context) initContext.lookup("java:/comp/env");

		// JDBC 연결 서비스 등록(resource name="jdbc/myoracle")
		DataSource ds = (DataSource) envContext.lookup("jdbc/myoracle");
		Connection conn = ds.getConnection();

		return conn;
	}

	/*
	 * 사용자 인증 메소드 리턴값: 아이디가 존재하지 않으면 -1, 맞지 않으면 0, 아이디와 비밀번호가 맞지않으면 1 반환
	 */

	public int userCheck(String userid, String pwd) { 

		Connection conn = null; // DB에 연결
		PreparedStatement pstmt = null; //PreparedStatement 방식을 사용하기 위한 초기화
		ResultSet rs = null;
		
		int result = 0; // 결과 리턴 변수

		String sql = "SELECT pwd FROM member WHERE userid=?"; // DB에서 수행할 SQL문

		try {

			// DB에 연결 수행
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);

			// ?에 입력 내용 연결(binding)
			pstmt.setString(1, userid);

			// 완성된 SQL문 실행
			rs = pstmt.executeQuery();

			// userid를 조건으로 조회하면 1행만 나온다고 가정하므로 while 대신 if문 사용
			if (rs.next()) { // 조회결과 조회

				// 조회결과에서 비밀번호를 가져옴
				String pwd_in_db = rs.getString("pwd");

				if (pwd.equals(pwd_in_db)) { // 테이블 pwd와 입력한 pwd 비교
					result = 1; // userid 와 pwd가 모두 일치하는경우

				} else {
					result = 0; // 암호가 틀림
				}

			} else { // 조회결과 없음
				result = -1;
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		return result;
	}

	// 아이디로 회원정보 가져오기

	public MemberVO getMember(String userid) {

		Connection conn = null; // DB에 연결
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		MemberVO member = null; // MemberVO 객체 생성

		String sql = "SELECT * FROM member WHERE userid=?"; // 입력한 ID값을 테이블에서 찾아 동일한게 있으면 회원정보 모두 조회

		try {
			// DB에 연결 수행
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);

			// ?에 입력 내용 연결(binding)
			pstmt.setString(1, userid); // 회원정보 하나로 가정한다

			// 완성된 SQL문 실행
			rs = pstmt.executeQuery();

			if (rs.next()) {

				member = new MemberVO(); // MemberVO 객체 변수 생성

				member.setName(rs.getString("name")); // getString("테이블 컬럼 변수")
				member.setUserid(rs.getString("userid"));
				member.setPwd(rs.getString("pwd"));
				member.setPhone(rs.getString("phone"));
				member.setAdmin(rs.getInt("admin"));

			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return member;
	}

	/*
	 * 회원가입시, 아이디 중복 체크를 위해 사용
	 */
	public int confirmID(String userid) {

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String sql = "SELECT * FROM member WHERE userid=?";
		int result = -1; // 반환할 초기값 -1로 초기화

		try {

			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userid);

			rs = pstmt.executeQuery();

			if (rs.next()) { // userid를 조건으로 사용자가 존재함
				return 1; // 지정한 id가 있을때
			} else {
				return -1; // 지정한 id가 없을때
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}

		}
		return result;
	}

	/*
	 * 회원가입 화면에서 가져온 데이터를 member 테이블에 저장한다
	 */

	public int insertMember(MemberVO member) {

		Connection conn = null;
		PreparedStatement pstmt = null;
		int result = -1;

		String sql = "INSERT INTO member VALUES(?,?,?,?,?,?)";

		try {

			conn = getConnection();
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, member.getName());
			pstmt.setString(2, member.getUserid());
			pstmt.setString(3, member.getPwd());
			pstmt.setString(4, member.getEmail());
			pstmt.setString(5, member.getPhone());
			pstmt.setInt(6, member.getAdmin());

			result = pstmt.executeUpdate(); // SQL문 수행

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return result;
	}

	public int updateMember(MemberVO member) {

		Connection conn = null;
		PreparedStatement pstmt = null;
		int result = -1;

		String sql = "UPDATE member SET pwd=?, email=?," + " phone=?, admin=? WHERE userid=?";

		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, member.getPwd());
			pstmt.setString(2, member.getEmail());
			pstmt.setString(3, member.getPhone());
			pstmt.setInt(4, member.getAdmin());
			pstmt.setString(5, member.getUserid());

			result = pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return result;
	}
}
