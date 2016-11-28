package homo.efficio.java8.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author omwomw@sk.com
 *         created on 2016. 11. 29.
 */
public class OnePipelineTest {

    public static void main(String[] args) {

        List<String> sList = Arrays.asList(
                "I", "am", "studying", "Java8", "in","a", "bus", "from", "scratch"
        );

        Stream<String> stream = sList.stream()
                .filter(s -> {
                    System.out.println("filter-----");
                    System.out.println(s);
                    return s.length() > 3;
                })
                .map(s -> {
                    System.out.println("            map=======");
                    System.out.println("            " + s);
                    return s.toUpperCase();
                });
        System.out.println(stream.collect(Collectors.toList()));

        // filter를 처음부터 끝까지 다 돌고 나서 통과한 것들에 대해서만 map을 적용하는 것이 아니라
        // filter와 map이 하나의 파이프라인으로서 모든 원소에 대해 적용된다.
        // 외부 반복에서 반복 돌 때마다 if () { if () { ... 식으로 중첩되는 것과 같다.
    }
}
