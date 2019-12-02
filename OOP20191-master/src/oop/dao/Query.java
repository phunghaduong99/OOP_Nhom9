package oop.dao;

import java.util.Map;

import com.arangodb.ArangoCursor;
import com.arangodb.ArangoDatabase;
import com.arangodb.entity.BaseDocument;
import com.arangodb.util.MapBuilder;

import oop.connectdb.ConnectArangoDB;

public class Query {
	private ArangoDatabase database;
	public Query() {
		this.database = ConnectArangoDB.getConnection();
	}

	// Lấy thông tin mô tả của một thực thể.
		public void getMoTa(String collectionName, String dinhDanh) {
			String query = "FOR t IN " + collectionName +
					" FILTER t.DinhDanh == @dinhDanh" +
					" RETURN t";
			Map<String, Object> bindVars = new MapBuilder().put("dinhDanh", dinhDanh).get();
			ArangoCursor<BaseDocument> cursor = database.query(query, bindVars, null, BaseDocument.class);
			cursor.forEachRemaining(aDocument -> {
				System.out.println(aDocument.getAttribute("MoTa"));
				System.out.println();
			});
		}

		// Lấy nhãn hiển thị của một thực thể.
		public void getNhanHienThi(String collectionName, String dinhDanh) {
			String query = "FOR t IN " + collectionName +
					" FILTER t.DinhDanh == @dinhDanh" +
					" RETURN t";
			Map<String, Object> bindVars = new MapBuilder().put("dinhDanh", dinhDanh).get();
			ArangoCursor<BaseDocument> cursor = database.query(query, bindVars, null, BaseDocument.class);
			cursor.forEachRemaining(aDocument -> {
				System.out.println(aDocument.getAttribute("NhanHienThi"));
				System.out.println();
			});
		}

		// Lấy địa điểm tổ chức của một Event.
		public void getLocationEvent(String event) {
			String query = "FOR t IN Event" +
					" FILTER t.DinhDanh == @event" +
					" RETURN t";
			Map<String, Object> bindVars = new MapBuilder().put("event", event).get();
			ArangoCursor<BaseDocument> cursor = database.query(query, bindVars, null, BaseDocument.class);
			cursor.forEachRemaining(aDocument -> {
				System.out.println(aDocument.getAttribute("Location"));
				System.out.println();
			});
		}

		// Event được tổ chức vào ngày nào.
		public void getTimeEvent(String event) {
			String query = "FOR t IN Event" +
					" FILTER t.DinhDanh == @event" +
					" RETURN t";
			Map<String, Object> bindVars = new MapBuilder().put("event", event).get();
			ArangoCursor<BaseDocument> cursor = database.query(query, bindVars, null, BaseDocument.class);
			cursor.forEachRemaining(aDocument -> {
				System.out.println(aDocument.getAttribute("Time"));
				System.out.println();
			});
		}

		// Lấy địa điểm tổ chức của một Agreement.
		public void getLocationAgreement(String agreement) {
			String query = "FOR t IN Agreement" +
					" FILTER t.DinhDanh == @agreement" +
					" RETURN t";
			Map<String, Object> bindVars = new MapBuilder().put("agreement", agreement).get();
			ArangoCursor<BaseDocument> cursor = database.query(query, bindVars, null, BaseDocument.class);
			cursor.forEachRemaining(aDocument -> {
				System.out.println(aDocument.getAttribute("Location"));
				System.out.println();
			});
		}

		// Agreement được diễn ra vào ngày nào.
		public void getTimeAgreement(String agreement) {
			String query = "FOR t IN Agreement" +
					" FILTER t.DinhDanh == @agreement" +
					" RETURN t";
			Map<String, Object> bindVars = new MapBuilder().put("agreement", agreement).get();
			ArangoCursor<BaseDocument> cursor = database.query(query, bindVars, null, BaseDocument.class);
			cursor.forEachRemaining(aDocument -> {
				System.out.println(aDocument.getAttribute("Time"));
				System.out.println();
			});
		}

		// Một Location nằm trong Country nào.
		public void getCountry_of_Location(String location) {
			String query = "FOR t IN Location" +
					" FILTER t.DinhDanh == @location" +
					" RETURN t";
			Map<String, Object> bindVars = new MapBuilder().put("location", location).get();
			ArangoCursor<BaseDocument> cursor = database.query(query, bindVars, null, BaseDocument.class);
			cursor.forEachRemaining(aDocument -> {
				System.out.println(aDocument.getAttribute("Country"));
				System.out.println();
			});
		}

		// Trụ sở của một Organization nằm ở đâu
		public void getTruSo(String organization) {
			String query = "FOR t IN Organization" +
					" FILTER t.DinhDanh == @organization" +
					" RETURN t";
			Map<String, Object> bindVars = new MapBuilder().put("organization", organization).get();
			ArangoCursor<BaseDocument> cursor = database.query(query, bindVars, null, BaseDocument.class);
			cursor.forEachRemaining(aDocument -> {
				System.out.println(aDocument.getAttribute("TruSo"));
				System.out.println();
			});
		}

