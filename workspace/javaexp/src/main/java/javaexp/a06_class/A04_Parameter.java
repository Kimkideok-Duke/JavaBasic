package javaexp.a06_class;

public class A04_Parameter {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/**
		# 생성자 및 메서드의 매개변수 처리
		1. 함수형 기능 처리는 매개변수를 효율적으로 처리하여야 한다.
		2. 주로 외부에서 데이터를 입력할 때, 주로 사용된다.
		3. 선언..
			1) 생성자 선언
				Person(int age){

				}
				매개변수가 정수형 age로 선언하면
			2) 호출
				new Person(25);
				선언된 형식대로 1개 매개변수에 정수형 데이터를 할당하여야 한다.
		 */
		ParamObj pa01 = new ParamObj("홍길동");
		ParamObj pa02 = new ParamObj(25);
		ParamObj pa03 = new ParamObj(true);
		ParamObj pa04 = new ParamObj('A');

		// ex)
		House h01 = new House((byte)0);
		House h02 = new House(25);
		House h03 = new House(30.3);
		House h04 = new House('A');
		House h05 = new House("Home");
	}

}
class House {
	House(String s){
		System.out.println("문자열 입력 : " + s);
	}
	House(byte b){
		System.out.println("byte값 입력 : " + b);
	}
	House(int i){
		System.out.println("정수값 입력 : " + i);
	}
	House(double d){
		System.out.println("실수값 입력 : " + d);
	}
	House(char c){
		System.out.println("char값 입력 : " + c);
	}
}

class ParamObj {
	ParamObj(String name){
		System.out.println("문자열 입력 : " + name);
	}
	ParamObj(int age){
		System.out.println("숫자 입력 : " + age);
	}
	ParamObj(boolean b){
		System.out.println("boolean값 입력 : " + b);
	}
	ParamObj(char c){
		System.out.println("char값 입력 : " + c);
	}
}