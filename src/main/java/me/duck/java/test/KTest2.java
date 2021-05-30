package me.duck.java.test;

public class KTest2 {
    public static long[] val;
    public static double[] val_um;

    public static void main(String args[]) {
        val = new long[10];
        val[0] = 1;
        for(int i=1; i<10; i++) {
            val[i] = val[i-1] * 10;
        }
        val_um = new double[10];
        val_um[0] = 0.1;
        for(int i=1; i<10; i++) {
            val_um[i] = val_um[i-1] * 0.1;
        }

        String input = "123";
        long longResult = atoi(0, input, 0);
        System.out.println(longResult);

        input = "123.456";
        String str[] = input.split("[.]");
        double doubleResult = atoi(0, str[0], 0) * 1.0 + atoi_um(0, str[1], str[1].length()-1);
        System.out.println(doubleResult);
    }

    public static long atoi(long res, String str, int i) {
        res = res + (str.charAt(i) - '0') * val[str.length()-1-i];
        if(i == str.length()-1) {
            return res;
        }
        return atoi(res, str, i+1);
    }

    public static double atoi_um(double res, String str, int i) {
        res = res + (str.charAt(i) - '0') * val_um[i];
        if(i == 0) {
            return res;
        }
        return atoi_um(res, str, i-1);
    }

    //'123'
    public static long atoi2(String str) {
        long res = 0;
        int position = str.length()-1;
        for(char c : str.toCharArray()) {
            int n = c - '0';
            res = res + n * val[position];
            position--;
        }
        return res;
    }
}
