package javaexp.a04_process;

import java.util.Scanner;

public class A09_while {
	
	public static void main(String[] args) {
        /**
        # while문을 통한 반복 처리
        1. while문은 반복여부를 처리하는 boolean값을 기준으로 반복수행을 처리한다.
        2. 기본 형식
            1) 기본
            while(반복조건){
                반복수행할 내용
            }
            2) 입력값에 따라 반복 처리
            while(true) {   // 무한반복
                ck = sc.nextLine();
                if(ck.equals("Q")) {    // Q를 입력했을 때, 반복 수행을 중단 처리.
                    break;
                }
            }
         */
        int cnt = 1;
        while(cnt<=10) { // 10이하까지 반복
            System.out.println("카운트 : " + (cnt++));
        }

        // ex)
        cnt = 100;
        while(cnt >= 70){
            System.out.println(cnt);
            cnt-=2;
        }
        Scanner sc = new Scanner(System.in);
        System.out.println("어서오세요!!");
        cnt = 1;
        // while(true) {
        //     System.out.println("주문할 메뉴를 입력하고, 종료시 Q를 입력하세요.");
        //     String menu = sc.nextLine();
        //     if(menu.equals("Q")) {
        //         System.out.println("주문이 완료되었습니다.");
        //         break;
        //     }
        //     System.out.println(cnt++ + "번째 주문 메뉴 : " + menu);
        // }
        // ex1)
        // while(true) {
        //     System.out.println("구매할 물건의 가격을 입력하세요");
        //     float prod = (float)Integer.parseInt(sc.nextLine());
        //     if(prod == -1) break;
        //     System.out.println("가격은 " + (int)prod);
        // }tv04
        // ex2)
        int user;
        while(true) {
            System.out.print("회원명을 입력하세요 : ");
            String name = sc.nextLine();
            if(name.equals("Q")) break;
            System.out.println("회원번호\t회원명");
            for(user = 0; user<cnt; user++)
                System.out.println(cnt + "\t\t" + name);
            cnt++;
        }
    }

}