		// Quốc tịch của một Person là gì
		public void getQuocTich(String person) {
			String query = "FOR t IN Person" +
					" FILTER t.DinhDanh == @person" +
					" RETURN t";
			Map<String, Object> bindVars = new MapBuilder().put("person", person).get();
			ArangoCursor<BaseDocument> cursor = database.query(query, bindVars, null, BaseDocument.class);
			cursor.forEachRemaining(aDocument -> {
				System.out.println(aDocument.getAttribute("QuocTich"));
				System.out.println();
			});
		}

		// Lấy tất cả các thông tin cơ bản của một thực thể (Định danh, Nhãn hiện thị, Mô tả)
		public void getThongTinCoBan(String collectionName, String dinhDanh) {
			String query = "FOR t IN " + collectionName +
					" FILTER t.DinhDanh == @dinhDanh" +
					" RETURN t";
			Map<String, Object> bindVars = new MapBuilder().put("dinhDanh", dinhDanh).get();
			ArangoCursor<BaseDocument> cursor = database.query(query, bindVars, null, BaseDocument.class);
			cursor.forEachRemaining(aDocument -> {
				System.out.println("Nhan hien thi: " + aDocument.getAttribute("NhanHienThi"));
				System.out.println("Dinh danh: " + aDocument.getAttribute("DinhDanh"));
				System.out.println("Mo ta: " + aDocument.getAttribute("MoTa"));
				System.out.println();
			});
		}

		// Lấy những người đã gặp gỡ một người nào đó vào một thời điểm cụ thể.
		public void getPerson_gap_go_at_time(String person, String time) {
			String query = "FOR t IN Fact" +
					" FILTER t.QuanHe == \"gap_go\"" +
					" FILTER t.Object == @person OR t.Subject == @person" +
					" FILTER t.Time == @time" +
					" RETURN t";
			Map<String, Object> bindVars = new MapBuilder().put("person", person).put("time", time).get();
			ArangoCursor<BaseDocument> cursor = database.query(query, bindVars, null, BaseDocument.class);
			cursor.forEachRemaining(aDocument -> {
				if(aDocument.getAttribute("Object").equals(person)) {
					System.out.println(aDocument.getAttribute("Subject"));
				} else if(aDocument.getAttribute("Subject").equals(person)) {
					System.out.println(aDocument.getAttribute("Object"));
				}
				System.out.println();
			});
		}

		// Hai người nào đó đã gặp nhau vào những lúc nào
		public void getTime_gap_go(String person1, String person2) {
			String query = "FOR t IN Fact" +
					" FILTER t.QuanHe == \"gap_go\"" +
					" FILTER t.Object == @person1 OR t.Subject == @person1" +
					" FILTER t.Object == @person2 OR t.Subject == @person2" +
					" RETURN t";
			Map<String, Object> bindVars = new MapBuilder().put("person1", person1).put("person2", person2).get();
			ArangoCursor<BaseDocument> cursor = database.query(query, bindVars, null, BaseDocument.class);
			cursor.forEachRemaining(aDocument -> {
				System.out.println(aDocument.getAttribute("Time"));
				System.out.println();
			});
		}

		// Lấy những người đã tổ chức một sự kiện vào một thời điểm cụ thể.
		public void getPerson_to_chuc_Event_at_time(String event, String time) {
			String query = "FOR t IN Fact" +
					" FILTER t.QuanHe == \"to_chuc\"" +
					" FILTER t.Object == @event" +
					" FILTER t.Time == @time" +
					" RETURN t";
			Map<String, Object> bindVars = new MapBuilder().put("event", event).put("time", time).get();
			ArangoCursor<BaseDocument> cursor = database.query(query, bindVars, null, BaseDocument.class);
			cursor.forEachRemaining(aDocument -> {
				System.out.println(aDocument.getAttribute("Subject"));
				System.out.println();
			});
		}

		// Những nước nào đã ký thỏa thuận với một nước nào đó vào một thời điểm cụ thể.
		public void getCountry_ky_thoa_thuan_at_time(String country, String time) {
			String query = "FOR t IN Fact" +
					" FILTER t.QuanHe == \"ky_thoa_thuan\"" +
					" FILTER t.Object == @country OR t.Subject == @country" +
					" FILTER t.Time == @time" +
					" RETURN t";
			Map<String, Object> bindVars = new MapBuilder().put("country", country).put("time", time).get();
			ArangoCursor<BaseDocument> cursor = database.query(query, bindVars, null, BaseDocument.class);
			cursor.forEachRemaining(aDocument -> {
				if(aDocument.getAttribute("Object").equals(country)) {
					System.out.println(aDocument.getAttribute("Subject"));
				} else if(aDocument.getAttribute("Subject").equals(country)) {
					System.out.println(aDocument.getAttribute("Object"));
				}
				System.out.println();
			});
		}

