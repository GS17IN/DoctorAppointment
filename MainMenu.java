package AppSystem;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

public class MainMenu {
	public static void main(String[] args) throws Exception {
		
		Scanner sc = new Scanner(System.in);
		
		try (Connection con = DriverManager.getConnection
				("jdbc:mysql://localhost:3306/project", "root","root123"))
		{
			boolean exit = false;
			boolean flag ;
			
			int ch;
			while(!exit) {
				
				flag = false;
				System.out.println("___________MAIN MENU OF DOCTOR APPOINTMENT SYSTEM___________\n");
				System.out.println("1. Patient Menu ");
				System.out.println("2. Display Doctor Details ");
				System.out.println("3. Appointment Menu ");
				System.out.println("0. Exit\n ");
				System.out.println("Enter your choice: ");
				int choice = sc.nextInt();
				
				switch(choice)
				{
					case 1:
						while(!flag)
						{
							System.out.println("------------PATIENT MENU-------------- ");
							System.out.println("1. Register Patient ");
							System.out.println("2. Modify  Patient Details ");
							System.out.println("3. Delete Patient Record");
							System.out.println("4. View All Records");
							System.out.println("5. View Single Record");
							System.out.println("0. Exit \n");
							System.out.println("Enter your choice: ");
							ch = sc.nextInt();
							switch(ch)
							{
								case 1:
									PatientInsert.PInsert();
									break;
				    			
								case 2:
									PatientModify.PModify();
									break;
				    			
								case 3:
									PatientDelete.PDelete();
									break;
				    		
								case 4:
									PatientDetails.PDetails();
									break;
				    		
								case 5:
									PatientDetails.PSingleDetails();
									break;
				    			
								case 0:
									flag = true;
									break;
				    			
								default:
									System.out.println("Invalid Choice!!! Please select again\n ");
							}
							//break;
						}
						break;
						
						case 2:
							DoctorDetails.RetrieveDetails();
							break;
							
						case 3:
							while(!flag) {
								System.out.println("----------APPOINTMENT MENU-------------- ");
								System.out.println("1. Book An Appointment ");
								System.out.println("2. Modify Appointment Details");
								System.out.println("3. Delete An Appointment");
								System.out.println("4. View All Records");
								System.out.println("5. View Single Record");
								System.out.println("0. Exit \n");
								System.out.println("Enter your choice: ");
							    ch = sc.nextInt();
							    
							    switch(ch)
							    {
							    case 1:
							    	Appointment.AppInsert();					
							    	break;
						    	
						    	case 2:
						    		Appointment.AppModify();
						    		break;
						    		
						    	case 3:
						    		Appointment.AppDelete();
						    		break;
						    		
						    	case 4:
						    		Appointment.AppShowAll();
						    		break;
						    		
						    	case 5:
						    		Appointment.AppShowOne();
						    		break;
						    		
						    	case 0:
						    		flag = true;
						    		break;
						    		
						    	default:
						    		System.out.println("Invalid Choice!!! Please select again \n");
							    }
							}
							break;
							
						case 0:
							exit = true;
							break;
							
						default:
							System.out.println("Invalid Choice!!! Please select again \n");
							
				}
			}
		}catch (SQLException e)
		{
			  e.printStackTrace();
		}
		sc.close();
	}
}


