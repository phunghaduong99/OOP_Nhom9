package oop.generatedata;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import oop.beans.Event;
import oop.beans.Person;

public class GeneratePersons implements GenerateData {
	@Override
	public List<Person> getData(int n) {

		List<Person> listPerson = new ArrayList<Person>();
		Random rd = new Random();
		ReadFile readFile = new ReadFile();
		for (int i = 0; i < n; i++) {
			int random = rd.nextInt(n);
			String nhanHienThi = readFile.randomDataInFile("./data/person/Person_nhan.txt");
			String dinhDanh = nhanHienThi + '_' + random;
			String moTa = readFile.randomDataInFile("./data/person/Person_nhan.txt");
			String link = readFile.randomDataInFile("./data/person/Person_nhan.txt");
			String chucVu = readFile.randomDataInFile("./data/person/Person_nhan.txt");
			String quocTich = readFile.randomDataInFile("./data/person/Person_nhan.txt");
			Person person = new Person(dinhDanh, nhanHienThi, moTa, link, chucVu, quocTich);
			listPerson.add(person);
		}
		return listPerson;
	}
}
