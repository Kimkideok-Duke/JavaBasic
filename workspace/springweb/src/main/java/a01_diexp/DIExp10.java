package a01_diexp;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class DIExp10 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String path="a01_diexp/di01.xml";
		AbstractApplicationContext ctx = new GenericXmlApplicationContext(path);
		// DL(dependency loopup)으로 id 명으로 객체를 가져온다.
		Object obj = ctx.getBean("obj",Object.class);
		System.out.println("###시작###");
		System.out.println("###객체 호출:"+obj);
		ctx.close();
	}

}