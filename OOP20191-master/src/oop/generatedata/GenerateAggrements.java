package oop.generatedata;

import java.util.ArrayList;
import java.util.List;

import oop.model.AggrementModel;

public class GenerateAggrements extends GenerateDataImpl {
	@Override 
	public List<AggrementModel> getData(int n) {
		List<AggrementModel> listAggrement = new ArrayList<AggrementModel>();
		ReadFile readFile = new ReadFile();
		List<String> nhanHienThi = readFile.readDataInFile("./data/agreement/Aggrement_nhan.txt");
		this.setNhanHienThi(nhanHienThi);
		List<String> moTa = readFile.readDataInFile("./data/agreement/Aggrement_mota.txt");
		List<String> link = readFile.readDataInFile("./data/agreement/Aggrement_mota.txt");
		List<String> time = readFile.readDataInFile("./data/agreement/Aggrement_time.txt");
		List<String> location = readFile.readDataInFile("./data/agreement/Aggrement_time.txt");
		for (int i = 0; i < n; i++) {
			AggrementModel aggrement = new AggrementModel(readFile.getOneInListString(nhanHienThi) + "_"+ (i+1),
					readFile.getOneInListString(nhanHienThi), readFile.getOneInListString(moTa),
					readFile.getOneInListString(link), readFile.getOneInListString(time),
					readFile.getOneInListString(location));
			listAggrement.add(aggrement);
		}
		return listAggrement;
	}
}
