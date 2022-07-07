package a01_diexp;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import a01_diexp.z04_vo.Mart;
import a01_diexp.z04_vo.Product;

public class DIExp22 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String path="a01_diexp/di22.xml";
		AbstractApplicationContext ctx = new GenericXmlApplicationContext(path);
		// DL(dependency loopup)으로 id 명으로 객체를 가져온다.
		Product prod = ctx.getBean("prod",Product.class);
		prod.setPname("지우개");
		prod.setPrice(500);
		prod.setCnt(3);
		Mart obj = ctx.getBean("mart01",Mart.class);
		obj.setMname("하이마트");
		System.out.println("###시작###");
		System.out.println("###객체 호출:"+obj);
		obj.shoppingInfo();
		ctx.close();
	}

}
