package javaexp.a06_class;

public class A05_MultiParam {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/**
		# 여러개의 매개변수가 있을 때 처리
		1. 생성자나 매서드는 여러개의 매개변수를 처리할 수 있고, 해당 type 유형과 매개변수의 갯수에 따라 호출한다.
		Person(String name, String loc){
		}
		==> 
		new Person("홍길동", "서울 신림동");
		Person(String name, int age){
		}
		==>
		new Person("홍길동", 25)
		 */
		Person02 p01 = new Person02("홍길동", "서울 신림동");
		Person02 p02 = new Person02("홍길동", 27);
		// ex)
		Bicycle b01 = new Bicycle("하이브리드", 150000);
		Bicycle b02 = new Bicycle('S');
		// 생성자나 매개변수는 
		// 1) 매개변수의 타입의 유형이 다를 때,
		// 2) 매개변수의 갯수가 다를 때,
		// 3) 매개변수의 갯수가 동일하더라도 타입의 순서가 다를 때
		// 	다른 생성자나 메서드로 인식하여 선언이 가능하다. ==> 오버로딩 규칙
	}

}
class Bicycle{
	Bicycle(char rank) {
		System.out.println("등급 : " + rank);
	}
	Bicycle(String name, int price) {
		System.out.println("자전거 이름 : " + name);
		System.out.println("가격 : " + price);
	}
}
class Person02{
	Person02(String name, String loc){
		System.out.println("# 생성자1 #");
		System.out.println("이름 : " + name);
		System.out.println("사는 곳 : " + loc);
	}
	Person02(String name, int age){
		System.out.println("# 생성자2 #");
		System.out.println("이름 : " + name);
		System.out.println("나이 : " + age);
	}
}