package javaexp.a02_start;

public class A02_VarInit {

	public static void main(String[] args) {
		int num01;
		
		num01 = 0;
		System.out.println("숫자 num01:"+num01);
		
		int num02;
//		System.out.println("숫자 num02:"+num02);
		num02 = 25;
		num01 = num02;
		System.out.println("숫자 num02:"+num02);
	}
}
