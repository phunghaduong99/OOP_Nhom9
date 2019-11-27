package oop.fact;

public class Fact {
	private String subject;
	private String object;
	private String relationShip;
	private String time;

	public Fact(String subject, String object, String relationShip, String time) {
		super();
		this.subject = subject;
		this.object = object;
		this.relationShip = relationShip;
		this.time = time;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getObject() {
		return object;
	}

	public void setObject(String object) {
		this.object = object;
	}

	public String getRelationShip() {
		return relationShip;
	}

	public void setRelationShip(String relationShip) {
		this.relationShip = relationShip;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

}
