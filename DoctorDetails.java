package AppSystem;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DoctorDetails {
	
	public static void RetrieveDetails() throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con=DriverManager.getConnection
				("jdbc:mysql://localhost:3306/project", "root","root123");
		Statement st=con.createStatement();
		ResultSet rs=st.executeQuery("select * from DoctorDetails;");
		
		while(rs.next()) {
			System.out.println(rs.getInt("Did")+" "+rs.getString("DName")+" "+
		        rs.getString("Qualification")+" "+rs.getString("Department")+" "+
					rs.getInt("RoomNo")+" "+ rs.getString("PhoneNo")+" "+rs.getString("WorkingHours"));
			
		}
		
		System.out.println("\n");
		st.close();
		con.close();

	}

}
