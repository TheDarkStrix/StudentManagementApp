package StudentManagementJDBC;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

/**
 * Servlet implementation class TestJDBC
 */
@WebServlet("/TestJDBC")
public class TestJDBC extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
//	Initiate JDBC SERVER : dataSource (tableName:student)
	@Resource(name="jdbc/student")
	private DataSource dataSource;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		response.setContentType("text/plain");
		
//		Initiate Connect to DataBase 
		Connection myConn = null;
		java.sql.Statement myStmt = null;
		ResultSet myRs = null;
		
		try {
//			Make the Connect using the dataSource
			myConn = dataSource.getConnection();
			
//			Make the sql query
			String sql ="select * from student";
			myStmt = myConn.createStatement();
//			Execute the query
			myRs = myStmt.executeQuery(sql);
// 			On execution of the query is successful display the emailID
			while(myRs.next()) {
				String email = myRs.getString("email");
				out.println(email);
			}
//			Catch any and all errors if found
		}catch(Exception exc) {
			exc.printStackTrace();
		}
		
	}

}
