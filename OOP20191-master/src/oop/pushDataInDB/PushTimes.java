package oop.pushDataInDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import com.arangodb.ArangoDatabase;

import oop.beans.Time;
import oop.connectDB.ConnectArangoDB;


public class PushTimes implements PushData{
	private ArrayList<Time> times;


	public PushTimes(ArrayList<Time> times) {
		this.times = times;
	}

	@Override
	public void pushData(int n) {

		ArangoDatabase arangoDatabase = ConnectArangoDB.getConnection();
		String sql = "INSERT INTO Time(id, id_name, time, description) VALUES (?,?,?,?,?);";
		PreparedStatement preparedStatement;

		try {
			preparedStatement = (PreparedStatement) ((Connection) arangoDatabase).prepareStatement(sql);
			((Connection) arangoDatabase).setAutoCommit(false); // tắt chế độ tự động ký thác sql sau mỗi lần transaction
			int count = 1;
			for (int k = 0; k < n; k += 1) {
				preparedStatement.setInt(1, k + 1);
				preparedStatement.setString(2, times.get(k).getDinhDanh());
				preparedStatement.setString(3, times.get(k).getNhanHienThi());
				preparedStatement.setString(3, times.get(k).getMoTa());
				preparedStatement.setString(4, times.get(k).getTime());
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
