package homo.efficio.java8.concurrent;

import org.junit.Before;
import org.junit.Test;

import java.util.concurrent.ConcurrentSkipListMap;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author homo.efficio@gmail.com
 * created on 2018-04-06
 */
public class ConcurrentSkipListMapTest {

    ConcurrentSkipListMap<Long, Long> asks;

    @Before
    public void setup() throws Exception {
        this.asks = new ConcurrentSkipListMap<>();
//        this.asks.put(82000L, 30L);
//        this.asks.put(81000L, 20L);
        this.asks.put(80000L, 20L);
    }

    @Test
    public void firstKey_lastKey() {
        System.out.println("firstkey: " + this.asks.firstKey());
        System.out.println("lastkey: " + this.asks.lastKey());
        System.out.println("ceilingKey(80500): " + this.asks.ceilingKey(80500L));
        System.out.println("floorKey(80500): " + this.asks.floorKey(80500L));
    }

    @Test
    public void getindex() {
        String name = "prod_user_parquet_13";
        assertThat(name.substring(name.lastIndexOf("_") + 1)).isEqualTo("13");
    }
}
