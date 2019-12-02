package oop.controller;

import java.util.Properties;

import org.apache.log4j.PropertyConfigurator;

import oop.dao.Query;

public class QueryExecute {

	public static void main(String[] args) {
		Properties prop = new Properties();
		prop.setProperty("log4j.rootLogger", "WARN");
		PropertyConfigurator.configure(prop);
		Query doc = new Query();
//		doc.getMoTa("Country", "Vương quốc Liên hiệp Anh và Bắc Ireland_1");
//		doc.getLocationEvent("Bầu cử Tổng thống Nga 2018_1");
//		doc.getTimeEvent("Bầu cử Tổng thống Nga 2018_1");
//		doc.getTimeAgreement("Hiệp định Liên Hiệp lần 4_1");
//		doc.getCountry_of_Location("Thành phố Nha Trang_1");
//		doc.getTruSo("Liên đoàn bóng đá Việt Nam_1");
//		doc.getQuocTich("Nhạc sĩ Văn Cao _1");
//		doc.getNhanHienThi("Agreement","Hiệp định Liên Hiệp lần 4_1");
//		doc.getThongTinCoBan("Agreement","Hiệp định Liên Hiệp lần 12_4");
//		doc.getPerson_gap_go_at_time("Thủ môn Đặng Văn Lâm", "4/8/2014");
		doc.getPerson_to_chuc_Event_at_time("Lễ hội ẩm thực việt hàn 2017", "5/7/2016");
//		doc.getCountry_ky_thoa_thuan_at_time("Nhật Bản", "5/7/2016");
//		doc.getPerson_tham_gia_Organization_at_time("Ban nhạc Linkin Part", "3/6/2019");
//		doc.getTime_gap_go("Tỷ phú Jeff Bezos", "Huấn luyện viên Jose Mourinho");
//		doc.getEvent_dien_ra_tai_Location_at_time("Liên bang Nga","23/6/2013");
//		doc.getLocation_dien_ra_Event_at_time("bán kết aff cup 2017", "23/6/2013");
//		doc.getPerson_dam_phan_at_time("Nhạc sĩ Trịnh Công Sơn", "6/9/2013");
//		doc.getPerson_phat_bieu_tai_Event_at_time("Thầy Trịnh Tuấn Đạt", "17/7/2012");
//		doc.getTime_dam_phan("Diễn viên Xuân Bắc", "Cầu thủ Công Phượng");

	}

}
