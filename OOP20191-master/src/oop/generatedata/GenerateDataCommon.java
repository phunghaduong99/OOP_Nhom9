package oop.generatedata;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import oop.beans.Event;

public class GenerateDataCommon<T> implements GenerateData {

	@Override
	public List<T> getData(int n) {
		ArrayList<T> listT = new ArrayList<T>();
		for (int i = 0; i < n; i++) {
			Random rd = new Random();
			ReadFile readFile = new ReadFile();
			int random = rd.nextInt(n);
			String nhanHienThi = readFile.randomDataInFile("./data/Aggrement_nhan.txt");
			String dinhDanh = nhanHienThi + '_' + random;
			String moTa = readFile.randomDataInFile("./data/Aggrement_nhan.txt");
			String link = readFile.randomDataInFile("./data/Aggrement_nhan.txt");
			String time = readFile.randomDataInFile("./data/event/event_time.txt");
			String location = readFile.randomDataInFile("./data/event/event_location.txt");
			Event event = new Event(dinhDanh, nhanHienThi, moTa, link, time, location);
		}
	
		return null;
	}

	
	
}
