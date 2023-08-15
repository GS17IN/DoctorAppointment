package AppSystem;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class Appointment {
	
	public static void AppInsert() throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con=DriverManager.getConnection
				("jdbc:mysql://localhost:3306/project", "root","root123");
		Statement st=con.createStatement();
		Scanner sc=new Scanner(System.in);
		
		System.out.println("Enter Patient id:- ");
		int p_id=sc.nextInt();
		
		// Check if Patient exists
	    ResultSet patientResultSet = st.executeQuery("SELECT * FROM PatientDetails WHERE PId = " + p_id);
	    if (!patientResultSet.next()) {
	        System.out.println("Patient with id " + p_id + " does not exist.\n");
	        st.close();
	        con.close();
	        return;
	    }
		
		System.out.println("Enter Doctor id:- ");
		int d_id=sc.nextInt();
		
		//Check if Doctor exists
		
		ResultSet doctorResultSet = st.executeQuery("SELECT * FROM DoctorDetails WHERE DId = " + d_id);
	    if (!doctorResultSet.next()) {
	        System.out.println("Doctor with id " + d_id + " does not exist.\n");
	        st.close();
	        con.close();
	        return;
	    }
		
		System.out.println("Enter Date of Appointment (DD/MM/YY) :- ");
		String a_date=sc.next();
		
		System.out.println("Enter Time of Appointment (Eg: 10am-10:30am) :- ");
		String a_time = sc.next();
		
	
		//Checking whether the appointment time is already booked
		
		String checkQuery = "SELECT * FROM Appointment WHERE AppDate = '" + a_date + "' AND AppTime = '" + a_time + "'";
	    ResultSet rs = st.executeQuery(checkQuery);
	    if (rs.next()) {
	        System.out.println("Sorry, the time slot is already taken.\n");
	        st.close();
	        con.close();
	        return;
	    }
	    
		String insertQuery="insert into Appointment (PId,DId,AppDate,AppTime)"
					+ "values("+p_id+","+d_id+",'"+a_date+"','"+a_time+"');";
		int res=st.executeUpdate(insertQuery);
			
		if(res == 0) {
				System.out.println("Record not inserted\n");
		}else {
				System.out.println("Record inserted succesfully\n");
		}
		
				
		st.close();
		con.close();
		//sc.close();
	}
	
	public static void AppDelete() throws Exception {
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con=DriverManager.getConnection
				("jdbc:mysql://localhost:3306/project", "root","root123");
		Statement st=con.createStatement();
		Scanner sc=new Scanner(System.in);
		
		System.out.println("Enter Appointment Number:- ");
		int a_id=sc.nextInt();
		
		String deleteQuery="delete from Appointment"
				+ " where AppNo = "+a_id+";";
		int res=st.executeUpdate(deleteQuery);
		
		if(res == 0) {
			System.out.println("Record not deleted\n");
		}else {
			System.out.println("Record deleted succesfully\n");
		}
		st.close();
		con.close();
		///sc.close();
		
	}
	
	public static void AppModify() throws Exception {
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con=DriverManager.getConnection
				("jdbc:mysql://localhost:3306/project", "root","root123");
		Statement st=con.createStatement();
		Scanner sc=new Scanner(System.in);
		
		System.out.println("-------------MODIFY APPOINTMENT DETAILS-------------- ");
		System.out.println("1. Change Patient Id ");
		System.out.println("2. Change Doctor Id ");
		System.out.println("3. Change Date and Time of Appointment");
		//System.out.println("4. Change Time of Appointment");
		System.out.println("0. Exit\n");
		
		System.out.println("Enter your choice: ");
		int ch = sc.nextInt();
		
		int app_no;
		
		switch(ch)
		{
		 	case 1:
		 		System.out.println("Enter Appointment Number:- ");
				app_no = sc.nextInt();
				
				ResultSet AppResultSet = st.executeQuery("SELECT * FROM Appointment WHERE AppNo = " + app_no);
			    if (!AppResultSet.next()) {
			        System.out.println("Appointment Number " + app_no + " does not exist.\n");
			        st.close();
			        con.close();
			        return;
			    }
				
		 		System.out.println("Enter Patient Id:- ");
				int p_id= sc.nextInt();
				
				 ResultSet patientResultSet = st.executeQuery("SELECT * FROM PatientDetails WHERE PId = " + p_id);
				    if (!patientResultSet.next()) {
				        System.out.println("Patient with id " + p_id + " does not exist.\n");
				        st.close();
				        con.close();
				        return;
				    }
				
		 		String ModPIdQuery=" update Appointment set PId = "+ p_id+" where AppNo ="+app_no+";";
		 		int res1=st.executeUpdate(ModPIdQuery);
				
				if(res1 == 0) {
					System.out.println("Record not updated\n");
				}else {
					System.out.println("Record updated succesfully\n");
				}
		 		break;
			
		 	case 2:
		 		System.out.println("Enter Appointment Number:- ");
				app_no = sc.nextInt();
				
				AppResultSet = st.executeQuery("SELECT * FROM Appointment WHERE AppNo = " + app_no);
			    if (!AppResultSet.next()) {
			        System.out.println("Appointment Number " + app_no + " does not exist.\n");
			        st.close();
			        con.close();
			        return;
			    }
				
		 		System.out.println("\nEnter Doctor Id:- ");
				int d_id= sc.nextInt();
				
				ResultSet doctorResultSet = st.executeQuery("SELECT * FROM DoctorDetails WHERE DId = " + d_id);
			    if (!doctorResultSet.next()) {
			        System.out.println("Doctor with id " + d_id + " does not exist.\n");
			        st.close();
			        con.close();
			        return;
			    }
				
				
		 		String ModDIdQuery=" update Appointment set DId = "+ d_id+" where AppNo ="+app_no+";";
		 		int res2=st.executeUpdate(ModDIdQuery);
				
				if(res2 == 0) {
					System.out.println("Record not updated\n");
				}else {
					System.out.println("Record updated succesfully\n");
				}
		 		break;
		 		
		 	case 3:
		 		System.out.println("Enter Appointment Number:- ");
				app_no = sc.nextInt();
				
				AppResultSet = st.executeQuery("SELECT * FROM Appointment WHERE AppNo = " + app_no);
			    if (!AppResultSet.next()) {
			        System.out.println("Appointment Number " + app_no + " does not exist.\n");
			        st.close();
			        con.close();
			        return;
			    }
				
		 		System.out.println("Enter Date of Appointment (DD/MM/YY):- ");
				String app_date= sc.next();
				
				System.out.println("Enter Time of Appointment (Eg: 10am-10:30am) :- ");
				String app_time = sc.next();
				
				String checkQuery = "SELECT * FROM Appointment WHERE AppDate = '" + app_date + "' AND AppTime = '" + app_time + "'";
			    ResultSet rs = st.executeQuery(checkQuery);
			    if (rs.next()) {
			        System.out.println("Sorry, the time slot is already taken.\n");
			        st.close();
			        con.close();
			        return;
			    }
				
		 		String ModDateQuery=" update Appointment set AppDate = '"+ app_date +"', AppTime = '" + app_time + "' where AppNo ="+app_no+";";
		 		int res3=st.executeUpdate(ModDateQuery);
				
				if(res3 == 0) {
					System.out.println("Record not updated\n");
				}else {
					System.out.println("Record updated succesfully\n");
				}
		 		break;
		 		
		 	/*case 4:
		 		System.out.println("Enter Appointment Number:- ");
				app_no = sc.nextInt();
		 		System.out.println("Enter Date of Appointment (Eg: 10am-10:30am) :- ");
				String app_time = sc.next();
		 		String ModTimeQuery =" update Appointment set AppTime = '"+ app_time +"' where AppNo ="+app_no+";";
		 		int res4=st.executeUpdate(ModTimeQuery);
				
				if(res4 == 0) {
					System.out.println("Record not updated\n");
				}else {
					System.out.println("Record updated succesfully\n");
				}
		 		break;*/
		 		
		 	case 0:
		 		break;
		 		
		 	default:
		 		System.out.println("Invalid Choice!!!\n");
		}
		 		
		st.close();
		con.close();
		//sc.close();
		
	}
	
	public static void AppShowAll() throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con=DriverManager.getConnection
				("jdbc:mysql://localhost:3306/project", "root","root123");
		Statement st=con.createStatement();
		Scanner sc=new Scanner(System.in);
		
		/*ResultSet rs=st.executeQuery("select * from Appointment;");
		
		while(rs.next()) {
			System.out.println(rs.getInt("AppNo")+" "+rs.getInt("PId")+" "+ rs.getInt("DId")+" "+rs.getString("AppDate")+" "
					+" "+rs.getString("AppTime"));
			
		}*/
		
		 ResultSet rs = st.executeQuery("SELECT a.AppNo, a.PId, a.DId, a.AppDate, a.AppTime, p.Name, d.DName " +
                 "FROM Appointment a " +
                 "JOIN PatientDetails p ON a.PId = p.PId " +
                 "JOIN DoctorDetails d ON a.DId = d.DId;");

		 while (rs.next()) {
			 System.out.println(
					 "Appointment No: " + rs.getInt("AppNo") + "\n" +
							 "Patient ID: " + rs.getInt("PId") + "\n" +
							 	"Patient Name: " + rs.getString("Name") + "\n" +
							 	"Doctor ID: " + rs.getInt("DId") + "\n" +
							 	"Doctor Name: " + rs.getString("DName") + "\n" +
							 	"Appointment Date: " + rs.getString("AppDate") + "\n" +
							 	"Appointment Time: " + rs.getString("AppTime") + "\n"
					 );
}


		System.out.println("\n");
		st.close();
		con.close();
		
	}
	
	public static void AppShowOne() throws Exception {
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con=DriverManager.getConnection
				("jdbc:mysql://localhost:3306/project", "root","root123");
		Statement st=con.createStatement();
		Scanner sc=new Scanner(System.in);
		
		System.out.println("Enter Appointment Number:- ");
		int u_id=sc.nextInt();
		
		//ResultSet rs=st.executeQuery("select * from Appointment where AppNo ="+ u_id+";");
		
		/*while(rs.next()) {
			System.out.println(rs.getInt("AppNo")+" "+rs.getInt("PId")+" "+ rs.getInt("DId")+" "+rs.getString("AppDate")+" "
		+" "+rs.getString("AppTime"));
			
		}*/
		
		
		String query = "SELECT a.AppNo, a.PId, a.DId, a.AppDate, a.AppTime, p.Name, d.DName " +
                "FROM Appointment a " +
                "JOIN PatientDetails p ON a.PId = p.PId " +
                "JOIN Doctordetails d ON a.DId = d.DId " +
                "WHERE a.AppNo = " + u_id + ";";
		
		ResultSet rs = st.executeQuery(query);

	    if (rs.next()) {
	        System.out.println(
	            "Appointment No: " + rs.getInt("AppNo") + "\n" +
	            "Patient ID: " + rs.getInt("PId") + "\n" +
	            "Patient Name: " + rs.getString("Name") + "\n" +
	            "Doctor ID: " + rs.getInt("DId") + "\n" +
	            "Doctor Name: " + rs.getString("DName") + "\n" +
	            "Appointment Date: " + rs.getString("AppDate") + "\n" +
	            "Appointment Time: " + rs.getString("AppTime")
	        );
	    }
	    else {
	    	System.out.println("Record not present. Please enter a valid Appointment number\n");
	    }
		
		System.out.println("\n");
		st.close();
		con.close();
		
	}

}
