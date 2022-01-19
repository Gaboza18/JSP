
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

		String gender = request.getParameter("gender"); // name 값을 받아온다
		String checkmail = request.getParameter("checkmail");
		String content = request.getParameter("content");

		response.setContentType("text/html; charset=UTF-8");
		
		PrintWriter out = response.getWriter(); // 응답할 데이터를 내보내기 위한 객체 생성
		
		out.print("<html><body>");
		out.print("당신이 입력한 정보<br>");
		out.print("성별: <b>" + gender + "</b><br>");
		out.print("메일 수신여부 <b>" + checkmail + "</b><br>");
		out.print("가입인사: <pre><b>" + content + "</b></pre><br>");
		out.print("<a href='javascript:history.go(-1)'>뒤로가기</a>");
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
