package homo.efficio.java8.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author omwomw@sk.com
 *         created on 2016. 11. 29.
 */
public class FlatMapTest {

    public static void main(String[] args) {

        List<Integer> ints1 = Arrays.asList(1, 2, 3);
        List<Integer> ints2 = Arrays.asList(7, 8);

        List<int[]> pairs = ints1.stream()
                .flatMap(
                        i -> ints2.stream()
                                .map(j -> new int[]{i, j})
                ).collect(Collectors.toList());

        pairs
                .forEach(pair -> System.out.println(String.format("(%d, %d)", pair[0], pair[1])));
    }

}
