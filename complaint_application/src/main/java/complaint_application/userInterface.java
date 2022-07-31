package complaint_application;

import java.sql.PreparedStatement;
import java.util.Scanner;

public class userInterface {
	public void reload() throws Exception {
		Main n=new Main();
		Scanner sc=new Scanner(System.in);
		System.out.println("Do you want to continue  : y/n" );
		System.out.println("y : User Portal");
		System.out.println("n : Exit");
		char c=sc.next().charAt(0);
		if(c=='y') {
			 System.out.println("Forwarding back to user interface");
        for(int k=0;k<5;k++) 
        {
        	System.out.print(".");
        	System.out.print(" ");
        	Thread.sleep(400);
        }
        
        n.user();
		}
		else if(c=='n') {
			for(int k=0;k<5;k++) 
	        {
	        	System.out.print(".");
	        	System.out.print(" ");
	        	Thread.sleep(400);
	        }
			n.main(null);
		}
		
	}
	public void Electricalcomplaint() throws Exception {
		System.out.println("*************Electrical Complaint*************");
		System.out.println();
		System.out.println();
		System.out.println();
		Scanner sc=new Scanner(System.in);
		PreparedStatement pr=dbconnection_admin.getelectrician();
		Electrician e=new Electrician();
		System.out.println();
		System.out.println("Enter Address");
		System.out.println();
		String address=sc.nextLine();
		System.out.println();
		System.out.println("Enter complain date in yyyy-mm-dd format");
		System.out.println();
		String date=sc.nextLine();
		System.out.println();
		System.out.println("Enter the complaint ");
		System.out.println();
		String complain=sc.nextLine();
		
		e.setElectrician(address, date, complain);
		   pr.setString(1, e.getAddress());
		   pr.setString(2, e.getC_date());
		   pr.setString(3, e.getComplain());
		  int i= pr.executeUpdate();
		  if(i>0) {
			  System.out.println();
			  System.out.println("Your complaint has been recorded");
			  System.out.println();
			  consoleHelper consoleHelper = new consoleHelper();
		        for (int j = 0; j < 20; j++) {
		            consoleHelper.animate(i + "");
		            //simulate a piece of task
		            Thread.sleep(400);
		        }
		        System.out.println("Electrical Complaint cleared");
		        reload();
		       
		  }
		   
	}
	
	public void Plumbercomplaint() throws Exception{
		System.out.println("*************Plumber Complaint*************");
		System.out.println();
		System.out.println();
		System.out.println();
		Scanner sc=new Scanner(System.in);
		PreparedStatement pr=dbconnection_admin.getcarWash();
		System.out.println("Enter Address");
		System.out.println();
		String address=sc.nextLine();
		System.out.println("Enter complain date in yyyy-mm-dd format");
		System.out.println();
		String date=sc.nextLine();
		System.out.println("Enter the complaint ");
		System.out.println();
		String complain=sc.nextLine();
		 pr.setString(1, address);
		   pr.setString(2, date);
		   pr.setString(3, complain);
		   int i= pr.executeUpdate();
			  if(i>0) {
				  System.out.println();
				  System.out.println("Your complaint has been recorded");
				  System.out.println();
				  consoleHelper consoleHelper = new consoleHelper();
			        for (int j = 0; j < 20; j++) {
			            consoleHelper.animate(i + "");
			            //simulate a piece of task
			            Thread.sleep(400);
			        }
			        System.out.println("Plumber Complaint cleared");
			       reload();
			  }
	}
	public void Carwash() throws Exception{
		System.out.println("*************CarWash Complaint*************");
		System.out.println();
		System.out.println();
		System.out.println();
		Scanner sc=new Scanner(System.in);
		PreparedStatement pr=dbconnection_admin.getcarWash();
		System.out.println();
		System.out.println("Enter Address");
		String address=sc.nextLine();
		System.out.println();
		System.out.println("Enter complain date in yyyy-mm-dd format");
		System.out.println();
		String date=sc.nextLine();
		System.out.println();
		System.out.println("Enter the complaint ");
		System.out.println();
		String complain=sc.nextLine();
		 pr.setString(1, address);
		   pr.setString(2, date);
		   pr.setString(3, complain);
		   int i= pr.executeUpdate();
			  if(i>0) {
				  System.out.println();
				  System.out.println("Your complaint has been recorded");
				  System.out.println();
				  consoleHelper consoleHelper = new consoleHelper();
			        for (int j = 0; j < 20; j++) {
			            consoleHelper.animate(i + "");
			            //simulate a piece of task
			            Thread.sleep(400);
			        }
			        System.out.println("CarWash Complaint cleared");
			        reload();
			       
			  }
	}
	
}
