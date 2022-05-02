package javaexp.z01_homework;

import java.util.Scanner;

public class A0429 {

    public static void main(String[] args) {
//      2022-04-29
//          [1단계:개념] 1. Math.radom() 기능의 기본 임의 데이터 처리 공식을 예제를 통해 기술하세요.
                        for(int i = 0; i < 10 ; i++){
                            double rand = Math.random();
                            System.out.println(rand);
                        }
                        // 실행결과 : 0.7467495184519897
                        //          0.1805733988221938
                        //          0.1688666138894681
                        //          0.5430306431474262
                        //          0.9779130615388081
                        //          0.9384151237056709
                        //          0.034668071461559036
                        //          0.9838731914656258
                        //          0.035503264732918094
                        //          0.9865869825549829
                        // Math.random()은 0.0~1.0까지의 임의의 실수값을 생성하는 기능을 한다.

//          [1단계:응용] 2. 학생 30명의 반에 영어점수(1~100)가 반복문으로 통해 임의로 처리되게 하세요.
//                예) 번호 점수, 최하단에 반전체 평균을 출력하세요.
                        int[] score = new int[30];
                        int sum = 0, avg = 0;
                        for(int i = 1; i<=30; i++) {
                            score[i-1] = (int)(Math.random()*101);
                            System.out.println("번호 : " + i + ",\t점수 : " + score[i-1]);
                            sum += score[i-1];
                        }
                        avg = sum/30;
                        System.out.println("반 전체 평균 : " + avg);

//          [2단계:응용] 3. 두명(컴퓨터vs컴퓨터)의 구슬 홀짝게임 : 한명이 구슬 10개를 가지고 임의의로 쥐게 하여, 
//                 다른 한명이 이것을 맞추었는지 여부에 따라 승/패로 출력하게 하세요.
                        int cpu1 = (int)(Math.random()*10+1);
                        int cpu2 = (int)(Math.random()*2);
                        if(cpu2 == 0) System.out.println("컴퓨터2 : 짝");
                        else System.out.println("컴퓨터2 : 홀");
                        System.out.println("컴퓨터1 : 뽑은 구슬수는 " + cpu1);
                        if(cpu1%2 == 0) {
                            if(cpu2 == 0) System.out.println("승");
                            else System.out.println("패");
                        }
                        else {
                            if(cpu2 == 1) System.out.println("승");
                            else System.out.println("패");
                        }

//          [1단계:응용] 4. 두 팀(홍/청-컴퓨터vs컴퓨터)이 주사위를 던져 홍팀의 결과를 출력하세요(승/무/패)
                        cpu1 = (int)(Math.random()*6+1);
                        cpu2 = (int)(Math.random()*6+1);
                        System.out.println("홍팀 : " + cpu1 + ", 청팀 : " + cpu2);
                        if(cpu1>cpu2) System.out.println("승");
                        else if(cpu1==cpu2) System.out.println("무");
                        else System.out.println("패");

//          [1단계:개념] 5. while문의 기본 형식을 예제를 통해 설명하세요.
//                      1. while문은 반복여부를 처리하는 boolean값을 기준으로 반복수행을 처리한다.
//                      2. 기본 형식
//                          1) 기본
//                          while(반복조건){
//                              반복수행할 내용
//                          }
/*
//          [1단계:응용] 6. while문을 이용해서 학생의 국어,영어,수학점수를 등록하고 총점과 평균을 
//             출력하되, 등록을 종료시 -1를 입력해서 처리하세요.
                        int sub = 0;
                        String[] sub_str = {"국어", "영어", "수학"};
                        int[] scr = new int[3];
                        Scanner sc = new Scanner(System.in);
                        sum = 0; avg = 0;
                        while(sub<3) {
                            System.out.println(sub_str[sub] + "점수를 입력하세요");
                            String str = sc.nextLine();
                            if(str.equals("-1")) break;
                            scr[sub] = Integer.parseInt(str);
                            sum += scr[sub];
                            sub++;
                        }
                        avg = sum / sub;
                        System.out.println("총점 : " + sum + ", 평균 : " + avg);
*/
/*
//          [2단계:응용] 7. while문 숫자 맞추기 게임, 컴퓨터가 임의로 1~100범위의 숫자를 저장하면,
//             while문을 통해서 해당 숫자를 입력한다. 비교해서 동일하면 종료,
//             보다크다/보다 작다라는 hint로 맞추기를 진행할 수 있도록 한다. 최종적으로 몇번만에 맞추었는지 표기
                        int num_rand, num_input, cnt=0;
                        Scanner sc = new Scanner(System.in);
                        num_rand = (int)(Math.random()*100+1);
                        while(true) {
                            cnt++;
                            System.out.println("1~100까지의 숫자를 입력하세요");
                            String str = sc.nextLine();
                            num_input = (int)Integer.parseInt(str);
                            if(num_input == num_rand) break;
                            else if(num_input>num_rand) System.out.println(num_input + "보다 작다");
                            else if(num_input<num_rand) System.out.println(num_input + "보다 크다");
                        }
                        System.out.println(cnt + "번 만에 맞춤");
*/
//          [1단계:개념] 8. 참조변수가 무엇인지? 메모리 영역을 기본 데이터유형과 비교하여
//                기본 예제를 통해서 설명하세요.
                    // # 참조변수
                    // 1. 자바에서 가장 많이 활용되는 메모리가 stack영역과 heap영역이 있다.
                    // 2. stack영역에는 기본 타입유형이 바로 할당되는데, 그외 배열, 열거, 객체, 인터페이스 유형은 heap영역에 할당되고, stack영역에 heap영역의 주소값을 할당하여 사용한다.
                    // 3. 이 때, 객체 유형은 heap영역을 참조한다는 개념으로 참조 타입이라고 한다. 이런 변수를 참조변수라고 한다.
                    // 기본 타입 변수
                    int a = 10;
                    // 참조 타입 변수
                    String n = "abcd";

//          [1단계:확인] 9. Music 클래스를 선언하고, 해당 m01, m02 참조변수를 선언하고, 비교하세요.
                        Music m01 = new Music();
                        Music m02 = new Music();
                        System.out.println(m01==m02);

//          [1단계:개념] 10. String 객체의 주소 활용방식을 ==, .equals()를 통하여 기본예제로 기술하세요. 
                        String str1 = new String("홍길동");
                        String str2 = new String("홍길동");
                        System.out.println("주소값비교2 : " + (str1==str2));
                        System.out.println("데이터 자체 내용을 비교하는 메서드 equals을 활용하여야 한다.");
                        System.out.println("문자열 비교 : " + (str1.equals(str2)));
    }

}

class Music {}