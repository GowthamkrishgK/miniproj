package complaint_application;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class dbconnection_admin {
	private static String url,user,pass;
  static {
	url="jdbc:mysql://localhost:3306/miniproj";
	user="root";
	pass="root";
  }		
   private static Connection con;

public static Connection getCon() throws SQLException {
	con=DriverManager.getConnection(url,user,pass);
	return con;
}   
public static PreparedStatement getuserstatement() throws Exception {
	Connection con=dbconnection_admin.getCon();
	PreparedStatement pr=con.prepareStatement("insert into user(email,name,password,con_pass,phonenumber,role) values(?,?,?,?,?,?);");
	   return pr;	
}
public static ResultSet getuser(String loginQuery) throws Exception{
	

	Connection con=dbconnection_admin.getCon();
	 Statement st=con.createStatement();
	  ResultSet rs=st.executeQuery(loginQuery);
	  return rs;
}
public static PreparedStatement  getelectrician()throws Exception{
	String query=" insert into electrician (address,c_date,complain) values(?,?,?);";
	Connection con=dbconnection_admin.getCon();
	PreparedStatement pt=con.prepareStatement(query);
	return pt;
}
public static PreparedStatement getplumber()throws Exception{
	String query="insert into plumber(address,c_date,complain) values(?,?,?);";
	Connection con=dbconnection_admin.getCon();
	PreparedStatement pt=con.prepareStatement(query);
	return pt;
}
public static PreparedStatement getcarWash()throws Exception{
	String query="insert into car_wash(address,c_date,complain) values(?,?,?);";
	Connection con=dbconnection_admin.getCon();
	PreparedStatement pt=con.prepareStatement(query);
	return pt;
}

public static PreparedStatement updatequery(String query)throws Exception{
	
	Connection con=dbconnection_admin.getCon();
	PreparedStatement pt=con.prepareStatement(query);
	return pt;
}

}
