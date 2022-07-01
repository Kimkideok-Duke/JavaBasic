package a01_diexp;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import a01_diexp.z01_vo.Person;
import a01_diexp.z01_vo.Product;

public class DIExp12 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String path="a01_diexp/di12.xml";
		AbstractApplicationContext ctx = new GenericXmlApplicationContext(path);
		// DL(dependency loopup)으로 id 명으로 객체를 가져온다.
		Product prod = ctx.getBean("pd01",Product.class);
		Person p01 = ctx.getBean("p01",Person.class);
		System.out.println("###시작###");
		System.out.println("###객체 호출:"+prod);
		System.out.println("###객체 호출:"+p01);
		System.out.println("###객체 호출:"+prod.getPname());
		System.out.println("###객체 호출:"+prod.getPrice());
		System.out.println("###객체 호출:"+prod.getCnt());
		System.out.println("###객체 호출:"+p01.getName());
		System.out.println("###객체 호출:"+p01.getAge());
		System.out.println("###객체 호출:"+p01.getLoc());
		Person p03 = ctx.getBean("p03",Person.class);
		System.out.println("p02:"+p03);
		System.out.println("###객체 호출:"+p03.getName());
		System.out.println("###객체 호출:"+p03.getAge());
		System.out.println("###객체 호출:"+p03.getLoc());
		ctx.close();
	}

}
