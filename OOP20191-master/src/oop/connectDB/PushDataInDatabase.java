package oop.connectDB;

import java.util.ArrayList;

import oop.beans.Aggrement;
import oop.beans.Country;
import oop.beans.Event;
import oop.beans.Location;
import oop.beans.Organization;
import oop.beans.Person;
import oop.beans.Time;
import oop.fact.GenerateFact;
import oop.fact.PushFact;
import oop.generatedata.GetData;
import oop.pushDataInDB.PushAggrement;
import oop.pushDataInDB.PushCountries;
import oop.pushDataInDB.PushData;
import oop.pushDataInDB.PushEvents;
import oop.pushDataInDB.PushLocations;
import oop.pushDataInDB.PushOrganizations;
import oop.pushDataInDB.PushPersons;
import oop.pushDataInDB.PushTimes;



public class PushDataInDatabase {
	// gọi các phương thức để đẩy dữ liệu vào database
	public PushDataInDatabase() {

	}

	public static void save(int n, int m) {
		
		GetData getData = new GetData(n);
		ArrayList<Time> times = getData.getTimes();
		ArrayList<Country> countrys = getData.getCountries();
		ArrayList<Event> events = getData.getEvents();
		ArrayList<Person> persons = getData.getPersons();
		ArrayList<Location> locations = getData.getLocations();
		ArrayList<Aggrement> aggrements = getData.getAggrements();
		ArrayList<Organization> organizations = getData.getOrganizations();
		organizations.get(2).printData();
		
//		PushData pushData = new PushOrganizations(organizations);
//		pushData.pushData(n);
//		
//		pushData = new PushAggrement(aggrements);
//		pushData.pushData(n);
//		
//		pushData = new PushPersons(persons);
//		pushData.pushData(n);
//		
//		pushData = new PushTimes(times);
//		pushData.pushData(n);
//		
//		pushData = new PushCountries(countrys);
//		pushData.pushData(n);
//		
//		pushData = new PushLocations(locations);
//		pushData.pushData(n);
//		
//		pushData = new PushEvents(events);
//		pushData.pushData(n);
//		
//		GenerateFact generateFact = new GenerateFact(m/11);      // vì có  11 hàm sinh quan hệ nên số lượng mỗi 
//																		//quan hệ sinh ra sẽ là (tổng qhe)/11
//		generateFact.dien_Ra_Tai(events, locations);
//		
//		pushData = new PushFact(generateFact.getFacts());
		
	}

}
