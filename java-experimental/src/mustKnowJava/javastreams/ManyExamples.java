package mustKnowJava.javastreams;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ManyExamples {

    @Test
    public void whenFindMaxOnIntStream_thenGetMaxInteger() {
        List<Integer> ids = Arrays.asList(3, 1, 5,2);

        Integer latestEmpId = ids.stream()
                .mapToInt(id -> id)
                .max()
               .orElseThrow(NoSuchElementException::new);

        assertEquals(latestEmpId, 5);
    }

}
