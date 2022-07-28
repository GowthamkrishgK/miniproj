package complaint_application;

public class Electrician {
private String address,c_date,complain;


public String getAddress() {
	return address;
}

public void setAddress(String address) {
	this.address = address;
}

public String getC_date() {
	return c_date;
}

public void setC_date(String c_date) {
	this.c_date = c_date;
}

public String getComplain() {
	return complain;
}

public void setComplain(String complain) {
	this.complain = complain;
}

public void setElectrician(String address,String date,String complain) {
	   System.out.println(" Electrical Complaint");
	  
	   this.address=address;
	   this.c_date=date;
	   this.complain=complain;
	   
}

}
