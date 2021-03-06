package com.green.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.green.dto.MovieVO;

import util.DBManager;

public class MovieDAO {

	private MovieDAO() { // 싱글톤 생성자
	}

	private static MovieDAO instance = new MovieDAO();

	public static MovieDAO getInstance() {
		return instance;
	}

	/*
	 * 영화 목록 전체 조회
	 */

	public List<MovieVO> selectAllMovie() {

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String sql = "SELECT * FROM movie ORDER BY title";

		List<MovieVO> movieList = new ArrayList<MovieVO>();

		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);

			rs = pstmt.executeQuery();

			while (rs.next()) {

				MovieVO movie = new MovieVO();

				movie.setCode(rs.getInt("code"));
				movie.setTitle(rs.getString("title"));
				movie.setPrice(rs.getInt("price"));
				movie.setDirector(rs.getString("director"));
				movie.setActor(rs.getString("actor"));
				movie.setPoster(rs.getString("poster"));
				movie.setSynopsis(rs.getString("synopsis"));

				movieList.add(movie);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}

		return movieList;
	}

	/*
	 * 영화정보 등록하기
	 */
	public void insertMovie(MovieVO movie) {

		Connection conn = null;
		PreparedStatement pstmt = null;

		String sql = "INSERT INTO movie VALUES(product_seq.NEXTVAL,?,?,?,?,?,?)";

		try {

			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, movie.getTitle());
			pstmt.setInt(2, movie.getPrice());
			pstmt.setString(3, movie.getDirector());
			pstmt.setString(4, movie.getActor());
			pstmt.setString(5, movie.getPoster());
			pstmt.setString(6, movie.getSynopsis());

			pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}
	}

	public MovieVO selectMovieByCode(String code) {

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		MovieVO movie = new MovieVO();

		String sql = "SELECT * FROM movie WHERE code=?";

		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, Integer.parseInt(code));

			rs = pstmt.executeQuery();

			while (rs.next()) {

				movie.setCode(rs.getInt("code"));
				movie.setTitle(rs.getString("title"));
				movie.setPrice(rs.getInt("price"));
				movie.setDirector(rs.getString("director"));
				movie.setActor(rs.getString("actor"));
				movie.setPoster(rs.getString("poster"));
				movie.setSynopsis(rs.getString("synopsis"));

			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}

		return movie;
	}

	public void updateMovie(MovieVO movie) {

		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "UPDATE movie SET title=?, price=?, director=?, " + "actor=?, poster=?,synopsis=? WHERE code=?";

		try {

			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, movie.getTitle());
			pstmt.setInt(2, movie.getPrice());
			pstmt.setString(3, movie.getDirector());
			pstmt.setString(4, movie.getActor());
			pstmt.setString(5, movie.getPoster());
			pstmt.setString(6, movie.getSynopsis());
			pstmt.setInt(7, movie.getCode());
			
			pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}
	}
}
