package javaexp.a07_multiObj;

public class A08_OneVsOne {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/**
		# 1:1 관계 클래스 선언과 활용
		1. 1:1 관계에 있는 경우는 현실에서도 많이 있을 뿐만 아니라 실제 프로그래밍에서 많이 발생한다.
			ex) 사람이 가지고 있는 핸드폰, 연필 지우개, 학생과 성적표, 학생과 전공 지도교수
		2. 선언 방식
			1) 종속된 클래스를 선언(필드 메서드)
			2) 포함하는 클래스를 선언
		 */
		HPerson p01 = new HPerson("홍길동");
		p01.usingPhone();

		p01.buyPhone(new HandPhone("01088881111", "apple", 100000));
		p01.usingPhone();

		// ex)
		PlayMan pm = new PlayMan("홍길동");
		pm.playMyHobby();
		pm.choiceHobby(new Hobby("산책", 1000, 2));
		pm.playMyHobby();
	}

}
class HPerson{
	private String name;
	private HandPhone phone;
	// 생성자를 통해서 이름을 할당.
	public HPerson(String name) {
		super();
		this.name = name;
	}
	public void buyPhone(HandPhone phone) {
		this.phone = phone;
	}
	public void usingPhone() {
		System.out.println(name+"님 핸드폰을 사용합니다.");
		if(phone == null) {
			// phone 객체가 메모리로 들어오지 않는 상황
			System.out.println("핸드폰을 소유하지 않았습니다.");
		}else { // HandPhone이 할당된 경우
			phone.showInfo();
		}
	}
}
class HandPhone{
	private String number;
	private String comp;
	private int price;
	public HandPhone(String number, String comp, int price) {
		super();
		this.number = number;
		this.comp = comp;
		this.price = price;
	}
	void showInfo() {
		System.out.println("# 핸드폰의 정보 #");
		System.out.println("번호 : " + number);
		System.out.println("제조사 : " + comp);
		System.out.println("구매가격 : " + price);
	}
}

class Hobby{
	private String name;
	private int pay;
	private int time;
	public Hobby(String name, int pay, int time) {
		super();
		this.name = name;
		this.pay = pay;
		this.time = time;
	}
	public void play() {
		System.out.println("# 취미생활을 하다 #");
		System.out.println("취미생활명 : " + name);
		System.out.println("비용 : " + pay);
		System.out.println("시간 : " + time);
	}
}
class PlayMan{
	private String name;
	private Hobby hb;
	public PlayMan(String name) {
		super();
		this.name = name;
	}
	public void choiceHobby(Hobby hb) {
		this.hb = hb;
	}
	public void playMyHobby() {
		System.out.println(name+"의 취미생활");
		if(hb==null) {
			System.out.println("아직 취미 생활이 없다");
		}else {
			hb.play();
		}
	}
}