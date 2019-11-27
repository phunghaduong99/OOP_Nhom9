package oop.model;



public class OrganizationModel extends EntityModel<OrganizationModel>{
	private String truSo;

	public String getTruSo() {
		return truSo;
	}

	public void setTruSo(String truSo) {
		this.truSo = truSo;
	}

	public OrganizationModel(String dinhDanh, String nhanHienThi, String moTa, String link, String truSo) {
		super(dinhDanh, nhanHienThi, moTa, link);
		this.truSo = truSo;
	}
	
	@Override
	public void work() {
		// TODO Auto-generated method stub
		
	}
	
	
}