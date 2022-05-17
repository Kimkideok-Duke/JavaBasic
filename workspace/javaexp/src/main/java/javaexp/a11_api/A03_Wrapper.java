package javaexp.a11_api;

import java.util.ArrayList;
import java.util.List;

public class A03_Wrapper {

    public static void main(String[] args) {
        /**
        # 포장(Wrapper) 클래스
        1. 기본 타입(byte, char, short, int, long, float, double, boolean)값을 내부에 두고 포장하는 객체
        2. 기본 타입의 값은 외부에서 변경 불가능하기 때문에 객체로 변환하여, 객체에게 지원하는 메서드를 통해 처리할 때 사용한다.
        3. 네이밍 원칙
            1) 기본타입이 소문자로 시작하면 포장클래스는 대문자로 시작한다.
                byte ==> Byte, short ==> Short, .. long ==> Long
            2) 단, 2가지 유형을 다르게 선언된다.
                char ==> Character
                int ==> Integer
        4. 박싱(Boxing)과 언박싱(Unboxing)
            1) 박싱 : 기본 타입의 값을 포장객체로 만드는 과정
                - 생성자 사용
                    Byte ob = new Byte(10); Byte ob2 = new Byte("10"); -- jdk version에 따라 지원되지 않음
                    Character ob = new Character('가');
                - valueOf() 메서드 이용
                    Integer ob1 = Integer.valueOf(1000);
                    Double ob2 = Double.valueOf("100.25");
            2) 언박싱 : 포장 객체에서 기본 타입의 값을 얻어내는 과정 
         */
        Byte ob01 = new Byte("10");
        Short ob02 = new Short("20");
        Integer ob03 = Integer.valueOf(1000);
        Double ob04 = Double.valueOf("425.21");
        System.out.println(ob01);
        System.out.println(ob02);
        System.out.println(ob03);
        System.out.println(ob04);

        // 포장객체에서 실제 기본 유형으로 변경 처리하는 과정
        byte num01 = ob01.byteValue();
        short num02 = ob02.shortValue();
        int num03 = ob03.intValue();
        double num04 = ob04.doubleValue();

        // ex)
        Character ex01 = new Character('A');
        Float ex02 = Float.valueOf(30);
        Boolean ex03 = new Boolean("true");
        System.out.println(ex01);
        System.out.println(ex02);
        System.out.println(ex03);
        // ex)
        char num05 = ex01.charValue();
        float num06 = ex02.floatValue();
        boolean num07 = ex03.booleanValue();
        System.out.println(num05);
        System.out.println(num06);
        System.out.println(num07);

        /**
        5. 자동박싱과 언박싱
            1) 자동 박싱 : 포장 클래스 타입에 기본값이 대입될 경우 발생한다.
                Integer obj = 100; // 자동박싱
                List<Integer> list = new ArrayList<Integer>();
                list.add(200);
         */
        // 자동박싱/자동언박싱 : 객체 데이터를 생성자, 객체 생성을 위한 기능 메서드를 통해서 객체를 생성하지만,
        // Wrapper는 기본 데이터 유형을 효과적으로 활용하기 위해 조금 더 간편하게 객체를 생성할 수 있게 자동박싱/자동언박싱 개념을 도입해서 생성한다.
        Integer obj = 1000;
        System.out.println("Wrapper 클래스가 메서드에 의해 기능처리(double) : " + obj.doubleValue());
        System.out.println("Wrapper 클래스가 메서드에 의해 기능처리(byte) : " + obj.byteValue());
        /**
        List<Integer> list = new ArrayList<Integer>();
        list.add(200);
        Collection 객체의 유형인 List는 객체만 사용할 수 있다.
        그런데, 이 객체중에 Wrapper 클래스인 경우, new XXXX() 형태로 객체를 생성하지 않더라도,
        기본 데이터 유형이 자동박싱으로 처리되어 내부적으로 객체가 만들어져서 할당된다.
        이렇게 collection에 타입이 Wrapper인 경우 기본 유형으로 할당이 가능하다.
         */
        List<Integer> list = new ArrayList<Integer>();
        list.add(2000);
        list.add(3000);
        list.add(4000);
        // for(Integer wrap:list) {
        System.out.println("# 자동 unboxing으로 처리된 결과 #");
        for(int num:list) { // 자동 unboxing에 의해 객체가 기본 데이터 유형으로 할당되어 사용할 수 있다.
            System.out.println(num);
        }
        /**
        자동 언박싱 - 기본타입에 포장객체가 대입될 경우 발생
         */
        Integer obj01 = new Integer("200");
        int value01 = obj01;
        int value02 = obj01 + 100;
        System.out.println(value01);
        System.out.println(value02);

        // ex)
        Double obj02 = new Double("3.14");
        double value03 = obj02+200;
        System.out.println(value03); 
    }
}
