package oop.pushdataindb;

import java.util.ArrayList;
import com.arangodb.ArangoDBException;
import com.arangodb.ArangoDatabase;
import com.arangodb.entity.BaseDocument;

import oop.connectdb.ConnectArangoDB;
import oop.model.PersonModel;



public class PushPersons implements IPushData{
	private ArrayList<PersonModel> people;
	public PushPersons(ArrayList<PersonModel> people) {
		this.people = people;
	}
	@Override
	public void pushData(int n, String collectionName) {
		ArangoDatabase arangoDatabase = ConnectArangoDB.getConnection();
		try {
			ArrayList <BaseDocument> listdocs = new ArrayList <BaseDocument>();
			for (int k = 0; k < n; k ++) {
				BaseDocument myObject = new BaseDocument();
				myObject.setKey(String.valueOf(k));
				myObject.addAttribute("NhanHienThi", people.get(k).getNhanHienThi());
				myObject.addAttribute("DinhDanh", people.get(k).getDinhDanh());
				myObject.addAttribute("MoTa", people.get(k).getMoTa());
				myObject.addAttribute("QuocTich", people.get(k).getQuocTich());
				listdocs.add(myObject);
				if(k % 500 == 0) {
					arangoDatabase.collection(collectionName).insertDocuments(listdocs);
					listdocs.clear();
				}
			}
			arangoDatabase.collection(collectionName).insertDocuments(listdocs);
		}
		catch (ArangoDBException e) {
			System.err.println("Failed to create document: " + collectionName  + e.getMessage());
		}
		
	}
}
