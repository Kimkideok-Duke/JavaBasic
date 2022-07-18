package springweb.a02_mvc.a04_vo;

public class ScPlayer {
	private String name;
	private String record;
	public ScPlayer() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ScPlayer(String name, String record) {
		super();
		this.name = name;
		this.record = record;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getRecord() {
		return record;
	}
	public void setRecord(String record) {
		this.record = record;
	}
	
}
