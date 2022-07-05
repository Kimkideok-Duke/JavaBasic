package a01_diexp.z01_vo;

public class People {
	private int number;
	private AmusementPark amuse;
	public People() {
		super();
		// TODO Auto-generated constructor stub
	}
	public People(int number, AmusementPark amuse) {
		super();
		this.number = number;
		this.amuse = amuse;
	}
	public People(int number) {
		super();
		this.number = number;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public AmusementPark getAmuse() {
		return amuse;
	}
	public void setAmuse(AmusementPark amuse) {
		this.amuse = amuse;
	}
	public void showPeople(){
		System.out.println(amuse.getPlace()+"소재의 "+amuse.getName()+"이용객은 하루평균"+number+"명이다.");
	}
}
