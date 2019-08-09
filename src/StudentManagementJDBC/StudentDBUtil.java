package StudentManagementJDBC;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

public class StudentDBUtil {
	private DataSource dataSource;

//	Initiate Data Source
	public StudentDBUtil(DataSource theDataSource) {
		dataSource = theDataSource;
	}

//  To fetch the data from DB
	public List<Student> getStudents() throws Exception{
//		Initially Set all JDBC Objects to null or empty
		List<Student> students = new ArrayList<>();
		Connection myConn = null;
		java.sql.Statement myStmt = null;
		ResultSet myRs = null;
		
// Try Catch or Try Finally is used to catch any and all exceptions 
		try {
		myConn = dataSource.getConnection();
		String sql = "select * from student order by last_name";
		
		myStmt = myConn.createStatement();
		
		myRs = myStmt.executeQuery(sql);
		
		while(myRs.next()) {
			int id = myRs.getInt("id");
			String firstName = myRs.getString("first_name");
			String lastName = myRs.getString("last_name");
			String email = myRs.getString("email");
			
			Student tempStudent = new Student(id,firstName,lastName,email);
			
			students.add(tempStudent);
		}
			return students;
		}finally {
			close(myConn,myStmt,myRs);
		}
		
	}
//	Close method is ensure closing of Openned JDBC Objects
	private void close(Connection myConn, Statement myStmt, ResultSet myRs) {
		try {
			if(myRs != null) {
				myRs.close();
			}
			if(myStmt != null) {
				myStmt.close();
			}
			if(myConn != null) {
				myConn.close();
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}