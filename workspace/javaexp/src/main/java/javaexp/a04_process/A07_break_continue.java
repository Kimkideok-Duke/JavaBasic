package javaexp.a04_process;

public class A07_break_continue {

    public static void main(String[] args) {
        // ex1)
        int i, cnt = 1;
        i=7;
        while(cnt<=9){
            System.out.println(i+" * "+cnt+" = " + i*cnt);
            if(cnt == 7) break;
            cnt++;
        }
        // ex2)
        int sum = 0;
        for(i=1;i<=12;i++) {
            if(i==5) continue;
            sum += 32000;
            System.out.println(i+"월\t"+"32000\t"+sum);
        }
    }
}
