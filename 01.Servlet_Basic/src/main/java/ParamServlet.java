

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
		
		String id = request.getParameter("id"); // ����ڰ� �Է��ϴ� id��
		int age = Integer.parseInt(request.getParameter("age")); // ����ڰ� �Է��ϴ� age��, �Ķ���� ���� ���ڿ��� �ޱ� ������ ���������� ��ȯ
		
		System.out.println("id= "+id); // �ܼ�â ���
		System.out.println("id= "+age);
		
		// ���� ������ ���� -> �ѱ� ó���� �ϱ� ���ؼ� �ݵ�� ����
		response.setContentType("text/html; charset=UTF-8");
		
		// ��� ��Ʈ��
		PrintWriter out = response.getWriter();
		
		out.print("<html><head><title>�Է�����</title></head>");
		out.print("<body><h3>�Է��Ͻ� �����Դϴ�</h3>");
		out.print("���̵�: " + id + "<br>");
		out.print("�� ��: " + age + "<br><br>");
		out.print("<a href = 'javascript:history.go(-1)'>�ڷΰ���</a>"); // ���� ���������� �� �������� �̵��ϴ� ��ũ
		out.print("</body></html>");
		
		out.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("doPost() ���� ����...");
		request.setCharacterEncoding("UTF-8"); // post ��Ŀ����� �ѱ��� ��½� UTF-8 ������ ��������� �Ѵ�
		
		String id = request.getParameter("id"); // ����ڰ� �Է��ϴ� id��
		int age = Integer.parseInt(request.getParameter("age")); // ����ڰ� �Է��ϴ� id��, �Ķ���� ���� ���ڿ��� �ޱ� ������ ���������� ��ȯ
		
		System.out.println("id= "+id); // �ܼ�â ���
		System.out.println("id= "+age);
		
		// ���� ������ ����
		response.setContentType("text/html; charset=UTF-8");
		
		// ��� ��Ʈ��
		PrintWriter out = response.getWriter();
		
		out.print("<html><head><title>�Է�����</title></head>");
		out.print("<body><h3>�Է��Ͻ� �����Դϴ�</h3>");
		out.print("���̵�: " + id + "<br>");
		out.print("�� ��: " + age + "<br><br>");
		out.print("<a href = 'javascript:history.go(-1)'>�ڷΰ���</a>"); // ���� ���������� �� �������� �̵��ϴ� ��ũ
		out.print("</body></html>");
		
		out.close();
	}

}
