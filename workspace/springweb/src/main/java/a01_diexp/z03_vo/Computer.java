package a01_diexp.z03_vo;

public class Computer {
	private String kind;
	private Cpu cpu;
	public Computer() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Computer(String kind, Cpu cpu) {
		super();
		this.kind = kind;
		this.cpu = cpu;
	}
	public Computer(String kind) {
		super();
		this.kind = kind;
	}
	public String getKind() {
		return kind;
	}
	public void setKind(String kind) {
		this.kind = kind;
	}
	public Cpu getCpu() {
		return cpu;
	}
	public void setCpu(Cpu cpu) {
		this.cpu = cpu;
	}
	public void checkComInfo(){
		System.out.println("cpu 스펙 : "+getCpu().getSpec());
		System.out.println("cpu 제조사 : "+getCpu().getCompany());
		System.out.println("computer 종류 : "+kind);
	}
}
