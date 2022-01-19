
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SelectServlet
 */
@WebServlet("/SelectServlet")
public class SelectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SelectServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html; charset=UTF-8");

		String job = request.getParameter("job"); // ù��° select
		String[] interest = request.getParameterValues("interest"); // �ι�° ���� select

		PrintWriter out = response.getWriter();

		out.print("<html><body>");
		out.print("����� ������ ����: <b>" + job + "</b><br>");
		out.print("����� ���ɺо�: <b>");
		if (interest == null) {
			out.print("������ �׸��� �����ϴ�");
		} else {
			for (String item : interest) {
				out.print(item + " ");
			}
		}
		out.print("<br><br><a href='javascript:history.go(-1)'>�ڷΰ���</a>");
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
