package com.green.dao;

import java.sql.*;
import javax.naming.*;
import javax.sql.*;

import com.green.dto.MemberVO;

public class MemberDAO { // DB �����͸� VO ��ü�� �����ų� VO ��ü�� ����� ���� DB�� �߰�

	// �̱��� Ŭ������ �ܺο��� ��ü�� �������� ���ϵ��� �����ڸ� private�� ����
	private MemberDAO() {
	}

	// ���������� ��ü�� ������ �д�
	private static MemberDAO instance = new MemberDAO();

	// ���ο��� ������ �ν��Ͻ��� �ܺο� �����ϴ� �޼ҵ�
	public static MemberDAO getInstance() {
		return instance;
	}

	// DB ������ �����ϴ�(DBCP �̿�) �޼ҵ�
	public Connection getConnection() throws Exception {

		// JNDI �ʱ�ȭ(��ü ����)
		Context initContext = new InitialContext();

		// lookup() - ������ �̸����� ��ϵ� ���� �ڿ��� ã�� �� ���
		Context envContext = (Context) initContext.lookup("java:/comp/env");

		// JDBC ���� ���� ���(resource name="jdbc/myoracle")
		DataSource ds = (DataSource) envContext.lookup("jdbc/myoracle");
		Connection conn = ds.getConnection();

		return conn;
	}

	/*
	 * ����� ���� �޼ҵ� ���ϰ�: ���̵� �������� ������ -1, ���� ������ 0, ���̵�� ��й�ȣ�� ���������� 1 ��ȯ
	 */

	public int userCheck(String userid, String pwd) { 

		Connection conn = null; // DB�� ����
		PreparedStatement pstmt = null; //PreparedStatement ����� ����ϱ� ���� �ʱ�ȭ
		ResultSet rs = null;
		
		int result = 0; // ��� ���� ����

		String sql = "SELECT pwd FROM member WHERE userid=?"; // DB���� ������ SQL��

		try {

			// DB�� ���� ����
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);

			// ?�� �Է� ���� ����(binding)
			pstmt.setString(1, userid);

			// �ϼ��� SQL�� ����
			rs = pstmt.executeQuery();

			// userid�� �������� ��ȸ�ϸ� 1�ุ ���´ٰ� �����ϹǷ� while ��� if�� ���
			if (rs.next()) { // ��ȸ��� ��ȸ

				// ��ȸ������� ��й�ȣ�� ������
				String pwd_in_db = rs.getString("pwd");

				if (pwd.equals(pwd_in_db)) { // ���̺� pwd�� �Է��� pwd ��
					result = 1; // userid �� pwd�� ��� ��ġ�ϴ°��

				} else {
					result = 0; // ��ȣ�� Ʋ��
				}

			} else { // ��ȸ��� ����
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

	// ���̵�� ȸ������ ��������

	public MemberVO getMember(String userid) {

		Connection conn = null; // DB�� ����
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		MemberVO member = null; // MemberVO ��ü ����

		String sql = "SELECT * FROM member WHERE userid=?"; // �Է��� ID���� ���̺��� ã�� �����Ѱ� ������ ȸ������ ��� ��ȸ

		try {
			// DB�� ���� ����
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);

			// ?�� �Է� ���� ����(binding)
			pstmt.setString(1, userid); // ȸ������ �ϳ��� �����Ѵ�

			// �ϼ��� SQL�� ����
			rs = pstmt.executeQuery();

			if (rs.next()) {

				member = new MemberVO(); // MemberVO ��ü ���� ����

				member.setName(rs.getString("name")); // getString("���̺� �÷� ����")
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
	 * ȸ�����Խ�, ���̵� �ߺ� üũ�� ���� ���
	 */
	public int confirmID(String userid) {

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String sql = "SELECT * FROM member WHERE userid=?";
		int result = -1; // ��ȯ�� �ʱⰪ -1�� �ʱ�ȭ

		try {

			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userid);

			rs = pstmt.executeQuery();

			if (rs.next()) { // userid�� �������� ����ڰ� ������
				return 1; // ������ id�� ������
			} else {
				return -1; // ������ id�� ������
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
	 * ȸ������ ȭ�鿡�� ������ �����͸� member ���̺� �����Ѵ�
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

			result = pstmt.executeUpdate(); // SQL�� ����

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
