package oop.pushdataindb;

import java.util.ArrayList;

import com.arangodb.ArangoDBException;
import com.arangodb.ArangoDatabase;
import com.arangodb.entity.BaseDocument;

import oop.connectdb.ConnectArangoDB;
import oop.model.LocationModel;


public class PushLocations implements IPushData{
	private ArrayList<LocationModel> locations;

	public PushLocations(ArrayList<LocationModel> locations) {
		this.locations = locations;
	}

	@Override
	public void pushData(int n, String collectionName) {
		ArangoDatabase arangoDatabase = ConnectArangoDB.getConnection();
		try {
			ArrayList <BaseDocument> listdocs = new ArrayList <BaseDocument>();
			for (int k = 0; k < n; k ++) {
				BaseDocument myObject = new BaseDocument();
				myObject.setKey(String.valueOf(k));
				myObject.addAttribute("NhanHienThi", locations.get(k).getNhanHienThi());
				myObject.addAttribute("DinhDanh", locations.get(k).getDinhDanh());
				myObject.addAttribute("MoTa", locations.get(k).getMoTa());
				myObject.addAttribute("Country", locations.get(k).getCountry());
				listdocs.add(myObject);
				if(k % 500 == 0) {
					arangoDatabase.collection(collectionName).insertDocuments(listdocs);
					listdocs.clear();
				}
			}
			arangoDatabase.collection(collectionName).insertDocuments(listdocs);
		}
		catch (ArangoDBException e) {
			System.err.println("Failed to create document: "   + e.getMessage());
		}
		
	}

}
