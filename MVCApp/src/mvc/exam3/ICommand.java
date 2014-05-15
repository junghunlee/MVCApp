package mvc.exam3;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//인터페이스만든 이유  ? 반복되는 코드를 간단하게 만들기위해
//, 매개변수 이유? 어떤값이 리턴될지 모르기떄문에 object리턴
public interface ICommand {
	public Object processCommand(HttpServletRequest req, HttpServletResponse res)throws ServletException,IOException;
	
}
