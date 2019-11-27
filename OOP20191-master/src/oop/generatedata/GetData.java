package oop.generatedata;

import java.util.ArrayList;
import oop.model.AggrementModel;
import oop.model.CountryModel;
import oop.model.EventModel;
import oop.model.LocationModel;
import oop.model.OrganizationModel;
import oop.model.PersonModel;
import oop.model.TimeModel;

public class GetData {
	private int n;
	private GenerateData generateData;
	
	public GetData(int n) {
		this.n = n;
	}
		
	public ArrayList<AggrementModel> getAggrements () {
		generateData = new GenerateAggrements();
		ArrayList<AggrementModel> aggrements = (ArrayList<AggrementModel>) generateData.getData(n);
		return aggrements;
	}
	
	public ArrayList<CountryModel> getCountries() {
		generateData = new GenerateCountries();
		ArrayList<CountryModel> countries = (ArrayList<CountryModel>) generateData.getData(n);
		return countries;
	}
	
	public ArrayList<EventModel> getEvents() {
		generateData = new GenerateEvents();
		@SuppressWarnings("unchecked")
		ArrayList<EventModel> events = (ArrayList<EventModel>) generateData.getData(n);
		return events;
	}
	
	public ArrayList<LocationModel> getLocations() {
		generateData = new GenerateLocations();
		ArrayList<LocationModel> locations = (ArrayList<LocationModel>) generateData.getData(n);
		return locations;
	}
	
	public ArrayList<OrganizationModel> getOrganizations() {
		generateData = new GenerateOrganizations();
		ArrayList<OrganizationModel> organizations = (ArrayList<OrganizationModel>) generateData.getData(n);
		return organizations;
	}
	
	public ArrayList<PersonModel> getPersons() {
		generateData = new GeneratePersons();
		ArrayList<PersonModel> persons = (ArrayList<PersonModel>) generateData.getData(n);
		return persons;
	}
	
	public ArrayList<TimeModel> getTimes() {
		generateData = new GenerateTimes();
		ArrayList<TimeModel> times = (ArrayList<TimeModel>) generateData.getData(n);
		return times;
	}
}
