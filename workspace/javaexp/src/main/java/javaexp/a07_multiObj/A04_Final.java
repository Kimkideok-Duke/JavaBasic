package javaexp.a07_multiObj;

public class A04_Final {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/**
		# final 필드
		1. 최종적인 값을 갖고 있는 필드 = 값을 변경할 수 없는 필드
		2. final 필드는 딱 한번의 초기값 지정 방법이다.
			1) 필드 선언시 처리할 수 있고
			2) 생성자로 초기값을 지정할 수 있다.
		3. 객체 단위로 초기값을 설정하고 변경되지 못하게 할 때, 주로 사용된다.
			단, 클래스 안에서 초기값을 설정하면 객체단위로도 변경이 불가능하다.
		 */
		Person p01 = new Person("951212-1802715", "홍길동");
		System.out.println(p01.nation);
		System.out.println(p01.ssn);
		System.out.println(p01.name);
// 		p01.nation = "일본"; final 키워드이기때문에 변경이 불가능 클래스 선언과 동시에 했기에 
// 			다른 객체로 객체 생성을 하더라도 변경이 불가능
// 		p01.ssn = "951212-1802715"; 에러 발생.. final 객체단위로 한번 설정이 되면 변경이 불가능하다.
		Person p02 = new Person("971212-1802715", "오길동");
		System.out.println(p02.nation); // 클래스 안에서 선언했기에 변경이 불가능
		System.out.println(p02.ssn); // 다른 객체를 통해서는 변경이 가능, 하지만 변경은 불가능
		System.out.println(p02.name); // 변경가능
		// ex)
		Player_B pl01 = new Player_B("LG", "김현수", 90);
		Player_B pl02 = new Player_B("NC", "양의지", 85);
		Player_B pl03 = new Player_B("SSG", "최주환", 60);
		pl01.showInfo();
		pl02.showInfo();
		pl03.showInfo();
		/**
		# 상수(static final)
		1. 상수 = static final 필드
			final 필드 : 객체마다 가지는 불변의 인스턴스 필드
			static final : 객체마다 가지고 있지 않고 클래스 단위로 설정
				메소드 영역에 클래스 별로 관리되는 불변의 정적 필드
				공용 데이터로 사용
		2. 상수 이름을 전부 대문자로 작성을 일반적으로 한다.(네이밍 규칙)
			ex) static final double PI = 3.14;
		3. 다른 단어가 결합되면 _로 연결
			ex) static final String CUR_NATION = "한국";
		 */
		System.out.println(Player_B.KIND);
	}

}
class Person{
	// 초기값 설정 클래스 내에서 바로 선언
	final String nation = "한국";
	final String ssn; // 생성자에 의해 초기값 설정
	String name;
	Person(String ssn, String name){
		this.ssn = ssn;
		this.name = name;
	}
}
class Player_B{
	static final String KIND = "야구선수";
	String t_name;
	int score;
	final String name;
	Player_B(String t_name, String name, int score) {
		this.t_name = t_name;
		this.score = score;
		this.name = name;
	}
	void showInfo() {
		System.out.println(t_name + "\t" + name + "\t" + score);
	}
}