package oop.pushdataindb;

import java.util.ArrayList;
import java.util.List;

import oop.dao.Collection;
import oop.generatedata.GetData;
import oop.model.AggrementModel;
import oop.model.CountryModel;
import oop.model.EventModel;
import oop.model.LocationModel;
import oop.model.OrganizationModel;
import oop.model.PersonModel;
import oop.model.TimeModel;



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
		List<String> organizationLabel = getData.getListLabel();
		ArrayList<TimeModel> times = getData.getTimes();
		List<String> timeLabel = getData.getListLabel();
		ArrayList<CountryModel> countrys = getData.getCountries();
		List<String> countryLabel = getData.getListLabel();
		ArrayList<EventModel> events = getData.getEvents();
		List<String> eventLabel = getData.getListLabel();
		ArrayList<PersonModel> persons = getData.getPersons();
		List<String> personLabel = getData.getListLabel();
		ArrayList<LocationModel> locations = getData.getLocations();
		List<String> locationLabel = getData.getListLabel();
		ArrayList<AggrementModel> aggrements = getData.getAggrements();
		List<String> aggrementLabel = getData.getListLabel();
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
		System.out.println("push Entity into Database: " + (end- start));
		
		start = System.currentTimeMillis(); // start lấy thời gian theo millisecond
		PushFact fact = new PushFact("Fact", m);
		fact.pushFactInDb(personLabel, personLabel, timeLabel, "gap_go", "_1");
		fact.pushFactInDb(personLabel, eventLabel, timeLabel, "to_chuc", "_2");
		fact.pushFactInDb(countryLabel, countryLabel, timeLabel, "ky_thoa_thuan", "_3");
		fact.pushFactInDb(personLabel, organizationLabel, timeLabel, "tham_gia", "_4");
		fact.pushFactInDb(eventLabel, countryLabel, timeLabel, "dien_ra_tai", "_5");
		fact.pushFactInDb(personLabel, aggrementLabel, timeLabel, "ung_ho", "_6");
		fact.pushFactInDb(personLabel, aggrementLabel, timeLabel, "phan_doi", "_7");
		fact.pushFactInDb(personLabel, eventLabel, timeLabel, "phat_bieu_tai", "_8");
		fact.pushFactInDb(countryLabel, countryLabel, timeLabel, "cang_thang_voi", "_9");
		fact.pushFactInDb(personLabel, eventLabel, timeLabel, "huy_bo", "_10");
		fact.pushFactInDb(countryLabel, countryLabel, timeLabel, "dam_phan_voi", "_11");
		end = System.currentTimeMillis(); // start lấy thời gian theo millisecond
		System.out.println("push Fact into Database: " + (end- start));
		
		
	}

}
