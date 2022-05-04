package javaexp.a06_class;

public class A02_Class {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/**
		# 클래스의 구성 멤버
		1. 필드(field)
			주로 데이터를 저장하는 역할을 한다.
			객체가 만들어졌을 때, 그 객체가 사용할 속성에 적절한 데이터를 할당할 때 사용된다.
			ex) 자동차의 배기량, 최고속도, 생산회사 등등
		2. 생성자(Constructor)
			객체 생성시, 초기화 역할을 담당한다.
			객체를 처음 만들었을 때, 이 객체가 가지고 있어야 할 기본 데이터를 저장할 떄 활용된다.
			매개변수를 통해서 전달받는 경우도 있다.
			ex) 마트에서 계산하는 계산기의 경우, 이 마트가 다루는 상품 정보, 가격 정보, 연산 규칙등은 계산기가 초기에 가지고 있어야할 정보다.
				이를 초기에 설정할 때, 생성자를 통해서 선언하고, 객체 생성시 초기화 된다.
		3. 메소드(Method)
			객체가 동작에 해당하는 실행블록을 말한다. 입력을 통해 필드에 데이터를 저장하거나, 저장된 데이터를 불러와서 연산을 하여 원하는 정보를 수집하는 등의 작업을 한다.
			주로 조건, 반복문을 통해서 원하는 정보로 만들어서 return한다.
		 */

		 Person01 p01 = new Person01(); // 객체의 생성
		 p01.name = "홍길동";
		 p01.age = 25;
		 p01.loc = "서울 신림동";
		 Person01 p02 = new Person01();
		 p01.name = "오길동";
		 p01.age = 27;
		 p01.loc = "경기 구리";
		 System.out.println("p01 객체의 필드");
		//  참조 변수.필드명
		 System.out.println(p01.name);
		 System.out.println(p01.age);
		 System.out.println(p01.loc);
		 System.out.println("p02 객체의 필드");
		//  참조 변수.필드명
		 System.out.println(p02.name);
		 System.out.println(p02.age);
		 System.out.println(p02.loc);
		//  ex) class로 Product01을 선언하고 물건명과 가격 필드를 선언하고, Product01 객체를 생성하여 물건정보 3개를 속성으로 선언하고 할당하세요
		Product01 pd01 = new Product01();
		pd01.name = "연필";
		pd01.price = 1200;
		pd01.num = 20;
		System.out.println(pd01.name);
		System.out.println(pd01.price);
		System.out.println(pd01.num);
		
		/*
		# 필드의 사용
		1. 필드값을 읽고, 변경하는 작업을 말한다.
		2. 필드 사용 위치
			1) 소속된 클래스 내부에서는 : 필드 이름으로 바로 접근
			2) 외부에서 객체를 호출할때는 : 참조변수, 필드명으로 접근
		*/
	}

}
class Person01 { // 같은 package package javaexp.a06_class;에 동일한 클래스는 선언이 불가능하다.
	// 필드 선언.
	// 저장할 데이터를 바로 선언 및 할당도 가능하지만, 일반적으로 외부에서 호출하여 데이터를 할당하는 경우가 많다.
	// # 필드의 내용
	// 1. 객체의 고유 데이터
	// 2. 객체가 가져야 할 부품 객체
	// 3. 객체의 현재 상태 데이터
	String name;
	int age;
	String loc;
}

class Product01 {
	String name;
	int price;
	int num;
}