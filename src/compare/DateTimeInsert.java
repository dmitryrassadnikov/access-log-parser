package compare;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class DateTimeInsert {
    public static void main(String[] args) {
        LocalDateTime[] datesArray = {LocalDateTime.now(), LocalDateTime.now().plusDays(1), LocalDateTime.now().plusDays(2)};
        List<LocalDateTime> dates = new ArrayList<>(datesArray.length);

        for (LocalDateTime date : datesArray) {
            dates.add(date);
        }

        System.out.println(dates);
    }
}

