package oop.generatedata;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import oop.beans.Country;

public class GenerateCountries implements GenerateData {
	@Override
	public List<Country> getData(int n) {
		List<Country> listCountries = new ArrayList<Country>();
		for (int i = 0; i < n; i++) {
			ReadFile readFile = new ReadFile();
			Random rd = new Random();
			int random = rd.nextInt(n);
			String nhanHienThi = readFile.randomDataInFile("./data/Aggrement_nhan.txt");
			String dinhDanh = nhanHienThi + '_' + random;
			String moTa = readFile.randomDataInFile("./data/Aggrement_nhan.txt");
			String link = readFile.randomDataInFile("./data/Aggrement_nhan.txt");
			String dienTich = readFile.randomDataInFile("./data/Aggrement_nhan.txt");
			Country country = new Country(dinhDanh, nhanHienThi, moTa, link, dienTich);
			listCountries.add(country);
		}
		return listCountries;
	}

}
