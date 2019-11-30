package oop.generatedata;

import java.util.ArrayList;
import java.util.List;

import oop.model.OrganizationModel;

public class GenerateOrganizations extends GenerateDataImpl {
	@Override
	public List<OrganizationModel> getData(int n) {

		List<OrganizationModel> listOrganization = new ArrayList<OrganizationModel>();
		ReadFile readFile = new ReadFile();
		List<String> nhanHienThi = readFile.randomDataInFile("./data/organization/Organization_nhan.txt");
		List<String> moTa = readFile.randomDataInFile("./data/organization/Organization_moTa.txt");
		List<String> link = readFile.randomDataInFile("./data/organization/Organization_link.txt");
		List<String> truSo = readFile.randomDataInFile("./data/organization/Organization_truSo.txt");

		for (int i = 0; i < n; i++) {
			OrganizationModel Organization = new OrganizationModel(readFile.getOneInListString(nhanHienThi) + "_"+ (i+1),
					readFile.getOneInListString(nhanHienThi), readFile.getOneInListString(moTa),
					readFile.getOneInListString(link), readFile.getOneInListString(truSo));
			listOrganization.add(Organization);
		}
		return listOrganization;
	}
}
