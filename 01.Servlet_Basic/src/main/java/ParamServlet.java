

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ParamServlet
 */
@WebServlet("/ParamServlet")
public class ParamServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ParamServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String id = request.getParameter("id"); // 사용자가 입력하는 id값
		int age = Integer.parseInt(request.getParameter("age")); // 사용자가 입력하는 age값, 파라미터 값은 문자열로 받기 때문에 숫자형으로 변환
		
		System.out.println("id= "+id); // 콘솔창 출력
		System.out.println("id= "+age);
		
		// 응답 데이터 전송 -> 한글 처리를 하기 위해서 반드시 선언
		response.setContentType("text/html; charset=UTF-8");
		
		// 출력 스트림
		PrintWriter out = response.getWriter();
		
		out.print("<html><head><title>입력정보</title></head>");
		out.print("<body><h3>입력하신 정보입니다</h3>");
		out.print("아이디: " + id + "<br>");
		out.print("나 이: " + age + "<br><br>");
		out.print("<a href = 'javascript:history.go(-1)'>뒤로가기</a>"); // 현재 페이지에서 전 페이지로 이동하는 링크
		out.print("</body></html>");
		
		out.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("doPost() 에서 실행...");
		request.setCharacterEncoding("UTF-8"); // post 방식에서는 한글을 출력시 UTF-8 형식을 선언해줘야 한다
		
		String id = request.getParameter("id"); // 사용자가 입력하는 id값
		int age = Integer.parseInt(request.getParameter("age")); // 사용자가 입력하는 id값, 파라미터 값은 문자열로 받기 때문에 숫자형으로 변환
		
		System.out.println("id= "+id); // 콘솔창 출력
		System.out.println("id= "+age);
		
		// 응답 데이터 전송
		response.setContentType("text/html; charset=UTF-8");
		
		// 출력 스트림
		PrintWriter out = response.getWriter();
		
		out.print("<html><head><title>입력정보</title></head>");
		out.print("<body><h3>입력하신 정보입니다</h3>");
		out.print("아이디: " + id + "<br>");
		out.print("나 이: " + age + "<br><br>");
		out.print("<a href = 'javascript:history.go(-1)'>뒤로가기</a>"); // 현재 페이지에서 전 페이지로 이동하는 링크
		out.print("</body></html>");
		
		out.close();
	}

}
