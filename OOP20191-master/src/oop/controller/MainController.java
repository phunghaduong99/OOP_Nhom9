package oop.controller;

import java.util.Properties;

import org.apache.log4j.PropertyConfigurator;
import com.arangodb.ArangoDatabase;

import oop.connectdb.ConnectArangoDB;
import oop.pushdataindb.PushDataInDatabase;

public class MainController {
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

		PushDataInDatabase.save((int)(10000/7), (int)(10000/11));

		end = System.currentTimeMillis(); // start lấy thời gian theo millisecond

		System.out.println("Time Millis: " + (end - start));
		System.out.println("success");

	}
}
