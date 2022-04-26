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
		
		
		// 2)
		int num1_5b = 1500000000;
		int num2b = 2000000000;
		//int num3_5b = num1_5b+num2b;
		long num3_5b = (long)num1_5b+(long)num2b;
		System.out.println("print 3.5b -> " + num3_5b);
	}

}
