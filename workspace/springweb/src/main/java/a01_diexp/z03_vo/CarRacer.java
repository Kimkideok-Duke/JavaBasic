package a01_diexp.z03_vo;

import org.springframework.stereotype.Component;

@Component
public class CarRacer {
	private String dname;
	private Car car;
	public CarRacer() {
		super();
		// TODO Auto-generated constructor stub
	}
	public CarRacer(String dname, Car car) {
		super();
		this.dname = dname;
		this.car = car;
	}
	public CarRacer(String dname) {
		super();
		this.dname = dname;
	}
	public String getDname() {
		return dname;
	}
	public void setDname(String dname) {
		this.dname = dname;
	}
	public Car getCar() {
		return car;
	}
	// byName set property를 기준으로 할당된다. car02
	public void setCar02(Car car) {
		this.car = car;
	}
	public void driving() {
		if(dname != null)
			System.out.println(dname+"가 자동차를 운행한다.");
		if(car != null)
			System.out.println("자동차는 "+car.getCname()+", 최고속도는 "+car.getMaxSpd());
	}
}
