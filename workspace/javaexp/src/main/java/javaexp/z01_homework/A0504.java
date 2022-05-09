package javaexp.z01_homework;

public class A0504 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 2022-05-04
		// [1단계:개념] 1. 메서드의 기능을 기본 예제를 통해서 설명하세요
						Homework0504 hw01 = new Homework0504();
						hw01.Date(4);
						// 객체의 동작을 처리한다.
						// 메서드를 호출하면 중괄호에 있는 모든 코드들이 일괄 실행한다.

		// [1단계:확인] 2. [리턴유형연습] 쇼핑몰에서 구매한 물건, 가격, 갯수, 배송지를 리턴값으로 선언하는 메서드와, 
		// 	리턴값이 없이 위 정보를 출력하는 메서드를 선언하세요
						hw01.setProduct("연필");
						hw01.setPrice(1200);
						hw01.setCnt(12);
						hw01.setAddr("서울");
						hw01.getProduct();

		// [1단계:확인] 3. [매개변수연습] driving메서드에 매개변수로 1~3개를 각각 선언하되,
		// 	차량명, 목적지, 거리를 선언하여 출력하되 오버로딩 규칙에 따라 처리하세요.
						hw01.Driving("Gv60");
						hw01.Driving("부산", 300);
						hw01.Driving("Gv60", "부산", 300);

		// [1단계:확인] 4. [매개변수+리턴] Student 클래스
		// 	tot() 매개변수:국어,영어,수학점수 리턴값:총점수(정수)
		// 	avg() 매개변수:국어,영어,수학점수 리턴값:평균값(실수)
		// 	reg() 매개변수:번호,이름  리턴값:@@번 @@@(문자열)
		// 	show() 매개변수:이름,국어,영어,수학  리턴값:없음, 출력:매개변수값
			Student st = new Student();
			System.out.println("총점수 : " + st.tot(70, 40, 99));
			System.out.println("평균값 : " + st.avg(70, 40, 99));
			System.out.println(st.reg(18, "김기덕"));
			st.show("김기덕", 92, 76, 65);;
		
		// [1단계:확인] 5. [매개변수+리턴] Member 클래스 선언하고, regdate()메서드로
		// 	회원명, 아이디, 패스워드 매개변수로 입력과 String으로 등록 내용을 리턴
		// 	usePoint()메서드로 사용한 포인트를 입력받아 10%적립포인트 리턴(실수)
		// 	addPoint()메서드로 추가할포인트를 입력받아 지역변수로 있는 point=1000
		// 	에 추가하여 리턴처리하세요.
			Member mb = new Member();
			System.out.println(mb.regdate("김기덕", "kkd", "deok"));
			System.out.println("적립포인트(사용포인트 : 11) : " + mb.usePoint(11));
			System.out.println("포인트 추가(기존 포인트 : 5000) : " + mb.addPoint(5000));

		// [1단계:확인] 6. [매개변수+필드] Caffee 클래스 선언, 
		// 	필드 : 주문커피종류, 주문 가격, 주문 갯수
		// 	메서드 : orderName - 주문커피종류 저장
		// 			orderCoffee - 주문커피종류, 가격, 갯수 저장
		// 			getPay - 총비용(가격*갯수) 리턴
		// 			getName() - 주문커피종류 리턴
		// 			showAll() - 저장된 주문커피종류,가격,갯수,총액 문자열리턴
			Coffee cf = new Coffee();
			cf.orderName("카푸치노");
			System.out.println(cf.getName());
			cf.orderCoffee("아메리카노", 3400, 3);
			System.out.println("총비용 : " + cf.getPay());
			System.out.println(cf.showAll());
			

		// [1단계:확인] 7. [필드+로직처리] Gugu 클래스 선언
		// 		필드 : 단수, 시작단수, 마지막단수
		// 	메서드 : schGrade - 단수지정
		// 			showResult - 해당 단수의 1~9까지 연산 출력
		// 					setFromTo - 시작단수,마지막단수 지정
		// 			showResult2 - 범위가 있는 단수 출력
			Gugu ggd = new Gugu();
			ggd.schGrade(3);
			ggd.showResult();
			ggd.setFromTo(6, 9);
			ggd.showResult2();

		// [1단계:확인] 8. [필드+로직처리] Bus 클래스 선언
		// 	필드 : 버스번호, 구간, 비용
		// 	메서드 : basicInfo - 입력 버스번호, 구간, 비용
		// 			takeBus - 입력 : 인원수 리턴:비용*인원수
		// 				화면 출력 : 구간 @@ 인  @@번 @@명 탑승
			Bus bus = new Bus();
			bus.basicInfo(223, "판교~강남", 1150);
			bus.takeBus(20);
			System.out.println("구간 " + bus.sector + "인 " + bus.bus_num + "번 " + bus.num_pp + "명 탑승");
	}

}
class Homework0504{
	// 1)
	void Date(int date) {
		System.out.println("오늘은 " + date + "일");
	}

