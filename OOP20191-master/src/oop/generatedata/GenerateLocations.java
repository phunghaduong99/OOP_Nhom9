package oop.generatedata;

import java.util.ArrayList;
import java.util.List;

import oop.model.LocationModel;

public class GenerateLocations extends GenerateDataImpl {
	@Override
	public List<LocationModel> getData(int n) {

		ArrayList<LocationModel> listLocation = new ArrayList<LocationModel>();
		ReadFile readFile = new ReadFile();
		List<String> nhanHienThi = readFile.randomDataInFile("./data/location/Location_nhan.txt");
		List<String> moTa = readFile.randomDataInFile("./data/location/Location_moTa.txt");
		List<String> link = readFile.randomDataInFile("./data/location/Location_link.txt");
		List<String> country = readFile.randomDataInFile("./data/location/location_country.txt");
		for (int i = 0; i < n; i++) {
			LocationModel location = new LocationModel(readFile.getOneInListString(nhanHienThi) + "_"+ (i+1),
					readFile.getOneInListString(nhanHienThi), readFile.getOneInListString(moTa),
					readFile.getOneInListString(link), readFile.getOneInListString(country));
			listLocation.add(location);
		}
		return listLocation;
	}

}
