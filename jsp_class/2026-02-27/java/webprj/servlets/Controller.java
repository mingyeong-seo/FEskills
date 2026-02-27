package webprj.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet implementation class Controller
 */
@WebServlet("*.one")
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uri = request.getRequestURI();
		int lastSlash = uri.lastIndexOf("/");
		String commandStr = uri.substring(lastSlash);
//		System.out.print(commandStr);
		
		if(commandStr.equals("/register.one")) {
			registFuc(request);
		}else if(commandStr.equals("/login.one")) {
			loginFuc(request);
		} else if(commandStr.equals("/freeboard.one")) {
			freeboardFuc(request);
		} 
		
		request.setAttribute("uri", uri);
		request.setAttribute("commandStr", commandStr);
		request.getRequestDispatcher("/serv/controller.jsp").forward(request, response);
		}

	private void freeboardFuc(HttpServletRequest request) {
		request.setAttribute("resultValue", "<h4>게시판</h4>");
	}

	private void loginFuc(HttpServletRequest request) {
		request.setAttribute("resultValue", "<h4>로그인</h4>");
	}

	private void registFuc(HttpServletRequest request) {
		request.setAttribute("resultValue", "<h4>회원가입</h4>");
	}

}

