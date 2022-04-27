package javaexp.a04_process;

public class A01_Basic {

    public static void main(String[] args) {

        /*
        # 코드 실행 흐름 제어
        1. 정상적인 코드 실행 흐름
            main() 메소드의 시작인 중괄호({})는 위에서 아래로, 왼쪽에서 오른쪽으로 실행을 한다. 단, 대입은 오른쪽에서 왼쪽으로 실행으름을 처리한다.
        2. 제어문의 역할
            코드의 실행 흐름을 개발자가 원하는 방향으로 변경할 수 있도록 도와준다.
        
        # 제어문의 종류
        1. 조건문
            if문, switch문
        2. 반복문
            for문, while문, do-while문
        3.break문, continue문

        # 제어문의 중첩
        1. 제어문의 중괄호 내부에 다른 제어문 작성이 가능하다.
            1) 다양한 흐름 발생 가능
        2. 유형 : 아래와 같이 여러가지 중첩적으로 제어문을 만들어서 처리할 수 있다.
            조건문
                조건문
            반복문
                반복문
            반복문
                조건문
        */
        int cnt = 1;
        System.out.println("flow의 진행 : " + cnt++);
        System.out.println("flow의 진행 : " + cnt++);
        if(cnt==3) {
            System.out.println("# cnt가 3일때 처리할 flow #");
            System.out.println("flow의 진행 : " + cnt++);
            System.out.println("# 종료 #");
        }
        if(cnt==4) System.out.println("flow의 진행(옆에 조건) : " + cnt++);
        System.out.println("flow의 진행 : " + cnt++);
        if(cnt==6)
            System.out.println("flow의 진행(중괄호 블럭 없이) : " + cnt++);
        System.out.println("flow의 진행 : " + cnt++);
        System.out.println("flow의 진행 : " + cnt++);
        System.out.println("flow의 진행 : " + cnt++);
        
        // ex) 과일의 갯수를 2개씩 증가시켜서 줄력하게 변수를 선언하여 출력하고, 
        //      4일 때, 처리할 조건 블럭 설정
        //      10일 때, 처리할 바로 옆에 프로세스를 처리
        //      14일 때, 바로 밑에 처리할 조건 프로세스를 처리하세요.
        int fru_cnt;
        for(fru_cnt = 0; fru_cnt<=20; fru_cnt+=2){
            if(fru_cnt == 4){
                System.out.println("과일의 갯수 : " + fru_cnt);
            }
            if(fru_cnt == 10) System.out.println("과일의 갯수 : " + fru_cnt);
            if(fru_cnt == 14)
                System.out.println("과일의 갯수 : " + fru_cnt);
        }
    }
}
   

