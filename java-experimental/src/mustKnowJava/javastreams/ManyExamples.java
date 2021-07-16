package mustKnowJava.javastreams;

import org.junit.jupiter.api.Test;

import java.lang.reflect.InvocationTargetException;
import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ManyExamples {

    @Test
    public void whenFindMaxOnIntStream_thenGetMaxInteger() {
        List<Integer> ids = Arrays.asList(3, 1, 5, 2);

        Integer latestEmpId = ids.stream()
                .mapToInt(id -> id)
                .max()
                .orElseThrow(NoSuchElementException::new);

        assertEquals(latestEmpId, 5);
    }

    @Test
    public void shouldGetMaxEmpById() {
        Integer id = getEmployeeById().stream()
                .mapToInt(emp -> emp.id)
                .max()
                .orElseThrow(NoSuchElementException::new);

        assertEquals(id, 3);

        // with objs
        Employee res = getEmployeeById()
                .stream()
                .max(Comparator.comparing(emp -> emp.id))
                .orElseThrow(NoClassDefFoundError::new);
        assertEquals(id, res.id);
    }

    @Test
    public void reflection() {
        try {
            Class<?> myClass = Class.forName("mustKnowJava.javastreams.ManyExamples");

            ManyExamples reflected = (ManyExamples) myClass.getConstructor().newInstance();

            reflected.getEmployeeById();

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }

    private List<Employee> getEmployeeById() {
        List<Employee> list = new ArrayList<>();
        list.add(new Employee("Ian", 1));
        list.add(new Employee("Dan", 3));
        list.add(new Employee("Ema", 2));
        return list;
    }

    class Employee {
        private String name;
        private Integer id;

        Employee(String name, Integer id) {
            this.id = id;
            this.name = name;
        }

    }

}
