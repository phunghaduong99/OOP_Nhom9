package oop.generatedata;

import java.util.ArrayList;
import java.util.List;

import oop.model.CountryModel;

public class GenerateCountries implements GenerateData {

	@Override
	public List<?> getData(int n) {
		List<CountryModel> listCountries = new ArrayList<CountryModel>();
		ReadFile readFile = new ReadFile();
		List<String> nhanHienThi = readFile.randomDataInFile("./data/country/Country_nhan.txt");
		List<String> dinhDanh = readFile.randomDataInFile("./data/country/Country_dinhDanh.txt");
		List<String> moTa = readFile.randomDataInFile("./data/country/Country_moTa.txt");
		List<String> link = readFile.randomDataInFile("./data/country/Country_link.txt");
		List<String> dienTich = readFile.randomDataInFile("./data/country/Country_dienTich.txt");
		for (int i = 0; i < n; i++) {
			CountryModel country = new CountryModel(readFile.getOneInListString(dinhDanh), readFile.getOneInListString(nhanHienThi),
					readFile.getOneInListString(moTa), readFile.getOneInListString(link), readFile.getOneInListString(dienTich));
			listCountries.add(country);
		}	
			
		return listCountries;
	}

}
