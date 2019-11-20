package oop.main;


import com.arangodb.ArangoDatabase;

import oop.connectDB.ConnectArangoDB;
import oop.connectDB.PushDataInDatabase;

public class TestMain {
	public static void main(String[] args) {
			ArangoDatabase c = ConnectArangoDB.getConnection();
			if (c == null) {
				System.out.println("something wrong");
			} else {
				System.out.println("ok");
			}
			
			long start, end;
			
	        start = System.currentTimeMillis(); // start lấy thời gian theo millisecond
	        
	        PushDataInDatabase.save(10000,20000);
	        
	        end = System.currentTimeMillis();   // start lấy thời gian theo millisecond
	        
	        System.out.println("Time Millis: " + (end - start));
	        System.out.println("success");
	       
		}
}
