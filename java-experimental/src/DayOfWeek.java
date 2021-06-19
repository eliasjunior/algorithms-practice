import java.time.LocalDate;
import java.util.Date;

public class DayOfWeek {
    String [] weekDays = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};

    public String dayOfTheWeek(int day, int month, int year) {
//        LocalDate.now().getYear();
//        LocalDate now = LocalDate.now();
//        int curYear = now.getYear();
//        int curMonth = now.getMonth();


         return weekDays[LocalDate.of(year, month, day).getDayOfWeek().getValue()];
    }
}
