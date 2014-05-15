package mvc.exam3;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class RecCompletCommand implements ICommand {

	@Override
	public Object processCommand(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		//DB연동 데이터 저장
		//session을 이용해서 표시 (request로 받음)
		HttpSession session = req.getSession();
		session.setAttribute("currentState", "COMPLETE");
		return "/exam3/regComplete.jsp";
	}

}
