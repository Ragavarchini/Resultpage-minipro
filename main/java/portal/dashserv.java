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

@WebServlet("/dashserv")
public class dashserv extends HttpServlet {
	
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		PrintWriter pw  = res.getWriter();
		RequestDispatcher re = req.getRequestDispatcher("general.html");
		re.include(req, res);
		HttpSession hst = req.getSession(false);
		if(hst!=null) {
			String s = (String) hst.getAttribute("un");
			pw.print("welcome" + " " + s);
		}
		else {
			pw.print("Oops!!!... you need to login first");
		}

	}
	
	}


