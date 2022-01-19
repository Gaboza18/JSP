package com.green.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
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
 * Servlet implementation class MovieWriteServlet
 */
@WebServlet("/movie_write.do")
public class MovieWriteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public MovieWriteServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String url = "movie/movieWrite.jsp";

		RequestDispatcher rd = request.getRequestDispatcher(url); // 사용자가 요청한 페이지
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");

		ServletContext context = getServletContext();
		String savePath = "upload"; // 업로드 파일을 저장할 이클립스 내의 폴더명
		int uploadFileSize = 5 * 1024 * 1024; // 업로드 파일크기 제한: 5MB
		String encType = "UTF-8";

		String uploadFilePath = context.getRealPath(savePath);
		System.out.println("실제 업로드파일 경로: " + uploadFilePath);

		MultipartRequest multi = new MultipartRequest(request, uploadFilePath, uploadFileSize, encType,
				new DefaultFileRenamePolicy());

		MovieVO movie = new MovieVO();

		movie.setTitle(multi.getParameter("title"));
		movie.setPrice(Integer.parseInt(multi.getParameter("price")));
		movie.setDirector(multi.getParameter("director"));
		movie.setActor(multi.getParameter("actor"));
		movie.setSynopsis(multi.getParameter("synopsis"));

		String fileName = multi.getFilesystemName("poster");
		movie.setPoster(fileName);

		MovieDAO mDao = MovieDAO.getInstance();
		mDao.insertMovie(movie);

		response.sendRedirect("movie_list.do");
	}

}
