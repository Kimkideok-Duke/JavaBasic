package javaexp.a04_process;

public class A06_For {

    public static void main(String[] args) {
        /////////////////////////////////////////////////
        int i_sum;
        // ex1)
        i_sum = 200;
        for(int i = 100; i >= 90; i--) {
            System.out.print(i);
            if(i>90) System.out.print(" - ");
            else System.out.print(" = ");
            i_sum -= i;
        }
        System.out.println(i_sum);
        // ex2)
        for(int i = 1; i<=100; i++) {
            System.out.print(i+"\t");
            if(i%5 == 0) System.out.print("\n");
        }
        for(int i = 0; i<=10; i++) {
            System.out.print(i);
            if(i%2 == 0) System.out.print("(짝), ");
            else System.out.print("(홀), ");
        }
        System.out.println(" ");
    }

}
