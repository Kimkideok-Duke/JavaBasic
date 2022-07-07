package a01_diexp.z05_vo;

import org.springframework.stereotype.Component;

// Component
public class Car {
	private String cname;
	private int maxSpd;
	public Car() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Car(String cname, int maxSpd) {
		super();
		this.cname = cname;
		this.maxSpd = maxSpd;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public int getMaxSpd() {
		return maxSpd;
	}
	public void setMaxSpd(int maxSpd) {
		this.maxSpd = maxSpd;
	}
	
}
