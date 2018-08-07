package homo.efficio.java8.stream;

import org.junit.Before;
import org.junit.Test;

import java.util.*;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.summingLong;
import static java.util.stream.Collectors.toList;
import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author homo.efficio@gmail.com
 * Created on 2018-08-07.
 */
public class GroupingByTest {

    class DateAndCount {
        private String yyyymmdd;
        private Long count;

        public DateAndCount(String yyyymmdd, Long count) {
            this.yyyymmdd = yyyymmdd;
            this.count = count;
        }
    }

    private List<DateAndCount> dateAndCounts =
            Arrays.asList(
                    new DateAndCount("2018080101", 1L)
                    , new DateAndCount("2018080102", 3L)
                    , new DateAndCount("2018080103", 5L)
                    , new DateAndCount("2018080104", 7L)
                    , new DateAndCount("2018080105", 9L)
                    , new DateAndCount("2018080201", 2L)
                    , new DateAndCount("2018080202", 4L)
                    , new DateAndCount("2018080203", 6L)
                    , new DateAndCount("2018080204", 8L)
                    , new DateAndCount("2018080205", 10L)
            );
    // 이걸
    // Arrays.asList(
    //     new DateAndCount("20180801", 25L),
    //     new DateAndCount("20180802", 30L)
    // )
    // 로 만들기


    @Test
    public void whenForLoop__thenSimpleCode() {
        final Map<String, Long> dateAndCountByDateMap = new LinkedHashMap<>();
        for (DateAndCount dnc: this.dateAndCounts) {
            dateAndCountByDateMap.merge(dnc.yyyymmdd.substring(0, 8), dnc.count, (a, b) -> a + b);
        }
        final ArrayList<DateAndCount> results = new ArrayList<>();
        for (Map.Entry<String, Long> entry: dateAndCountByDateMap.entrySet()) {
            results.add(new DateAndCount(entry.getKey(), entry.getValue()));
        }

        assertThat(results.size()).isEqualTo(2);
        assertThat(results.get(0).yyyymmdd).isEqualTo("20180801");
        assertThat(results.get(0).count).isEqualTo(25L);
        assertThat(results.get(1).yyyymmdd).isEqualTo("20180802");
        assertThat(results.get(1).count).isEqualTo(30L);
    }

    @Test
    public void whenStreamingWithUglyGroupingBy__thenUglyCode() {
        final List<DateAndCount> results = this.dateAndCounts.stream()
                .collect(groupingBy(dnc -> dnc.yyyymmdd.substring(0, 8)))
                .entrySet()
                .stream()
                .sorted(Map.Entry.<String, List<DateAndCount>>comparingByKey())
                .map(entry -> {
                    long sumByDate = entry.getValue().stream()
                            .map(dnc -> dnc.count)
                            .reduce((a, b) -> a + b)
                            .orElse(0L);
                    return new DateAndCount(entry.getKey(), sumByDate);
                })
                .collect(toList());

        assertThat(results.size()).isEqualTo(2);
        assertThat(results.get(0).yyyymmdd).isEqualTo("20180801");
        assertThat(results.get(0).count).isEqualTo(25L);
        assertThat(results.get(1).yyyymmdd).isEqualTo("20180802");
        assertThat(results.get(1).count).isEqualTo(30L);
    }

    @Test
    public void whenStreamingWithGoodGroupingBy__thenSimpleCode() {
        final List<DateAndCount> results = this.dateAndCounts.stream()
                .collect(groupingBy(dnc -> dnc.yyyymmdd.substring(0, 8), LinkedHashMap::new, summingLong(dnc -> dnc.count)))
                .entrySet()
                .stream()
                .map(entry -> new DateAndCount(entry.getKey(), entry.getValue()))
                .collect(toList());

        assertThat(results.size()).isEqualTo(2);
        assertThat(results.get(0).yyyymmdd).isEqualTo("20180801");
        assertThat(results.get(0).count).isEqualTo(25L);
        assertThat(results.get(1).yyyymmdd).isEqualTo("20180802");
        assertThat(results.get(1).count).isEqualTo(30L);
    }
}
