package mvc.exam1;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DepartServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		
		String param = req.getParameter("depart");
		
		ArrayList advice = new DepartAdvice().getAdvice(param);
		
		/*bean���θ����
		 * ArrayList advice = new ArrayList();
		if(param.equals("kor")){
			advice.add("1 ��� ���ؾ� �Ѵ�");
			advice.add("2 ��� ����ؾ� �Ѵ�");
		}
		else if(param.equals("eng")){
			advice.add("1 ��� ���ؾ� �Ѵ�");
			advice.add("2 ��� ����ؾ� �Ѵ�");
		}
		else if(param.equals("com")){
			advice.add("1 ��ǻ�͸� ���ؾ� �Ѵ�");
			advice.add("2 ��ǻ�͸� ����ؾ� �Ѵ�");
	}
		else if(param.equals("bus")){
			advice.add("1 �濵�� ���ؾ� �Ѵ�");
			advice.add("2 �濵�� ����ؾ� �Ѵ�");

		}*/
		
		
		/* jsp��
		 * req.setCharacterEncoding("euc-kr");
		resp.setCharacterEncoding("euc-kr");
		
		PrintWriter out = resp.getWriter();
		out.println("<html><body>");
		out.println("<h1>����� ������ �а��� ���� �����Դϴ�</h1>");
		for(int i=0; i<advice.size();i++){
			out.println(advice.get(i)+"<br/>");
		}
		out.println("</body></html>");
		out.close();*/
		
		req.setAttribute("advice", advice);
		RequestDispatcher view= req.getRequestDispatcher("/WEB-INF/views/result.jsp");
		// �������� ������� �������� ���� �����ϴ� �޼���
		view.forward(req, resp);
	}
}
