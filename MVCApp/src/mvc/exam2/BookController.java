package mvc.exam2;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;
import java.util.Vector;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class BookController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.setCharacterEncoding("euc-kr");

		String cmd = req.getParameter("command");
		HttpSession session = req.getSession();

		// Vector bookList = (Vector) req.getAttribute("cart"); //이게 널값 그래서
		// req대신 세션을 사용
		Vector bookList = (Vector) session.getAttribute("cart");
		if (cmd.equals("CHK")) {
			RequestDispatcher view = req
					.getRequestDispatcher("/exam2/checkout.jsp");
			view.forward(req, resp);
		}

		else {
			if (cmd.equals("ADD")) {
				if (bookList == null) {
					bookList = new Vector();
				}
				bookList.add(getBook(req));
			} else if (cmd.equals("DEL")) {
				int idx = Integer.parseInt(req.getParameter("idx"));
				bookList.remove(idx);
			}
			session.setAttribute("cart", bookList);
			RequestDispatcher view = req
					.getRequestDispatcher("/exam2/bookShop.jsp");
			view.forward(req, resp);
		}

	}

	// 클라이언트가 보내온 데이터를 4개로 나누어서 DTO에 저장 // trim은 공백을 없앰
	public BookDto getBook(HttpServletRequest req) {
		String book = req.getParameter("book");
		String qty = req.getParameter("quantity").trim();

		StringTokenizer token = new StringTokenizer(book, "/");
		String title = token.nextToken().trim();
		String author = token.nextToken().trim();
		String price = token.nextToken().trim();

		// dto저장위해 인스턴스 생성
		BookDto dto = new BookDto();
		dto.setAuthor(author);
		dto.setPrice(Integer.parseInt(price));
		dto.setQuantity(Integer.parseInt(qty));
		dto.setTitle(title);

		return dto;
	}

}
