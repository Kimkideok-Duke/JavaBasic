package javaexp.z01_homework;

public class A0512 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// 2022-05-12
		// [1단계:개념] 1. protected의 접근 범위에 대하여 예제를 통하여 기술하세요
					// 같은 패키지에서는 default 와 같이 접근 제한이 없지만,
					// 다른 패키지에서는 자식 클래스만 접근을 허용한다.

		// [1단계:개념] 2. 다형성을 오버라이딩과 함께 기본 예제를 통하여 설명하세요.
					// 같은 타입이지만 실행 결과가 다양한 객체 대입(이용)가능한 성질을 말한다.
					Weapon1 w1 = new Gun();
					Weapon1 w2 = new Sword();
					w1.attack();
					w2.attack();
					System.out.println();

		// [1단계:확인] 3. 상위 컴퓨터 부품(ComPart), 하위 Ram, Hdd, Cpu롤 선언하여 fuction메서드를 통해 해당 기능을 출력하게 선언하고
		// 			다양한 기능이 처리되게 하세요..
					ComPart1 cp1 = new Cpu1();
					ComPart1 cp2 = new Ram1();
					ComPart1 cp3 = new Hdd1();
					cp1.function();
					cp2.function();
					cp3.function();
					System.out.println();

		// [1단계:개념] 4. 추상 클래스의 특징을 기술하세요. 
					// 추상메서드(abstract)가 하나라도 있으면, 추상클래스로(abstract class 클래스명)로 선언되어야 하며
					// 추상클래스가 가지고 있는 추상메서드는 상속받는 하위 클래스에서 반드시 재정의하여야 한다.
					// 추상클래스는 혼자 생성하지 못하고, 다형성에 의해서 생성할 수 있다.

		// [1단계:확인] 5. 추상/구상클래스 선언하되, 추상클래스 Robot : 필드로 로봇종류, 추상메서드 attack(), 공통메서드 move() 선언하여 처리되게 하세요.
					Robot1 r1 = new RcCar();
					Robot1 r2 = new Humanoid();
					r1.attack();
					r1.move();
					r2.attack();
					r2.move();
					System.out.println();

		// [1단계:개념] 6. 인터페이스의 역할을 기술하세요
					// - 개발코드가 객체에 종속되지 않게 --> 객체 교체할 수 있도록 하는 역할
					// - 개발 코드 변경없이 리턴값 또는 실행 내용이 다양해 질 수 있음(다형성)

		// [1단계:확인] 7. 인터페이스로 SoundWay 추상메서드 sound(), 하위상속클래스 NormalSound(꽥꽥꽥), EleSound(삑삑삑)로 처리하고, 
		// 			Duck클래스에 SoundWay를 필드로 선언 setSound(SoundWay sw)를 통해서 할당하고 duckSound()메서드를 통해서 출력처리하게 하세요.
					Duck d1 = new Duck();
					d1.duckSound();
					d1.setSound(new EleSound());
					d1.duckSound();
					d1.setSound(new NormalSound());
					d1.duckSound();
	}

}
class Weapon1{
	public void attack() {
		System.out.println("공격을 하다");
	}
}
class Gun extends Weapon1{
	@Override
	public void attack() {
		System.out.println("총을 쏘다");
	}
}
class Sword extends Weapon1{
	@Override
	public void attack() {
		System.out.println("검으로 베다");
	}
}

class ComPart1{
	String kind;
	ComPart1(String kind) {
		this.kind = kind;
	}
	public void function() {
		System.out.println(kind + "의 기능");
	}
}
class Cpu1 extends ComPart1{
	Cpu1() {
		super("cpu");
	}
	@Override
	public void function() {
		super.function();
		System.out.println("연산처리를 담당");
	}
}
class Ram1 extends ComPart1{
	Ram1() {
		super("ram");
	}
	@Override
	public void function() {
		super.function();
		System.out.println("단기 기억(휘발성 메모리)을 담당");
	}
}
class Hdd1 extends ComPart1{
	Hdd1() {
		super("hdd");
	}
	@Override
	public void function() {
		super.function();
		System.out.println("장기 기억(비휘발성 메모리)을 담당");
	}
}

abstract class Robot1{
	private String kind;
	public Robot1(String kind) {
		this.kind = kind;
	}
	abstract void attack();
	void move() {
		System.out.println(kind + "로봇이 움직인다.");
	}

	public String getKind() {
		return this.kind;
	}
	
}
class RcCar extends Robot1{
	public RcCar() {
		super("Rc카");
	}
	@Override
	void attack() {
		System.out.println("몸통 박치기");
	}
}
class Humanoid extends Robot1{
	public Humanoid() {
		super("휴머노이드");
	}
	@Override
	void attack() {
		System.out.println("발차기");
	}
}

class Duck{
	private SoundWay sw;
	public void setSound(SoundWay sw) {
		this.sw = sw;
	}
	public void duckSound() {
		if(sw != null) {
			System.out.print("오리는 ");
			sw.sound();
		}else {
			System.out.println("오리가 조용하다.");
		}
	}
}
interface SoundWay {
	void sound();
}
class NormalSound implements SoundWay{
	@Override
	public void sound() {
		System.out.println("꽥꽥꽥");
	}
}
class EleSound implements SoundWay{
	@Override
	public void sound() {
		System.out.println("삑삑삑");
	}
}