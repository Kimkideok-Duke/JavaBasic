package javaexp.a05_reference;

public class A03_String {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/**
		# String 타입과 메모리 할당.
		1. 문자열을 바로 할당하면 같은 문자열인 경우에는 같은 heap영역의 메모리를 사용하여 ==(비교연산자)를 활용하면 동일하게 처리된다.
		cf) 대부분 외부에서 입력받거나 전달 받는 데이터는 이렇게 처리되지 않는다.
		 */
		String name01 = "홍길동";
		String name02 = "홍길동"; // 같은 heap메모리를 바라본다.
		System.out.println(name01 == name02);
		/**
		2. 문자열의 일반적인 데이터 생성 형태는 내부적으로 new String()으로 사용된다.
		 */
		String name03 = new String("홍길동");
		String name04 = new String("홍길동");
		System.out.println("주소값비교2 : " + (name03==name04));
		System.out.println("데이터 자체 내용을 비교하는 메서드 equals을 활용하여야 한다.");
		System.out.println("문자열 비교 : " + (name03.equals(name04)));

		System.out.println(("name01과 name03의 주소값 비교 : " + (name01==name03)));
		/**
		# 정리
		1. 문자열의
		 */
	}

}
