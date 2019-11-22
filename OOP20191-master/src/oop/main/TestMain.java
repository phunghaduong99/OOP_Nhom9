package oop.main;

import java.util.Properties;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.PropertyConfigurator;

import com.arangodb.ArangoDatabase;

import oop.connectDB.ConnectArangoDB;
import oop.connectDB.PushDataInDatabase;

public class TestMain {
	public static void main(String[] args) {
		Properties prop = new Properties();
		prop.setProperty("log4j.rootLogger", "WARN");
		PropertyConfigurator.configure(prop);
		ArangoDatabase c = ConnectArangoDB.getConnection();
		if (c == null) {
			System.out.println("something wrong");
		} else {
			System.out.println("ok");
		}
		
		long start, end;

		start = System.currentTimeMillis(); // start lấy thời gian theo millisecond

		PushDataInDatabase.save(100, (int)(200/11));

		end = System.currentTimeMillis(); // start lấy thời gian theo millisecond

		System.out.println("Time Millis: " + (end - start));
		System.out.println("success");

	}
}
