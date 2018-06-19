package homo.efficio.java8.time;

import org.junit.Test;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author homo.efficio@gmail.com
 * created on 2018-06-19
 */
public class LocalDateTimeTest {

    @Test
    public void local_date_time_00_second_fail() throws Exception {

        String expectedZeroSec = "2018-03-03T05:05:00";

        LocalDateTime actualZeroSecLdt = LocalDateTime.parse(expectedZeroSec, DateTimeFormatter.ISO_LOCAL_DATE_TIME);

        assertThat(actualZeroSecLdt.withNano(0).toString()).isEqualTo(expectedZeroSec);
    }

    @Test
    public void local_date_time_00_second_pass() throws Exception {

        String expectedZeroSec = "2018-03-03T05:05:00";

        LocalDateTime actualZeroSecLdt = LocalDateTime.parse(expectedZeroSec, DateTimeFormatter.ISO_LOCAL_DATE_TIME);

        String actualZeroSec = DateTimeFormatter.ISO_LOCAL_DATE_TIME.format(actualZeroSecLdt);

        assertThat(actualZeroSec).isEqualTo(expectedZeroSec);
    }
}
