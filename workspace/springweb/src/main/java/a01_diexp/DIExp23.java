package a01_diexp;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import a01_diexp.z05_vo.Car;
import a01_diexp.z05_vo.CarRacer;

public class DIExp23 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String path="a01_diexp/di23.xml";
		AbstractApplicationContext ctx = new GenericXmlApplicationContext(path);
		// DL(dependency loopup)으로 id 명으로 객체를 가져온다.
		CarRacer obj = ctx.getBean("carRacer",CarRacer.class);
		obj.setDname("홍킬동");
		// Car car = ctx.getBean("car",Car.class);
		// car.setCname("포르쉐 카이엔");
		// car.setMaxSpd(60);
		System.out.println("###시작###");
		System.out.println("###객체 호출:"+obj);
		obj.driving();
		ctx.close();
	}

}
