package a01_diexp;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import a01_diexp.z07_vo.Product;

public class DIExp25 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String path="a01_diexp/di25.xml";
		AbstractApplicationContext ctx = new GenericXmlApplicationContext(path);
		// DL(dependency loopup)으로 id 명으로 객체를 가져온다.
		Product pd01 = ctx.getBean("pd01",Product.class);
		System.out.println("###시작###");
		System.out.println("###객체 호출:"+pd01);
		System.out.println(pd01.getPname());
		System.out.println(pd01.getPrice());
		System.out.println(pd01.getCnt());
		ctx.close();
	}

}
