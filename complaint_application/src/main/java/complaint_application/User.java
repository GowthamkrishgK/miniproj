package complaint_application;

import java.util.Scanner;

public class User {
	private String name;
	private String email;
	private String phone;
	private String password;
	private String con_pass;
	private String role;
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	Scanner sc=new Scanner(System.in);

	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getCon_pass() {
		return con_pass;
	}
	public void setCon_pass(String con_pass) {
		this.con_pass = con_pass;
	}
	public void setUser() {
		String[] s= {"user","admin"};
		System.out.println("Enter user name ");
		 name=sc.nextLine();
		 System.out.println("Enter Email");
		 email=sc.nextLine();
		 System.out.println("Enter Phone Number");
		 phone=sc.nextLine();
		System.out.println("Enter Password");
		 password=sc.nextLine();
		 System.out.println("Confirm Password");
		 con_pass=sc.nextLine();
		 System.out.println("Select the Role");
		 System.out.println("1:Admin Role");
		 System.out.println("2:User Role");
		 int n=sc.nextInt();
		 if(n==1)
			 role=s[1];
		 if(n==2)
			 role=s[0];
		 
		 
	}
	public void setUserLogin() {
		System.out.println("**********Login");
		System.out.println("Enter Email");
		setEmail(sc.nextLine());
		System.out.println("Enter Password");
		setPassword(sc.nextLine());
	}
	
}
