package AppSystem;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class PatientDetails {
	
	public static void PDetails() throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con=DriverManager.getConnection
				("jdbc:mysql://localhost:3306/project", "root","root123");
		Statement st=con.createStatement();
		Scanner sc=new Scanner(System.in);
		//System.out.println("Enter Patient id:- ");
		//int u_id=sc.nextInt();
		
		ResultSet rs=st.executeQuery("select * from PatientDetails;");
		
		while(rs.next()) {
			System.out.println(rs.getInt("Pid")+" "+rs.getString("Name")+" "+
		        rs.getInt("Age")+" "+rs.getString("Gender")+rs.getString("PhoneNo"));
			
		}
		st.close();
		con.close();

	}
	
	public static void PSingleDetails() throws Exception {
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con=DriverManager.getConnection
				("jdbc:mysql://localhost:3306/project", "root","root123");
		Statement st=con.createStatement();
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter Patient id:- ");
		int u_id=sc.nextInt();
		
		ResultSet rs=st.executeQuery("select * from PatientDetails where PId ="+u_id+";");
		
		
		if(rs.next()) {
			System.out.println(rs.getInt("Pid")+" "+rs.getString("Name")+" "+
					rs.getInt("Age")+" "+rs.getString("Gender")+rs.getString("PhoneNo"));
			
		}
		else {
	    	System.out.println("Record not present. Please enter a valid Patient Id\n");
	    }
		
		System.out.println("\n");
		st.close();
		con.close();
		
	}

}
