package javaexp.a04_process;

public class A05_For {

    public static void main(String[] args) {
        ////////////////////////////////////////////////
        // ex1)
        for(int i = 1; i <= 10; i++){
            System.out.print(i + " + ");
        }
        System.out.print("\n");
        // ex2)
        for(int i = 100; i >= 90; i--){
            System.out.print(" ^^ " + i);
        }
        System.out.print("\n");
        // ex3)
        for(int i = 1; i <= 10; i++){
            System.out.println("5 * " + i + " = " + 5*i);
        }
        // ex4)
        for(int i = 1; i <= 4; i++){
            System.out.print(i + ") I love you ! ♥ ♥");
        }
        System.out.print("\n");
        // ex5)
        for(int i = 100; i >= 50; i-=10){
            if(i > 50) System.out.print(i + " - ");
            else System.out.println(i);
        }
        /**
        # 반복문 밖에 외부 변수를 통한 처리
            1) 지정된 변수 설정과 반복문의 변수와 혼합하여 출력하기
                ex) 구구단의 단수, 1~10까지의 반복변수, 혼합하여 구구단 출력
            2) 누적 데이터 처리
                합산할 변수 선언
                변수를 통해 누적 처리 데이터 출력
         */
        int sum = 0; // 반복문 밖의 전역변수 설정
        for(int cnt = 1;cnt<=10;cnt++) {
            int sum01 = 0;
            sum01 += cnt;
            sum += cnt;
            System.out.print("합산1 : " + sum01 + "\t");
            System.out.println("합산2 : " + sum);
        }
        int grade = 8;
        for(int cnt = 1; cnt <= 9; cnt++) {
            System.out.println(grade + " X " + cnt + " = " + (grade*cnt));
        }
        int gimbap = 2500;
        for(int date = 1;date<=10;date++) {
            System.out.println(date + "째날 판매 금액 : " + gimbap*date);
        }
        // ex1)
        int i_sum = 0;
        for(int i = 1; i<=20; i++) {
            i_sum+=i;
        } 
        System.out.println(i_sum);
        // ex2)
        i_sum = 0;
        for(int i = 2; i<=10; i+=2) {
            i_sum += i;
        }
        System.out.println(i_sum);
        // ex3)
        i_sum = 0;
        for(int i = 1;i <= 10;i++) {
            i_sum = i*5000;
            System.out.println(i+"그릇 " + i_sum+"원");
        }
    }

}
