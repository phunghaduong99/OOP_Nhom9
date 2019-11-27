package oop.fact;

import java.util.ArrayList;
import java.util.Random;

import com.arangodb.ArangoDBException;
import com.arangodb.ArangoDatabase;
import com.arangodb.entity.BaseDocument;

import oop.connectDB.ConnectArangoDB;
import oop.model.AggrementModel;
import oop.model.CountryModel;
import oop.model.EntityModel;
import oop.model.EventModel;
import oop.model.LocationModel;
import oop.model.OrganizationModel;
import oop.model.PersonModel;
import oop.model.TimeModel;

public class PushFact {
	String collectionName;
	int m;

	public PushFact(String collectionName, int m) {
		this.collectionName = collectionName;
		this.m = m;
	}

	public void pushFactIntoDatabase(ArrayList<OrganizationModel> organizations, ArrayList<TimeModel> times,
			ArrayList<CountryModel> countrys, ArrayList<EventModel> events, ArrayList<PersonModel> persons,
			ArrayList<LocationModel> locations, ArrayList<AggrementModel> aggrements) {
		this.gap_go(persons, persons, times);
		this.to_chuc(persons, events, times);
		this.ky_thoa_thuan(countrys, countrys, times);
		this.tham_gia(persons, organizations, times);
		this.dien_ra_tai(events, locations, times);
		this.ung_ho(persons, aggrements, times);
		this.phan_doi(persons, aggrements, times);
		this.phat_bieu_tai(persons, persons, times);
		this.cang_thang_voi(persons, persons, times);
		this.huy_bo(persons, persons, times);
		this.dam_phan_voi(persons, persons, times);
	}

