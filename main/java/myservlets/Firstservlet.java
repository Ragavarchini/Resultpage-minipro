package myservlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Firstservlet")
public class Firstservlet extends HttpServlet {
	
	public void service(HttpServletRequest req,HttpServletResponse res) {
		
		try {
			
			int id = Integer.parseInt(req.getParameter("f1"));
			String name = req.getParameter("f2");
			int salary = Integer.parseInt(req.getParameter("f3"));
			int age = Integer.parseInt(req.getParameter("f4"));
			String gender = req.getParameter("f5");
			String D_O_J = req.getParameter("f6");
			
			String str = "insert into employees values(?,?,?,?,?,?)";
			
			Connection cn = DriverManager.getConnection("jdbc:mysql://localhost:3307/dbsql", "root", "root");
			 PreparedStatement ps = cn.prepareStatement(str);
			    ps.setInt(1,id);
		        ps.setString(2,name);
			    ps.setInt(3,salary);
				ps.setInt(4,age);
				ps.setString(5,gender);
				ps.setString(6,D_O_J);
				
				ps.execute();	
				
				  String str1 = "select * from employees";
				  PreparedStatement ps1 = cn.prepareStatement(str1);
                  ResultSet rs = ps1.executeQuery();
                 while(rs.next()) {
                	 int n = rs.getInt("E_id");
                	 String name1 = rs.getString("E_name");
                	 int salary1 = rs.getInt("salary");
                	 int age1 = rs.getInt("age");
                	 String gen = rs.getString("gender");
                	 String doj = rs.getString("D_O_J");
                	 PrintWriter pw;
					try {
						pw = res.getWriter();
						pw.println("id: " + n + " name :" + name1 +" salary: " + salary1 + " age: " + age1 + " gen: " + gen + " doj: "+ doj );
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
  