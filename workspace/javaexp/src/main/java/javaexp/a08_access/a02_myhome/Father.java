package javaexp.a08_access.a02_myhome;

public class Father {
    // 접근 제어자 X(default)이상일때, 호출 가능(같은 패키지일때)
    void callMyInfo() {
        Mine m = new Mine();

        // 같은 패키지에 있는 클래스는 private 이외에는 모두 접근이 가능
        // System.out.println(m.passwd);
        System.out.println(m.ourFamilyplan);
        System.out.println(m.bday);
    }
}
