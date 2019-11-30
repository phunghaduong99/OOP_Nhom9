package oop.pushdataindb;

import java.util.ArrayList;
import com.arangodb.ArangoDBException;
import com.arangodb.ArangoDatabase;
import com.arangodb.entity.BaseDocument;

import oop.connectdb.ConnectArangoDB;
import oop.model.TimeModel;


public class PushTimes implements IPushData{
	private ArrayList<TimeModel> times;


	public PushTimes(ArrayList<TimeModel> times) {
		this.times = times;
	}


	@Override
	public void pushData(int n, String collectionName) {
		ArangoDatabase arangoDatabase = ConnectArangoDB.getConnection();
		try {
			ArrayList <BaseDocument> listdocs = new ArrayList <BaseDocument>();
			for (int k = 0; k < n; k ++) {
				BaseDocument myObject = new BaseDocument();
				myObject.setKey(String.valueOf(k));
				myObject.addAttribute("NhanHienThi", times.get(k).getNhanHienThi());
				myObject.addAttribute("DinhDanh", times.get(k).getDinhDanh());
				myObject.addAttribute("MoTa", times.get(k).getMoTa());
				myObject.addAttribute("Time", times.get(k).getTime());
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
