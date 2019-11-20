package oop.generatedata;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import oop.beans.Location;

public class GenerateLocations implements GenerateData{
	@Override
	public List<Location> getData(int n) {
		
		ArrayList<Location> listLocation = new ArrayList<Location>();
		for (int i = 0; i < n; i++) {
			Random rd = new Random();
			ReadFile readFile = new ReadFile();
			int random = rd.nextInt(n);
			String nhanHienThi = readFile.randomDataInFile("./data/Aggrement_nhan.txt");
			String dinhDanh = nhanHienThi + '_' + random;
			String moTa = readFile.randomDataInFile("./data/Aggrement_nhan.txt");
			String link = readFile.randomDataInFile("./data/Aggrement_nhan.txt");
			String location = readFile.randomDataInFile("./data/location/location_name.txt");
			String country = readFile.randomDataInFile("./data/location/location_name.txt");
			Location location1 = new Location(dinhDanh, nhanHienThi, moTa, link, country);
			listLocation.add(location1);
		}
		return listLocation;
	}

}
