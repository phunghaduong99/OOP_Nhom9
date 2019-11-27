package oop.pushDataInDB;

import java.util.ArrayList;

import com.arangodb.ArangoDBException;
import com.arangodb.ArangoDatabase;
import com.arangodb.entity.BaseDocument;

import oop.connectDB.ConnectArangoDB;
import oop.model.OrganizationModel;

public class PushOrganizations implements PushData {
	private ArrayList<OrganizationModel> organizations;

	public PushOrganizations(ArrayList<OrganizationModel> organizations) {
		this.organizations = organizations;
	}

	@Override
	public void pushData(int n, String collectionName) {
		ArangoDatabase arangoDatabase = ConnectArangoDB.getConnection();
		try {
			ArrayList <BaseDocument> listdocs = new ArrayList <BaseDocument>();
			for (int k = 0; k < n; k ++) {
				BaseDocument myObject = new BaseDocument();
				myObject.setKey(String.valueOf(k));
				myObject.addAttribute("NhanHienThi", organizations.get(k).getNhanHienThi());
				myObject.addAttribute("DinhDanh", organizations.get(k).getDinhDanh());
				myObject.addAttribute("MoTa", organizations.get(k).getMoTa());
				myObject.addAttribute("TruSo", organizations.get(k).getTruSo());
				listdocs.add(myObject);
				if((k+1) % 5000 == 0) {
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
