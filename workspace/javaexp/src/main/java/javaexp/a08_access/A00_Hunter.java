package javaexp.a08_access;

import javaexp.a08_access.a01_friendship.WoodCutter;
// public이라도 외부 패키지에 있는 클래스는 import 또는 패키지명.클래스명으로 사용가능하다.

public class A00_Hunter {

	void callWoodCutterInfo() {
        // WoodCutter wc : public class WoodCutter
        // wc = new WoodCutter() : public WoodCutter(){}
        // wc.hiddenDeer : default 접근제어자로 상단에 선언된 패키지가 같을때 접근이 가능하다.
        // package javaexp.a08_access.a01_friendship;
        WoodCutter wc = new WoodCutter();
        // System.out.println(wc.hiddenDeer);
    }
	void callDeerInfo(){
		// 사슴의 클래스에 대한 접근도 default이기에 접근이 불가능
		// Deer d = new Deer();
		// System.out.println(d.whereWhen);
	}
}
