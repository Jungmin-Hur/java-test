package me.duck.java.test;

public class TempTest {
    public static void main(String args[]) {
        int a = 1;
        int b = 5;
        System.out.println(a ^ b);
        System.out.println(a >> 1);
        System.out.println(b >> 1);
        System.out.println(b >> 2);
        System.out.println(a & 1);
        System.out.println(b + "," + (b & 1));
        System.out.println((b >> 1) + "," + ((b >> 1) & 1));
        System.out.println((b >> 2) + "," + ((b >> 2) & 1));
        System.out.println((b >> 3) + "," + ((b >> 3) & 1));

        //and test
        System.out.println("---------");
        System.out.println(0 & 1);
        System.out.println(1 & 1);
        System.out.println(2 & 1);
        System.out.println(3 & 1);
        System.out.println(4 & 1);
        System.out.println(5 & 1);
        System.out.println(6 & 1);
        System.out.println(7 & 1);
        System.out.println(8 & 1);
        System.out.println(9 & 1);
        System.out.println(10 & 1);

        System.out.println("---------");
        System.out.println(0 & 2);
        System.out.println(1 & 2);
        System.out.println(2 & 2);
        System.out.println(3 & 2);
        System.out.println(4 & 2);
        System.out.println(5 & 2);
        System.out.println(6 & 2);
        System.out.println(7 & 2);
        System.out.println(8 & 2);
        System.out.println(9 & 2);
        System.out.println(10 & 2);

        System.out.println("---------");
        System.out.println(0 & 3);
        System.out.println(1 & 3);
        System.out.println(2 & 3);
        System.out.println(3 & 3);
        System.out.println(4 & 3);
        System.out.println(5 & 3);
        System.out.println(6 & 3);
        System.out.println(7 & 3);
        System.out.println(8 & 3);
        System.out.println(9 & 3);
        System.out.println(10 & 3);
    }
}
