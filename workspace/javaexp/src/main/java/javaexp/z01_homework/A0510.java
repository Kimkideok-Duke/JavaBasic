package javaexp.z01_homework;

import javaexp.z01_homework.playroom.Friend1;
import javaexp.z01_homework.playroom.Friend2;
import javaexp.z01_homework.studyroom.Student1;
import javaexp.z01_homework.studyroom.Student2;

public class A0510 {
	
	public static void main(String[] args) {
		// 2022-05-10(과제)
		// [1단계:개념] 1. static 변수와 일반 변수의 차이점을 기본 예제를 통해 설명하세요.
			// Static 변수는 클래스 변수이다.
			// 객체를 생성하지 않고도 Static 자원에 접근이 가능하다.
			System.out.println(Homework0510.month);
			Homework0510 hw01 = new Homework0510();
			System.out.println(hw01.day);

		// [1단계:확인] 2. 가수의 정보(이름, 소속사, 현재타이틀곡)을 static과 일반변수를 적절하게 설정하고 메서드를 통해 출력하세요.
			Singer1 s1 = new Singer1("에스파", "넥스트 레벨");
			Singer1 s2 = new Singer1("레드벨벳", "덤덤");
			s1.showInfo();
			s2.showInfo();

		// [1단계:개념] 3. static final 상수와 static 변수의 차이점을 기술하세요.
			// static final : 객체마다 가지고 있지 않고 클래스 단위로 설정
			// 				  메소드 영역에 클래스 별로 관리되는 불변의 정적 필드
			// 				  공용 데이터로 사용

		// [1단계:개념] 4. package란 무엇이고 클래스와의 관계를 설명하세요.
			// 패키지란 클래스를 기능별로 묶어서 그룹 이름을 붙여 놓은 것을 말한다.
			// 클래스를 유일하게 만들어 주는 식별자
			// 전체클래스 이름 = 상위패키지.하위패키지.클래스
			// 클래스명이 같아도 패키지명이 다르면 다른클래스로 취급한다.

		// [1단계:개념] 5. 접근제어자의 범위를 기술하세요.
			// 1) private : 같은 클래스 내에서만 접근 가능
			// 2) default : 같은 패키지 내에서만 접근 가능
			// 3) protected : 같은 패키지 내에서, 그리고 다른 패키지의 자식 클래스에서 접근 가능
			// 4) public : 접근 제한이 전혀 없다.

		// [1단계:확인] 6. playroom패키지 선언과 내부적으로 친구1, 친구2 클래스 선언, studyroom패키지선언 학생1, 학생2 클래스
		// 			선언호, 친구1, 학생1에서 private, X(default), public에 적절한 필드값을 선언하고, 상호간에 호출하세요.
			Friend1 f1 = new Friend1();
			Friend2 f2 = new Friend2();
			f1.callStudentInfo();
			f2.callFriendinfo();
			Student1 st1 = new Student1();
			Student2 st2 = new Student2();
			st1.callFriendinfo();
			st2.callStudentInfo();

		// [1단계:확인] 8. 클래스의 1:1 내용을 현실에서 3개 이상 선언하고 할당하여 출력하는 내용을 처리하세요
			Keyboard kb1 = new Keyboard("cmk87");
			kb1.getSwitch();
			kb1.choiceSwitch(new Switch("체리적축", 45));
			kb1.getSwitch();
			Keyboard kb2 = new Keyboard("nj80");
			kb2.choiceSwitch(new Switch("홀리판다", 35));
			kb2.getSwitch();
			Keyboard kb3 = new Keyboard("qk65");
			kb3.choiceSwitch(new Switch("아쿠아킹", 60));
			kb3.getSwitch();
	}

}
class Homework0510{
	static int month = 100;
	int day = 10;
}
class Singer1{
	static String comp = "SM";
	String name, title;
	Singer1(String name, String title) {
		this.name = name;
		this.title = title;
	}
	void showInfo() {
		System.out.println(comp + "\t" + name + "\t" + title);
	}
}

class Switch{
	private String name;
	private int gram;
	public Switch(String name, int gram) {
		super();
		this.name = name;
		this.gram = gram;
	}
	public void showInfo() {
		System.out.println(name + " " + gram + "g");
		System.out.println();
	}
}
class Keyboard{
	private String name;
	private Switch sw;
	public Keyboard(String name) {
		super();
		this.name = name;
	}
	public void choiceSwitch(Switch sw) {
		this.sw = sw;
	}
	public void getSwitch() {
		System.out.println(name + "의 축");
		if(sw == null) {
			System.out.println("축이 없다");
			System.out.println();
		}else {
			sw.showInfo();
		}
	}
}