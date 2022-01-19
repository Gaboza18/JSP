
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

		String job = request.getParameter("job"); // 첫번째 select
		String[] interest = request.getParameterValues("interest"); // 두번째 다중 select

		PrintWriter out = response.getWriter();

		out.print("<html><body>");
		out.print("당신이 선택한 직업: <b>" + job + "</b><br>");
		out.print("당신의 관심분야: <b>");
		if (interest == null) {
			out.print("선택한 항목이 없습니다");
		} else {
			for (String item : interest) {
				out.print(item + " ");
			}
		}
		out.print("<br><br><a href='javascript:history.go(-1)'>뒤로가기</a>");
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
