package me.duck.java.test;

//최적화 필요함
public class NTest2 {
    class Solution {
        public int solution(String S) {
            int[] lower = new int[26];
            int[] upper = new int[26];

            int res = Integer.MAX_VALUE;

            for(int start=0; start<S.length(); start++) {
                char startChar = S.charAt(start);
                if(startChar >= 'a') {
                    lower[startChar-'a']++;
                } else {
                    upper[startChar-'A']++;
                }

                for(int end=start+1; end<S.length(); end++) {
                    char endChar = S.charAt(end);

                    if(endChar >= 'a') {
                        lower[endChar-'a']++;
                    } else {
                        upper[endChar-'A']++;
                    }

                    if(isBalancedFragment(lower, upper)) {
                        int size = end-start+1;
                        if(size < res) res = size;
                    }
                }
                for(int i=0; i<26; i++) {
                    lower[i]=0;
                    upper[i]=0;
                }
            }
            return res==Integer.MAX_VALUE ? -1 : res;
        }

        public boolean isBalancedFragment(int[] lower, int[] upper) {
            for(int i=0; i<26; i++) {
                if(lower[i]==0 && upper[i]>0) return false;
                if(lower[i]>0 && upper[i]==0) return false;
            }
            return true;
        }
    }

}


//class Solution {
//    int solution(int[] A, int K) {
//        int n = A.length;
//        int best = 0;
//        int count = 1;
//        for (int i = A.length-1; i > 0; i--) {
//            if (A[i] == A[i - 1])
//                count = count + 1;
//            else
//                count = 0;
//
//            int add = (A.length-i) < K ? (A.length-i) : K;
//            i = i - count;
//            count = count + add;
//
//            //나랑 같은 애덜 + 나보다 큰 애덜을 해
//            //나보다 큰 애덜이 k보다 크면?
//            count + (i+1);
//            if (count > best)
//                best = count;
//        }
//        int result = best + 1 + K;
//
//        return result;
//    }
//}
