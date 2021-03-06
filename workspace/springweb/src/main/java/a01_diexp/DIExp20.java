package a01_diexp;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import a01_diexp.z02_vo.Person;

public class DIExp20 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String path="a01_diexp/di20.xml";
		AbstractApplicationContext ctx = new GenericXmlApplicationContext(path);
		// DL(dependency loopup)으로 id 명으로 객체를 가져온다.
		Person obj = ctx.getBean("person",Person.class);
		System.out.println("###시작###");
		System.out.println("###객체 호출:"+obj);
		ctx.close();
		/* ex) a01_diexp.z03_vo 패키지 생성,
		 * 	클래스 copy 생성하고 만들고, @Component 선언 후, 해당 범위에 객체들이 로딩되게 처리
		 * DIExp21.java
		 * di21.xml
		 */
	}

}
