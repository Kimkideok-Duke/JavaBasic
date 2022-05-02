package javaexp.z01_homework;

import java.util.Scanner;

public class A0428 {

    public static void main(String[] args) {
//         2022-04-28
//          [1단계:개념]1. 반복문 for, while, do while의 차이점을 기술하세요.
//                      for문 : 반복 step에 변수를 사용할 필요가 있을 때 사용된다.
//                      while문 : 반복 블럭에서 특정 입력데이터에 의해 변경이 되어 반복을 중단할 때 주로 사용된다.
//                      do{}while문 : 반복할 내용을 일단 한번은 수행하고 입력데이터에 의해 반복여부를 처리할 때 주로 사용된다.

//          [1단계:개념]2. for문의 기본 구성요소를 기본 예제를 통하여 특징을 기술하세요.
                        for(int i = 0; i < 10; i++){
                            System.out.println(i + "\t");
                        }
                        // int i = 0 : 초기값을 설정하고 한번만 호출된다.
                        // i < 0 : 반복 block을 다시 수행시켜줄 조건을 설정한다.
                        // i++ : 초기화식에 의해 초기화된 변수를 증가/감소 시켜준다.
                        // System.out.println(i) : 실제 반복이 일어나는 구문이다.

//          [1단계:개념]3. for(기본) - 200에서 3씩 차감하여 100까지 차감된 데이터를 출력하세요
                        for(int i = 200; i >= 100; i-=3){
                            System.out.println(i + "\t");
                        }
                        
//          [1단계:개념]4. for(지역/전역) - 곰돌이가 하루 빵을 2개씩 증가해서 먹어(첫째날 2개, 둘째날 4개, 셋째날 6개 ...) 총 10일 동안 먹은 빵의 갯수를 누적하여 아래와 같이 출력하세요
//                      # 출력 형식
//                      1일차 2개 2개
//                      2일차 4개 6개
//                      3일차 6개 10개
                        int sum = 0;
                        for(int i = 1; i<=10; i++) {
                            sum += i*2;
                            System.out.println(i + "일차\t" + i*2 + "개\t" + sum + "개");
                        }

//          [1단계:코드]5. 3/6/9게임 2단계 1~20까지 해당 게임과 같이 출력처리하세요(모두 출력해주세요)
//                      1) 1단계 : 3의 배수에 짝이라 표기
//                      2) 2단계 : 1 2 짝 4 ... 10 11 12 짝 14 15 16 짝...
                        for(int i = 1; i<=20;i++) {
                            if(i%3 == 0 || i%10 == 3 || i%10 == 6 || i%10 == 9) System.out.print("짝 ");
                            else System.out.print(i + " ");
                        }
                        System.out.println(" ");

//          [1단계:코드]6. 100에서 1/4로  4회 누적해서 나눈 값을 아래의 형식으로 출력 하세요
//                     초기데이터 100
//                     1회  25 
//                     2회  6.2..
//                     3회  1.54...
//                     4회  0.38..
                        float num = 100;
                        for(int i = 1; i<=4; i++) {
                            num /= 4;
                            System.out.println(i+"회\t" + num);
                        }

//          [1단계:개념]7. 반복문에서 break와 continue의 차이점을 기본 예제를 통하여 기술하세요
                        for(int i = 0; i<=10; i++) {
                            if(i == 3) continue;
                            System.out.print(i + "\t");
                            if(i == 8) break;
                        }
                        System.out.println(" ");
                        // 3일때 continue는 반복문을 건너뛰고 8일때 break는 반복문을 탈출한다.
//          [2단계:코드]8. [continue 활용]1~12월까지 마지막일수*10으로 월급여 산정하되, 31일만 있는 월만 산정해서 출력하고 나머지 월(30일, 28일까지 있는 달)은 산정 처리하지 않고 총 급여을 아래와 같이 출력하세요
//                          월  일수   월급여 누적연봉      
//                          1월 31일  310만 310만원
//                          3월 31일  310만 620만원
//                          5월 31일  310만 930만원
//                          ..
//                          12 31일  .. 
                        System.out.println("월\t" + "일수\t" + "월급여\t" + "누적연봉");
                        int day = 31, money_sum=0;
                        for(int month = 1; month<=12; month++) {
                            if(month == 2 || month == 4 || month == 6 || month == 9 || month == 11) continue;
                            else {
                                money_sum+=(day*10);
                                System.out.println(month + "월\t" + "31일\t" + day*10 + "만\t" + money_sum + "만원");
                            }
                        }

//          [1단계:개념]9. Scanner 객체 선언과 사용법을 기술하세요.
                    // # Scanner 객체
                    // 1. java에서 기본적인 입력을 console을 통해서 처리해주는 객체이다.
                    // 2. 사용방법
                    //  1) 내장되었지만, 기본 java.lang패키지가 아니어서 import를 상단에 해주어서 객체를 생성해서 사용할 수 있다.
                        Scanner sc = new Scanner(System.in);
                    //  2) 객체를 생성할 때, 생성자의 매개변수를 java의 기본 io의 입력 처리 객체인 System.in로 할당하여야 한다.
                    //  3) 객체가 생성되면 기본적으로 nextLine() 메서드를 통해서 console에서 line단위로 문자열을 데이터 입력받을 수 있다.

//          [1단계:확인]10. Scanner 객체를 통해서 국어, 영어, 수학 점수를 숫자로 입력받아 합산과 평균을 출력하세요.
                        System.out.println("국어 점수를 입력하세요!!");
                        String kor = sc.nextLine();
                        int score_kor = Integer.parseInt(kor);
                        System.out.println("수학 점수를 입력하세요!!");
                        String math = sc.nextLine();
                        int score_math = Integer.parseInt(math);
                        System.out.println("영어 점수를 입력하세요!!");
                        String eng = sc.nextLine();
                        int score_eng = Integer.parseInt(eng);
                        int score_sum = score_kor + score_math + score_eng;
                        float score_avg = (float)score_sum / 3; 
                        System.out.println("합산 : " + score_sum + ", 평균 : " + score_avg);
    }
}
