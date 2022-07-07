package a01_diexp.z02_vo;

public class Pen {
	private String pname;
	private String company;
	public Pen() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Pen(String pname, String company) {
		super();
		this.pname = pname;
		this.company = company;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
}
