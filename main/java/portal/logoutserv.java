package portal;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/logoutserv")
public class logoutserv extends HttpServlet {
	
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
		PrintWriter pw = res.getWriter();
		RequestDispatcher r = req.getRequestDispatcher("general.html");
		r.include(req, res);
		
		
       HttpSession hp = req.getSession();
       hp.getAttribute("un");
       hp.invalidate();
       
      
       pw.println("logged out");
       
       
       
	}


}
