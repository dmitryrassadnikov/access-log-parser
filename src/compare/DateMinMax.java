package compare;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DateMinMax {
    public static void main(String [] args) {
        List<LocalDateTime> dates = new ArrayList<>();
        // Добавление дат в список
      /*  dates.add(LocalDateTime.of(2022, 09, 26, 12, 30));
        dates.add(LocalDateTime.of(2022, 09, 27, 13, 00));
        dates.add(LocalDateTime.of(2022, 09, 28, 13, 30));
*/
        LocalDateTime minDate = Collections.min(dates);
        LocalDateTime maxDate = Collections.max(dates);

        System.out.println("Минимальная дата: " + minDate);
        System.out.println("Максимальная дата: " + maxDate);
    }
}

