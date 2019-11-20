package oop.generatedata;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import oop.beans.Person;

public class GeneratePersons implements GenerateData {
	@Override
	public List<Person> getData(int n) {
		
		List<Person> listPerson = new ArrayList<Person>();
		for (int i = 0; i < n; i++) {
			Random rd = new Random();
			ReadFile readFile = new ReadFile();
			int random = rd.nextInt(n);
			String nhanHienThi = readFile.randomDataInFile("./data/Aggrement_nhan.txt");
			String dinhDanh = nhanHienThi + '_' + random;
			String moTa = readFile.randomDataInFile("./data/Aggrement_nhan.txt");
			String link = readFile.randomDataInFile("./data/Aggrement_nhan.txt");
			String chucVu = readFile.randomDataInFile("./data/Aggrement_nhan.txt");
			String quocTich = readFile.randomDataInFile("./data/Aggrement_nhan.txt");
			Person person = new Person(dinhDanh, nhanHienThi, moTa, link, chucVu, quocTich);
			listPerson.add(person);
		}
		return listPerson;
	}
}
