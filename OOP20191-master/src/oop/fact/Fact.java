package oop.fact;


public class Fact {

	private String entity1;
	private String fact;
	private String entity2;

	

	public Fact(String entity1, String fact, String entity2) {
		super();
		this.entity1 = entity1;
		this.fact = fact;
		this.entity2 = entity2;
	}

	public String getEntity1() {
		return entity1;
	}

	public void setEntity1(String entity1) {
		this.entity1 = entity1;
	}

	public String getFact() {
		return fact;
	}

	public void setFact(String fact) {
		this.fact = fact;
	}

	public String getEntity2() {
		return entity2;
	}

	public void setEntity2(String entity2) {
		this.entity2 = entity2;
	}

}
