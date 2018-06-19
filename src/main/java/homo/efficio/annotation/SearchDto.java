package homo.efficio.annotation;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

/**
 * @author homo.efficio@gmail.com
 * created on 2018-04-04
 */
@Getter
@Setter
@MostSearchPeriod
public class SearchDto implements ValidPeriod {

    @NotNull(message = "keyword가 명시되어야 합니다.")
    private String keyword;

    @NotNull(message = "기간 시작 일자가 명시되어야 합니다.")
    @Pattern(regexp = "\\d{4}[0-1]\\d[0-3]\\d", message = "startDate는 yyyymmdd 형식이어야 합니다.")
    private String startDate;

    @NotNull(message = "기간 종료 일자가 명시되어야 합니다.")
    @Pattern(regexp = "\\d{4}[0-1]\\d[0-3]\\d", message = "endDate는 yyyymmdd 형식이어야 합니다.")
    private String endDate;

    @Override
    public boolean isValidPeriod() {
        long startDate = Long.valueOf(this.startDate);
        long endDate = Long.valueOf(this.endDate);

        return (endDate - startDate) <= 30 && (endDate - startDate) >= 0;
    }
}



