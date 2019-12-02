package oop.dao;

import java.util.Map;

import com.arangodb.ArangoCursor;
import com.arangodb.ArangoDatabase;
import com.arangodb.entity.BaseDocument;
import com.arangodb.util.MapBuilder;

import oop.connectdb.ConnectArangoDB;

public class QueryArticle {
	private ArangoDatabase database;
	public QueryArticle() {
		this.database = ConnectArangoDB.getConnection();
	}

	public void query(String value, String collumnName, String collectionName ) {
		String query="FOR t IN "+ collectionName +" FILTER t."+ collumnName + " == @name RETURN t";
		Map<String, Object> bindVars = new MapBuilder().put("name", value).get();
		ArangoCursor<BaseDocument> cursor=database.query(query, bindVars, null, BaseDocument.class);
		cursor.forEachRemaining(aDocument -> {
			System.out.println("NhanHienThi: " + aDocument.getAttribute("NhanHienThi"));
			System.out.println("DinhDanh: " + aDocument.getAttribute("DinhDanh"));
			System.out.println("MoTa: " + aDocument.getAttribute("MoTa"));
			System.out.println();
		  });
	}
	
	
	
}
