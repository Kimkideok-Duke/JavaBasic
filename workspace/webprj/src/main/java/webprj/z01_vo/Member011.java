package webprj.z01_vo;

public class Member011 {
	private String id;
	private String pass;
	private String name;
	private int point;
	private String auth;
	public Member011() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Member011(String id, String pass, String name, int point, String auth) {
		super();
		this.id = id;
		this.pass = pass;
		this.name = name;
		this.point = point;
		this.auth = auth;
	}
	public Member011(String name, String auth) {
		super();
		this.name = name;
		this.auth = auth;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPoint() {
		return point;
	}
	public void setPoint(int point) {
		this.point = point;
	}
	public String getAuth() {
		return auth;
	}
	public void setAuth(String auth) {
		this.auth = auth;
	}
	
}
