package javaexp.a06_class;

public class A06_ConstructorInitData {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/**
		# 생성자의 필드값 초기화
		1. 생성자의 가장 핵심 기능으로 필드값을 할당하여 처리할 수 있다.
		2. 기본 예제
			class Person{
				String name;
				int age;
				Person(String name, int age) {
					this.name = name; // 입력된 매개변수명과 필드명이 같을 때는 this키워드를 통해 구분해 준다. this.필드명
					this.age = age;
				}
			}
		 */
		Person04 p01 = new Person04("홍길동", 25);
		System.out.println(p01.name);
		System.out.println(p01.age);
		// ex)
		Product05 pd01 = new Product05("연필", 500, 12);
		System.out.println(pd01.name);
		System.out.println(pd01.price);
		System.out.println(pd01.cnt);

		Calculator calc = new Calculator(2, 3, '+');
		System.out.print(calc.num1);
		System.out.print(calc.c);
		System.out.println(calc.num2);

		Book book = new Book("해리포터", 8700, "조앤");
		System.out.println(book.name);
		System.out.println(book.price);
		System.out.println(book.author);
	}

}
class Product05{
	String name;
	int price;
	int cnt;
	Product05(String name, int price, int cnt){
		this.name = name;
		this.price = price;
		this.cnt = cnt;
	}
}
class Calculator{
	int num1;
	int num2;
	char c;
	Calculator(int num1, int num2, char c){
		this.num1 = num1;
		this.num2 = num2;
		this.c = c;
	}
}
class Book{
	String name;
	int price;
	String author;
	Book(String name, int price, String author){
		this.name = name;
		this.price = price;
		this.author = author;
	}
}
class Person04{
	String name;
	int age;
	Person04(String name, int age){
		this.name = name;
		this.age = age;
	}
} 