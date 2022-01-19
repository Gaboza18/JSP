package com.green.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.*; // ���� ���ε� �ϱ����� import
import com.oreilly.servlet.multipart.*; // ���� ���ε� �ϱ����� import

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

		String savePath = "upload"; // ���ε� ������ ������ ��Ŭ���� ���� ������
		int uploadFileSize = 5 * 1024 * 1024; // ���ε� ����ũ�� ����: 5MB
		String encType = "UTF-8"; // ���ڵ� Ÿ��

		// ���ε� ������ ���� ��� ���ϱ�
		ServletContext context = getServletContext();
		String uploadFilePath = context.getRealPath(savePath);
		System.out.println("���� ���ε����� ���: " + uploadFilePath);

		MultipartRequest multi = new MultipartRequest(request, uploadFilePath, uploadFileSize, encType,
				new DefaultFileRenamePolicy());

		// ȭ�鿡�� ���ε��� ������ �̸��� "name"�Ӽ����� �̿��Ͽ� ���´�.
		String fileName = multi.getFilesystemName("upload_file");

		if (fileName == null) {
			System.out.println("������ ���ε� ���� �ʾҽ��ϴ�.");
		} else {
			out.println("�۾���: " + multi.getParameter("writer") + "<br>");
			out.println("�� ��: " + multi.getParameter("title") + "<br>");
			out.println("���ϸ�: " + fileName);
		}
	}

}
