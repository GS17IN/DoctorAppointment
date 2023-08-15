package AppSystem;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Scanner;


public class PatientDelete {
	
	public static void deleteAppointmentsByPatientId(int patientId) throws Exception {
	    Class.forName("com.mysql.cj.jdbc.Driver");
	    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/project", "root", "root123");
	    Statement st = con.createStatement();

	    String deleteQuery = "DELETE FROM Appointment WHERE PId = " + patientId + ";";
	    int res = st.executeUpdate(deleteQuery);

	    if (res == 0) {
	        //System.out.println("No appointments found for the given patient id.");
	    } else {
	        System.out.println("Appointments for patient id " + patientId + " deleted successfully.");
	    }

	    st.close();
	    con.close();
	}
	
	public static void PDelete() throws Exception {
		Scanner sc=new Scanner(System.in);
		
		System.out.println("Enter Patient id to delete the record:- ");
		int u_id=sc.nextInt();
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con=DriverManager.getConnection
				("jdbc:mysql://localhost:3306/project", "root","root123");
		Statement st=con.createStatement();
		String deleteQuery="delete from PatientDetails "
				+ "where PId = "+u_id+";";
		int res=st.executeUpdate(deleteQuery);
		
		if(res == 0) {
			System.out.println("Record not deleted!!!");
		}else {
			System.out.println("Record deleted succesfully");
		}
		
		deleteAppointmentsByPatientId(u_id);
		
		st.close();
		con.close();
		//sc.close();
	}
}
