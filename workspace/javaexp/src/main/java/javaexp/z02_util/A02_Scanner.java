package javaexp.z02_util;

import java.util.Scanner;

public class A02_Scanner {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("구매할 과일명을 입력해주세요");
        String fr_name  = sc.nextLine();
        System.out.println("구매할 과일갯수를 입력해주세요");
        String fr_cnt  = sc.nextLine();
        System.out.println("과일명 : " + fr_name + ", 갯수 : " + fr_cnt + "개");
        
    }
}
