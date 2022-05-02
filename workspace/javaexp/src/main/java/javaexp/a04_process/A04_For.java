package javaexp.a04_process;

public class A04_For {

	public static void main(String[] args) {
        /**
         # 반복문
         1. 중괄호 블록내용을 반복적으로 실행할 때, 사용된다.
         2. 종류
            for문 : 반복 step에 변수를 사용할 필요가 있을 때 사용된다.
                cf) 배열 데이터에서 단위 데이터를 반복적으로 사용할 때 활용된다.
            while문 : 반복 블럭에서 특정 입력데이터에 의해 변경이 되어 반복을 중단할 때 주로 사용된다.
            do{}while문 : 반복할 내용을 일단 한번은 수행하고 입력데이터에 의해 반복여부를 처리할 때 주로 사용된다.

        # for문
        1. 반복 횟수를 알고 있을 때, 주로 사용한다.
            1) 기본형식
                for(초기화식1;조건식2;증감식4){
                    실행문3
                }
                초기화식1 : 생략해도 되는데, 주로 초기값을 설정할 때, 사용된다.
                        해당 반복문 block에서 사용할 초기값을 선언한다.
                        이 초기화식은 한번만 호출되어 사용한다.
                조건식2 : 반복 block을 다시 수행시켜줄 조건을 설정한다.
                        보통 boolean(true/false)을 설정하는 것이 일반적이다.
                실행문3 : 실제 반복이 일어나는 구문을 말한다.
                증감식4 : 초기화식에 의해 초기화된 변수를 증가/감소 시켜준다.
            cf) for(;;){} : 생략하면 while문과 동일하다.
        */
        for(int cnt=1;cnt<=10;cnt++){
            System.out.println("카운트 : " + cnt);
        }
        // ex1) 5~25까지 출력
        for(int cnt=5;cnt<=25;cnt++){
            System.out.print(cnt + " ");
        }
        // ex2) 100~120까지 출력
        for(int cnt=100;cnt<=120;cnt++){
            System.out.print(cnt + " ");
        }

        /**
        #반복문 처리 연습 단계
        1. 기본 구성요소 연습
            1) 초기값, 반복 조건 연습
            2) 증감연산자 연습
                cnt++, cnt--, cnt+=2, cnt-=3
            3) 출력할 내용에 대한 연습
                System.out.println() : 줄바꿈 없이 처리
                System.out.print() : 중바꿈 없이 처리
                System.out.print("\t") : 탭간격 처리
                System.out.print("\n") : 줄바꿈 처리
        
        2. 반복문 밖에 외부 변수를 통한 처리
            1) 지정된 변수 설정과 반복문의 변수와 혼합하여 출력하기
                ex) 구구단의 단수, 1~10까지의 반복변수, 혼합하여 구구단 출력
            2) 누적 데이터 처리
                합산할 변수 선언
                변수를 통해 누적 처리 데이터 출력
        
        3. 반복문과 조건문을 혼합하여 처리하기
            1) 반복문 안에 조건을 넣어 특정한 경우에 출력 또는 연산 처리하기
                ex) 1~10 출력 내용 중에 짝수만 출력하기
                ex) 합산된 값이 20일때 출력하기
                ex) 1~100 출력하되 5단위로 줄바꿈 처리하기
                ex) 1~20까지 합산을 하되 마지막에는 =을 표기하기
                    1 + 2 + 3 ... + 20 = xxx
            2) 조건문으로 특정한 경우 break와 continue를 통해서 프로세스를 제어하기
                ex) 구구단에서 5인 경우에 중단 처리하기
        
        4. 반복문에서 반복문을 활용하기
         */
        System.out.println("# 5씩 증가# ");
        for(int cnt = 1;cnt<=100;cnt++){
            System.out.println(cnt);
        }
        System.out.println("# 2씩 감소# ");
        for(int cnt = 10;cnt>0;cnt--){
            System.out.println(cnt);
        }

        // ex1)
        System.out.println("# ex1)# ");
        for(int cnt = 10;cnt<=50;cnt+=3){
            System.out.println(cnt);
        }
        // ex2)
        System.out.println("# ex2)# ");
        for(int cnt = 10;cnt>=0;cnt--){
            System.out.println(cnt);
        }
        // ex3)
        System.out.println("# ex3)# ");
        for(int cnt = 100;cnt>=70;cnt-=5){
            System.out.println(cnt);
        }
        // ex4)
        System.out.println("# ex4)# ");
        for(int cnt = 50;cnt>=-20;cnt-=4){
            System.out.println(cnt);
        }
    }
}
