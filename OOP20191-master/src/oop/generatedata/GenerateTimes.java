package oop.generatedata;

import java.util.ArrayList;
import java.util.List;

import oop.model.TimeModel;

public class GenerateTimes extends GenerateDataImpl {
	@Override
	public List<TimeModel> getData(int n) {
		List<TimeModel> listTime = new ArrayList<TimeModel>();
		ReadFile readFile = new ReadFile();
		List<String> nhanHienThi = readFile.randomDataInFile("./data/time/Time_nhan.txt");
		this.setNhanHienThi(nhanHienThi);
		List<String> moTa = readFile.randomDataInFile("./data/time/Time_moTa.txt");
		List<String> link = readFile.randomDataInFile("./data/time/Time_link.txt");
		List<String> time = readFile.randomDataInFile("./data/time/Time_time.txt");
		for (int i = 0; i < n; i++) {
			TimeModel timee = new TimeModel(readFile.getOneInListString(nhanHienThi) + "_" + (i + 1),
					readFile.getOneInListString(nhanHienThi), readFile.getOneInListString(moTa),
					readFile.getOneInListString(link), readFile.getOneInListString(time));
			listTime.add(timee);

		}
		return listTime;
	}

}
