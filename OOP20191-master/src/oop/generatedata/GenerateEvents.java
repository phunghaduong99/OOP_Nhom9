package oop.generatedata;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import oop.beans.Country;
import oop.beans.Event;

public class GenerateEvents implements GenerateData {
	@Override
	public List<Event> getData(int n) {
		ArrayList<Event> lisEvents = new ArrayList<Event>();
		ReadFile readFile = new ReadFile();
		Random rd = new Random();
		for (int i = 0; i < n; i++) {
			int random = rd.nextInt(n / 15);
			String nhanHienThi = readFile.randomDataInFile("./data/event/Event_nhan.txt");
			String dinhDanh = nhanHienThi + '_' + random;
			String moTa = readFile.randomDataInFile("./data/event/Event_nhan.txt");
			String link = readFile.randomDataInFile("./data/event/Event_nhan.txt");
			String time = readFile.randomDataInFile("./data/event/Event_nhan.txt");
			String location = readFile.randomDataInFile("./data/event/Event_nhan.txt");
			Event event = new Event(dinhDanh, nhanHienThi, moTa, link, time, location);
			lisEvents.add(event);
		}
		return lisEvents;
	}
}
