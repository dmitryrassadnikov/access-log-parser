package compare;

import java.time.Duration;
import java.time.LocalDateTime;

public class TimeDifferenceExample {
    public static void main(String[] args) {
        LocalDateTime startDateTime = LocalDateTime.parse("2022-09-23T06:25:14");
        LocalDateTime endDateTime = LocalDateTime.parse("2022-09-26T09:12:09");

        Duration duration = Duration.between(startDateTime, endDateTime);
        long hours = duration.toHours();
        System.out.println("Начало отсчета: " + startDateTime);
        System.out.println("Конец отсчета: " + endDateTime);
        System.out.printf("Разница во времени: %d часов%n", hours);
    }
}


