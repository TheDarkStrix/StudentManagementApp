package StudentManagementJDBC;

import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;


/**
 * Servlet implementation class StudentControllerServlet
 */
@WebServlet("/StudentControllerServlet")
public class StudentControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
private StudentDBUtil studentDBUtil;
	
//  Initate Connect with JDBC server where student is the table name
	@Resource(name="jdbc/student")
	private DataSource dataSource;

//Use inits to load the request on every request
	@Override
	public void init() throws ServletException {
		super.init();
		
		try {
			studentDBUtil = new StudentDBUtil(dataSource);
		}catch(Exception e) {
			throw new ServletException(e);
		}
		
	}
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
//			Get the the Command value from JSP page
			String theCommand = request.getParameter("Command");
			
			if(theCommand == null) {
				theCommand = "LIST";
			}
//			Make the decision according the command Value
			switch(theCommand) {
//			List -> Lists the Details 
			case "LIST" : 
				listStudents(request,response);
				break;
//			List -> Create Entry				
			case "ADD" : 
				addStudent(request,response);
				break;
			
		default : 
			listStudents(request,response);
		}
			}
			catch (Exception e) {
				throw new ServletException(e);
			}
		}
	
private void addStudent(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		String firstname = request.getParameter("firstName");
		String lastname = request.getParameter("lastName");
		String email = request.getParameter("email");
		
		Student theStudent = new Student(firstname,lastname,email);
		
		studentDBUtil.addStudent(theStudent);
		
		listStudents(request,response);
		
	}
	
	private void listStudents(HttpServletRequest request, HttpServletResponse response) throws Exception{
//		Get the Students from the DB CLASS
		List<Student> students = studentDBUtil.getStudents();
//		Set the received DATA to student Objects with the name STUDENT_LIST
		request.setAttribute("STUDENT_LIST", students);

//		This will Dispatch the data to a JSP page
		RequestDispatcher dispatcher = request.getRequestDispatcher("/list-students.jsp");
		dispatcher.forward(request, response);
	}

}
