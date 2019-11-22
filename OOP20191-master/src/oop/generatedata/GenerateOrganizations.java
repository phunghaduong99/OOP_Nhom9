package oop.generatedata;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import oop.beans.Organization;

public class GenerateOrganizations implements GenerateData {
	@Override
	public List<Organization> getData(int n) {
		
		List<Organization> listOrganization = new ArrayList<Organization>();
		Random rd = new Random();
		ReadFile readFile = new ReadFile();
		for (int i = 0; i < n; i++) {
			int random = rd.nextInt(n); //-------------------------------------
			String nhanHienThi = readFile.randomDataInFile("./data/Aggrement_nhan.txt");
			String dinhDanh = nhanHienThi + '_' + random;
			String moTa = readFile.randomDataInFile("./data/Aggrement_nhan.txt");
			String link = readFile.randomDataInFile("./data/Aggrement_nhan.txt");
			String truSo = readFile.randomDataInFile("./data/Orgnization_headquaters.txt");
			Organization Organization = new Organization(dinhDanh, nhanHienThi, moTa, link, truSo);
			listOrganization.add(Organization);
		}
		
		return listOrganization;
	}
}
