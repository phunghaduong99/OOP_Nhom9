package oop.model;



public class LocationModel extends EntityModel<LocationModel>{
	private String country;
	
	public LocationModel(String dinhDanh, String nhanHienThi, String moTa, String link, String country) {
		super(dinhDanh, nhanHienThi, moTa, link);
		
		this.country = country;
	}	
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	@Override
	public void work() {
		// TODO Auto-generated method stub
		
	}
}
