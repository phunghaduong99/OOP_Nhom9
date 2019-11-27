package oop.generatedata;

import java.util.ArrayList;
import java.util.List;

import oop.model.AggrementModel;

public class GenerateAggrements implements GenerateData {

	@Override
	public List<AggrementModel> getData(int n) {
		List<AggrementModel> listAggrement = new ArrayList<AggrementModel>();
		ReadFile readFile = new ReadFile();
		List<String> nhanHienThi = readFile.randomDataInFile("./data/agreement/Aggrement_nhan.txt");
		List<String> dinhDanh = readFile.randomDataInFile("./data/agreement/Aggrement_dinhdanh.txt");
		List<String> moTa = readFile.randomDataInFile("./data/agreement/Aggrement_mota.txt");
		List<String> link = readFile.randomDataInFile("./data/agreement/Aggrement_mota.txt");
		List<String> time = readFile.randomDataInFile("./data/agreement/Aggrement_time.txt");
		List<String> location = readFile.randomDataInFile("./data/agreement/Aggrement_time.txt");
		for (int i = 0; i < n; i++) {
			AggrementModel aggrement = new AggrementModel(readFile.getOneInListString(dinhDanh),
					readFile.getOneInListString(nhanHienThi), readFile.getOneInListString(moTa),
					readFile.getOneInListString(link), readFile.getOneInListString(time),
					readFile.getOneInListString(location));
			listAggrement.add(aggrement);
		}
		return listAggrement;
	}
}