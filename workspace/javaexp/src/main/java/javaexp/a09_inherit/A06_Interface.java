package javaexp.a09_inherit;

public class A06_Interface {

    public static void main(String[] args) {
        /**
        # 인터페이스란?
        1. 개발 코드와 객체가 서로 통신하는 접점
            1) 개발 코드는 인터페이스의 메소드만 알고 있으면 OK
        2. 인터페이스의 역할
            1) 개발코드가 객체에 종속되지 않게 --> 객체 교체할 수 있도록 하는 역할
            2) 개발 코드 변경없이 리턴값 또는 실행 내용이 다양해 질 수 있음(다형성)
        3. 인터페이스의 선언
            1) 인터페이스 이름 - 자바 식별자 작성 규칙에 따라 작성
            2) 소스 파일 생성 - 인터페이스 이름과 대소문자가 동일한 소스 파일 생성
            3) 인터페이스 선언
                interface 인터페이스명{}
            4) 인터페이스 구성 멤버
                타입 상수명 = 값;
                타입 메소드명(매개변수,..)
                default 타입 메소드명(매개변수..){}
                static 타입 메소드명(매개변수..){}
         */
        WingInf w1 = new Wing01();
        w1.flying();
        WingInf w2 = new Wing02();
        w2.flying();
        Mz m1 = new Mz();
        m1.running();
        m1.flying();
        m1.setWing(new Wing01());
        m1.flying();
        // 날개를 통해 upgrade할 내용을 Mz 소스 변경하지 않고
        // WingInf를 상속받은 하위클래스를 선언하면, Mz의 나는 기능을 계속 변경할 수 있다.
        m1.setWing(new Wing02());
        m1.flying();
        m1.setWing(new Wing03());
        m1.flying();
        m1.attack();
        m1.setWeapon(new MissileAttack());
        m1.attack();
        m1.setWeapon(new RocketAttack());
        m1.attack();
    }
}
class Mz{
    private WingInf wing;
    public void setWing(WingInf wing) {
        this.wing = wing;
    }
    public void running() {
        System.out.println("MZ가 뛰어다닙니다.");
    }
    public void flying() {
        if(wing!=null) {
            System.out.println("MZ 날다");
            wing.flying();
        }else {
            System.out.println("날개가 장착되지 않았습니다.");
        }
    }
    private AttackWay weapon;
    public void setWeapon(AttackWay weapon) {
        this.weapon = weapon;
    }
    public void attack() {
        if(weapon!=null) {
            System.out.println("공격하다");
            weapon.attack();
        }else {
            System.out.println("무기가 장착되지 않았습니다.");
        }
    }
}
interface WingInf{ // 추상클래스의 종류중에 하나
    void flying();  // public abstract 무조건 붙음
}
class Wing01 implements WingInf{ // 인터페이스는 implements라는 키워드를 통해서 상속받음
    @Override
    public void flying() {
        System.out.println("날개 1호 우리동네를 날다.");
    }
}
class Wing02 implements WingInf{
    @Override
    public void flying(){
        System.out.println("날개 2호 우리 나라 창공을 누비다.");
    }
}
class Wing03 implements WingInf{
    @Override
    public void flying() {
        System.out.println("날개 3호 세계를 누비다.");
    }
}
interface AttackWay{
    void attack();
}
class RocketAttack implements AttackWay{
    @Override
    public void attack() {
        System.out.println("로켓포 발사");
    }
}
class MissileAttack implements AttackWay{
    @Override
    public void attack() {
        System.out.println("미사일 발사");
    }
}