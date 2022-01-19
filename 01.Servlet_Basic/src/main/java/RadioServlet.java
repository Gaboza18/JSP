
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RadioServlet
 */
@WebServlet("/RadioServlet")
public class RadioServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RadioServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String gender = request.getParameter("gender"); // name ���� �޾ƿ´�
		String checkmail = request.getParameter("checkmail");
		String content = request.getParameter("content");

		response.setContentType("text/html; charset=UTF-8");
		
		PrintWriter out = response.getWriter(); // ������ �����͸� �������� ���� ��ü ����
		
		out.print("<html><body>");
		out.print("����� �Է��� ����<br>");
		out.print("����: <b>" + gender + "</b><br>");
		out.print("���� ���ſ��� <b>" + checkmail + "</b><br>");
		out.print("�����λ�: <pre><b>" + content + "</b></pre><br>");
		out.print("<a href='javascript:history.go(-1)'>�ڷΰ���</a>");
		out.print("</body></html>");
		out.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
