package webprj.z01_vo;

public class Player {
	private String team;
	private String name;
	private String score;
	public Player() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Player(String team, String name, String score) {
		super();
		this.team = team;
		this.name = name;
		this.score = score;
	}
	public String getTeam() {
		return team;
	}
	public void setTeam(String team) {
		this.team = team;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getScore() {
		return score;
	}
	public void setScore(String score) {
		this.score = score;
	}
	
}
