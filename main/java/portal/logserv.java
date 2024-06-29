package portal;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/logserv")
public class logserv extends HttpServlet {

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException {
		PrintWriter pw = res.getWriter(); 
		String uname = req.getParameter("username");
		String pass = req.getParameter("password");
		
		try {
			String str = "select Rno,pass from students where Rno=? and pass = ?";
			Connection cn = DriverManager.getConnection("jdbc:mysql://localhost:3307/dbsql", "root", "root");
			PreparedStatement ps = cn.prepareStatement(str);
			ps.setString(1, uname);
			ps.setString(2, pass);
			
			RequestDispatcher r = req.getRequestDispatcher("general.html");
			try {
				r.include(req, res);
			} catch (ServletException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
            ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				HttpSession htp = req.getSession();
				htp.setAttribute("un", uname);
				pw.println("login success");
		
	          }
			else {
				RequestDispatcher rd = req.getRequestDispatcher("loginpage.html");
				try {
					rd.forward(req, res);
				} catch (ServletException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		
	}

}
