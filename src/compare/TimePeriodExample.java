package compare;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.Period;

public class TimePeriodExample {
    public static void main(String[] args) {
        LocalDateTime startDateTime = LocalDateTime.now();
        LocalDateTime endDateTime = LocalDateTime.now().plusHours(1);

        Period period = Period.between(startDateTime.toLocalDate(), endDateTime.toLocalDate());
        Duration duration = Duration.between(startDateTime.toLocalTime(), endDateTime.toLocalTime());
        System.out.println(duration.toHours());
     /*   System.out.printf("Период между датами: %d дней, %d часов, %d минут, %d секунд%n",
                period.getDays())*//*, period.getHours(), period.getMinutes(), period.getSeconds())*//*;
        System.out.printf("Длительность между временем: %d часов, %d минут, %d секунд%n",
                duration.toHours(), duration.toMinutes(), duration.toSeconds());*/
    }
}

