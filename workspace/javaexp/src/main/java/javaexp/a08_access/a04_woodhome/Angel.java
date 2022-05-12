package javaexp.a08_access.a04_woodhome;

public class Angel {
    public void callWoodCutter() {
        WoodCutter wc = new WoodCutter();
        // 같은 패키지에 있는 클래스는 private이외에 모두 접근 가능하다.
        // System.out.println("private : " + wc.privSec);
        System.out.println("default : " + wc.payOurHome);
        System.out.println("protected : " + wc.inheritMoney);
        System.out.println("public : " + wc.announce);
    }
}
