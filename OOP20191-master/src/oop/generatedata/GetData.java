package oop.generatedata;

import java.util.ArrayList;
import java.util.List;

import oop.model.AggrementModel;
import oop.model.CountryModel;
import oop.model.EventModel;
import oop.model.LocationModel;
import oop.model.OrganizationModel;
import oop.model.PersonModel;
import oop.model.TimeModel;

public class GetData {
	private int n;
	private GenerateDataImpl generateData;
	private List<String> listLabel;
	public GetData(int n) {
		this.n = n;
	}
		
	public List<String> getListLabel() {
		return listLabel;
	}

	public void setListLabel(List<String> listLabel) {
		this.listLabel = listLabel;
	}

	public ArrayList<AggrementModel> getAggrements () {
		generateData = new GenerateAggrements();
		ArrayList<AggrementModel> aggrements = (ArrayList<AggrementModel>) generateData.getData(n);
		this.setListLabel(generateData.getNhanHienThi());
		return aggrements;
	}
	
	public ArrayList<CountryModel> getCountries() {
		generateData = new GenerateCountries();
		ArrayList<CountryModel> countries = (ArrayList<CountryModel>) generateData.getData(n);
		this.setListLabel(generateData.getNhanHienThi());
		return countries;
	}

	public ArrayList<EventModel> getEvents() {
		generateData = new GenerateEvents();
		@SuppressWarnings("unchecked")
		ArrayList<EventModel> events = (ArrayList<EventModel>) generateData.getData(n);
		this.setListLabel(generateData.getNhanHienThi());
		return events;
	}
	
	public ArrayList<LocationModel> getLocations() {
		generateData = new GenerateLocations();
		ArrayList<LocationModel> locations = (ArrayList<LocationModel>) generateData.getData(n);
		this.setListLabel(generateData.getNhanHienThi());
		return locations;
	}
	
	public ArrayList<OrganizationModel> getOrganizations() {
		generateData = new GenerateOrganizations();
		ArrayList<OrganizationModel> organizations = (ArrayList<OrganizationModel>) generateData.getData(n);
		this.setListLabel(generateData.getNhanHienThi());
		return organizations;
	}
	
	public ArrayList<PersonModel> getPersons() {
		generateData = new GeneratePersons();
		ArrayList<PersonModel> persons = (ArrayList<PersonModel>) generateData.getData(n);
		this.setListLabel(generateData.getNhanHienThi());
		return persons;
	}
	
	public ArrayList<TimeModel> getTimes() {
		generateData = new GenerateTimes();
		ArrayList<TimeModel> times = (ArrayList<TimeModel>) generateData.getData(n);
		this.setListLabel(generateData.getNhanHienThi());
		return times;
	}
}
