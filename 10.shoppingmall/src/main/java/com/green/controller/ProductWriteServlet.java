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

		String url = "product/productWrite.jsp"; // ��ǰ��� ������ url �ּ�

		RequestDispatcher rd = request.getRequestDispatcher(url); // ����ڰ� ��û�� ������
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
		String savePath = "upload"; // ���ε� ������ ������ ��Ŭ���� ���� ������
		int uploadFileSize = 5 * 1024 * 1024; // ���ε� ����ũ�� ����: 5MB
		String encType = "UTF-8"; // ���ڵ� Ÿ��

		// ���ε� ������ ���� ��� ���ϱ�
		String uploadFilePath = context.getRealPath(savePath);
		System.out.println("���� ���ε����� ���: " + uploadFilePath);

		MultipartRequest multi = new MultipartRequest(request, uploadFilePath, uploadFileSize, encType,
				new DefaultFileRenamePolicy());

		// ȭ�鿡�� �Է��� �����͸� ProductVO ��ü�� ����
		ProductVO product = new ProductVO();

		product.setName(multi.getParameter("name"));
		product.setPrice(Integer.parseInt(multi.getParameter("price")));
		product.setDescription(multi.getParameter("description"));

		String fileName = multi.getFilesystemName("pictureurl");
		product.setPictureurl(fileName);

		ProductDAO pDao = ProductDAO.getInstance();
		pDao.insertProduct(product);

		// insert ������ Ȯ�� -- ��ǰ ��� ���
		response.sendRedirect("product_list.do");

	}

}
