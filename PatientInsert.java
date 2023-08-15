package AppSystem;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class PatientInsert {
	
	public static void PInsert() throws Exception {
		
		Scanner sc=new Scanner(System.in);
		
		//Get the details from the user
		
		//System.out.println("Enter Patient id:- ");
		//int u_id=sc.nextInt();
		System.out.println("Enter Patient name:- ");
		String u_name= sc.next();
		System.out.println("Enter age of the patient:- ");
		int u_age = sc.nextInt();
		System.out.println("Enter the gender of the Patient (Male/Female):- ");
		String u_gen = sc.next();
		System.out.println("Enter the mobile number:- ");
		String u_num = sc.next();
		
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con=DriverManager.getConnection
				("jdbc:mysql://localhost:3306/project", "root","root123");
		Statement st=con.createStatement();
		String insertQuery="insert into PatientDetails(Name,Age,Gender,PhoneNo) "
				+ "values('"+u_name+"',"+u_age+",'"+u_gen+"','"+u_num+"');";
		int res=st.executeUpdate(insertQuery);
		
		if(res == 0) {
			System.out.println("\nRecord not inserted\n");
	        
		}else {
			
			/*ResultSet generatedKeys = st.getGeneratedKeys();
	        int patientId = -1;
	        if (generatedKeys.next()) {
	            patientId = generatedKeys.getInt(1);
	            System.out.println("\nPatient ID: " + patientId + "\n");
	        }*/
			System.out.println("Record inserted succesfully\n");
		}
		st.close();
		con.close();
		//sc.close();
	}

}
