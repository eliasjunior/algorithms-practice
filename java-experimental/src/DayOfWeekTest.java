import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DayOfWeekTest {

    @Test
    public void testDayOfWeek() {
        DayOfWeek dayOfWeek = new DayOfWeek();
        assertEquals(dayOfWeek.weekDays[6], dayOfWeek.dayOfTheWeek(5, 6, 2021));
        assertEquals(dayOfWeek.weekDays[6], dayOfWeek.dayOfTheWeek(31, 8, 2019));
    }

}