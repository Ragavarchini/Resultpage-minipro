package assign;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/paliserv")
public class paliserv extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter pw = response.getWriter(); 
		int n = Integer.parseInt(request.getParameter("number"));
		boolean palindrome = palimethod.ispali(n); 
		 request.setAttribute("booleanValue", palindrome);

	     request.getRequestDispatcher("palindro.jsp").forward(request, response);
		
	}

	

}
