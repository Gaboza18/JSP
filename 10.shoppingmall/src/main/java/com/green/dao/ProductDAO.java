package com.green.dao;

import java.sql.*;
import java.util.*;
import com.green.dto.*;

import util.DBManager;

public class ProductDAO {

	private ProductDAO() { // 싱글톤 생성자
	}

	private static ProductDAO instance = new ProductDAO();

	public static ProductDAO getInstance() {
		return instance;
	}

	/*
	 * 상품목록 전체를 조회
	 */

	public List<ProductVO> selectAllProduct() {

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String sql = "SELECT * FROM product ORDER BY name";

		// 상품목록 저장을 위한 변수 생성
		List<ProductVO> productList = new ArrayList<ProductVO>();

		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);

			rs = pstmt.executeQuery();

			while (rs.next()) {

				// 개별제품 정보를 ProductVO 변수에 담는다.
				ProductVO product = new ProductVO();

				product.setCode(rs.getInt("code"));
				product.setName(rs.getString("name"));
				product.setPrice(rs.getInt("price"));
				product.setDescription(rs.getString("description"));
				product.setPictureurl(rs.getString("pictureurl"));

				productList.add(product);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}

		return productList;
	}

	/*
	 * 상품 등록하기
	 */

	public void insertProduct(ProductVO product) {

		Connection conn = null;
		PreparedStatement pstmt = null;

		String sql = "INSERT INTO product VALUES(product_seq.NEXTVAL,?,?,?,?)"; // 첫번째는 시퀀스 값

		try {

			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, product.getName());
			pstmt.setInt(2, product.getPrice());
			pstmt.setString(3, product.getPictureurl());
			pstmt.setString(4, product.getDescription());

			pstmt.executeUpdate(); // SQL문 수행

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}
	}

	public ProductVO selectProductByCode(String code) {

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ProductVO product = new ProductVO();

		String sql = "SELECT * FROM product WHERE code=?";

		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, Integer.parseInt(code));

			rs = pstmt.executeQuery();

			while (rs.next()) {

				product.setCode(rs.getInt("code"));
				product.setName(rs.getString("name"));
				product.setPrice(rs.getInt("price"));
				product.setDescription(rs.getString("description"));
				product.setPictureurl(rs.getString("pictureurl"));

			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}

		return product;

	}

	public void upadteProduct(ProductVO product) {

		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "UPDATE product SET name=?, price=?, pictureurl=?, " + "description=? WHERE code=?";

		try {

			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, product.getName());
			pstmt.setInt(2, product.getPrice());
			pstmt.setString(3, product.getPictureurl());
			pstmt.setString(4, product.getDescription());
			pstmt.setInt(5, product.getCode());

			pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}
	}

	public void deleteProduct(String code) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "DELETE FROM product WHERE code=?";

		try {

			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, code);

			pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}
	}
}
