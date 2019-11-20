package oop.generatedata;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import oop.beans.Time;

public class GenerateTimes implements GenerateData {

	@Override
	public List<Time> getData(int n) {
		
		List<Time> listTime = new ArrayList<Time>();
		
		for (int i = 0; i < n; i++) {
			Random rd = new Random();
			ReadFile readFile = new ReadFile();
			int random = rd.nextInt(n/15);
			String nhanHienThi = readFile.randomDataInFile("./data/Aggrement_nhan.txt");
			String dinhDanh = nhanHienThi + '_' + random;
			String moTa = readFile.randomDataInFile("./data/Aggrement_nhan.txt");
			String link = readFile.randomDataInFile("./data/Aggrement_nhan.txt");
			String time = readFile.randomDataInFile("./data/Aggrement_nhan.txt");
			Time Time = new Time(dinhDanh, nhanHienThi, moTa, link, time);
			listTime.add(Time);
		}
		return listTime;
		
	}

}
