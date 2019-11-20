package oop.generatedata;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import oop.beans.Aggrement;

public class GenerateAggrement implements GenerateData{

		@Override
		public List<Aggrement> getData(int n) {
			List<Aggrement> listAggrement = new ArrayList<Aggrement>();
			for(int i = 0;i < n;i++) {
				ReadFile readFile = new ReadFile();
				Random rd = new Random();
				int random = rd.nextInt(n/15);
				String nhanHienThi = readFile.randomDataInFile("./data/Aggrement_nhan.txt");
				String dinhDanh = nhanHienThi +"_" + random;
				String moTa = readFile.randomDataInFile("./data/Aggrement_nhan.txt");
				String link = readFile.randomDataInFile("./data/Aggrement_nhan.txt");
				String time = readFile.randomDataInFile("./data/Aggrement_nhan.txt");
				String location = readFile.randomDataInFile("./data/Aggrement_nhan.txt");
				Aggrement aggrement = new Aggrement(dinhDanh, nhanHienThi, moTa, link, time, location);
				listAggrement.add(aggrement);
			}
			return listAggrement;
		}
	}
