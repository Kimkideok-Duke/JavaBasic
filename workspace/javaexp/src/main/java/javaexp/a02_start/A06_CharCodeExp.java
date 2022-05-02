package javaexp.a02_start;

public class A06_CharCodeExp {
	
	public static void main(String[] args) {
		// 1)
		char a = 'a', A = 'A', z = 'z', Z = 'Z';
		System.out.println("a = " + (int)a);
		System.out.println("A = " + (int)A);
		System.out.println("z = " + (int)z);
		System.out.println("Z = " + (int)Z);
		
		// 2)
		int num1 = 69, num2 = 80;
		System.out.println("69 = " + (char)num1);
		System.out.println("80 = " + (char)num2);
		
		//////////////////////////////////////////
		
		// 1)
		//byte num300 = 300;
		short num300 = 300;
		System.out.println("print 300 -> " + num300);
		// 연산이 들어가는 순간 데이터 유형은 int형 이상이 필요로 한다.
		byte num08 = 25;
		byte num09 = 7;
		// byte num10 = num08+num09; 에러 발생
		// System.out.println(num10);
		
		
		// 2)
		int num1_5b = 1500000000;
		int num2b = 2000000000;
		//int num3_5b = num1_5b+num2b;
		long num3_5b = (long)num1_5b+(long)num2b;
		System.out.println("print 3.5b -> " + num3_5b);

		/**
		 * Math.random() 함께 임시비밀번호 발급
		 */
		for(int code = 65;code<=90;code++) {
			System.out.println(code + ":" + (char)code);
		}
		System.out.println("# 임의의 비밀번호(알파벳 대문자) #");
		for(int cnt = 1; cnt<=8; cnt++) {
			int ranCode = (int)(Math.random()*26+65);
			System.out.println(ranCode + ":" + (char)ranCode);
		}
	}

}
