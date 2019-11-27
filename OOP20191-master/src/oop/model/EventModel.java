package oop.model;



public class EventModel extends EntityModel<EventModel>{
	private String time;
	private String location;
	
	@Override
	public void work() {
		// TODO Auto-generated method stub
		
	}
	
	public EventModel(String dinhDanh, String nhanHienThi, String moTa, String link, String time, String location) {
		super(dinhDanh, nhanHienThi, moTa, link);
		this.time = time;
		this.location = location;
	}

	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	
	
	
}