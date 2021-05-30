package me.duck.java.test;

public class NTest {
    public static void main(String args[]) {
        System.out.println(solution("azABaabza"));
    }

    public static int solution(String S) {
        int[] low = new int[26];
        int[] upper = new int[26];

        int res = Integer.MAX_VALUE;

        for(int start=0; start<S.length(); start++) {
            char startChar = S.charAt(start);
            if(startChar >= 'a') {
                low[startChar-'a']++;
            } else {
                upper[startChar-'A']++;
            }

            for(int end=start+1; end<S.length(); end++) {
                char endChar = S.charAt(end);

                if(endChar >= 'a') {
                    low[endChar-'a']++;
                } else {
                    upper[endChar-'A']++;
                }

                if(isBalancedFragment(low, upper)) {
                    int size = end-start;
                    if(size < res) res = size;
                }
            }
        }
        return res==Integer.MAX_VALUE ? -1 : res;
    }

    public static boolean isBalancedFragment(int[] low, int[] upper) {
        for(int i=0; i<26; i++) {
            if(low[i]==0 && upper[i]>0) return false;
            if(low[i]>0 && upper[i]==0) return false;
        }
        return true;
    }
}
