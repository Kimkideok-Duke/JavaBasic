package javaexp.a09_inherit;

public class A03_Overriding {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/**
		# 메소드 재정의(overriding)
		1. 부모 클래스의 상속 메소드 수정해 자식 클래스에서 재정의 하는 것
		2. 메소드 재정의 조건
			1) 부모 클래스의 메소드와 동일한 메소드명을 가져야 한다.
			2) 접근 제한을 더 강하게 오버라이딩하는 것을 불가하다.
				상위 default(X) ==> 하위 default(X), protected, public
				상위 protected ==> 하위 protected, public
				상위 public ==> 하위 public
		3. @Override 어노테이션
			컴파일러에게 부모 클래스의 메소드 선언부와 동일한지 검사 지시
			정확한 메소드 재정의 위해 붙여주면 ok
			ex) 해당 내용을 선언학, 오기나 잘못된 메서드표기시 오버라이딩 할 때까지 에러가 표기된다.
		4. 메서드 재정의 효과
			1) 부모 메서드는 숨겨지는 효과 발생
				- 재정의된 자식 메소드 실행
		 */
		Soldier s1 = new Soldier();
		s1.working();
		TaxiDriver td = new TaxiDriver();
		td.working();
		SamsungElec ss = new SamsungElec();
		ss.earnMoney();
		HyndaiHM hh = new HyndaiHM();
		hh.earnMoney();
	}

}
class Worker01{
	private String kind;
	public Worker01(String kind) {
		this.kind = kind;
	}
	public void working() {
		System.out.println(kind + " 일을 합니다!");
	}
}
class Soldier extends Worker01{
	public Soldier() {
		super("군인");
	}
	// 재정의 : 동일한 메서드를 정의
	public void working() {
		super.working();
		System.out.println("나라를 지킵니다!!");
	}
}
class TaxiDriver extends Worker01{
	public TaxiDriver() {
		super("택시 운전기사");
	}
	@Override
	public void working() {
		super.working();
		System.out.println("택시운전을 합니다!!");
	}
}
class Company {
	private String name;

	public Company(String name) {
		this.name = name;
	}
	public void earnMoney() {
		System.out.println(name + "가(이) 돈을 법니다.");
	}
}
class SamsungElec extends Company{
	public SamsungElec(String name) {
		super(name);
	}

	public SamsungElec() {
		this("삼성전자"); // this() 현재 선언된 생성자를 호출
	}
	// @Override 선언하면 재정의된 메서드인지 확인하여 컴파일시, check 해준다.
	@Override
	public void earnMoney() {
		super.earnMoney();
		// 재정의 하였기에 부모클래스가 선언한 메서드와 동일한 메서드를 가지고 있다.
		//  부모의 메서드 내용을 구분하여 호출할 때, super.를 활용한다.
		System.out.println("휴대폰을 판다.");
	}
}
class HyndaiHM extends Company{
	public HyndaiHM() {
		super("현대중공업");
	}
	@Override
	public void earnMoney() {
		super.earnMoney();
		System.out.println("선박을 판다.");
	}
}
