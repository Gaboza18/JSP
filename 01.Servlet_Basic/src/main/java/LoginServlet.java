

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 한글 처리를 위한 선언
		request.setCharacterEncoding("UTF-8");
		
		// 응답할 데이터를 생성
		response.setContentType("text/html; charset=UTF-8");
		
		String id = request.getParameter("id"); // id의 name을 받아온다
		String pwd = request.getParameter("pwd"); // pwd의 name을 받아온다
		
		PrintWriter out = response.getWriter(); // 응답할 데이터를 내보내기 위한 객체 생성
		
		out.print("<html><body>");
		out.print("<h3>당신이 입력한 정보</h3><br>");
		out.print("아이디: " + id + "<br>");
		out.print("비밀번호: " + pwd + "<br>");
		out.print("<a href='javascript:history.go(-1)'>뒤로가기</a>");
		out.print("</body></html>");
		out.close();
	}

}
