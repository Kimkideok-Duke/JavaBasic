package javaexp.a03_calcu;

public class A03_Calcu03 {

    public static void main(String[] args) {
        
        /*
        # 대입연산자
        1. = : 데이터를 오른쪽에서 왼쪽으로 대입하여 할당이 된다.
        */
        int num01 = 25;
        int num02; int num03; int num04;
        num02 = num03 = num04 = 5;
        System.out.println(num01);
        System.out.println(num02);
        System.out.println(num03);
        System.out.println(num04);
        /*
        2. +=,-=,*=,/=,%=
            기존 변수에서 누적하여 다시 데이터를 할당할 때, 활용된다.
            2이상의 증가하거나 감소등의 연산식을 처리할 때, 활용된다.
        */
        num01 = num01+5;
        System.out.println("기존에 데이터를 합산한 값 : " + num01);
        num01 += 5;
        System.out.println("누적 합산 값 : " + num01);
        num01 -= 5;
        System.out.println("누적 뺀 값 : " + num01);
        /*
        ex) 변수 cnt01~05에 데이터 5를 한번에 선언과 할당을 하고, 누적증감연산자에 의해서 cnt01~05, 2,3,4,5,6 증가 처리하여 출력하세요.
        */
        int cnt01, cnt02, cnt03, cnt04, cnt05;
        cnt01=cnt02=cnt03=cnt04=cnt05=5;
        int add = 2;
        System.out.println(cnt01+=add); add++;
        System.out.println(cnt02+=add); add++;
        System.out.println(cnt03+=add); add++;
        System.out.println(cnt04+=add); add++;
        System.out.println(cnt05+=add);
    }

}
