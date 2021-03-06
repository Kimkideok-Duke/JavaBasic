package javaexp.a09_inherit;

import java.util.ArrayList;

public class A04_Polymorphism {
	public static void main(String[] args) {
        /**
        # 다형성(polymorphism)
        1. 같은 타입이지만 실행 결과가 다양한 객체 대입(이용)가능한 성질을 말한다.
            - 부모 타입에서는 모든 자식 객체가 대입가능
            - 자식 타빙은 부모 타입으로 자동 타입 변환
            ex) 타이어의 공통적인 내용애서 사용시
                    한국타이어, 금호타이어, 광폭타이어 등 여러가지 형태로 재정의 메서드에 따라서 활용되는것을 사용할 수 있다.
                컴퓨터의 부품(ComPart)이라는 공통클래스에서
                    Ram, Cpu, Hdd 등의 기능에 따라서 여러가지 내용을 사용할 수 있다.
                    이때, 상위에 있는 공통필드나 메서드를 선언하고, 하위에 재정의하여 활용하면 프로그램을 효과적으로 처리할 수 있다.
        2. 자동 타입 변환(promotion)
            - 프로그램 실행 도중에 자동 타입 변환이 일어나는것
                부모클래스 변수 = 자식클래스 타입
                class Animal{}
                class Cat extends Animal{}
                Animal an01 = new Cat();
         */
        // 부모객체가 형변환이 일어나서 하위객체로 생성
        Larba l1 = new Dron();
        l1.attack();
        Larba l2 = new Zerggling();
        l2.attack();
        Larba l3 = new Hydra();
        l3.attack();

        // ex)
        Animal a1 = new Cat();
        a1.sound();
        Animal a2 = new Dog();
        a2.sound();
        Animal a3 = new Bird();
        a3.sound();
        ArrayList<Animal> alist = new ArrayList<Animal>();
        alist.add(new Cat());
        alist.add(new Dog());
        alist.add(new Bird());
        for(Animal a:alist){
            a.eatFood();
        }
        System.out.println("임의의 객체 호출");
        int ranIdx = (int)(Math.random()*3);
        alist.get(ranIdx).sound();

    }
	
}
class Larba{
    public void attack() {
        System.out.println("공격을 하다");
    }
}
class Dron extends Larba{
    @Override
    public void attack() {
        super.attack();
        System.out.println("공격력 +1로 원거리");
    }
}
class Zerggling extends Larba{
    @Override
    public void attack() {
        super.attack();
        System.out.println("공격력 +1로 빠르게 근거리 공격");
    }
}
class Hydra extends Larba{
    @Override
    public void attack() {
        super.attack();
        System.out.println("공격력 +3으로 원거리 공격");
    }
}
// ex)
class Animal{
    String kind;
    Animal(String kind) {
        this.kind = kind;
    }
    public void eatFood() {
        System.out.println(kind + "가 음식을 먹다");
    }
    public void sound() {
        System.out.println(kind + "가 소리를 내다");
    }
}
class Cat extends Animal{
    public Cat() {
        super("고양이");
    }
    @Override
    public void eatFood() {
        super.eatFood();
        System.out.println("생선을 먹는다.");
    }
	@Override
	public void sound() {
		// TODO Auto-generated method stub
		super.sound();
        System.out.println("냐옹");
	}
}
class Dog extends Animal{
    public Dog() {
        super("강아지");
    }
    @Override
    public void eatFood() {
        super.eatFood();
        System.out.println("사료를 먹는다.");
    }
	@Override
	public void sound() {
		// TODO Auto-generated method stub
		super.sound();
        System.out.println("멍멍");
	}
}
class Bird extends Animal{
    public Bird() {
        super("새");
    }
    @Override
    public void eatFood() {
        super.eatFood();
        System.out.println("모이를 먹는다.");
    }
	@Override
	public void sound() {
		// TODO Auto-generated method stub
		super.sound();
        System.out.println("짹짹");
	}
}