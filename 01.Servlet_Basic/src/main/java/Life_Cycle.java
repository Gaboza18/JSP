

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
	int count = 0; // doGet() �޼ҵ尡 ����ɶ����� ī��Ʈ �ϱ� ���� ����
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Life_Cycle() {
        super();
        // TODO Auto-generated constructor stub
    }

	@Override
	public void destroy() {
		
		System.out.println("destory() �޼ҵ�� ��Ĺ ����� �ѹ��� ȣ��"); // ������ �����ϰ� ��Ĺ�� �����ϸ� ����ȴ�
		
	}

	@Override
	public void init() throws ServletException {
		System.out.println("init() �޼ҵ�� ù��° ��û�ÿ��� �ѹ� ����"); // ó�� ������ ������ �Ҷ��� ȣ��ȴ�
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("doGet() �޼ҵ�� ��û�� ���������� ȣ���: " + count++); // ������ ����ǰ� f5 ���������� ȣ���Ѵ�
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
