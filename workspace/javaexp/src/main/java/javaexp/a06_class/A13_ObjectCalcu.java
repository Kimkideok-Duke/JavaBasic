package javaexp.a06_class;

public class A13_ObjectCalcu {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/**
		# 메서드를 통해서 기능처리하는 반복문 예제
		1. 기능 메서드를 통해 반복 처리하는 로직 처리
		 */
		Counter c1 = new Counter();
		c1.setData(1, 10);
		int sum = c1.showCount();
		System.out.println("총합 : " + sum);
		c1.setData(1, 100);
		System.out.println("총합 : " + c1.showCount());
		CalcuPay cp = new CalcuPay();
		cp.inputData(5, 125);
		cp.searchLoop();
	}

}
class Counter{
	int from;
	int to;
	void setData(int from, int to) {
		this.from = from;
		this.to = to;
	}
	int showCount() {
		System.out.println(" # " + from + "에서부터" + to + "까지 #");
		int tot = 0;
		for(int cnt = from; cnt<=to; cnt++) {
			System.out.println(cnt + ", ");
			tot += cnt;
		}
		System.out.println();
		return tot;
	}
}
class CalcuPay{
	int max_cnt;
	int price;
	void inputData(int max_cnt, int price) {
		this.max_cnt = max_cnt;
		this.price = price;
	}
	void searchLoop() {
		for(int i = 1; i <= max_cnt; i++) {
			System.out.println("단가 : " + price + "\t" + i + "개\t" + price*i);
		}
	}
}