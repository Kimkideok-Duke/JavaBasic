package javaexp.a02_start;

public class A01_Var {

	public static void main(String[] args) {
		int age;
		double height;
		
		/*
		 # 변수명 선언의 규칙
		 1. 특수문자는 $,_ 만 허용된다.
		 */
		int $name = 25;

//		2. 숫자로 시작할 수 없다. 문자로 시작해서 숫자가 삽입되는 것은 가능하다.
		int n25 = 40;
		int num02 = 50;
//		3. 대소문자는 구분한다.
		int N01 = 25;
		int n01 = 30;
		// ex) 객체지향 프로그램의 가독성을 위한 규칙(에러는 발생하지 않지만 변경과 코드해석에서 지켜야할 규칙)
		// 	1. 클래스명/객체명은 대문자로 시작해서 선언하여야 한다.
		// 	2. 참조변수, 일반변수, 메서드명은 소문자로 시작한다.
		// 	3. 합성어로 된 변수는 구분자를 대문자나 _로 설정한다.
		// 		setName(), getName(), prg_name
		//  4. 상수나 static 변수는 전체 대문자로 선언한다.
//		4. 자바 예약어는 사용할 수 없다.
//			break, for, if, class 등 내부적으로 지정된 언어는 변수로 사용할 수 없다.
		int break01;
//		예약어 뒤에 접미사를 사용하면 가
	}
}
