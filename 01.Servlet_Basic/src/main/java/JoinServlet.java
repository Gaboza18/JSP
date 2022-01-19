
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

		// trim() �޼ҵ�: ��,�� ��������
		if (request.getParameter("email_dns").trim() == "") {
			email += "@" + request.getParameter("emailaddr"); // ������ ���ý�(select�� �����ΰ� �����ؼ� �Է��Ҷ�)
		} else {
			email += "@" + request.getParameter("email_dns"); // �����ΰ��� �����Է��� ���
		}

		String zip = request.getParameter("zip");
		String addr = request.getParameter("addr1") + " " + request.getParameter("addr2");
		String phone = request.getParameter("phone");
		String job = request.getParameter("job");
		String chk_mail = request.getParameter("chk_mail");
		String[] interest = request.getParameterValues("interest");

		PrintWriter out = response.getWriter();

		out.print("<html><body>");
		out.print("�̸�: <b>" + name + "</b></br>");
		out.print("�ֹι�ȣ: <b>" + jumin_no + "</b></br>");
		out.print("���̵�: <b>" + id + "</b></br>");
		out.print("��й�ȣ: <b>" + pwd + "</b></br>");
		out.print("�̸���: <b>" + email + "</b></br>");
		out.print("�����ȣ: <b>" + zip + "</b></br>");
		out.print("�ּ�: <b>" + addr + "</b></br>");
		out.print("�ڵ�����ȣ: <b>" + phone + "</b></br>");
		out.print("����: <b>" + job + "</b></br>");
		out.print("���ſ���: <b>" + chk_mail + "</b></br>");
		out.print("���ɺо�: <b>");
		if (interest == null) {
			out.print("������ �׸��� �����ϴ�.");
		} else {
			for (String item : interest) {
				out.print(item + "");
			}
		}
		out.print("</b><br><br><a href='javascript:history.go(-1)'>�ڷΰ���</a>");
		out.print("</body></html>");
		out.close();
	}

}
