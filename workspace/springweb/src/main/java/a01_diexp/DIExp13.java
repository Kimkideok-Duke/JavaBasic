package a01_diexp;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import a01_diexp.z01_vo.Music;

public class DIExp13 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String path="a01_diexp/di13.xml";
		AbstractApplicationContext ctx = new GenericXmlApplicationContext(path);
		// DL(dependency loopup)으로 id 명으로 객체를 가져온다.
		Music m01 = ctx.getBean("m01",Music.class);
		Music m02 = ctx.getBean("m02",Music.class);
		System.out.println("###시작###");
		System.out.println("###객체 호출:"+m01);
		System.out.println("###객체 호출:"+m02);
		System.out.println("###곡:"+m01.getSong());
		System.out.println("###가수:"+m01.getSinger());
		System.out.println("###곡:"+m02.getSong());
		System.out.println("###가수:"+m02.getSinger());
		ctx.close();
	}

}
