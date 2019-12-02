package oop.generatedata;

import java.util.ArrayList;
import java.util.List;

import oop.model.PersonModel;

public class GeneratePersons extends GenerateDataImpl {
	@Override
	public List<PersonModel> getData(int n) {
		List<PersonModel> listPerson = new ArrayList<PersonModel>();
		ReadFile readFile = new ReadFile();
		List<String> nhanHienThi = readFile.readDataInFile("./data/person/Person_nhan.txt");
		this.setNhanHienThi(nhanHienThi);
		List<String> moTa = readFile.readDataInFile("./data/person/Person_moTa.txt");
		List<String> link = readFile.readDataInFile("./data/person/Person_link.txt");
		List<String> chucVu = readFile.readDataInFile("./data/person/Person_chucVu.txt");
		List<String> quocTich = readFile.readDataInFile("./data/person/Person_quocTich.txt");
		for (int i = 0; i < n; i++) {
			PersonModel person = new PersonModel(readFile.getOneInListString(nhanHienThi) + "_"+ (i+1), readFile.getOneInListString(nhanHienThi),
					readFile.getOneInListString(moTa), readFile.getOneInListString(link), readFile.getOneInListString(chucVu), readFile.getOneInListString(quocTich));
			listPerson.add(person);
		}
		return listPerson;

	}
}
