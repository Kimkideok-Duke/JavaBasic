package javaexp.z01_homework;

public class A0503 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// 2022-05-03
		// [1단계:개념] 1. 클래스와 객체의 관계를 메모리를 활용하여 설명하고, 주소값을 출력하세요..
					// new 클래스 명()으로 선언하는 순간 heap영역에 객체가 메모리를 잡아서 사용할 수 있게 된다.
					Homework01 hw01 = new Homework01();
					System.out.println("주소값 : " + hw01);

		// [1단계:개념] 2. 클래스를 통해 만들어진 객체와 일반 primitive 데이터와 어떠한 차이점이 있는지 기술하세요.
					// 클래스를 통해 만들어진 데이터는 heap메모리에 저장되지만 일반 데이터는 stack메모리에 저장된다.

		// [1단계:개념] 3. 클래스의 구성요소 3가지를 예제를 통해서 특징을 기술하세요.
					// 1. 필드(field)
					// 		주로 데이터를 저장하는 역할을 한다.
					// 		객체가 만들어졌을 때, 그 객체가 사용할 속성에 적절한 데이터를 할당할 때 사용된다.
					// 		ex) 자동차의 배기량, 최고속도, 생산회사 등등
					// 2. 생성자(Constructor)
					// 		객체 생성시, 초기화 역할을 담당한다.
					// 		객체를 처음 만들었을 때, 이 객체가 가지고 있어야 할 기본 데이터를 저장할 떄 활용된다.
					// 		매개변수를 통해서 전달받는 경우도 있다.
					// 		ex) 마트에서 계산하는 계산기의 경우, 이 마트가 다루는 상품 정보, 가격 정보, 연산 규칙등은 계산기가 초기에 가지고 있어야할 정보다.
					// 			이를 초기에 설정할 때, 생성자를 통해서 선언하고, 객체 생성시 초기화 된다.
					// 3. 메소드(Method)
					// 		객체가 동작에 해당하는 실행블록을 말한다. 입력을 통해 필드에 데이터를 저장하거나, 저장된 데이터를 불러와서 연산을 하여 원하는 정보를 수집하는 등의 작업을 한다.
					// 		주로 조건, 반복문을 통해서 원하는 정보로 만들어서 return한다.

		// [1단계:개념] 4. 매개변수의 통하여 생성자나 메서드에 데이터를 할당 처리할 수 있다. 그 기준이 되는 유형, 갯수 선언 규칙(오버로딩)을 예제를 통하여 설명하세요.
						// 생성자나 매개변수는 
						// 1) 매개변수의 타입의 유형이 다를 때,
						// 2) 매개변수의 갯수가 다를 때,
						// 3) 매개변수의 갯수가 동일하더라도 타입의 순서가 다를 때
						// 	다른 생성자나 메서드로 인식하여 선언이 가능하다.
						Homework02 hw02 = new Homework02(10);
						Homework02 hw03 = new Homework02(20, 30);
						Homework02 hw04 = new Homework02("HW", 'T');

		// [1단계:확인] 5. Car 객체의 생성자를 매개변수를 제조사, 최고속도, 배기량을 기준으로 1~3개까지 선언하고 해당 데이터를 출력하세요.
						Car c1 = new Car("벤츠", 320, 5000);

		// [1단계:확인] 6. 아래와 같이 여러가지 생성자를 초기화하고 출력하세요.
		// 	1) Singer 클래스를 선언하고 매개변수로 이름, 소속사, 메인곡을 선언하고, 생성자를 통해서 초기화 하고 출력하세요.
			Singer singer1 = new Singer("아이유", "카카오", "좋은날");
			System.out.println("이름 : " + singer1.name);
			System.out.println("소속사 : " + singer1.ent_name);
			System.out.println("메인곡 : " + singer1.Title);
			Singer singer2 = new Singer("에스파", "SM", "Next Level");
			System.out.println("이름 : " + singer2.name);
			System.out.println("소속사 : " + singer2.ent_name);
			System.out.println("메인곡 : " + singer2.Title);
			Singer singer3 = new Singer("트와이스", "JYP", "TT");
			System.out.println("이름 : " + singer3.name);
			System.out.println("소속사 : " + singer3.ent_name);
			System.out.println("메인곡 : " + singer3.Title);
		// 	2) Game 클래스를 선언하고 출시회사, 비용, 인기순
			Game game1 = new Game("락스타", 78000, "GOTY");
			System.out.println("출시회사 : "  + game1.company);
			System.out.println("비용 : " + game1.payment);
			System.out.println("인기순 : " + game1.pop);
			Game game2 = new Game("넥슨", 0, "중상");
			System.out.println("출시회사 : "  + game2.company);
			System.out.println("비용 : " + game2.payment);
			System.out.println("인기순 : " + game2.pop);
			Game game3 = new Game("닌텐도", 65000, "최하");
			System.out.println("출시회사 : "  + game3.company);
			System.out.println("비용 : " + game3.payment);
			System.out.println("인기순 : " + game3.pop);
	}

}
class Homework01 {

}
class Homework02 {
	Homework02(int i) {
		System.out.println("i = " + i);
	}
	Homework02(int i, int j) {
		System.out.println("i = " + i);
		System.out.println("j = " + j);
	}
	Homework02(String str, char c) {
		System.out.println("str = " + str);
		System.out.println("c = " + c);
	}
}
class Car {
	Car(String Maker, int Max_spd, int cc) {
		System.out.println("제조사 : " + Maker);
		System.out.println("최고 속도 : " + Max_spd);
		System.out.println("배기량 : " + cc);
	}
}
class Singer {
	String name;
	String ent_name;
	String Title;
	Singer(String name, String ent_name, String Title) {
		this.name = name;
		this.ent_name = ent_name;
		this.Title = Title;
	}
}
class Game {
	String company;
	int payment;
	String pop;
	Game(String company, int payment, String pop) {
		this.company = company;
		this.payment = payment;
		this.pop = pop;
	}
}