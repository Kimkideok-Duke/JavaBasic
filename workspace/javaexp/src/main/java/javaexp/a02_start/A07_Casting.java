package javaexp.a02_start;

public class A07_Casting {
	
	public static void main(String[] args) {
		
		/*
		 # 데이터의 형변환
		 1. 데이터 타입을 다른 타입으로 변환하는 것을 말한다.
		 	byte ==> int, int ==> double
		 2. 종류
		 	자동(묵시적)타입변환
		 	강제(명시적)타입변환
		 3. 자동(묵시적)타입 변환
		 	작은데이터유형에서 큰 데이터 유형으로 변환할 때는 추가 코드없이 자동으로 할당이 된다. 
		 */
		
		byte num01 = 25;
		int num02 = 25+num01;
		int num03 = 30;
		double num04 = num03;
		System.out.println(" # 묵시적 형변환 결과 #");
		System.out.println(num01);
		System.out.println(num02);
		System.out.println(num03);
		System.out.println(num04);
		
		/*
		 4. 명시적 형변환
		 	1) ()을 활용하여 특정한 데이터유형으로 변경이 명시적으로 필요할 때, 사용한다.
		 	2)유형
		 		큰데이터형 ==> 작은데이터형
		 			int num01 = (int)25.27;
		 		작은데이터형 ==> 큰데이터형
		 		 	int num02 = 10;
		 		 	int num03 = 3;
		 		 	double result = num02/(double)num03;
					cf)자바에서는 정수와 정수형의 나눗셈은 정수형으로만 나온다. 실수형까지 처리하려면 피연산자중 하나는 실수형이여야 한다. 
		 */
		double dblNum = 25.27;
		int num05 = (int)dblNum;
		System.out.println("casting한 결과 : " + num05);
		int num06 = 10;
		int num07 = 3;
		// 정수형/정수형 ==> 정수형 : 소숫점 이하의 값이 나오지 않는다.
		// 정수형/실수형 ==> 실수형 : 소숫점 이하의 값이 처리가 된다.
		double result = num06/num07;
		System.out.println("연산결과값 : "+result);
		double result2 = num06/(double)num07;
		System.out.println("연산결과값 : "+result2);
		
		/*
		 ex1) byte형으로 구매한사과의 갯수와 바나나의 갯수를 합산하여 특정한 데이터 유형에 할당하세요!
		 ex2) 소고기 600g을 7등분을 하되 소숫점 이하의 결과까지 출력 처리하세요.
		 */
		// 1)
		byte apple_num=1, banana_num=2;
		int ab_num = (int)apple_num + (int)banana_num;
		System.out.println(ab_num);
		
		// 2)
		int beef = 600;
		System.out.println("600그램의 소고기를 7등분하면 " + ((double)beef/7));
	}

}
