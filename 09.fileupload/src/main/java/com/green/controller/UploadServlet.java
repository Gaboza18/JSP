package com.green.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.*; // 파일 업로드 하기위한 import
import com.oreilly.servlet.multipart.*; // 파일 업로드 하기위한 import

/**
 * Servlet implementation class UploadServlet
 */
@WebServlet("/upload.do")
public class UploadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UploadServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");

		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();

		String savePath = "upload"; // 업로드 파일을 저장할 이클립스 내의 폴더명
		int uploadFileSize = 5 * 1024 * 1024; // 업로드 파일크기 제한: 5MB
		String encType = "UTF-8"; // 인코딩 타입

		// 업로드 파일의 실제 경로 구하기
		ServletContext context = getServletContext();
		String uploadFilePath = context.getRealPath(savePath);
		System.out.println("실제 업로드파일 경로: " + uploadFilePath);

		MultipartRequest multi = new MultipartRequest(request, uploadFilePath, uploadFileSize, encType,
				new DefaultFileRenamePolicy());

		// 화면에서 업로드한 파일의 이름을 "name"속성갑을 이용하여 얻어온다.
		String fileName = multi.getFilesystemName("upload_file");

		if (fileName == null) {
			System.out.println("파일이 업로드 되지 않았습니다.");
		} else {
			out.println("글쓴이: " + multi.getParameter("writer") + "<br>");
			out.println("제 목: " + multi.getParameter("title") + "<br>");
			out.println("파일명: " + fileName);
		}
	}

}
