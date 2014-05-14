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
		
		/*bean으로만들기
		 * ArrayList advice = new ArrayList();
		if(param.equals("kor")){
			advice.add("1 국어를 잘해야 한다");
			advice.add("2 국어를 사랑해야 한다");
		}
		else if(param.equals("eng")){
			advice.add("1 영어를 잘해야 한다");
			advice.add("2 영어를 사랑해야 한다");
		}
		else if(param.equals("com")){
			advice.add("1 컴퓨터를 잘해야 한다");
			advice.add("2 컴퓨터를 사랑해야 한다");
	}
		else if(param.equals("bus")){
			advice.add("1 경영를 잘해야 한다");
			advice.add("2 경영를 사랑해야 한다");

		}*/
		
		
		/* jsp로
		 * req.setCharacterEncoding("euc-kr");
		resp.setCharacterEncoding("euc-kr");
		
		PrintWriter out = resp.getWriter();
		out.println("<html><body>");
		out.println("<h1>당신이 선택한 학과에 대한 조언입니다</h1>");
		for(int i=0; i<advice.size();i++){
			out.println(advice.get(i)+"<br/>");
		}
		out.println("</body></html>");
		out.close();*/
		
		req.setAttribute("advice", advice);
		RequestDispatcher view= req.getRequestDispatcher("/WEB-INF/views/result.jsp");
		// 누구에게 결과값을 가져가게 할지 지시하는 메서드
		view.forward(req, resp);
	}
}
