package complaint_application;

import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

public class fileLogg {
public void loguser() throws Exception {
	FileOutputStream fr=new FileOutputStream("loguser.txt");


	  SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
	   Date now=new Date();
	                 sdf.format(now);
	                 System.out.println(sdf);
	fr.write(null);
}
public static void main(String[] args) throws Exception {
	   
}
}
