package oop.dao;

import java.util.Properties;

import org.apache.log4j.PropertyConfigurator;

public class PullArticleDAO {
	public void thongtinNhanVat(String value, String collumnName, String collectionName) {
		QueryArticle query = new QueryArticle();
		query.query(value, collumnName, collectionName);
//	Map<String, Object> map= object.getProperties();
//	System.out.println(map.get("NhanHienThi"));
	}

	public static void main(String[] args) {
		Properties prop = new Properties();
		prop.setProperty("log4j.rootLogger", "WARN");
		PropertyConfigurator.configure(prop);
		PullArticleDAO dao = new PullArticleDAO();
		long start, end;
		start = System.currentTimeMillis();
		dao.thongtinNhanVat("Hiệp định Liên Hiệp lần 30_2", "DinhDanh", "Agreement");
		end = System.currentTimeMillis();
		System.out.println("testtt "+ (end-start));

	}

}
