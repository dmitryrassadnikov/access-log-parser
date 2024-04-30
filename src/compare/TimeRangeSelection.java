package compare;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

public class TimeRangeSelection {
    private List<LocalDateTime> timeRange;

    public TimeRangeSelection(List<LocalDateTime> times) {
        this.timeRange = times;
    }

    public List<LocalDateTime> getHourRange(int hourStart, int hourEnd) {
        List<LocalDateTime> result = new ArrayList<>();
        for (LocalDateTime time : timeRange) {
            if (time.getHour() >= hourStart && time.getHour() <= hourEnd) {
                result.add(time);
            }
        }
        return result;
    }
    public static void main(String[] args) {
        // Пример данных
        List<LocalDateTime> timeRange = new ArrayList<>();
        timeRange.add(LocalDateTime.of(2024, 4, 29, 10, 0)); // 10:00
        timeRange.add(LocalDateTime.of(2024, 4, 29, 11, 0)); // 11:00
        timeRange.add(LocalDateTime.of(2024, 4, 29, 12, 0)); // 12:00
        timeRange.add(LocalDateTime.of(2024, 4, 29, 13, 0)); // 13:00
        timeRange.add(LocalDateTime.of(2024, 4, 29, 14, 0)); // 14:00
        timeRange.add(LocalDateTime.of(2024, 4, 29, 15, 0)); // 15:00
        timeRange.add(LocalDateTime.of(2024, 4, 29, 16, 0)); // 16:00
        timeRange.add(LocalDateTime.of(2024, 4, 29, 17, 0)); // 17:00
        timeRange.add(LocalDateTime.of(2024, 4, 29, 18, 0)); // 18:00
        timeRange.add(LocalDateTime.of(2024, 4, 29, 19, 0)); // 19:00

        // Создаем объект TimeRangeSelection
        TimeRangeSelection selection = new TimeRangeSelection(timeRange);

        // Получаем диапазон в 1 час, начиная с 15:00 и заканчивая 16:00
        List<LocalDateTime> selectedTimes = selection.getHourRange(15, 16);

        // Выводим результат
        System.out.println("Выбранные времена:");
        for (LocalDateTime time : selectedTimes) {
            System.out.println(time);
        }
    }

}

