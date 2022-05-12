package javaexp.a08_access.a06_neighbor;

import javaexp.a08_access.a04_woodhome.WoodCutter;

public class Uncle {
    public void callWoodCutter() {
        WoodCutter wc = new WoodCutter();
        // 같은 패키지에 있으면 private 이외 모든 필드를 접근할 수 있다.
        // System.out.println("private : " + privSec);
        // System.out.println("default : " + wc.payOurHome);
        // System.out.println("protected : " + wc.inheritMoney);
        // 상속관계가 없는 외부패키지의 클래스는 public만 접근이 가능하다.
        System.out.println("public : " + wc.announce);
    }
}
