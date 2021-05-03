package me.duck.java.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 100,000개인 경우
 * useFor-> size:16667, time:12
 * useForeach-> size:16667, time:8
 * use1Filter-> size:16667, time:6
 * useParallelStreamFilter-> size:16667, time:12
 * use2Filters-> size:16667, time:6
 *
 * 10,000,000인 경우
 * useFor-> size:1666667, time:137
 * useForeach-> size:1666667, time:129
 * use1Filter-> size:1666667, time:117
 * useParallelStreamFilter-> size:1666667, time:117
 * use2Filters-> size:1666667, time:188
 *
 * 70,000,000인 경우
 * useFor-> size:11666667, time:2338
 * useForeach-> size:11666667, time:1819
 * use1Filter-> size:11666667, time:506
 * useParallelStreamFilter-> size:11666667, time:1730
 * use2Filters-> size:11666667, time:2352
 *
 */

/**
 * 1) stream은 반복문보다 빠르다.
 * 2) parallelStream은 병렬처리라서 반복문이나 stream보다 더 빠를 꺼 같지만 특정 상황에서 잘 써야 빠르다.
 * 3) 잘 모르겠으면 속도를 측정해보고 쓸지 말지 판단하라.
 *
 *
 * parallelStream을 써야 한다면 아래 내용은 꼭 고민하도록 하자.
 * - Stream Collection을 같이 쓸 때는 비용이 많이 든다.
 * - 적은 양의 데이터에서는 오버헤드가 있어서 실익이 없을 수도 있다.
 * - 박싱은 성능을 크게 저하시키므로 IntStream, LongStream, DoubleStream을 쓸 것을 고려하도록 해라.
 * - 순서에 의존하는 연산(limit, findFirst)는 비용이 많이 들 수 있다.
 * - filter는 효과적이지 않을 수도 있다. 그 이유는 stream의 길이를 예측할 수 없어서이다.
 * - 병렬처리에 생각보다 잘 안맞는 메소드가 있을 수 있으므로 꼭 시간을 측정해보자.
 */
public class streamCompareTest {
    public static void main(String args[]) {
        List<Integer> integerList = new ArrayList<>();
        for(int i=0; i<40000000; i++) {
            integerList.add(i);
        }

        long start = 0;
        long end = 0;
        List<Integer> res;

        start = System.currentTimeMillis();
        res = useFor(integerList);
        end = System.currentTimeMillis();
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
        res = useParallelStreamFilter(integerList);
        end = System.currentTimeMillis();
        System.out.println("useParallelStreamFilter-> size:" +  res.size() + ", time:" + (end-start));

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
        List<Integer> res = integerList
                .stream()
                .filter(i-> i % 2 == 0 && i % 3 == 0)
                .collect(Collectors.toList());
        return res;
    }

    // parallelStream() 인 경우, collect는 좋지 않은 성능을 가진다.
    // ArrayList, HashMap, HashSet, ConcurrentHashMap, Arrays, Int ranges, long ranges는 병렬처리에 적합함
    // redcution, min, max, count, sum anyMatch, allMatch, noneMatch는 병렬처리에 적합한 terminal operation이다.
    public static List<Integer> useParallelStreamFilter(List<Integer> integerList) {
        List<Integer> res = integerList
                .parallelStream()
                .filter(i-> i % 2 == 0 && i % 3 == 0)
                .collect(Collectors.toList());
        return res;
    }

    public static List<Integer> use2Filters(List<Integer> integerList) {
        List<Integer> res = integerList
                .stream()
                .filter(i-> i % 2 == 0)
                .filter(i -> i % 3 == 0)
                .collect(Collectors.toList());
        return res;
    }
}
