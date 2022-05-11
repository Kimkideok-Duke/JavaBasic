package javaexp.a08_access;

public class A02_AccessModifier {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/**
		# 접근 제한자
		1. 클래스 및 클래스의 구성멤버에 대한 접근을 제한하는 역할
			1) 다른 패키지에서 클래서를 사용하지 못하도록(클래스 제한)
			(public) class 클래스명{}
			==> 외부패키지에서 클래스명 참조변수;
			ex) Person p01; 같은 패키지일때는 public이 없어도 되지만 다른패키지일때는 public을 선언하지 않으면 에러발생 (접근제한자 에러)
			2) 클래스로부터 객체를 생성하지 못하도록(생성자 제한)
				public class 클래스명{
					// public 생성자(){} default 생성자 선언..
					(public) 생성자(){}
				}
				==> 외부패키지에서 참조변수 = new 생성자();
				ex) p01 = new Person();
					외부 패키지일깨는 default 생성자이거나 명시적 public을 선언하여야 한다.
			3) 특정 필드와 메소드를 숨김처리(필드와 메소드 제한)
				private String name;
				public void call(){}
		2. 접근 제한자의 종류
			1) public, protected, default(X), private
			cf) 외부 패키지에서 해당 클래스나, 클래스 소속 멤버들을 사용할 때
			import 패키지명.클래스명, 패키지명.클래스명
			접근제한자가 public이여야 한다.
		 */
	}

}
