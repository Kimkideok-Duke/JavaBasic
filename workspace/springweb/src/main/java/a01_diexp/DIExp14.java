package a01_diexp;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import a01_diexp.z01_vo.*;

public class DIExp14 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String path="a01_diexp/di14.xml";
		AbstractApplicationContext ctx = new GenericXmlApplicationContext(path);
		// DL(dependency loopup)으로 id 명으로 객체를 가져온다.
		HPerson obj = ctx.getBean("hperson01",HPerson.class);
		System.out.println("###시작###");
		System.out.println("###객체 호출:"+obj);
		obj.myHandphone();
		ctx.close();
	}

}
