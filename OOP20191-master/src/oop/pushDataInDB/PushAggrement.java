package oop.pushDataInDB;

import java.util.ArrayList;
import com.arangodb.ArangoDBException;
import com.arangodb.ArangoDatabase;
import com.arangodb.entity.BaseDocument;

import oop.connectDB.ConnectArangoDB;
import oop.model.AggrementModel;



//INSERT document INTO collection [ OPTIONS options ]
public class PushAggrement implements PushData{

	private ArrayList<AggrementModel> aggrements;
	public PushAggrement(ArrayList<AggrementModel> aggrements) {
		this.aggrements = aggrements;
	}
	@Override
	public void pushData(int n, String collectionName) {
		ArangoDatabase arangoDatabase = ConnectArangoDB.getConnection();
		try {
			ArrayList <BaseDocument> listdocs = new ArrayList <BaseDocument>();
			for (int k = 0; k < n; k ++) {
				BaseDocument myObject = new BaseDocument();
				myObject.setKey(String.valueOf(k));
				myObject.addAttribute("NhanHienThi", aggrements.get(k).getNhanHienThi());
				myObject.addAttribute("DinhDanh", aggrements.get(k).getDinhDanh());
				myObject.addAttribute("MoTa", aggrements.get(k).getMoTa());
				myObject.addAttribute("Location", aggrements.get(k).getLocation());
				myObject.addAttribute("Time", aggrements.get(k).getTime());
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
