package com.green.controller;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.green.dao.MovieDAO;
import com.green.dto.MovieVO;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

/**
 * Servlet implementation class MovieUpdateServlet
 */
@WebServlet("/movie_update.do")
public class MovieUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public MovieUpdateServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String url = "movie/movieUpdate.jsp";

		String code = request.getParameter("code");

		MovieDAO mDao = MovieDAO.getInstance();
		MovieVO movie = mDao.selectMovieByCode(code);

		request.setAttribute("movie", movie);

		request.getRequestDispatcher(url).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");

		ServletContext context = getServletContext();
		String savePath = "upload"; // ���ε� ������ ������ ��Ŭ���� ���� ������
		int uploadFileSize = 5 * 1024 * 1024; // ���ε� ����ũ�� ����: 5MB
		String encType = "UTF-8"; // ���ڵ� Ÿ��

		String uploadFilePath = context.getRealPath(savePath);
		System.out.println("���� ���ε����� ���: " + uploadFilePath);

		MultipartRequest multi = new MultipartRequest(request, uploadFilePath, uploadFileSize, encType,
				new DefaultFileRenamePolicy());

		MovieVO movie = new MovieVO();

		movie.setCode(Integer.parseInt(multi.getParameter("code")));
		movie.setTitle(multi.getParameter("title"));
		movie.setPrice(Integer.parseInt(multi.getParameter("price")));
		movie.setDirector(multi.getParameter("director"));
		movie.setActor(multi.getParameter("actor"));
		movie.setSynopsis(multi.getParameter("synopsis"));

		String poster = multi.getFilesystemName("poster");

		if (poster == null) {
			movie.setPoster(multi.getParameter("noupdateImg"));
		} else {
			movie.setPoster(poster);
		}

		MovieDAO pDao = MovieDAO.getInstance();
		pDao.updateMovie(movie);

		response.sendRedirect("movie_list.do");

	}

}