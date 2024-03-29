package oop.pushdataindb;

import java.util.ArrayList;

import com.arangodb.ArangoDBException;
import com.arangodb.ArangoDatabase;
import com.arangodb.entity.BaseDocument;

import oop.connectdb.ConnectArangoDB;
import oop.model.CountryModel;


public class PushCountries implements IPushData{
	private ArrayList<CountryModel> countrys;

	public PushCountries(ArrayList<CountryModel> countrys) {
		// TODO Auto-generated constructor stub
		this.countrys = countrys;
	}
	
	@Override
	public void pushData(int n, String collectionName) {
		ArangoDatabase arangoDatabase = ConnectArangoDB.getConnection();
		try {
			ArrayList <BaseDocument> listdocs = new ArrayList <BaseDocument>();
			for (int k = 0; k < n; k ++) {
				BaseDocument myObject = new BaseDocument();
				myObject.setKey(String.valueOf(k));
				myObject.addAttribute("NhanHienThi", countrys.get(k).getNhanHienThi());
				myObject.addAttribute("DinhDanh", countrys.get(k).getDinhDanh());
				myObject.addAttribute("MoTa", countrys.get(k).getMoTa());
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
