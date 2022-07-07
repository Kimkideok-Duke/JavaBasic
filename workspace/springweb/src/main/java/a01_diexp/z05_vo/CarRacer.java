package a01_diexp.z05_vo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CarRacer {
	private String dname;
// 	Autowired(required = true) : default 옵션
// 	자동 wiring 처리에 해당 객체가 반드시 있어서 처리되게 옵션
// 	객체가 없으면 에러 발생

// 	객체가 컨테이너에 없더라도 에러가 발생하지 않게 선언.
	@Autowired(required = false)
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
	public void setCar(Car car) {
		this.car = car;
	}
	public void driving() {
		if(dname != null)
			System.out.println(dname+"가 자동차를 운행한다.");
		if(car != null)
			System.out.println("자동차는 "+car.getCname()+", 최고속도는 "+car.getMaxSpd());
	}
}
