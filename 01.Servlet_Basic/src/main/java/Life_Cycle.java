

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Life_Cycle
 */
@WebServlet("/Life_Cycle")
public class Life_Cycle extends HttpServlet {
	private static final long serialVersionUID = 1L;
	int count = 0; // doGet() 메소드가 수행될때마다 카운트 하기 위한 변수
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Life_Cycle() {
        super();
        // TODO Auto-generated constructor stub
    }

	@Override
	public void destroy() {
		
		System.out.println("destory() 메소드는 톰캣 종료시 한번만 호출"); // 파일을 실행하고 톰캣을 종료하면 실행된다
		
	}

	@Override
	public void init() throws ServletException {
		System.out.println("init() 메소드는 첫번째 요청시에만 한번 수행"); // 처음 파일이 컴파일 할때만 호출된다
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("doGet() 메소드는 요청이 있을때마다 호출됨: " + count++); // 파일이 실행되고 f5 누를때마다 호출한다
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
