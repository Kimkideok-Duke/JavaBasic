package springweb.z01_vo;

public class Player {
	private String pname;
	private String score;
	public Player() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Player(String pname, String score) {
		super();
		this.pname = pname;
		this.score = score;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public String getScore() {
		return score;
	}
	public void setScore(String score) {
		this.score = score;
	}
	
}
