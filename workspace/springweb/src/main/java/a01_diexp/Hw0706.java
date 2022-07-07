package a01_diexp;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import a01_diexp.z10_vo.Music;
import a01_diexp.z10_vo.Note;
import a01_diexp.z10_vo.Pen;

public class Hw0706 {

	// 2022-07-06
	// [1단계:개념] 1. 스프링에서 컨테이너에 특정한 패키지의 자동 객체 설정을 처리할 때, 처리할 내용을 기술하세요
				// 1. 컨테이너 선언에 있어서 특정 패키지를 지정하여, 해당 범위에 있는 클래스를 특정한 패턴에 의해서 객체로 로딩하게 처리할 수 있다.
				// 2. 처리 순서
				// 	1) 패키지 단위 로딩하고자 하는 클래스 선언
				// 	2) 컨테이너(@@.xml)에서 특정 패키지를 지정하여 포함된 클래스를 filtering
				// 		방식을 선언하여 객체 선택 처리
				// 	3) 속성값
				// 		base-package : 대상 패키지 선언
				// 		context:include-filter : filter 기준을 설정하는 내용(포함)
				// 		context:exclude-filter : filter 기준으로 배제하는 내용
				// 		type : filter 대상에 대한 type 지정 ex) annotation, regex
				// 		expression : 실제 쓰이는 대상이 되는 클래스 선언
				// 3. 호출 처리
				// 	1) 각 클래스에 @Component를 선언하면 클래스명의 첫번째 문자는 소문자로 하여 id/name으로 인식하여 처리가 된다.
				// 	2) 위 식별자는 @Component("식별자명")으로 변경하여 처리할 수 있다.
				// 		일반적으로 패키지가 다르지만 동일한 클래스 명으로 하나의 컨테이너에 식별자가 충돌이 나는 경우
				// 		이렇게 명시적으로 식별자명을 바꾸어서 처리가 가능하다.
				// 4. 소스상 자동 autowiring 처리
				// 	1) 위와 같이 Component가 선언되어 있을 때, 여러가지 특정한 코드를 통해 필드나
				// 		기능 메서드의 상단에 @Autowired라는 키워드를 통해서 객체간의 자동으로 메모리가 할당하게 할 수 있다.
				// 	2) 컨테이너에서 autowire 옵션으로 위에 선언된 여러가지 옵션을 선언할 필요없이,
				// 		바로 추가되는 클래스에서 선언하여 객체를 자동으로 할당되게 한다.
				// 	3) 실무적으로 MVC패턴에서 Controller는 Service객체를 Service객체는 Dao객체를 필드로 선언하면서 
				// 		@Autowired 옵션으로 new XXXX() 없이 객체가 컨테이너에 로딩된 메모리를 사용할 수 있게 해준다.


	// [1단계:확인] 2. 스프링 컨테이너에 z10_vo 패키지에 클래스를 등록하여, 1:1연관관계가 있는 펜과 종이 객체를 선언하고,
	// 	코드상 자동 설정관계가 있게 처리하고 호출하세요
	// [1단계:확인] 3. 공통 설정 파일을 java 폴드 밑에 msg/msg01로 설정하고, 좋아하는 음악, 가수를 설정하고,
	// 	이를 vo로 만들어 호출되게 처리하여 출력결과를 확인하세요.
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String path="a01_diexp/hw0706.xml";
		AbstractApplicationContext ctx = new GenericXmlApplicationContext(path);
		// [1단계:확인] 2. 스프링 컨테이너에 z10_vo 패키지에 클래스를 등록하여, 1:1연관관계가 있는 펜과 종이 객체를 선언하고,
		// 	코드상 자동 설정관계가 있게 처리하고 호출하세요
		Note note01 = ctx.getBean("note01",Note.class);
		note01.setSize("휴대용");
		System.out.println("###시작###");
		System.out.println("###객체 호출:"+note01);
		note01.notepenInfo();
		Pen pen01 = ctx.getBean("pen01",Pen.class);
		pen01.setPname("검은펜");
		pen01.setCompany("모나미");
		note01.notepenInfo();
		// [1단계:확인] 3. 공통 설정 파일을 java 폴드 밑에 msg/msg01로 설정하고, 좋아하는 음악, 가수를 설정하고,
		// 	이를 vo로 만들어 호출되게 처리하여 출력결과를 확인하세요.
		Music music01 = ctx.getBean("music01",Music.class);
		System.out.println(music01.getSong());
		System.out.println(music01.getSinger());
		ctx.close();
	}

}
