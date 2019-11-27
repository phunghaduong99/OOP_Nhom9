package oop.generatedata;

import java.util.ArrayList;
import java.util.List;

import oop.model.EventModel;

public class GenerateEvents implements GenerateData {
	@Override
	public List<EventModel> getData(int n) {
		ArrayList<EventModel> lisEvents = new ArrayList<EventModel>();
		ReadFile readFile = new ReadFile();
		List<String> nhanHienThi = readFile.randomDataInFile("./data/event/Event_nhan.txt");
		List<String> dinhDanh = readFile.randomDataInFile("./data/event/Event_dinhDanh.txt");
		List<String> moTa = readFile.randomDataInFile("./data/event/Event_moTa.txt");
		List<String> link = readFile.randomDataInFile("./data/event/Event_link.txt");
		List<String> time = readFile.randomDataInFile("./data/event/Event_time.txt");
		List<String> location = readFile.randomDataInFile("./data/event/Event_location.txt");
		for (int i = 0; i < n; i++) {
			EventModel event = new EventModel(readFile.getOneInListString(dinhDanh), readFile.getOneInListString(nhanHienThi),
					readFile.getOneInListString(moTa), readFile.getOneInListString(link),
					readFile.getOneInListString(time), readFile.getOneInListString(location));
			lisEvents.add(event);
		}
		return lisEvents;
	}
}
