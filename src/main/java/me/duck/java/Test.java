package me.duck.java;

public class Test {

    public static void main(String args[]) {

        int n = 10;

        //q1
        System.out.println(fibo(n));

        //q2
        int val[] = new int[n + 1];
        val[1] = 1;
        val[2] = 1;
        val[3] = 1;
        for(int i=4; i<=n; i++) {
            val[i] = val[i-2] + val[i-3];
        }
        System.out.println(val[n]);

        //q3
        //f(1) 1
        //2 1
        //3 1
        //4 1+2==>2
        //5 2+3==>2
        //6 3+4==>3
        //7 4+5==>4
        //8 5+6==>5
        //9 6+7==>6
        //10 7+8==>9
        int val_pre3 = 1;
        int val_pre2 = 1;
        int val_pre1 = 1;
        int res = 0;
        for(int i=4; i<=n; i++) {
            res = val_pre1 + val_pre2;
            val_pre1 = val_pre2;
            val_pre2 = val_pre3;
            val_pre3 = res;
        }
        System.out.println(res);
    }

    public static int fibo(int n) {
        if(n == 1 || n == 2 || n == 3) return 1;
        return fibo(n-2) + fibo(n-3);
    }
}
