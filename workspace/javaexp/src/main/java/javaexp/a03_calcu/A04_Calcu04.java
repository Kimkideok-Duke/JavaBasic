package javaexp.a03_calcu;

public class A04_Calcu04 {

    public static void main(String[] args){

        /*
        #증감
        1. 증가 또는 감소 처리를 할때, 활용된다.
            - 기본적으로 1씩 증가 또는 감소를 한다.
        2. 반복문에 주로 활용된다.
        3. 형식
            변수명++, 변수명--
            ++변수명, --변수명
        ps)2이상, 증가 감소시는 +=, -=를 활용한다.
        */
        int num01 = 1;
        int num02 = 10;
        System.out.println(++num01);
        System.out.println(num01++);
        System.out.println(num01++);
        System.out.println(num01);
        System.out.println(num01+=2);
        System.out.println(num01+=2);
        System.out.println(num01+=2);
        System.out.println(num01+=2);

        System.out.println(++num01);
        System.out.println(++num01);
        System.out.println(++num01);
        System.out.println(++num01);
        System.out.println(--num02);
        System.out.println(--num02);
        System.out.println(num02--);
        System.out.println(num02--);


        // ex1) 구매하는 김밥의 갯수를 선언하고, 1씩 증가하여
        //      김밥의 단가(2500)
        //      김밥 1개 구매 2500
        //      김밥 2개 구매 5000

        int gimbob_cnt = 1, gimbob_price = 2500;
        System.out.println("김밥 " + gimbob_cnt + "개 구매 " + gimbob_price*gimbob_cnt); gimbob_cnt++;
        System.out.println("김밥 " + gimbob_cnt + "개 구매 " + gimbob_price*gimbob_cnt); gimbob_cnt++;
        System.out.println("김밥 " + gimbob_cnt + "개 구매 " + gimbob_price*gimbob_cnt); gimbob_cnt++;
        System.out.println("김밥 " + gimbob_cnt + "개 구매 " + gimbob_price*gimbob_cnt); gimbob_cnt++;
        System.out.println("김밥 " + gimbob_cnt + "개 구매 " + gimbob_price*gimbob_cnt); gimbob_cnt++;
        System.out.println("김밥 " + gimbob_cnt + "개 구매 " + gimbob_price*gimbob_cnt); gimbob_cnt++;
    }

}
