package com.green.controller;

import java.io.IOException;

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
 * Servlet implementation class ProductUpdateServlet
 */
@WebServlet("/productUpdate.do")
public class ProductUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ProductUpdateServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String url = "product/productUpdate.jsp";

		// 상품목록 화면에서 전송된 code값을 가져온다.
		String code = request.getParameter("code");

		ProductDAO pDao = ProductDAO.getInstance();
		ProductVO product = pDao.selectProductByCode(code);

		// request 내장객체에 상품정보 저장
		request.setAttribute("product", product);

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
		String savePath = "upload"; // 업로드 파일을 저장할 이클립스 내의 폴더명
		int uploadFileSize = 5 * 1024 * 1024; // 업로드 파일크기 제한: 5MB
		String encType = "UTF-8"; // 인코딩 타입

		// 업로드 파일의 실제 경로 구하기
		String uploadFilePath = context.getRealPath(savePath);
		System.out.println("실제 업로드파일 경로: " + uploadFilePath);

		MultipartRequest multi = new MultipartRequest(request, uploadFilePath, uploadFileSize, encType,
				new DefaultFileRenamePolicy());

		ProductVO product = new ProductVO();

		product.setCode(Integer.parseInt(multi.getParameter("code")));
		product.setName(multi.getParameter("name"));
		product.setPrice(Integer.parseInt(multi.getParameter("price")));
		product.setDescription(multi.getParameter("description"));

		// 상품 이미지 설정
		String picture = multi.getFilesystemName("pictureurl");
		if (picture == null) { // 상품 이미지 변경안함
			product.setPictureurl(multi.getParameter("noupdateImg"));
		} else { // 이미지가 변경되있을경우
			product.setPictureurl(picture);
		}

		ProductDAO pDao = ProductDAO.getInstance();
		pDao.upadteProduct(product);

		response.sendRedirect("product_list.do");
	}

}
