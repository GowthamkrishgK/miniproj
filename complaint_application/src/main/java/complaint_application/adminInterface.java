package complaint_application;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Formatter;
import java.util.Scanner;

public class adminInterface {
	
	
	///////////////////////////DISPLAY///////////////////////////////
	
	public void displayuser()throws Exception{
		String query="select * from user";
		ResultSet rs=dbconnection_admin.getuser(query);
		  System.out.println("Table User:");
		  Formatter fmt = new Formatter();  
		  fmt.format("%20s %20s %20s %20s %20s %20s %20s\n", "User Id", "Email", "Name","Password","confirm Password","PhoneNumber","Role");  
		  while(rs.next()) {
			  String email,name,password,con_pass,phonenumber,role;
			  int id;
			  email= rs.getString("email");
			  name=rs.getString("name");
			  password=rs.getString("password");
			  con_pass=rs.getString("con_pass");
			  phonenumber=rs.getString("phonenumber");
			  id=rs.getInt("id");
			  role=rs.getString("role");
			  fmt.format("%19s %19s %19s %19s %19s %19s %20s\n",id,email,name,password,con_pass,phonenumber,role );
			  
			  
		  }
		  System.out.println(fmt);
		  
	}
	public void displayelectrician()throws Exception{
		String query="select * from electrician;";
		ResultSet rs=dbconnection_admin.getuser(query);
		System.out.println("Table Electrician");
		  Formatter fmt = new Formatter();  
		  fmt.format("%14s %14s %14s %15s\n",  "id","Address","Date","Complain"); 
		  while(rs.next()) {
			  String Address,date,complain;
			  int id;
			  Address= rs.getString("address");
			  date=rs.getString("c_date");
			  complain=rs.getString("complain");
			  id=rs.getInt("e_id");
			  fmt.format("%14s %14s %14s %15s\n",id,Address,date,complain);
			  
			  
		  }
		  System.out.println(fmt);
		
	}
	public void displaycarwash()throws Exception{
		String query="select * from car_wash;";
		ResultSet rs=dbconnection_admin.getuser(query);
		System.out.println("Table carwash");
		  Formatter fmt = new Formatter();  
		  fmt.format("%14s %14s %14s %15s\n",  "id","Address","Date","Complain"); 
		  while(rs.next()) {
			  String Address,date,complain;
			  int id;
			  Address= rs.getString("address");
			  date=rs.getString("c_date");
			  complain=rs.getString("complain");
			  id=rs.getInt("wash_id");
			  fmt.format("%14s %14s %14s %15s\n",id,Address,date,complain);
			  
			  
		  }
		  System.out.println(fmt);
		
	}
	public void displayplumber()throws Exception{
		String query="select * from plumber;";
		ResultSet rs=dbconnection_admin.getuser(query);
		System.out.println("Table Plumber");
		  Formatter fmt = new Formatter();  
		  fmt.format("%14s %14s %14s %14s\n",  "id","Address","Date","Complain"); 
		  while(rs.next()) {
			  String Address,date,complain;
			  int id;
			  Address= rs.getString("address");
			  date=rs.getString("c_date");
			  complain=rs.getString("complain");
			  id=rs.getInt("p_id");
			  fmt.format("%14s %14s %14s %15s\n",id,Address,date,complain);
			  
			  
		  }
		  System.out.println(fmt);
		
	}
	/////////////////////////////INSERT////////////////////////////////////////////////
	public void insertUser() throws Exception{
		System.out.println("################### Add user #####################");
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
		System.out.println("Insertion is done Successsfully");
		
	}else {
		System.out.println("Email already exist");
	}
	}else {
		System.out.println("Password and Confirm Password should be same");
	}
	}
	
	
	public void Electricalcomplaint() throws Exception {
		System.out.println("*************INSERT Electrical Complaint*************");
		System.out.println();
		System.out.println();
		System.out.println();
		Scanner sc=new Scanner(System.in);
		PreparedStatement pr=dbconnection_admin.getelectrician();
		Electrician e=new Electrician();
		System.out.println();
		System.out.println("Enter Address");
		String address=sc.next();
		System.out.println("Enter complain date in yyyy-mm-dd format");
		String date=sc.next();
		System.out.println("Enter the complaint ");
		String complain=sc.next();
		e.setElectrician(address, date, complain);
		   pr.setString(1, e.getAddress());
		   pr.setString(2, e.getC_date());
		   pr.setString(3, e.getComplain());
		  int i= pr.executeUpdate();
		  if(i>0) {
			  System.out.println();
			  System.out.println("Complaint Inserted");
			  System.out.println();
		  }
		   
	}
	
	public void Plumbercomplaint() throws Exception{
		System.out.println("*************INSERT Plumber Complaint*************");
		System.out.println();
		System.out.println();
		System.out.println();
		Scanner sc=new Scanner(System.in);
		PreparedStatement pr=dbconnection_admin.getcarWash();
		System.out.println("Enter Address");
		String address=sc.next();
		System.out.println("Enter complain date in yyyy-mm-dd format");
		String date=sc.next();
		System.out.println("Enter the complaint ");
		String complain=sc.next();
		 pr.setString(1, address);
		   pr.setString(2, date);
		   pr.setString(3, complain);
		   int i= pr.executeUpdate();
			  if(i>0) {
				  System.out.println();
				  System.out.println("Your complaint has been inserted");
				  System.out.println();
			  }
	}
	public void Carwash() throws Exception{
		System.out.println("*************INSERT CarWash Complaint*************");
		System.out.println();
		System.out.println();
		System.out.println();
		Scanner sc=new Scanner(System.in);
		PreparedStatement pr=dbconnection_admin.getcarWash();
		System.out.println();
		System.out.println("Enter Address");
		String address=sc.next();
		System.out.println();
		System.out.println("Enter complain date in yyyy-mm-dd format");
		System.out.println();
		String date=sc.next();
		System.out.println();
		System.out.println("Enter the complaint ");
		System.out.println();
		String complain=sc.next();
		 pr.setString(1, address);
		   pr.setString(2, date);
		   pr.setString(3, complain);
		   int i= pr.executeUpdate();
			  if(i>0) {
				  System.out.println();
				  System.out.println("Your complaint has been inserted");
				  System.out.println();
			  }
	}
	/////////////////////UPDATE////////////////////////////////////////////////////////
	public void updateuser()throws Exception {
		String[] r= {"user","admin"};
		Scanner sc=new Scanner(System.in);
		displayuser();
		System.out.println("Select the id for the row you want to update");
		int id=sc.nextInt();
		String query="UPDATE user SET email = ?, name = ?,password=?,con_pass=?,phonenumber=?,role=? WHERE id=? ;";
		PreparedStatement p=dbconnection_admin.updatequery(query);
		
		System.out.print("\n Enter Emaill");
		String email=sc.next();
		System.out.println("Enter Name");
		String name=sc.next();
		System.out.println("Enter Password");
		String password=sc.next();
		System.out.println("Enter Confirm Pass");
		String con_pass=sc.next();
		System.out.println("Enter Phone");
		String phonenumber=sc.next();
		
		String role="";
		System.out.println("Enter your Choice");
		System.out.println("1:user");
		System.out.println("2:Admin");
		int n=sc.nextInt();
		switch (n) {
		case 1:role=r[0];
		break;
		case 2:role=r[1];
		break;
		}	
		p.setString(1,email);
		p.setString(2,name);
		p.setString(3,password);
		p.setString(4,con_pass);
		p.setString(5,phonenumber);
		p.setString(6,role);
		p.setInt(7, id);
		int i=p.executeUpdate();
		if(i>0)
			System.out.println("User updated Successfully");
		else
			System.out.println("update failed");
		    
		
	}
	
	
	
	
	public void updateplumber()throws Exception {
		Scanner sc=new Scanner(System.in);
		displayplumber();
		System.out.println("Select the id for the row you want to update");
		int id=sc.nextInt();
		String query="UPDATE plumber SET  address = ?, c_date = ?,complain=? WHERE p_id=? ;";
		PreparedStatement p=dbconnection_admin.updatequery(query);
		System.out.print("\n Enter Address ");
		String Address=sc.next();
		System.out.println("Enter date in yyyy-mm-dd format");
		String date=sc.next();
		System.out.println("Enter complain");
		String complain=sc.next();
		p.setString(1,Address);
		p.setString(2,date);
		p.setString(3,complain);
		p.setInt(4, id);
		int i=p.executeUpdate();
		if(i>0)
			System.out.println("plumber updated Successfully");
		else
			System.out.println("update failed");
		
	}
	public void updatecarWash()throws Exception {
		Scanner sc=new Scanner(System.in);
		displaycarwash();
		System.out.println("Select the id for the row you want to update");
		int id=sc.nextInt();
		String query="UPDATE car_wash SET  address = ?, c_date = ?,complain=? WHERE wash_id=? ;";
		PreparedStatement p=dbconnection_admin.updatequery(query);
		System.out.print("\n Enter Address ");
		String Address=sc.next();
		System.out.println("Enter date in yyyy-mm-dd format");
		String date=sc.next();
		System.out.println("Enter complain");
		String complain=sc.next();
		p.setString(1,Address);
		p.setString(2,date);
		p.setString(3,complain);
		p.setInt(4, id);
		int i=p.executeUpdate();
		if(i>0)
			System.out.println("CarWash updated Successfully");
		else
			System.out.println("update failed");
	}
	public void updateElectrician()throws Exception {
		Scanner sc=new Scanner(System.in);
		displayelectrician();
		System.out.println("Select the id for the row you want to update");
		int id=sc.nextInt();
		String query="UPDATE electrician SET  address = ?, c_date = ?,complain=? WHERE e_id=? ;";
		PreparedStatement p=dbconnection_admin.updatequery(query);
		System.out.print("\n Enter Address ");
		String Address=sc.next();
		System.out.println("Enter date in yyyy-mm-dd format");
		String date=sc.next();
		System.out.println("Enter complain");
		String complain=sc.next();
		p.setString(1,Address);
		p.setString(2,date);
		p.setString(3,complain);
		p.setInt(4, id);
		int i=p.executeUpdate();
		if(i>0)
			System.out.println("Electrician updated Successfully");
		else
			System.out.println("update failed");
	}
	////////////////////////////////DELETE///////////////////////////////

	public void deleteuser() throws Exception{
		displayuser();
		System.out.println("################### Delete user #####################");
		Scanner sc=new Scanner(System.in);
		System.out.println("Select the id for the row you want to delete");
		int id=sc.nextInt();
		String query="Delete  from user where id=?";
		PreparedStatement p=dbconnection_admin.updatequery(query);
		p.setInt(1,id);
		int i=p.executeUpdate();
		if(i>0)
			System.out.println("User deleted Successfully");
		else
			System.out.println("delete failed");
		
	}
	public void deleteElectrician() throws Exception{
		displayelectrician();
		Scanner sc=new Scanner(System.in);
		System.out.println("Select the id for the row you want to delete");
		int id=sc.nextInt();
		String query="Delete  from electrician where e_id=?";
		PreparedStatement p=dbconnection_admin.updatequery(query);
		p.setInt(1,id);
		int i=p.executeUpdate();
		if(i>0)
			System.out.println("Electrician deleted Successfully");
		else
			System.out.println("delete failed");
		
	}
public void deletePlumber() throws Exception{
	displayplumber();
	Scanner sc=new Scanner(System.in);
	System.out.println("Select the id for the row you want to delete");
	int id=sc.nextInt();
	String query="Delete  from plumber where p_id=?";
	PreparedStatement p=dbconnection_admin.updatequery(query);
	p.setInt(1,id);
	int i=p.executeUpdate();
	if(i>0)
		System.out.println("Plumber deleted Successfully");
	else
		System.out.println("delete failed");
	}
public void deletecarWash() throws Exception{
	displaycarwash();
	Scanner sc=new Scanner(System.in);
	System.out.println("Select the id for the row you want to delete");
	int id=sc.nextInt();
	String query="Delete  from car_wash where wash_id=?";
	PreparedStatement p=dbconnection_admin.updatequery(query);
	p.setInt(1,id);
	int i=p.executeUpdate();
	if(i>0)
		System.out.println("carwash deleted Successfully");
	else
		System.out.println("delete failed");
	
}
}
