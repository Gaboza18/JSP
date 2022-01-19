
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class JoinServlet
 */
@WebServlet("/JoinServlet")
public class JoinServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public JoinServlet() {
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

		String name = request.getParameter("name");
		String jumin_no = request.getParameter("jumin_1") + "-" + request.getParameter("jumin_2");
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		String email = request.getParameter("email");

		// trim() 메소드: 앞,뒤 공백제거
		if (request.getParameter("email_dns").trim() == "") {
			email += "@" + request.getParameter("emailaddr"); // 도메인 선택시(select중 도메인값 선택해서 입력할때)
		} else {
			email += "@" + request.getParameter("email_dns"); // 도메인값을 직접입력할 경우
		}

		String zip = request.getParameter("zip");
		String addr = request.getParameter("addr1") + " " + request.getParameter("addr2");
		String phone = request.getParameter("phone");
		String job = request.getParameter("job");
		String chk_mail = request.getParameter("chk_mail");
		String[] interest = request.getParameterValues("interest");

		PrintWriter out = response.getWriter();

		out.print("<html><body>");
		out.print("이름: <b>" + name + "</b></br>");
		out.print("주민번호: <b>" + jumin_no + "</b></br>");
		out.print("아이디: <b>" + id + "</b></br>");
		out.print("비밀번호: <b>" + pwd + "</b></br>");
		out.print("이메일: <b>" + email + "</b></br>");
		out.print("우편번호: <b>" + zip + "</b></br>");
		out.print("주소: <b>" + addr + "</b></br>");
		out.print("핸드폰번호: <b>" + phone + "</b></br>");
		out.print("직업: <b>" + job + "</b></br>");
		out.print("수신여부: <b>" + chk_mail + "</b></br>");
		out.print("관심분야: <b>");
		if (interest == null) {
			out.print("선택한 항목이 없습니다.");
		} else {
			for (String item : interest) {
				out.print(item + "");
			}
		}
		out.print("</b><br><br><a href='javascript:history.go(-1)'>뒤로가기</a>");
		out.print("</body></html>");
		out.close();
	}

}
