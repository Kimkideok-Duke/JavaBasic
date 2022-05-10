package javaexp.a06_class;

public class A14_ObjectFunc {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AutoSeller au01 = new AutoSeller("음료", "콜라", 1200);
		AutoSeller au02 = new AutoSeller("제과", "칸쵸", 1100);
		AutoSeller au03 = new AutoSeller("일상용품", "물티슈", 3000);
		au01.display();
		au01.input(100);
		au01.input(100);
		au01.input(500);
		au01.input(1000);
		au01.input(1000);
		System.out.println("나온 물건 : " + au01.choiceProd(1));
		System.out.println("나온 물건 : " + au01.choiceProd(1));
		System.out.println("나온 물건 : " + au01.choiceProd(1));
		au02.display();
		au03.display();
	}

}
/**
 # class의 모든 구성요소를 이용해서 객체 활용하기 (자동판매기)
 */
class AutoSeller{
	String title;
	String prod;
	int price;
	int inputMoney;
	// 판매기의 종류, 판매물건과 가격
	AutoSeller(String title, String prod, int price) {
		this.title = title;
		this.prod = prod;
		this.price = price;
	}
	void display() {
		System.out.println(title + " 자동 판매기!!(물건을 선택하세요)");
		System.out.println("1." + prod + "(" + price + "원)");
	}
	void input(int inputMoney) {
		System.out.println(title + "자판기에 입금된 금액 : " + inputMoney + "원");
		this.inputMoney += inputMoney;
		displayRestMoney();
	}
	void displayRestMoney() {
		System.out.println(title + "자판기에 현재 금액 : " + this.inputMoney + "원");
	}
	String choiceProd(int num) {
		String ret = "";
		if(num == 1) {
			if(price<=inputMoney) {
				System.out.println("구매 제품이 나옵니다.");
				ret = prod;
				inputMoney -= price;
				displayRestMoney();
			}else {
				System.out.println("잔액이 부족합니다");
			}
		}
		return ret;
	}
	int backMoney() {
		System.out.println("# 잔액 리턴 처리 #");
		int reM = inputMoney; // 지역변수를 활용해서 잔액 0와 리턴 처리를 함
		// System.out.println("잔액" + inputMoney + "리턴");
		inputMoney = 0;
		displayRestMoney();
		return reM;
	}
}