package oop.generatedata;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ReadFile {
	// chọn ngẫu nhiên thực thể trong file
		@SuppressWarnings("finally")
		public List<String> listData(String path){
			ArrayList<String> list = new ArrayList<String>();
			try {
				FileInputStream fis = new FileInputStream(path);
				InputStreamReader isr = new InputStreamReader(fis);
				BufferedReader bfr = new BufferedReader(isr);
				String line = bfr.readLine();
				while(line != null) {
					list.add(line);
					line = bfr .readLine(); 
				}
//				fis.close();
//				isr.close();
				bfr.close();
			} catch (Exception e) {
				e.printStackTrace();
			}finally {
				return list;
			}
		}
		
		public String randomDataInList(List<String> list,int n) {
			Random rd = new Random();
			return list.get(rd.nextInt(n));
		}
		
		
		public String randomDataInFile(String path) {
			List<String> list = listData(path);
			return randomDataInList(list, list.size());
		}
		



}
