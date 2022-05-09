package javaexp.a06_class;

public class A10_ParamReturn {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/**
		# 메서드의 매개변수와 리턴값 처리 연습
		1. 객체의 기능메서드는 매개변수를 통해 입력되고, 리턴값을 통해서 데이터의 최종결과를 받을 수 있다.
		2. 두개의 구성요소에 대한 입/출력에 대한 종합 예제를 해보자.
		 */
		Calcu c1 = new Calcu();
		System.out.println(c1.plus(25,30));
		int tot = c1.plus(40, 30);
		System.out.println("변수할당 : " + tot);
		String op_str = c1.plus("+", 1, 2);
		System.out.println(op_str);
		// ex)
		Product06 pd05 = new Product06();
		int tot_p = pd05.buy(500, 12);
		System.out.println("총가격 : " + tot_p);
	}

}
class Product06{
	int buy(int price, int cnt) {
		System.out.println("가격 : " + price);
		System.out.println("갯수 : " + cnt);
		return price*cnt;
	}
}
class Calcu{
	int plus(int num01, int num02){
		System.out.println("입력값 num01 : " + num01);
		System.out.println("입력값 num02 : " + num02);
		return num01 + num02;
	}
	// ex)
	String plus(String op, int num01, int num02) {
		return num01 + op + num02;
	}
}