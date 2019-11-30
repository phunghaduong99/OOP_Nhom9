package oop.connectdb;

import java.util.ArrayList;
import java.util.List;

import oop.fact.Fact;
import oop.fact.PushFact;
import oop.generatedata.GenerateCountries;
import oop.generatedata.GenerateEvents;
import oop.generatedata.GeneratePersons;
import oop.generatedata.GetData;
import oop.model.AggrementModel;
import oop.model.CountryModel;
import oop.model.EntityModel;
import oop.model.EventModel;
import oop.model.LocationModel;
import oop.model.OrganizationModel;
import oop.model.PersonModel;
import oop.model.TimeModel;
import oop.pushdataindb.Collection;
import oop.pushdataindb.IPushData;
import oop.pushdataindb.PushAggrement;
import oop.pushdataindb.PushCountries;
import oop.pushdataindb.PushEvents;
import oop.pushdataindb.PushLocations;
import oop.pushdataindb.PushOrganizations;
import oop.pushdataindb.PushPersons;
import oop.pushdataindb.PushTimes;



public class PushDataInDatabase {
	// gọi các phương thức để đẩy dữ liệu vào database
	public PushDataInDatabase() {

	}

	public static void save(int n, int m) {
		long start, end;
		long startread, endread;
		startread = System.currentTimeMillis(); // start lấy thời gian theo millisecond
		GetData getData = new GetData(n);
		ArrayList<OrganizationModel> organizations = getData.getOrganizations();
		ArrayList<TimeModel> times = getData.getTimes();
		List<String> time = getData.getListLabel();
		System.out.println("time"+time.size());
		ArrayList<CountryModel> countrys = getData.getCountries();
		List<String> countriese = getData.getListLabel();
		System.out.println("cou "+ countriese.size());
		ArrayList<EventModel> events = getData.getEvents();
		ArrayList<PersonModel> persons = getData.getPersons();
		ArrayList<LocationModel> locations = getData.getLocations();
		ArrayList<AggrementModel> aggrements = getData.getAggrements();
		endread = System.currentTimeMillis();
		System.out.println("read Data from file: " + (endread- startread));
		
	
		Collection coll = new Collection();
		coll.deleteCollection("Organization");
		coll.deleteCollection("Time");
		coll.deleteCollection("Country");
		coll.deleteCollection("Event");
		coll.deleteCollection("Person");
		coll.deleteCollection("Location");
		coll.deleteCollection("Agreement");
		coll.deleteCollection("Fact");
		
		coll.createCollection("Organization");
		coll.createCollection("Time");
		coll.createCollection("Country");
		coll.createCollection("Event");
		coll.createCollection("Person");
		coll.createCollection("Location");
		coll.createCollection("Agreement");
		coll.createCollection("Fact");
		
		IPushData pushData = new PushOrganizations(organizations);
		
		start = System.currentTimeMillis(); // start lấy thời gian theo millisecond
		pushData.pushData(n, "Organization");
	
		pushData = new PushTimes(times);
		pushData.pushData(n, "Time");

		pushData = new PushCountries(countrys);
		pushData.pushData(n, "Country");
		
		pushData = new PushEvents(events);
		pushData.pushData(n, "Event");
		
		pushData = new PushPersons(persons);
		pushData.pushData(n, "Person");
		
		pushData = new PushLocations(locations);
		pushData.pushData(n, "Location");
		
		pushData = new PushAggrement(aggrements);
		pushData.pushData(n, "Agreement");
		
		end = System.currentTimeMillis(); // start lấy thời gian theo millisecond
		System.out.println("push Data into Database: " + (end- start));
		
		start = System.currentTimeMillis(); // start lấy thời gian theo millisecond
		
		System.out.println("test");
		
		PushFact fact = new PushFact("Fact", m);
		fact.pushFactInDb(countriese, countriese, time, "ky_thoa_thoa", "_4");
		System.out.println("test");
//		fact.pushFactIntoDatabase(organizations, times, countrys, events, persons, locations, aggrements);
//		fact.gap_go(persons, persons, times);
//		fact.to_chuc(persons, events, times);
//		fact.ky_thoa_thuan(countrys, countrys, times);
//		fact.tham_gia(persons, organizations, times);
//		fact.dien_ra_tai(events, locations, times);
//		fact.ung_ho(persons, aggrements, times);
//		fact.phan_doi(persons, aggrements, times);
//		fact.phat_bieu_tai(persons, persons, times);
//		fact.cang_thang_voi(persons, persons, times);
//		fact.huy_bo(persons, persons, times);
//		fact.dam_phan_voi(persons, persons, times);
		end = System.currentTimeMillis(); // start lấy thời gian theo millisecond
	
		System.out.println("push Fact into Database: " + (end- start));
		
		
	}

}
