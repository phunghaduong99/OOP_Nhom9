package oop.pushDataInDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import com.arangodb.ArangoDatabase;

import oop.beans.Person;
import oop.connectDB.ConnectArangoDB;



public class PushPersons implements PushData{
	private ArrayList<Person> people;
	public PushPersons(ArrayList<Person> people) {
		this.people = people;
	}
	@Override
	public void pushData(int n) {
		ArangoDatabase arangoDatabase = ConnectArangoDB.getConnection();
		String aql = "INSERT INTO organization(id,id_name, name,gender, description, position) VALUES (?,?,?,?,?,?);";
		PreparedStatement preparedStatement;

		try {
			preparedStatement = (PreparedStatement) ((Connection) arangoDatabase).prepareStatement(aql);
			((Connection) arangoDatabase).setAutoCommit(false); // tắt chế độ tự động ký thác sql sau mỗi lần transaction
			int count = 1;
			for (int k = 0; k < n; k += 1) {

				preparedStatement.setInt(1, k + 1);
				preparedStatement.setString(2, people.get(k).getDinhDanh());
				preparedStatement.setString(3, people.get(k).getNhanHienThi());
				preparedStatement.setString(4, people.get(k).getMoTa());
				preparedStatement.setString(5, people.get(k).getQuocTich());
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
