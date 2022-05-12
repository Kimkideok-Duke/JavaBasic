package javaexp.a09_inherit;

public class A05_Abstract {

    public static void main(String[] args) {
        /**
        # 추상클래스(abstract class)
        1. 추상클래스 개념
            1) 추상(abstract)
                - 실제들 간의 공통되는 특성을 추출하는 것
                ex) 새, 곤충, 물고기 ==> 동물(추상)
                    삼성, 현대, LG ==> 회사(추상)
            2) 추상 클래스(abstract class)
                - 실체 클래스들의 공통되는 필드와 메소드 정의한 클래스
                - 추상 클래스는 실제 클래스의 부모 클래스 역할(단독 객체 X)
                cf) 추상 클래스 법칙
                1. 추상메서드(abstract)가 하나라도 있으면,
                    추상클래스로(abstract class 클래스명)로 선언되어야 하며
                    ex) 추상 메서드는 재정의가 목적이기에 body({})가 없다.
                2. 추상클래스가 가지고 있는 추상메서드는 상속받는 하위 클래스에서 반드시 재정의하여야 한다.
                3. 추상클래스는 혼자 생성하지 못하고, 다형성에 의해서 생성할 수 있다.
                    추상클래스 참조 = new 추상클래스(); (X)
                    추상클래스 참조 = new 하위실체클래스(); (O)
                    
        2. 추상 클래스의 용도
            1) 실체 클래스의 공통된 필드와 메소드의 이름 통일 목적
                - 실체 클래스의 설계자가 여러 사람일 경우
                - 실체 클래스마다 필드와 메소드가 제각기 다른 이름을 가질 수 있음
            2) 실체 클래스를 작성할 때 시간절약
                - 실체 클래스는 추가적인 필드와 메서드만 선언
            3) 실체 클래스 설계 규격을 만들고자 할 때
                - 실체 클래스가 가져야 할 필드와 메소드를 추상 클래스에 미리 정의
                - 실체 클래스는 추상 클래스를 무조건 상속 받아 작성.
        3. 기본 코드
            1) 추상 클래스 선언
                public abstract class 클래스명{
                    public abstract 리턴값 메소드명(){}
                }
            2) 추상 클래스를 상속받은 하위 클래스(실체 클래스)
                class 클래스 extends 클래스명{
                    // 추상메서드는 반드시 재정의 하여야 한다. : (강제) - 컴파일 에러 발생
                    public 리턴값 상위에선언된추상메서드(){

                    }
                }
         */
        // Larba1 lb01 = new Larba1(); // 추상클래스 혼자 객체생성을 하지 못한다.
        Larba1 lb02 = new Mutal(); // 추상클래스 = 실체클래스 형태로 객체생성 가능
        lb02.move();
        lb02.attack();

        // ex)
        Company1 c01 = new Samsung();
        Company1 c02 = new Hyundai();
        Company1 c03 = new LG();
        c01.working();
        c02.working();
        c03.working();
        Company1 []coms = {new Samsung(), new Hyundai(), new LG()};
        for(Company1 com:coms) {
            com.working();
        }
    }
}
abstract class Larba1{
    void move() { // 공통 메서드
        System.out.println("이동하다.");
    }
    abstract void attack(); // body가 없는 추상 메서드 : 재정의할 메서드
}
class Mutal extends Larba1{
    // 추상클래스를 상속한 하위클래스는 추상메서드를 반드시 재정의하여야 한다.(메서드 통일을 유지가능)
    @Override
    void attack() {
        System.out.println("공중 원거리 공격하다.");
    }
}
class Ultra extends Larba1{
    @Override
    void attack() {
        System.out.println("근접 공격하다.");
    }
}

abstract class Company1{
    private String name;
    public Company1(String name) {
        this.name = name;
    }
    void earnMoney() {
        System.out.println(name + "가 돈을 벌다.");
    }
    abstract void working();

    public String getName() {
        return this.name;
    }
    
}
class Samsung extends Company1{
    public Samsung(){
        super("삼성");
    }
    @Override
    void working() {
        super.earnMoney();
    }
}
class Hyundai extends Company1{
    public Hyundai(){
        super("현대");
    }
    @Override
    void working() {
        super.earnMoney();
    }
}
class LG extends Company1{
    public LG(){
        super("LG");
    }
    @Override
    void working() {
        super.earnMoney();
    }
}