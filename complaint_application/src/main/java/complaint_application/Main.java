package complaint_application;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

import com.mysql.cj.protocol.Resultset;

public class Main {
	

	public void login() throws Exception{
		System.out.println("################### Log-IN #####################");
		User u=new User();
		u.setUserLogin();
		String Query="select email,password,name,role from user where email='"+u.getEmail()+"' and password='"+u.getPassword()+"';";
		 ResultSet rs=dbconnection_admin.getuser(Query);
		 String email="",pass="",name="",r="";
		 while(rs.next()) {
		 email=rs.getString(1);
		 pass= rs.getString(2);
		 name=rs.getString(3);
		 r=rs.getString(4);
		 }
		 if(email.equals(u.getEmail()) && pass.equals(u.getPassword())){
				if(r.equals("admin")) {
				    System.out.println("Login Success");
				    System.out.println("Welcome To Admin Portal "+name);
				    admin();
				}
				if(r.equals("user")) {
				    System.out.println("Login Success");
				    System.out.println("Welcome To Complaint Application "+name);
				    user();
				}
				
			}
			else {
				System.out.println("User does not exist");
				signUPUser();
			}
		
	}
	
	public void signUPUser() throws Exception{
		System.out.println("################### Sign-UP #####################");
		User r=new User();
		r.setUser();
		PreparedStatement pr=dbconnection_admin.getuserstatement();
		Connection con=dbconnection_admin.getCon();
		Statement s=con.createStatement();
		
	pr.setString(1, r.getEmail());
	pr.setString(2, r.getName());
	pr.setString(3, r.getPassword());
	pr.setString(4, r.getCon_pass());
	pr.setString(5, r.getPhone());
	pr.setString(6, r.getRole());
	if(r.getPassword().equals(r.getCon_pass())) {
	int i=pr.executeUpdate();
	if(i>0) {
		System.out.println("SIGN UP SUCCESS");
		login();
	}else {
		System.out.println("Email already exist");
	}
	}else {
		System.out.println("Password and Confirm Password should be same");
	}
	}
	public void insertOperations() throws Exception {
		 System.out.println("Insertion Portal");
		userInterface c=new userInterface();
		adminInterface cc=new adminInterface();
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter Your Choice");
		System.out.println("1:InsertUser");
		System.out.println("2:InsertElectrician");
		System.out.println("3:InsertPlumber");
		System.out.println("4:InsertCarWash");
		int n1=sc.nextInt();
		switch(n1) {
		case 1:cc.insertUser();
			break;
		case 2:c.Electricalcomplaint();
			break;
		case 3:c.Plumbercomplaint();
			break;
		case 4:c.Carwash();
			break;
		}
		
	}
	public void updateOperations() throws Exception{
		System.out.println("Updation Portal");
		adminInterface cc=new adminInterface();
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter Your Choice");
		System.out.println("1:UpdateUser");
		System.out.println("2:UpdateElectrician");
		System.out.println("3:UpdatePlumber");
		System.out.println("4:UpdateCarWash");
		int n1=sc.nextInt();
		switch(n1) {
		case 1:cc.updateuser();
			break;
		case 2:cc.updateElectrician();
			break;
		case 3:cc.updateplumber();
			break;
		case 4:cc.updatecarWash();
			break;
		}
		
	}
	public void deleteOperations() throws Exception{
		System.out.println("Delete Portal");
		adminInterface cc=new adminInterface();
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter Your Choice");
		System.out.println("1:DeleteUser");
		System.out.println("2:DeleteElectrician");
		System.out.println("3:DeletePlumber");
		System.out.println("4:DeleteCarWash");
		int n1=sc.nextInt();
		switch(n1) {
		case 1:cc.deleteuser();
			break;
		case 2:cc.deleteElectrician();
			break;
		case 3:cc.deletePlumber();
			break;
		case 4:cc.deletecarWash();
			break;
		}
		
	}
	public void admin() throws Exception{
		Scanner sc=new Scanner(System.in);
		System.out.println("Hello.......Admin");
		
		System.out.println("Enter Your Choice");
		System.out.println("1:Insert");
		System.out.println("2:Update");
		System.out.println("3:Delete");
		
		int n=sc.nextInt();
		switch (n) {
		case 1: insertOperations();
		break;
		case 2:updateOperations();
		break;
		case 3:deleteOperations();
		break;
			
		}
		
	}
	
	
	public void user() throws Exception {
		userInterface a=new userInterface(); 
		System.out.println("###############   Welcome to Complaint Application");
		System.out.println("###############   Choose your Complaint");
		System.out.println("###############   1:Electrician");
		System.out.println("###############   2:Plumber");
		System.out.println("###############   3:Car Wash");
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		switch(n) {
		case 1: a.Electricalcomplaint();
		    break;
		case 2: a.Plumbercomplaint();
			break;
		case 3:a.Carwash();
			break;
		}
	}
	
	
	
	
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		
		     try {
		    	 System.out.println("|--------------------------Complaint Appintlication-----------------------------|");
//		    	   Thread.sleep(2000);
		 		System.out.println("|---------------------------Enter Your choice-----------------------------------|");
		 		System.out.println("------------>  1:SignUp   <-------------");
		 		System.out.println("------------>  2:Login    <-------------");
		 		int n=sc.nextInt();
		 		     Main m=new Main();
		    	 switch (n) {
				case 1:
					   m.signUPUser();
					break;
				case 2:  
					m.login();
				break;
				default:
					break;
				}
		    
		     }catch(Exception e) {
		    	 System.out.println(e);
		     }
	}
	
}
