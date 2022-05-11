package javaexp.z03_vo;

public class Seat {
	private String num;
    private String place;
    public Seat() {
		super();
		// TODO Auto-generated constructor stub
    }
	public Seat(String num, String place) {
		this.num = num;
		this.place = place;
	}
    
    public void show() {
        System.out.println(num + "번 " + place + "좌석");
    }

    public String getNum() {
        return this.num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public String getPlace() {
        return this.place;
    }

    public void setPlace(String place) {
        this.place = place;
    }
    
}
