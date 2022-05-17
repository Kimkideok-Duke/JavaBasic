package javaexp.z01_homework;

public class A0516 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 2022-05-16
		// [1단계:개념] 1. api 클래스의 주요기능과 java.lang.* 패키지의 특징을 기술하세요
		// # 자바 api 도큐먼트
		// 1. 자바에서 기본적으로 제공하는 라이브러리
		// 2. 프로그램 개발에 자주 사용되는 클래스 및 인터페이스 모음
		// 3. 쉽게 api찾아 이용할 수 있도록 문서화 한것
		// 4. html 페이지로 작성되어 있어 웹 브라우저로 바로 볼 수 있음.

		// # java.lang 패키지
		// 1. 자바 프로그램의 기본적인 클래스를 담은 패키지
		// 2. 포함된 클래스와 인터페이스는 import 없이 사용
		// 3. 주요 클래스
		// 1) Object : 자바클래스의 최상위 클래스로 사용
		// 2) System : 표준 입력/출력 장치 처리 필요
		// 3) Class : 클래스를 메모리로 로딩할 때, 사용
		// 4) String : 문자열을 저장하고 여러가지 정보를 얻을 때 사용
		// 5) StringBuffer, StringBuilder : 문자열을 저장 혹 내부 문자열을 조작할 때 사용
		// 6) Math : 수학 함수를 이용할 때 사용
		// 7) Wrapper(Byte, Short, Character, Integer, Float, Double, Boolean)
		// 기본 타입의 데이터를 갖는 객체를 만들 때 사용
		// 문자열을 기본타입으로 변환할 때 사용
		// 입력값 검사에 사용

		// [1단계:활용] 2. charAt() 활용 - 알파벳A~Z까지 있는 문자열 배열에서 임의의 문자 4개를 추출하여 출력하세요.
		String alp = "ABCDEFGHIZKLMNOPQRSTUVWXYZ";
		for(int i = 0; i<4; i++) {
			int rand = (int) (Math.random() * 25);
			System.out.println(alp.charAt(rand));	
		}
		
		// [1단계:활용] 3. 과일명 5개가 나열된 문자열에서 해당 특정 과일명의 index위치를 추출하여 출력하세요.
		String fruit = "사과 바나나 오렌지 수박 파인애플";
		System.out.println(fruit.indexOf("수박"));

		// [1단계:활용] 4. 좋아하는 운동선수 3명이 나열된 문자열에서 length()와 charAt() 반복문을 활용하여, 한글자씩을 탭간격으로
		// 출력하세요.
		String player = "김현수양의지최주환";
		for(int i = 0; i < player.length(); i++) {
			System.out.print(player.charAt(i)+"\t");
		}
		System.out.println();

		// [1단계:활용] 5. 회원명단을 ^로 구분하여 나열한 문자열을 선언하고, 이것을 배열로 처리한 후,
		// 특정회원이 있는지 여부를 확인하는 처리를 해보자.
		String member = "김길동!홍길동!신길동!고길동";
		String tname = "고길동";
		String mnames[] = member.split("!");
		int flag = 0;
        for(String n:mnames) {
            System.out.println(n);
			if(n.compareTo(tname) > 0) flag++;
        }
		if(flag>0) System.out.println(tname+"회원 있음");
		else System.out.println("회원없음");

		// [3단계:설치] 6. 오늘 진행한 DB설치 내용을 ppt로 작성하여 캡쳐한 내용을 과제와 함께 전달하세요.
	}

}
