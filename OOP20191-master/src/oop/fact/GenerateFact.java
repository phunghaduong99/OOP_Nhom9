package oop.fact;

import java.util.ArrayList;

import oop.beans.Aggrement;
import oop.beans.Country;
import oop.beans.Event;
import oop.beans.Location;
import oop.beans.Organization;
import oop.beans.Person;


public class GenerateFact {
	private ArrayList<Fact> facts = new ArrayList<Fact>();
	private int so_quan_he; // số quan hệ sẽ sinh của mỗi phương thức quan hệ

	public GenerateFact(int so_quan_he) {
		this.so_quan_he = so_quan_he;
	}

	public void dien_Ra_Tai(ArrayList<Event> a, ArrayList<Location> b) {

	}

	public void gap_Go(ArrayList<Person> a, ArrayList<Person> b) {

	}

	// person tổ chức event
	public void to_chuc_1(ArrayList<Person> a, ArrayList<Event> b) {

	}

	// Organization tố chức event
	public void to_chuc_2(ArrayList<Organization> a, ArrayList<Person> b) {

	}

	public void ky_thoa_thuan(ArrayList<Country> a, ArrayList<Country> b) {

	}

	public void tham_gia(ArrayList<Person> a, ArrayList<Organization> b) {

	}

	public void dien_ra_tai(ArrayList<Event> a, ArrayList<Country> b) {

	}

	public void ung_ho(ArrayList<Person> a, ArrayList<Aggrement> b) {

	}

	public void phan_doi(ArrayList<Person> a, ArrayList<Aggrement> b) {

	}
	
	public void phat_bieu_tai(ArrayList<Person> a, ArrayList<Person> b) {
			
	}
	
	public void cang_thang_voi(ArrayList<Person> a, ArrayList<Person> b) {
		
	}
	
	public void huy_bo(ArrayList<Person> a, ArrayList<Person> b) {
		
	}
	
	public void dam_phan_voi(ArrayList<Person> a, ArrayList<Person> b) {
		
	}
	public ArrayList<Fact> getFacts() {
		return facts;
	}

	public void setFacts(ArrayList<Fact> facts) {
		this.facts = facts;
	}

	public int getSo_quan_he() {
		return so_quan_he;
	}

	public void setSo_quan_he(int so_quan_he) {
		this.so_quan_he = so_quan_he;
	}
}
