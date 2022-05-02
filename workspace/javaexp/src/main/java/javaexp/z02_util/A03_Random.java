package javaexp.z02_util;

import java.util.Scanner;

public class A03_Random {

    public static void main(String[] args) {

        // # Random 데이터란
        // 1. 임의의 데이터를 말하는 것으로 프로그램이나 빅데이터 처리시 많이 활용된다.
        // 2. 자바에서는 기본적으로. Math.random()을 통해 0.0~1.0 사이에 실수로 임의의 데이터가 지원되고 있다.
        // 3. 0.0 <= Math.random() < 1.0
        // 4. 0.0*10 <= Math.random()*10 < 10.0
        // 5. 0 <= (int)(Math.random()*10) < 10
        // 6. 1 <= (int)(Math.random()*10+1) < 11
        // # 공식 (int)(Math.random()*경우의 수 + 시작수) < 11
        System.out.println(Math.random());
        System.out.println(Math.random()*10);
        System.out.println((int)(Math.random()*10));
        System.out.println((int)(Math.random()*10+1));
        // 주사위를 뽑아 낼려고 한다.
        // 주사위의 수 : 6, 시작수 1
        int dice1 = (int)(Math.random()*6+1);
        int dice2 = (int)(Math.random()*6+1);
        System.out.println("주사위1 : " + dice1);
        System.out.println("주사위2 : " + dice2);
        // 동전 앞/뒤 처리
        // 경우의 수 : 2 ==> 0,1
        int game01 = (int)(Math.random()*2);
        if(game01==0) {
            System.out.println("동전 앞면");
        }else {
            System.out.println("동전 뒷면");
        }
        // ex1) 
        int kor_score = (int)(Math.random()*101);
        System.out.println("국어 점수 : " + kor_score);
        // ex2)
        int rsp1 = (int)(Math.random()*3);
        int rsp2 = (int)(Math.random()*3);
        int cnt = 0;
        if(rsp1 == 0) System.out.println("가위");
        else if(rsp1 == 1) System.out.println("바위");
        else System.out.println("보");
        if(rsp2 == 0) System.out.println("가위");
        else if(rsp2 == 1) System.out.println("바위");
        else System.out.println("보");
        // ex3)
        Scanner sc = new Scanner(System.in);
        System.out.println("홀과 짝중에 선택해 주세요");
        String input_str = sc.nextLine();
        // int input_int = Integer.parseInt(input_str);
        int sin_dou = (int)(Math.random()*2);
        String sin_dou_str;
        if(sin_dou == 0) {
             System.out.println("홀");
             sin_dou_str = "홀";
        }
        else {
            System.out.println("짝");
            sin_dou_str = "짝";
        }
        if(sin_dou_str.equals(input_str)) System.out.println("맞췄습니다.");
        else System.out.println("틀렸습니다.");
    }
}
