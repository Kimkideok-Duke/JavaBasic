package javaexp.a05_reference;

public class A01_Basic {

	public static void main(String[] args) {
		/**
		# 참조변수
		1. 자바에서 가장 많이 활용되는 메모리가 stack영역과 heap영역이 있다.
			(stack)	[			]
					[	heap	]
					[    		]
			cf) 기본데이터 유형을 stack에 선언과 할당
				객체(배열, 객체, 인터페이스...)을 사용하는 메모리 비유
				
		2. stack영역에는 기본 타입유형이 바로 할당되는데, 그외 배열, 열거, 객체, 인터페이스 유형은 heap영역에 할당되고, stack영역에 heap영역의 주소값을 할당하여 사용한다.
		3. 이 때, 객체 유형은 heap영역을 참조한다는 개념으로 참조 타입이라고 한다. 이런 변수를 참조변수라고 한다.
			배열, 열거, 객체, 인터페이스는 실제 할당된 메모리는 heap영역이고, stack영역에서는 할당된 heap영역의 주소값을 가지고 있기에 참조라는 개념으로 참조변수를 사용한다.

		# 데이터 타입의 분류
		1. 기본타입
			정수, 실수, 논리 타입
		2. 참조 타입
			베열, 열거, 클래스, 인터페이스
		# 변수의 메모리 사용
		1. 기본 타입
			할당할 데이터를 변수 안에 저장한다.
			stack 영역에 데이터를 바로 저장
		2. 참조타입 변수
			할당할 데이터를 변수 안에 주소로 저장한다.
			heap영역의 데이터를 주소값으로 stack영역에 할당 저장.
		 */
		int num01 = 25;
		int num02 = 25;
		System.out.println("stack영역 할당된 데이터 : " + num01);
		System.out.println("stack영역 할당된 데이터 : " + num02);
		Person p01 = new Person();
		Person p02 = new Person();
		System.out.println("stack영역 할당된 참조변수의 데이터 : " + p01);
		System.out.println("stack영역 할당된 참조변수의 데이터 : " + p02);
		System.out.println(num01 == num02);
		// javaexp.a05_reference.Person@251a69d7
		// 패키지명.객체명@heap영역의주소값(16진수)
		System.out.println("객체의 데이터 활용 : " + p02.name);
		System.out.println("객체의 데이터 활용 : " + p02.age);
		System.out.println(p01 == p02);
		Person p03 = p01; // p03이라는 stack영역에 메모리 p01주소값을 할당
		System.out.println(p01 == p03);

		System.out.println("////////////////EX//////////////////");
		// ex1) Product를 prod01과 prod02객체를 생성하고 주소값을 비교
		Product prod01 = new Product();
		Product prod02 = new Product();
		// ex2) prod03을 선언하고 prod01에서 할당하고, prod01과 prod03을 비교
		Product prod03 = prod01;
		System.out.println(prod01 == prod03);
		// ex3) prod01, prod02, prod03의 heap영역의 주소값을 출력
		System.out.println(prod01);
		System.out.println(prod02);
		System.out.println(prod03);
	}

}

class Product{}

class Person{
	String name = "홍길동";
	int age = 25;
} // 객체를 만들기 위한 코드(클래스)
// 클래스는 도면, 객체는 이 도면을 통해서 jvm에서 실제 메모리를 할당하고 만들어 사용할 수 있는 것을 말한다.