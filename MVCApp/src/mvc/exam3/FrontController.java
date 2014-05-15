package mvc.exam3;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class FrontController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		/*String cmd= req.getParameter("command");
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
		else if(cmd.equals("ZIPSEARCH"){
			//db���� �����ȣ �˻� ��� ����
			nextPage = "/exam3/zipSearch.jsp";
		}
		else{
			//�������� ��û�� �ƴҰ�쿡 ���� ���� ó��
		}
		RequestDispatcher view = req.getRequestDispatcher(nextPage);
		view.forward(req, resp);*/
	/*	String cmd= req.getParameter("command");
		String nextPage="";
		MainCommand mainCommand=null;
		RegFormCommand regCommand=null;
		ICommand iCmd=null;
		if(cmd.equals("MAIN")){
			iCmd = new MainCommand();
			
		}
		else if (cmd.equals("REGFORM")){
			iCmd = new RegFormCommand();
			nextPage = (String)regCommand.processCommand(req, resp);
		
		}else  if(cmd.equals("REGCONFIRM")){
			//�Է°� Ȯ��
			//�Է°��� �߸��Ǿ��� ��� �ش� ������������ �̵�
			iCmd = new RegComfirmCommand();
		}
		else  if(cmd.equals("REGCOMPLETE")){
			iCmd = new RecCompletCommand();
			//db���� ������ ����
		}
		else if(cmd.equals("ZIPSEARCH"){
			iCmd = new ZipCommand();
		}
		
		else{
			//�������� ��û�� �ƴҰ�쿡 ���� ���� ó��
		}
		
*/
		/*String cmd= req.getParameter("command");
		String nextPage="";
		
		CommandFactory factory = CommandFactory.getInstance();
		ICommand iCmd=factory.createComman(cmd);
		
		
		nextPage = (String)iCmd.processCommand(req, resp);
		RequestDispatcher view = req.getRequestDispatcher(nextPage);
		view.forward(req, resp);*/
		req.setCharacterEncoding("euc-kr");
		String cmd= req.getParameter("command");
		String nextPage="";
		
		HttpSession session = req.getSession();
		String current = (String)session.getAttribute("currentState");
		
		if(current != null && current.equals("COMPLETE")){
			nextPage = "/exam3/alreadyRegister.jsp";
		}else{
		CommandFactory factory = CommandFactory.getInstance();
		ICommand iCmd=factory.createComman(cmd);
		nextPage = (String)iCmd.processCommand(req, resp);
		}
		
		
		RequestDispatcher view = req.getRequestDispatcher(nextPage);
		view.forward(req, resp);
		}

}
