package oop.fact;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import com.arangodb.ArangoDBException;
import com.arangodb.ArangoDatabase;
import com.arangodb.entity.BaseDocument;
import oop.connectdb.ConnectArangoDB;

public class PushFact {
	String collectionName;
	int m;

	public void setM(int m) {
		this.m = m;
	}

	public PushFact(String collectionName, int m) {
		this.collectionName = collectionName;
		this.m = m;
	}

	public void pushFactInDb(List<String> a, List<String> b, List<String> c, String relation, String loai) {
		ArangoDatabase arangoDatabase = ConnectArangoDB.getConnection();
		Random rd = new Random();
		int a_size = a.size();
		int b_size = b.size();
		int c_size = c.size();
		try {
			ArrayList<BaseDocument> listdocs = new ArrayList<BaseDocument>();
			for (int k = 0; k < m; k++) {
				int randomS = rd.nextInt(a_size);
				int randomO = rd.nextInt(b_size);
				int randomT = rd.nextInt(c_size);
				Fact fact = new Fact(a.get(randomS), b.get(randomO), relation,
						c.get(randomT));
				BaseDocument myObject = this.createBaseDocumentFact(fact, k, loai);
				listdocs.add(myObject);
				if (k % 500 == 0) {
					arangoDatabase.collection(collectionName).insertDocuments(listdocs);
					listdocs.clear();
				}
			}
			arangoDatabase.collection(collectionName).insertDocuments(listdocs);
		} catch (ArangoDBException e) {
			System.err.println("Failed to import Fact: " + e.getMessage());
		}
	}
	public BaseDocument createBaseDocumentFact(Fact fact, int k, String type) {
		BaseDocument myObject = new BaseDocument();
		myObject.setKey(String.valueOf(k) + type);
		myObject.addAttribute("Subject", fact.getSubject());
		myObject.addAttribute("Object", fact.getObject());
		myObject.addAttribute("QuanHe", fact.getRelationShip());
		myObject.addAttribute("Time", fact.getTime());
		return myObject;
	}
	public String getCollectionName() {
		return collectionName;
	}

	public void setCollectionName(String collectionName) {
		this.collectionName = collectionName;
	}

	public int getM() {
		return m;
	}
	
	
}
