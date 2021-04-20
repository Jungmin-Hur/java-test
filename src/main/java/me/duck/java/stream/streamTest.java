package me.duck.java.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class streamTest {
    public static void main(String args[]) {
        List<List<String>> list = new ArrayList<>();
        list.add(Arrays.asList("a1","b1"));
        list.add(Arrays.asList("a2","b2"));
        list.add(Arrays.asList("a3","b3"));
        list.add(Arrays.asList("a4","b4"));
        list.add(Arrays.asList("a5","b5"));

        // 두코드의 결과가 같음
        extractStringList(list);
        extractStringListWithStream(list);
    }

    public static void extractStringList(List<List<String>> list) {
        List<List<String>> subList = list.subList(2, 4);
        List<String> res = new ArrayList<>();
        for (List<String> item : subList) {
            res.add(item.get(0));
        }
        System.out.println(res);
    }

    public static void extractStringListWithStream(List<List<String>> list) {
        List<String> res = list.subList(2, 4).stream().map(item -> item.get(0)).collect(Collectors.toList());
        System.out.println(res);
    }
}
