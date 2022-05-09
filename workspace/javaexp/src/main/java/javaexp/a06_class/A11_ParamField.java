package javaexp.a06_class;

public class A11_ParamField {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/**
		# 메서드 매개변수와 필드값의 처리
		1. 객체의 메서드의 매개변수를 통해서 필드값을 할당/수정/누적 연산 처리가 가능하다.
		2. 필드값이 변경되면 다른 메서드를 통해서 해당 필드값에 대한 여러가지 연산이나 기능 처리를 할 수 있다.
		 */
		ParamField pf = new ParamField();
		System.out.println("초기 num01 : " + pf.getNum01());
		pf.setNum01(25);
		System.out.println("기능메서드 처리 후 num01 : " + pf.getNum01());
		// ex
		pf.setNum02(55);
		System.out.println(pf.name("김현수"));
		Fruit fr = new Fruit();
		fr.set_fr("수박");
		fr.get_fr();
	}

}
class ParamField{
	int num01;
	int num02;
	void setNum01(int num01) {
		this.num01 = num01;
		System.out.println("매개변수를 통해 필드값 할당.");
	}
	int getNum01() {
		System.out.println("현재 필드 num01 리턴");
		return num01;
	}
	void setNum02(int num02) {
		this.num02 = num02;
		System.out.println("매개변수를 통해 필드값 할당.");
	}
	String name (String name) {
		return name;
	}
}
class Fruit {
	String fr_name;
	void set_fr(String fr_name) {
		this.fr_name = fr_name;
		System.out.println("입력된 과일 종류는 " + fr_name);
	}
	String get_fr() {
		System.out.println("출력된 과일 종류는 " + fr_name);
		return fr_name;
	}
}