	// 2)
	String pd_name;
	int pd_price;
	int pd_cnt;
	String addr;
	String setProduct(String pd_name) {
		this.pd_name = pd_name;
		return pd_name;
	}
	int setPrice(int pd_price) {
		this.pd_price = pd_price;
		return pd_price;
	}
	int setCnt(int pd_cnt) {
		this.pd_cnt = pd_cnt;
		return pd_cnt;
	}
	String setAddr(String addr) {
		this.addr = addr;
		return addr;
	}
	void getProduct() {
		System.out.println("물건 : " + pd_name);
		System.out.println("가격 : " + pd_price);
		System.out.println("갯수 : " + pd_cnt);
		System.out.println("배송 주소 : " + addr);
	}

	// 3)
	void Driving(String car_name) {
		System.out.println("차량명 : " + car_name);
	}
	void Driving(String dest, int dist) {
		System.out.println("목적지 : " + dest + ", 거리 : " + dist);
	}
	void Driving(String car_name, String dest, int dist) {
		System.out.println("차량명 : " + car_name + ", 목적지 : " + dest + ", 거리 : " + dist);
	}
}

class Student{
	int tot(int kor, int eng, int math) {
		System.out.println("국어 : " + kor + ", 영어 : " + eng + ", 수학 : " + math);
		return kor + eng + math;
	}
	double avg(int kor, int eng, int math) {
		System.out.println("국어 : " + kor + ", 영어 : " + eng + ", 수학 : " + math);
		return (double)(kor + eng + math)/3;
	}
	String reg(int num, String name) {
		return num + "번 " + name;
	}
	void show(String name, int kor, int eng, int math) {
		System.out.println("이름 : " + name + ", 국어 : " + kor + ", 영어 : " + eng + ", 수학 : " + math);
	}
}
class Member{
	String name;
	String id;
	String passwd;
	int point = 1000;
	String regdate(String name, String id, String passwd) {
		this.name = name;
		this.id = id;
		this.passwd = passwd;
		return "이름 : " + name + ", 아이디 : " + id + ", 패스워드 : " + passwd;
	}
	double usePoint(int usepoint) {
		return usepoint*0.1;
	}
	int addPoint(int point) {
		return point + this.point;
	}
}
class Coffee{
	String kind;
	int order_price, order_cnt;
	void orderName(String kind) {
		this.kind = kind;
	}
	void orderCoffee(String kind, int order_price, int order_cnt) {
		this.kind = kind;
		this.order_price = order_price;
		this.order_cnt = order_cnt;
	}
	int getPay() {
		return order_price*order_cnt;
	}
	String getName() {
		return kind;
	}
	String showAll() {
		return "주문커피종류 : " + kind + ", 가격 : " + order_price + ", 갯수 : " + order_cnt + ", 총액 : " + order_price*order_cnt;
	}
}
class Gugu{
	int times, start_times, end_times;
	void schGrade(int times) {
		this.times = times;
	}
	void showResult() {
		for(int i = 1; i <= 9; i++) {
			System.out.println(times + "X" + i + "=" + times*i);
		}
	}
	void setFromTo(int start_times, int end_times) {
		this.start_times = start_times;
		this.end_times = end_times;
	}
	void showResult2() {
		for(int i = start_times; i <= end_times; i++) {
			for(int j = 1; j <= 9; j++) {
				System.out.println(i + "X" + j + "=" + i*j);
			}
		}
	}
}
class Bus {
	int bus_num, fee, num_pp;
	String sector;
	void basicInfo(int bus_num, String sector, int fee) {
		this.bus_num = bus_num;
		this.sector = sector;
		this.fee = fee;
	}
	int takeBus(int num_pp) {
		this.num_pp = num_pp;
		return fee*num_pp;
	}
}