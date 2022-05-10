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