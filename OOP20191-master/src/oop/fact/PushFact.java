package oop.fact;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import com.arangodb.ArangoDB;

import oop.connectDB.ConnectArangoDB;
import oop.pushDataInDB.PushData;



public class PushFact implements PushData{
	private ArrayList<Fact> facts;

	public PushFact(ArrayList<Fact> facts) {
		this.facts= facts;
	}

	@Override
	public void pushData(int n) {

		com.arangodb.ArangoDatabase arangoDatabase = ConnectArangoDB.getConnection();
		String sql = "INSERT INTO relationShip(id,entity1, relationShip, entity2) VALUES (?,?,?,?);";
		PreparedStatement preparedStatement;

		try {
			preparedStatement = (PreparedStatement) ((Connection) arangoDatabase).prepareStatement(sql);
			((Connection) arangoDatabase).setAutoCommit(false); // tắt chế độ tự động ký thác sql sau mỗi lần transaction
			int count = 1;
			for (int k = 0; k < n; k += 1) {

				preparedStatement.setInt(1, k + 1);
				preparedStatement.setString(2, facts.get(k).getEntity1());
				preparedStatement.setString(3, facts.get(k).getFact());
				preparedStatement.setString(4, facts.get(k).getEntity2());

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
