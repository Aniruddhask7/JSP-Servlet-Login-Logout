package pack;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 * Servlet implementation class loginServlet
 */
@WebServlet("/loginServlet")
public class loginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		request.getRequestDispatcher("link.html").include(request,response);
		
		String name = request.getParameter("name");
		String pass = request.getParameter("pass");
		
		if(pass.equals("@niruddha")) {
			out.print("welcome " +name);
			HttpSession session = request.getSession();
			session.setAttribute("name" , name);
		}else {
			out.println("Sorry ! Username or Pass Wrong");
			request.getRequestDispatcher("login.html").include(request, response);
		}
		
		out.close();
			
	}

}
