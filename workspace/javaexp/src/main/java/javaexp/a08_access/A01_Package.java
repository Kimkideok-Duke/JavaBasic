package javaexp.a08_access;

import javaexp.a07_multiObj.A06_Food;
import javaexp.a07_multiObj.A07_Bus;

public class A01_Package {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/**
		# 패키지란?
		1. 클래스를 기능별로 묶어서 그룹 이름을 붙여 놓은 것을 말한다.
			1) 파일들을 관리하기 위해 사용하는 폴더(디렉토리)와 비슷한 개념이다.
			2) 패키지의 물리적인 형태는 파일 시스템의 폴더이다.
		2. 클래스 이름의 일부
			1) 클래스를 유일하게 만들어 주는 식별자
			2) 전체클래스 이름 = 상위패키지.하위패키지.클래스
				ex) 현재 클래스명 : javaexp.a08_access.A01_Package
			3) 클래스명이 같아도 패키지명이 다르면 다른클래스로 취급한다.
				ex) 같은 클래스명이지만 다른 클래스로 취급
					javaexp.a07_multiObj.A01_package
		3. 클래스 선언할 때, 패키지 결정
			1) 클래스 선언할 때 포함될 패키지 선언
				package 패키지명
				class 클래스명
				ex)
					package javaexp.a08_access;
					public class A01_Package {
			2) 클래스 파일(.class) 선언된 패키지와 동일한 폴더 안에서 동작
			3) 클래스 파일(.class) 다른 폴더안에 넣으면 동작하지 않음.
		 */
		System.out.println(new A01_Package());
		// javaexp.a08_access.A01_Package@251a69d7
		// 패키지명.클래스명@주소값
		// 동일한 클래스의 다른 패키지의 클래스를 객체로 사용할 때는 패키지명을 지정하여 호출한다.
		javaexp.a07_multiObj.A01_Package pk = new javaexp.a07_multiObj.A01_Package();
		System.out.println("다른 패키지 클래스의 객체 : " + pk);
		javaexp.a07_multiObj.A05_Person ps = new javaexp.a07_multiObj.A05_Person();
		System.out.println(ps.name);
		/**
		# 클래스명이 한 곳에서 동일할 것이 호출되지 않을 때는 패키지명을 생략가능한다.
		1. import 패키지명.클래스명으로 상단에 선언하고
		2. public 접근제어자 범위안에 있으면 객체를 사용할 수 있다.
		 */
		// import하면은 패키지명 없이도 사용이 가능하다.
		// import javaexp.a07_multiobj.A06_Food;
		A06_Food f01 = new A06_Food();
		System.out.println(f01.name);

		// ex)
		A07_Bus b01 = new A07_Bus();
		System.out.println(b01.num);
	}

}
