package a01_diexp;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import a01_diexp.z01_vo.*;

public class DIExp19 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String path="a01_diexp/di19.xml";
		AbstractApplicationContext ctx = new GenericXmlApplicationContext(path);
		// DL(dependency loopup)으로 id 명으로 객체를 가져온다.
		CarRacer cr = ctx.getBean("cr",CarRacer.class);
		System.out.println("###객체 호출:"+cr.getCar().getCname());
		System.out.println("###객체 호출:"+cr.getCar().getMaxSpd());
		cr.driving();
		ctx.close();
	}

}