	public void gap_go(ArrayList<PersonModel> a, ArrayList<PersonModel> b, ArrayList<TimeModel> c) {
		ArangoDatabase arangoDatabase = ConnectArangoDB.getConnection();
		Random rd = new Random();
		int n = a.size();
		try {
			ArrayList<BaseDocument> listdocs = new ArrayList<BaseDocument>();
			for (int k = 0; k < m; k++) {
				int randomS = rd.nextInt(n);
				int randomO = rd.nextInt(n);
				int randomT = rd.nextInt(n);
				Fact fact = new Fact(a.get(randomS).getNhanHienThi(), b.get(randomO).getNhanHienThi(), "gap_go",
						c.get(randomT).getNhanHienThi());
				BaseDocument myObject = this.createBaseDocumentFact(fact, k, "_1");
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

	public void to_chuc(ArrayList<PersonModel> a, ArrayList<EventModel> b, ArrayList<TimeModel> c) {
		ArangoDatabase arangoDatabase = ConnectArangoDB.getConnection();
		Random rd = new Random();
		int n = a.size();
		try {
			ArrayList<BaseDocument> listdocs = new ArrayList<BaseDocument>();
			for (int k = 0; k < m; k++) {
				int randomS = rd.nextInt(n);
				int randomO = rd.nextInt(n);
				int randomT = rd.nextInt(n);
				Fact fact = new Fact(a.get(randomS).getNhanHienThi(), b.get(randomO).getNhanHienThi(), "to_chuc",
						c.get(randomT).getNhanHienThi());
				BaseDocument myObject = this.createBaseDocumentFact(fact, k, "_2");
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

	public void ky_thoa_thuan(ArrayList<CountryModel> a, ArrayList<CountryModel> b, ArrayList<TimeModel> c) {
		ArangoDatabase arangoDatabase = ConnectArangoDB.getConnection();
		Random rd = new Random();
		int n = a.size();
		try {
			ArrayList<BaseDocument> listdocs = new ArrayList<BaseDocument>();
			for (int k = 0; k < m; k++) {
				int randomS = rd.nextInt(n);
				int randomO = rd.nextInt(n);
				int randomT = rd.nextInt(n);
				Fact fact = new Fact(a.get(randomS).getNhanHienThi(), b.get(randomO).getNhanHienThi(), "ky_thoa_thuan",
						c.get(randomT).getNhanHienThi());
				BaseDocument myObject = this.createBaseDocumentFact(fact, k, "_3");
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

	public void tham_gia(ArrayList<PersonModel> a, ArrayList<OrganizationModel> b, ArrayList<TimeModel> c) {
		ArangoDatabase arangoDatabase = ConnectArangoDB.getConnection();
		Random rd = new Random();
		int n = a.size();
		try {
			ArrayList<BaseDocument> listdocs = new ArrayList<BaseDocument>();
			for (int k = 0; k < m; k++) {
				int randomS = rd.nextInt(n);
				int randomO = rd.nextInt(n);
				int randomT = rd.nextInt(n);
				Fact fact = new Fact(a.get(randomS).getNhanHienThi(), b.get(randomO).getNhanHienThi(), "tham_gia",
						c.get(randomT).getNhanHienThi());
				BaseDocument myObject = this.createBaseDocumentFact(fact, k, "_4");
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

	public void dien_ra_tai(ArrayList<EventModel> a, ArrayList<LocationModel> b, ArrayList<TimeModel> c) {
		ArangoDatabase arangoDatabase = ConnectArangoDB.getConnection();
		Random rd = new Random();
		int n = a.size();
		try {
			ArrayList<BaseDocument> listdocs = new ArrayList<BaseDocument>();
			for (int k = 0; k < m; k++) {
				int randomS = rd.nextInt(n);
				int randomO = rd.nextInt(n);
				int randomT = rd.nextInt(n);
				Fact fact = new Fact(a.get(randomS).getNhanHienThi(), b.get(randomO).getNhanHienThi(), "dien_ra_tai",
						c.get(randomT).getNhanHienThi());
				BaseDocument myObject = this.createBaseDocumentFact(fact, k, "_5");
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

	public void ung_ho(ArrayList<PersonModel> a, ArrayList<AggrementModel> b, ArrayList<TimeModel> c) {
		ArangoDatabase arangoDatabase = ConnectArangoDB.getConnection();
		Random rd = new Random();
		int n = a.size();
		try {
			ArrayList<BaseDocument> listdocs = new ArrayList<BaseDocument>();
			for (int k = 0; k < m; k++) {
				int randomS = rd.nextInt(n);
				int randomO = rd.nextInt(n);
				int randomT = rd.nextInt(n);
				Fact fact = new Fact(a.get(randomS).getNhanHienThi(), b.get(randomO).getNhanHienThi(), "ung_ho",
						c.get(randomT).getNhanHienThi());
				BaseDocument myObject = this.createBaseDocumentFact(fact, k, "_6");
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

	public void phan_doi(ArrayList<PersonModel> a, ArrayList<AggrementModel> b, ArrayList<TimeModel> c) {
		ArangoDatabase arangoDatabase = ConnectArangoDB.getConnection();
		Random rd = new Random();
		int n = a.size();
		try {
			ArrayList<BaseDocument> listdocs = new ArrayList<BaseDocument>();
			for (int k = 0; k < m; k++) {
				int randomS = rd.nextInt(n);
				int randomO = rd.nextInt(n);
				int randomT = rd.nextInt(n);
				Fact fact = new Fact(a.get(randomS).getNhanHienThi(), b.get(randomO).getNhanHienThi(), "phan_doi",
						c.get(randomT).getNhanHienThi());
				BaseDocument myObject = this.createBaseDocumentFact(fact, k, "_7");
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

	public void phat_bieu_tai(ArrayList<PersonModel> a, ArrayList<PersonModel> b, ArrayList<TimeModel> c) {
		ArangoDatabase arangoDatabase = ConnectArangoDB.getConnection();
		Random rd = new Random();
		int n = a.size();
		try {
			ArrayList<BaseDocument> listdocs = new ArrayList<BaseDocument>();
			for (int k = 0; k < m; k++) {
				int randomS = rd.nextInt(n);
				int randomO = rd.nextInt(n);
				int randomT = rd.nextInt(n);
				Fact fact = new Fact(a.get(randomS).getNhanHienThi(), b.get(randomO).getNhanHienThi(), "phat_bieu_tai",
						c.get(randomT).getNhanHienThi());
				BaseDocument myObject = this.createBaseDocumentFact(fact, k, "_8");
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

	public void cang_thang_voi(ArrayList<PersonModel> a, ArrayList<PersonModel> b, ArrayList<TimeModel> c) {
		ArangoDatabase arangoDatabase = ConnectArangoDB.getConnection();
		Random rd = new Random();
		int n = a.size();
		try {
			ArrayList<BaseDocument> listdocs = new ArrayList<BaseDocument>();
			for (int k = 0; k < m; k++) {
				int randomS = rd.nextInt(n);
				int randomO = rd.nextInt(n);
				int randomT = rd.nextInt(n);
				Fact fact = new Fact(a.get(randomS).getNhanHienThi(), b.get(randomO).getNhanHienThi(), "cang_thang_voi",
						c.get(randomT).getNhanHienThi());
				BaseDocument myObject = this.createBaseDocumentFact(fact, k, "_9");
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

	public void huy_bo(ArrayList<PersonModel> a, ArrayList<PersonModel> b, ArrayList<TimeModel> c) {
		ArangoDatabase arangoDatabase = ConnectArangoDB.getConnection();
		Random rd = new Random();
		int n = a.size();
		try {
			ArrayList<BaseDocument> listdocs = new ArrayList<BaseDocument>();
			for (int k = 0; k < m; k++) {
				int randomS = rd.nextInt(n);
				int randomO = rd.nextInt(n);
				int randomT = rd.nextInt(n);
				Fact fact = new Fact(a.get(randomS).getNhanHienThi(), b.get(randomO).getNhanHienThi(), "huy_bo",
						c.get(randomT).getNhanHienThi());
				BaseDocument myObject = this.createBaseDocumentFact(fact, k, "_10");
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

	public void dam_phan_voi(ArrayList<PersonModel> a, ArrayList<PersonModel> b, ArrayList<TimeModel> c) {
		ArangoDatabase arangoDatabase = ConnectArangoDB.getConnection();
		Random rd = new Random();
		int n = a.size();
		try {
			ArrayList<BaseDocument> listdocs = new ArrayList<BaseDocument>();
			for (int k = 0; k < m; k++) {
				int randomS = rd.nextInt(n);
				int randomO = rd.nextInt(n);
				int randomT = rd.nextInt(n);
				Fact fact = new Fact(a.get(randomS).getNhanHienThi(), b.get(randomO).getNhanHienThi(), "dam_phan_voi",
						c.get(randomT).getNhanHienThi());
				BaseDocument myObject = this.createBaseDocumentFact(fact, k, "_11");
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

	public void setM(int m) {
		this.m = m;
	}
}