		// Lấy những người đã tham gia (gia nhập) vào một tổ chức nào đó vào một thời điểm cụ thể.
		public void getPerson_tham_gia_Organization_at_time(String organization, String time) {
			String query = "FOR t IN Fact" +
					" FILTER t.QuanHe == \"tham_gia\"" +
					" FILTER t.Object == @organization" +
					" FILTER t.Time == @time" +
					" RETURN t";
			Map<String, Object> bindVars = new MapBuilder().put("organization", organization).put("time", time).get();
			ArangoCursor<BaseDocument> cursor = database.query(query, bindVars, null, BaseDocument.class);
			cursor.forEachRemaining(aDocument -> {
				System.out.println(aDocument.getAttribute("Subject"));
				System.out.println();
			});
		}

		// Tại một địa điểm và thời điểm cụ thể, những Event nào được diễn ra
		public void getEvent_dien_ra_tai_Location_at_time(String location, String time) {
			String query = "FOR t IN Fact" +
					" FILTER t.QuanHe == \"dien_ra_tai\"" +
					" FILTER t.Object == @location" +
					" FILTER t.Time == @time" +
					" RETURN t";
			Map<String, Object> bindVars = new MapBuilder().put("location", location).put("time", time).get();
			ArangoCursor<BaseDocument> cursor = database.query(query, bindVars, null, BaseDocument.class);
			cursor.forEachRemaining(aDocument -> {
				System.out.println(aDocument.getAttribute("Subject"));
				System.out.println();
			});
		}

		// Lấy tên những địa điểm mà tại đó diễn ra một event cụ thể tại một thời điểm cụ thể.
		public void getLocation_dien_ra_Event_at_time(String event, String time) {
			String query = "FOR t IN Fact" +
					" FILTER t.QuanHe == \"dien_ra_tai\"" +
					" FILTER t.Subject == @event" +
					" FILTER t.Time == @time" +
					" RETURN t";
			Map<String, Object> bindVars = new MapBuilder().put("event", event).put("time", time).get();
			ArangoCursor<BaseDocument> cursor = database.query(query, bindVars, null, BaseDocument.class);
			cursor.forEachRemaining(aDocument -> {
				System.out.println(aDocument.getAttribute("Object"));
				System.out.println();
			});
		}

		// Lấy những nước đã đàm phán với một nước nào đó vào một thời điểm cụ thể.
		public void getPerson_dam_phan_at_time(String country, String time) {
			String query = "FOR t IN Fact" +
					" FILTER t.QuanHe == \"dam_phan_voi\"" +
					" FILTER t.Object == @country OR t.Subject == @country" +
					" FILTER t.Time == @time" +
					" RETURN t";
			Map<String, Object> bindVars = new MapBuilder().put("country", country).put("time", time).get();
			ArangoCursor<BaseDocument> cursor = database.query(query, bindVars, null, BaseDocument.class);
			cursor.forEachRemaining(aDocument -> {
				if(aDocument.getAttribute("Object").equals(country)) {
					System.out.println(aDocument.getAttribute("Subject"));
				} else if(aDocument.getAttribute("Subject").equals(country)) {
					System.out.println(aDocument.getAttribute("Object"));
				}
				System.out.println();
			});
		}

		// Những ai đã phát biểu ở một Event nào đó vào một thời điểm cụ thể
		public void getPerson_phat_bieu_tai_Event_at_time(String event, String time) {
			String query = "FOR t IN Fact" +
					" FILTER t.QuanHe == \"phat_bieu_tai\"" +
					" FILTER t.Object == @event" +
					" FILTER t.Time == @time" +
					" RETURN t";
			Map<String, Object> bindVars = new MapBuilder().put("event", event).put("time", time).get();
			ArangoCursor<BaseDocument> cursor = database.query(query, bindVars, null, BaseDocument.class);
			cursor.forEachRemaining(aDocument -> {
				System.out.println(aDocument.getAttribute("Subject"));
				System.out.println();
			});
		}

		// Hai nước nào đó đã đàm phán với nhau vào những lúc nào
		public void getTime_dam_phan(String country1, String country2) {
			String query = "FOR t IN Fact" +
					" FILTER t.QuanHe == \"gap_go\"" +
					" FILTER t.Object == @country1 OR t.Subject == @country1" +
					" FILTER t.Object == @country2 OR t.Subject == @country2" +
					" RETURN t";
			Map<String, Object> bindVars = new MapBuilder().put("country1", country1).put("country2", country2).get();
			ArangoCursor<BaseDocument> cursor = database.query(query, bindVars, null, BaseDocument.class);
			cursor.forEachRemaining(aDocument -> {
				System.out.println(aDocument.getAttribute("Time"));
				System.out.println();
			});
		}
	
	
	
}
