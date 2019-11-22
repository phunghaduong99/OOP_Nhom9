package oop.generatedata;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import oop.beans.Country;

public class GenerateCountries implements GenerateData {

	@Override
	public List<?> getData(int n) {
		List<Country> listCountries = new ArrayList<Country>();
		ReadFile readFile = new ReadFile();
		Random rd = new Random();
		for (int i = 0; i < n; i++) {
			int random = rd.nextInt(n);
			String nhanHienThi = readFile.randomDataInFile("./data/country/Country_nhan.txt");
			String dinhDanh = nhanHienThi + '_' + random;
			String moTa = readFile.randomDataInFile("./data/country/Country_nhan.txt");
			String link = readFile.randomDataInFile("./data/country/Country_nhan.txt");
			String dienTich = readFile.randomDataInFile("./data/country/Country_nhan.txt");
			Country country = new Country(dinhDanh, nhanHienThi, moTa, link, dienTich);
			listCountries.add(country);
		}	
			
		return listCountries;
	}

}
