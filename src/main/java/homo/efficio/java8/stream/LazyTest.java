package homo.efficio.java8.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author omwomw@sk.com
 *         created on 2016. 11. 29.
 */
public class LazyTest {

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

        // 외부 반복은 resultList.add()를 하지 않아도 sourceList의 원소에 대한 루핑을 탄다.
        // 내부 반복은 최종 연산을 실행하지 않으면 중간 연산은 파이프라인만 구성할 뿐 루핑은 돌지 않는다
    }
}
