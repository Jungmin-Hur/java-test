package me.duck.java.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 총 테스트대상갯수 70000000건
 * useFor-> size:11666667, time:1250
 * useForeach-> size:11666667, time:3535
 * use1Filter-> size:11666667, time:589
 * use2Filters-> size:11666667, time:2346
 */
public class streamCompareTest {
    public static void main(String args[]) {
        List<Integer> integerList = new ArrayList<>();
        for(int i=0; i<70000000; i++) {
            integerList.add(i);
        }

        long start = System.currentTimeMillis();
        List<Integer> res = useFor(integerList);
        long end = System.currentTimeMillis();
        System.out.println("useFor-> size:" +  res.size() + ", time:" + (end-start));

        start = System.currentTimeMillis();
        res = useForeach(integerList);
        end = System.currentTimeMillis();
        System.out.println("useForeach-> size:" +  res.size() + ", time:" + (end-start));

        start = System.currentTimeMillis();
        res = use1Filter(integerList);
        end = System.currentTimeMillis();
        System.out.println("use1Filter-> size:" +  res.size() + ", time:" + (end-start));

        start = System.currentTimeMillis();
        res = use2Filters(integerList);
        end = System.currentTimeMillis();
        System.out.println("use2Filters-> size:" +  res.size() + ", time:" + (end-start));
    }

    public static List<Integer> useFor(List<Integer> integerList) {
        List<Integer> res = new ArrayList<>();
        for(int i : integerList) {
            if(i % 2 == 0 && i % 3 == 0) {
                res.add(i);
            }
        }
        return res;
    }

    public static List<Integer> useForeach(List<Integer> integerList) {
        List<Integer> res = new ArrayList<>();
        integerList.forEach(i -> {
            if(i % 2 == 0 && i % 3 == 0) {
                res.add(i);
            }
        });
        return res;
    }

    public static List<Integer> use1Filter(List<Integer> integerList) {
        List<Integer> res = integerList.stream().filter(i-> i % 2 == 0 && i % 3 == 0).collect(Collectors.toList());
        return res;
    }

    public static List<Integer> use2Filters(List<Integer> integerList) {
        List<Integer> res = integerList.stream().filter(i-> i % 2 == 0).filter(i -> i % 3 == 0).collect(Collectors.toList());
        return res;
    }
}
