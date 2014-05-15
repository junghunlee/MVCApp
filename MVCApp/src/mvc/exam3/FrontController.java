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
			//입력값 확인
			//입력값이 잘못되었을 경우 해당 에러페이지로 이동
			nextPage = "/exam3/regConfirm.jsp";
		}
		else  if(cmd.equals("REGCOMPLETE")){
			nextPage = "/exam3/regComplete.jsp";
			//db연동 데이터 저장
		}
		else if(cmd.equals("ZIPSEARCH"){
			//db연동 우편번호 검색 결과 저장
			nextPage = "/exam3/zipSearch.jsp";
		}
		else{
			//정상적인 요청이 아닐경우에 대해 예외 처리
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
			//입력값 확인
			//입력값이 잘못되었을 경우 해당 에러페이지로 이동
			iCmd = new RegComfirmCommand();
		}
		else  if(cmd.equals("REGCOMPLETE")){
			iCmd = new RecCompletCommand();
			//db연동 데이터 저장
		}
		else if(cmd.equals("ZIPSEARCH"){
			iCmd = new ZipCommand();
		}
		
		else{
			//정상적인 요청이 아닐경우에 대해 예외 처리
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
