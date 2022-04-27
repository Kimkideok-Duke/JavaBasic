package javaexp.z01_homework;

public class A0427 {
	
    public static void main(String[] args) {
        
        //  2022-04-27
        // [1단계:개념] 1. 증감연산식의 앞에 ++, 뒤에 ++의 차이점을 예제를 통하여 기술하세요.
        int x = 0;
        System.out.println("++x = " + ++x); // 앞에 ++은 증가된 후 적용
        System.out.println("x++ = " + x++); // 뒤의 ++은 적용된 후 증가
        System.out.println("x = " + x);

        // [1단계:코드] 2. 짜장면(5000), 짬뽕(6000)의 가격으로 되었을 때, 증감 연산자를 활용해서
        //     1~3, 1~5까지의 총비용을 출력하세요.
        int jja_cnt = 0, jja_price = 5000, jjam_cnt = 0, jjam_price = 6000;
        System.out.println("짜장면 " + ++jja_cnt + "개의 가격 : " + jja_price*jja_cnt + ", 짬뽕 " + ++jjam_cnt + "개의 가격 : " + jjam_cnt*jjam_price);
        System.out.println("짜장면 " + ++jja_cnt + "개의 가격 : " + jja_price*jja_cnt + ", 짬뽕 " + ++jjam_cnt + "개의 가격 : " + jjam_cnt*jjam_price);
        System.out.println("짜장면 " + ++jja_cnt + "개의 가격 : " + jja_price*jja_cnt + ", 짬뽕 " + ++jjam_cnt + "개의 가격 : " + jjam_cnt*jjam_price);
        System.out.println("짜장면 " + ++jja_cnt + "개의 가격 : " + jja_price*jja_cnt + ", 짬뽕 " + ++jjam_cnt + "개의 가격 : " + jjam_cnt*jjam_price);
        System.out.println("짜장면 " + ++jja_cnt + "개의 가격 : " + jja_price*jja_cnt + ", 짬뽕 " + ++jjam_cnt + "개의 가격 : " + jjam_cnt*jjam_price);

        // [1단계:개념] 3. 비교연산식의 종류를 기술하고, 기본예제를 만들어 해당 내용에 대한 개념을 설명하세요.
        //  비교연산자 종류 : ==, !=, >, <, >=, <=
        int num01 = 10;
        int num02 = 7;
        System.out.println(num01 + " == " + num02 + " = " + (num01==num02));
        System.out.println(num01 + " != " + num02 + " = " + (num01!=num02));
        System.out.println(num01 + " > " + num02 + " = " + (num01>num02));
        System.out.println(num01 + " < " + num02 + " = " + (num01<num02));
        System.out.println(num01 + " >= " + num02 + " = " + (num01>=num02));
        System.out.println(num01 + " <= " + num02 + " = " + (num01<=num02));
        
        // [1단계:코드] 4. 아래와 같이 비교 연산식을 이용하여 boolean(true/false) 처리하세요
        //     1) 점수를 지정하여 A학점(90이상 경우) 여부를 출력하세요
                int score = 77;
                System.out.println("점수 : " + score + ", A학점 여부 : " + (score>=90));
        //     2) 4지선다 설문지에서 3번항목을 선택하지 않은 경우를 출력
                int pick_num1 = 1, pick_num2 = 2, pick_num3 = 3, pick_num4 = 4;
                System.out.println("3번 힝목을 선택 : " + (pick_num1 == 3));
                System.out.println("3번 힝목을 선택 : " + (pick_num2 == 3));
                System.out.println("3번 힝목을 선택 : " + (pick_num3 == 3));
                System.out.println("3번 힝목을 선택 : " + (pick_num4 == 3));
        //     3) 점수를 지정하여 60점 미만인 경우 과락이면, 과락여부를 출력
                int score1 = 55, score2 = 60, score3 = 77;
                System.out.println("점수 : " + score1 + ", 과락 여부 : " + (score1 >= 60));
                System.out.println("점수 : " + score2 + ", 과락 여부 : " + (score2 >= 60));
                System.out.println("점수 : " + score3 + ", 과락 여부 : " + (score3 >= 60));

        // [1단계:개념] 5. 비교연산식와 논리연산식의 차이점을 기술하세요.
        //              비교연산식으로 true/false값이 나오게 된다면
        //              논리연산식은 비교연산식으로 나온 값에 의해 and/or로 결과를 혼합해서 처리한다

        // [1단계:개념] 6. 단항연산자, 이항연산자, 삼항 연산자의 차이점을 개념과 예제를 통해 기술하세요.
        //              단항 연산자: 연산에 필요한 값이 한 개 입니다.
        //              예)+x, -x (부호 붙이기)
        //              예) ++x, x++
                        int x1 = 0; 
                        System.out.println(x++);
        //              이항 연산자: 연산에 필요한 값이 두 개이며 사칙 연산이 대표적입니다.
        //              예) a + b, a += b, a = b, a == b
                        int x2 = 0, y2 = 1; 
                        System.out.println(x2+y2);
        //              삼항 연산자: 연산에 필요한 값이 세 개입니다.
        //              예) x ? a : b
                        int x3 = 0, y3 = 1, z3 = 2; 
                        System.out.println((z3 > 3)?x3:y3);

        // [2단계:코드] 7. 삼항연산자를 이용하여 놀이공원에 입장료가 50000원 일 때, 나이가 6미만이거나 65세 이상일 때는 무료,
        //              10~20일 때는 청소년 요금으로 20%할인이 된다. 나이에 따라 무료여부와, 청소년요금제 여부를 처리하고, 총비용을 출력하세요
                        int fee = 50000, age = 0, discount = 0;
                        String teen;
                        age = 18;
                        discount = (age<6 || age>=65) ? 100 : ((age>=10 && age<=20) ? 20 : 0);
                        teen = (age>=10 && age<=20)? "청소년 요금제가 맞음" : "청소년 요금제가 아님";
                        fee -= fee * discount / 100;
                        System.out.println("나이 : " + age + ", 할인율 : " + discount + ", 총비용 : " + fee + ", 청소년 요금제 여부 : " + teen);

        // [1단계:개념] 8. main()에서 데이터의 기본 흐름 방향을 기술하고, 조건문이 처리되는 형식에 따른 플로우를 설명하세요.
        //              
        //              main() 메소드의 시작인 중괄호({})는 위에서 아래로, 왼쪽에서 오른쪽으로 실행을 한다. 단, 대입은 오른쪽에서 왼쪽으로 실행으름을 처리한다.
        //              조건문 if 의 처리방식 : if(조건){실행} -> 조건이 성립하면 실행문을 실행하고 성립하지 않으면 실행하지 않고 넘어간다.
        //              조건문 switch 의 처리방식 : switch(조건){
        //                                          case 값:
        //                                              실행
        //                                              break;
        //                                      } -> 조건이 성립하면 해당 값에 해당하는 break전까지의 실행문을 실행하고 성립하지 않으면 실행하지 않고 넘어간다.

        // [1단계:코드] 9. 조건문활용하여 1~10까지 출력하되 3/6/9게임과 같이, 해당 번호에서는 짝이라고 문자열을 출력하게 하세요.
                        int i;
                        for(i = 1;i<=10;i++){
                            if(i == 3 || i == 6 || i == 9) System.out.print("짝");
                            else System.out.print(i);
                        }
                        System.out.println(" ");

        // [1단계:코드] 10. if else문을 이용하여 점수에 따른 등급 A~F를 출력 처리하세요.
                        int scr = 86;
                        if(scr >= 90) System.out.println("A등급");
                        else if(scr >= 80) System.out.println("B등급");
                        else if(scr >= 70) System.out.println("C등급");
                        else if(scr >= 60) System.out.println("D등급");
                        else if(scr >= 50) System.out.println("E등급");
                        else System.out.println("F등급");

        // [1단계:코드] 11. switch case문을 활용하여 월별 날짜수를 출력하고 월이 아닌 범위는 월이 아니라고 출력하세요.
                        int month = 13;
                        switch(month) {    
                            case 1: 
                            case 2: 
                            case 3: 
                            case 4: 
                            case 5: 
                            case 6: 
                            case 7: 
                            case 8: 
                            case 9: 
                            case 10: 
                            case 11: 
                            case 12: 
                                System.out.println(month + "월");
                                break;
                            default:
                                System.out.println("월이 아님");
                        }
    }
}
