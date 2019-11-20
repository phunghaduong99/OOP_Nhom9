package oop.pushDataInDB;


import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import com.arangodb.ArangoDatabase;

import oop.beans.Event;
import oop.connectDB.ConnectArangoDB;
import java.sql.Connection;
public class PushEvents implements PushData{
	private ArrayList<Event> events;

	public PushEvents(ArrayList<Event> events) {
		this.events = events;
	}

	@Override
	public void pushData(int n) {
		ArangoDatabase arangoDatabase = ConnectArangoDB.getConnection();
		String aql = "INSERT INTO event(id,id_name, name,location, description, time) VALUES (?,?,?,?,?,?);";
		PreparedStatement preparedStatement;

		try {
			preparedStatement = (PreparedStatement) ((Connection) arangoDatabase).prepareStatement(aql);
			((Connection) arangoDatabase).setAutoCommit(false); // tắt chế độ tự động ký thác sql sau mỗi lần transaction
			int count = 1;
			for (int k = 0; k < n; k += 1) {

				preparedStatement.setInt(1, k + 1);
				preparedStatement.setString(2, events.get(k).getNhanHienThi()); // id_name trong database
				preparedStatement.setString(3, events.get(k).getDinhDanh());
				preparedStatement.setString(4, events.get(k).getMoTa());
				preparedStatement.setString(5, events.get(k).getTime());
				preparedStatement.setString(6, events.get(k).getLocation());
				preparedStatement.addBatch();
				count++;

				count--;
				if (count % 600 == 0) { // cứ sau 600 bản ghi được đưa vào Batch thì sẽ được đẩy lên server
					preparedStatement.executeBatch(); // đẩy 600 bản ghi lên server
					((Connection) arangoDatabase).commit(); // lưu lại trạng thái là đã đẩy xong
					System.out.println(k);
				}
				count++;
			}
			preparedStatement.executeBatch(); // số batch < 600 được đẩy nốt lên server
			((Connection) arangoDatabase).commit();
			preparedStatement.close();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
	}
		
}
