package oop.generatedata;

import java.util.ArrayList;
import java.util.List;

public class GenerateDataImpl implements IGenerateData {
	private List<String> nhanHienThi = new ArrayList<String>();
	@Override
	public List<?> getData(int n) {
		// TODO Auto-generated method stub
		return null;
	}
	public List<String> getNhanHienThi() {
		return nhanHienThi;
	}
	public void setNhanHienThi(List<String> nhanHienThi) {
		this.nhanHienThi = nhanHienThi;
	}
	

}
