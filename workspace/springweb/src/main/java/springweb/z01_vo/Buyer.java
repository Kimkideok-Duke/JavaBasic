package springweb.z01_vo;

public class Buyer {
	private String name;
	private String plist;
	public Buyer() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Buyer(String name, String plist) {
		super();
		this.name = name;
		this.plist = plist;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPlist() {
		return plist;
	}
	public void setPlist(String plist) {
		this.plist = plist;
	}
	
}
