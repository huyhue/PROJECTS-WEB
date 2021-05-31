package com.fpt.soft;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DepartmentProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(DepartmentProjectApplication.class, args);
		
//		2021-05-29 3:00 (String) 
//		2021-05-26 22:01:00.0 (SQL date)
// 		05/25/2021 9:33 PM (Tue May 25 21:33:00 ICT)       (booking date)
		
//		 String testDateString = "02/04/2014";
//		 DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
//		 
//		 String testDateString2 = "02-04-2014 23:37:50";
//		 DateFormat df2 = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
//	
//		try {
//			 Date d1 = df.parse(testDateString);//Wed Apr 02 00:00:00 ICT 2014
//	           System.out.println("Date: " + d1);
//	           System.out.println("Date in dd/MM/yyyy format is: "+df.format(d1)+ df.format(d1).getClass());
//		
//	           System.out.println("In ra: ");
//	           
//	           Date d2 = df2.parse(testDateString2);
//	           System.out.println("Date: " + d2);
//	           System.out.println("Date in dd-MM-yyyy HH:mm:ss format is: "+df2.format(d2));
//		} catch (ParseException e) {
//			e.printStackTrace();
//		}
		
	}

}
