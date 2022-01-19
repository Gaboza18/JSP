package com.green.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.green.dao.ProductDAO;
import com.green.dto.ProductVO;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

/**
 * Servlet implementation class ProductWriteServlet
 */
@WebServlet("/productWrite.do")
public class ProductWriteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ProductWriteServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String url = "product/productWrite.jsp"; // 상품등록 페이지 url 주소

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
		String encType = "UTF-8"; // 인코딩 타입

		// 업로드 파일의 실제 경로 구하기
		String uploadFilePath = context.getRealPath(savePath);
		System.out.println("실제 업로드파일 경로: " + uploadFilePath);

		MultipartRequest multi = new MultipartRequest(request, uploadFilePath, uploadFileSize, encType,
				new DefaultFileRenamePolicy());

		// 화면에서 입력한 데이터를 ProductVO 객체에 저장
		ProductVO product = new ProductVO();

		product.setName(multi.getParameter("name"));
		product.setPrice(Integer.parseInt(multi.getParameter("price")));
		product.setDescription(multi.getParameter("description"));

		String fileName = multi.getFilesystemName("pictureurl");
		product.setPictureurl(fileName);

		ProductDAO pDao = ProductDAO.getInstance();
		pDao.insertProduct(product);

		// insert 데이터 확인 -- 상품 목록 출력
		response.sendRedirect("product_list.do");

	}

}
