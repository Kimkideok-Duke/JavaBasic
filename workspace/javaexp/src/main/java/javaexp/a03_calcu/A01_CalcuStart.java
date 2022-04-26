package javaexp.a03_calcu;

public class A01_CalcuStart {

	public static void main(String[] args) {
		
		/*
		 # 
		 1. 연산이란?
		 	데이터를 처리하여 결과를 산출하는 것을 말한다.
		 2. 연산자(operations)
		 	연산에 사용되는 표시나 기호를 말한다.
		 	+,-,*,/,%,=, ...
		 3. 피연산자(operand)
		 	연산 대상이 되는 데이터(리터럴, 변수)
		 	num01, 25, num02
		 4. 연산식 
		 	연산자와 피연산자를 이용하여 연사의 과정을 기술하는 것
		 	num01 + num02
		 	sum = num01*num02
		 	연산자 : =,*
		 	피연산자 : sum, num01, num02
		 	연산식 : 연산자와 피연산자를 혼합하여 식을 만들어 가는 것
		 */
		int num01 = 25; // 연산자 =, 피연산자 num01에 리터럴 데이터 25로 할당
		int num02 = 5;
		System.out.println(num01 + "+" + num02 +  "=" + (num01+num02));
		System.out.println(num01 + "-" + num02 +  "=" + (num01-num02));
		System.out.println(num01 + "*" + num02 +  "=" + (num01*num02));
		System.out.println(num01 + "/" + num02 +  "=" + (num01/num02));
		System.out.println(num01 + "%" + num02 +  "=" + (num01%num02));
		/*
		ex) 사칙연산자 처리 연습예제
		1. 사과와 바나나의 가격을 설정하여 총 비용을 연산자, 피연산자를 통한 연산식을 만들어 결과를 출력하세요.
		*/
		int apple_price = 800, banana_price = 1500;
		int apple_num = 5, banana_num = 7;
		System.out.println("총비용 : " + ((apple_num * apple_price)+(banana_num*apple_price)));

		int bear = 3, bread = 20;
		int rem_bread = bread%bear;
		System.out.println("곰돌이가 먹은 빵의 갯수 : " + (bread/bear) + ", 남은 빵의 갯수 : " + rem_bread);
	}
}
