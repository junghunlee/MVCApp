package mvc.exam3;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FrontController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String cmd= req.getParameter("command");
		String nextPage="";
		if(cmd.equals("MAIN")){
			nextPage = "/exam3/index.jsp";
		}
		else if (cmd.equals("REGFORM")){
			nextPage = "/exam3/regForm.html";
		
		}else  if(cmd.equals("REGCONFIRM")){
			//�Է°� Ȯ��
			//�Է°��� �߸��Ǿ��� ��� �ش� ������������ �̵�
			nextPage = "/exam3/regConfirm.jsp";
		}
		else  if(cmd.equals("REGCOMPLETE")){
			nextPage = "/exam3/regComplete.jsp";
			//db���� ������ ����
		}
		else{
			//�������� ��û�� �ƴҰ�쿡 ���� ���� ó��
		}
		RequestDispatcher view = req.getRequestDispatcher(nextPage);
		view.forward(req, resp);
		}

}
