package a01_diexp;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import a01_diexp.z01_vo.*;

public class Hw0704 {

	// 2022-07-04
	// [1단계:확인] 1. 컨테이너에 1:1관계에 있는 펜과 노트를 객체를 선언하여 처리하고, 내용을 출력하세요

	// [1단계:개념] 2. autowire 무엇인지 기술하고, 종류를 기술하세요
				// # Autowired(자동 주입 설정)
				// 1. 스프링의 빈의 요구 사항과 매칭되는 애플리케이션 컨텍스트 상에서 다른 빈을 찾아 빈간의 의존성을
				// 	자동으로 만족시키도록 하는 수단이다.
				// 2. 의존성 자동 주입 설정 옵션
				// 	1) no : 의존성 자동 주입이 일어나지 않게 설정
				// 	2) byType : 할당할 type(객체)가 있으면 자동으로 주입되게 처리한다.
				// 	3) byName : type이 있고, 기능 메서드 명이 객체의 참조명과 같은 때 처리된다.
				// 	4) constructor : 의존성 자동 주입이 생성자의 매개변수의 type으로 결정된다.
				// 	5) autodetect : 자동으로 생성자나 기능 property로 설정이 된다.


	// [1단계:확인] 3. 놀이공원에 간 사람으로 1:1관계로 class를 설정하고 autowiring 옵션을 설정하여 처리하세요.

	// [1단계:개념] 4. autowire의 옵션 중, byType과 byName의 차이점을 기본예제를 통해서 설명하세요.
				// # autowire="byType" 스프링 컨테이너 메모리가 해당 객체 타입으로 들어올 수 있는
				// 메서드가 정의가 되면 자동으로 할당이 되게 처리하는 것을 말한다.
				// 명시적으로 property를 선언하지 않더라도 할당이 되는 것을 말한다.
				// public void setHandphone(HandPhone handphone)가 있으므로,
				// 해당하는 객체로 할당이 가능하다.

				// # autowire="byName" 할당할 수 있는 객체가 여러개 있을 때(type은 동일을 전제), 해당 객체
				//   되는 것이 기능 메서드의 byName으로 선언함으로, 여러개 객체들 중에 id값이 set property와
				//   동일한것이 할당되어지게 처리

	// [1단계:확인] 5. 마트와 마트에서 구매한 객체 Product 3개를 선언하고, 이 중 하나의 객체를 byName으로 설정해서 할당하게 처리
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String path="a01_diexp/hw0704.xml";
		AbstractApplicationContext ctx = new GenericXmlApplicationContext(path);
		// 1. 컨테이너에 1:1관계에 있는 펜과 노트를 객체를 선언하여 처리하고, 내용을 출력하세요
		Note obj = ctx.getBean("note",Note.class);
		obj.notepenInfo();
		// 3. 놀이공원에 간 사람으로 1:1관계로 class를 설정하고 autowiring 옵션을 설정하여 처리하세요.
		People ap = ctx.getBean("people",People.class);
		ap.showPeople();
		// 5. 마트와 마트에서 구매한 객체 Product 3개를 선언하고, 이 중 하나의 객체를 byName으로 설정해서 할당하게 처리
		Mart mt = ctx.getBean("mart",Mart.class);
		mt.shoppingInfo();
		ctx.close();

		
	}

}
