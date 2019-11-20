package oop.pushDataInDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import com.arangodb.ArangoDatabase;

import oop.beans.Country;
import oop.connectDB.ConnectArangoDB;


public class PushCountries implements PushData{
	private ArrayList<Country> countrys;

	public PushCountries(ArrayList<Country> countrys) {
		// TODO Auto-generated constructor stub
		this.countrys = countrys;
	}

	
	@Override
	public void pushData(int n) {

		ArangoDatabase arangoDatabase = ConnectArangoDB.getConnection();
		String aql = "INSERT INTO country(id,id_name, name, population, description) VALUES (?,?,?,?,?);";
		PreparedStatement preparedStatement;

		try {
			preparedStatement = (PreparedStatement) ((Connection) arangoDatabase).prepareStatement(aql);
			((Connection) arangoDatabase).setAutoCommit(false); // tắt chế độ tự động ký thác sql sau mỗi lần transaction
			int count = 1;
			for (int k = 0; k < n; k += 1) {

				preparedStatement.setInt(1, k + 1);
				preparedStatement.setString(2, countrys.get(k).getDinhDanh()); // id_name
				preparedStatement.setString(3, countrys.get(k).getMoTa());
				preparedStatement.setString(4, countrys.get(k).getNhanHienThi());
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
