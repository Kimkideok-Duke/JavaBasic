package javaexp.a06_class;

public class A03_Constructor {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		# 생성자
		1. new 연산자에 의해 호출되어 겍체의 초기화를 담당한다.
			new 클래스명();
			1) 필드의 값 설정
			2) 메소드 호출해 객체를 사용할 수 있도록 준비하는 역할 수행
		2. 기본 생성자(Default Constructor)
			1) 모든 클래스는 생성자가 반드시 존재하며 하나 이상 가질 수 있다.
			2) 생성자 선언을 생략하면 컴파일러로 클래스명과 동일하고 매개변수가 없는 생성자가 추가된다.
		*/
		// Music m01 = new Music() // Music() 생성자라고 한다.
		// 		default 생성자는 개발자에 의해서 생성자를 선언하는 순간 사라진다.
		// 		선언된 생성자에 적합하게 호출하는 경우에 사용할 수 있다.
		Music m02 = new Music("행복한 음악");
		// ex)
		Player player01 = new Player("김현수");
	}

}
class Player {
	Player(String name) {
		System.out.println("이름 : " + name);
	}
}

class Music {
	// 코드로 생성자를 선언하지 않을 때는 내부적으로 컴파일시
	// Music(){}
	// 코드로 생성자를 선언하는 순간 default 생성자는 사라진다.
	Music(String name){
		System.out.println("입력받은 값 : " + name);
	}
}