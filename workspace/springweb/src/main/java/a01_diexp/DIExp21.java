package a01_diexp;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import a01_diexp.z03_vo.CarRacer;
import a01_diexp.z03_vo.Mart;
import a01_diexp.z03_vo.Product;

public class DIExp21 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String path="a01_diexp/di21.xml";
		AbstractApplicationContext ctx = new GenericXmlApplicationContext(path);
		// DL(dependency loopup)으로 id 명으로 객체를 가져온다.
		CarRacer obj = ctx.getBean("carRacer",CarRacer.class);
		Mart mt = ctx.getBean("mart01",Mart.class);
		mt.setMname("하이마트"); // 직접 값을 넣어줘야함
		mt.setPd(new Product("연필", 1200, 12));
		System.out.println("###시작###");
		System.out.println("###객체 호출:"+obj);
		System.out.println("###객체 호출:"+mt);
		obj.driving();
		mt.shoppingInfo();
		ctx.close();
	}

}
