package javaexp.a09_inherit;

public class A01_Basic {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/**
		# 상속
		1. 상속 개념과 활용
			1) 상속의 효과 
				- 부모클래스 재사용해 자식클래스 빨리 개발 가능
				- 반복된 코드 중복 줄임
				- 유지 보수 편리성 제공
				- 객체 다형성 구현 기능
				ex) 공통적인 DB접근 class를 만들고, 상속받아서 DB서버별(oracle, mysql, mssql...)
					에 맞는 처리 class 선언하여 활용
			2) 상속 대상 제한
				- 부모 클래스의 private 접근 갖는 필드와 메소드 제외 private 자체가 해당 클래스에서만 사용할 수 있지,
					직접적인 접근 및 처리를 하지 못한다. 단, 간접적으로 다른 메서드나 생성자를 통해서 접근은 가능하다.
				- 부모 클래스가 다른 패키지에 있을 경우, default 접근 갖는 필드와 메소드도 제외
		2. 상속 처리 기본 형식
			1) extends 키워드 활용
				자식 클래스가 상속할 부모 클래스를 지정하는 키워드
					class 부모{}
					class 자식 extends 부모{}
		 */
		Father f = new Father();
		System.out.println(f.shape);
		f.show();
		System.out.println("# 상속받은 아들 객체 #");
		Son s1 = new Son();
		System.out.println(s1.shape);
		s1.show();
		System.out.println("추가 기능 필드 : " + s1.running);
		// ex)
		Mother m = new Mother();
		m.show();
		Daughter d1 = new Daughter("요리를 못한다", "수영을 못한다", "불같다");
		d1.show();
		System.out.println(d1.swimming);
	}

}
class Father{
	String shape = "통통하다";
	String height = "키가 큰편이다.";
	void show() {
		System.out.println("모습 : " + shape);
		System.out.println("키 : " + height);
	}
}
class Son extends Father{
	String running = "달리기를 잘한다.";
}

class Mother{
	String cooking = "요리를 잘한다.";
	String cha = "온화하다.";
	void show() {
		System.out.println("요리실력 : " + cooking);
		System.out.println("성격 : " + cha);
	}
}
class Daughter extends Mother{
	String swimming = "수영을 잘한다.";
	Daughter(){}
	Daughter(String cooking, String swimming, String cha) {
		this.cooking = cooking;
		this.swimming = swimming;
		this.cha = cha;
	}
}