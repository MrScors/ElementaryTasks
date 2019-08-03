package main.java.career.softserveinc.com.softserve.model.task3;

import main.java.career.softserveinc.com.softserve.model.task2.Task2Arguments;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class Task3ArgumentsTest {


    @Test
    void addTestStringGiven(){
        Task3Arguments task3Arguments = new Task3Arguments();
        boolean actual = task3Arguments.add("name,7,7,7");
        assertTrue(actual);
    }

    @Test
    void addTestInvalidStringGiven(){
        Task3Arguments task3Arguments = new Task3Arguments();
        boolean actual = task3Arguments.add("name,7,7m7,7");
        assertFalse(actual);
    }

    @Test
    void addTestStringsGiven(){
        Task3Arguments task3Arguments = new Task3Arguments();
        boolean actual = task3Arguments.add(new String[]{"name,7,7,7", "name,9,9,9"});
        assertTrue(actual);
    }

    @Test
    void addTestPartlyInvalidStringsGiven(){
        Task3Arguments task3Arguments = new Task3Arguments();
        boolean actual = task3Arguments.add(new String[]{"name,7,7,7","name,fff9,9,9"});
        assertFalse(actual);
    }

    @Test
    void addTestInvalidStringsGiven(){
        Task3Arguments task3Arguments = new Task3Arguments();
        boolean actual = task3Arguments.add(new String[]{"name,7,7,fh","name,fff9,9,9"});
        assertFalse(actual);
    }

    @Test
    void getArgsTestStringGiven() {
        Task3Arguments task3Arguments = new Task3Arguments("name,7,7,7");
        List<Triangle> actual = task3Arguments.getArgs();
        List<Triangle> expected = new ArrayList<>();
        expected.add(new Triangle("name", 7, 7,7));
        assertEquals(expected.toString(), actual.toString());
    }

    @Test
    void getArgsTestInvalidStringGiven() {
        Task3Arguments task3Arguments = new Task3Arguments("name,7,7");
        List<Triangle> actual = task3Arguments.getArgs();
        assertEquals("[]", actual.toString());
    }

    @Test
    void getArgsTestStringArgsGiven() {
        Task3Arguments task3Arguments = new Task3Arguments(new String[]{"name,7,7,7","name,9,9,9"});
        List<Triangle> actual = task3Arguments.getArgs();
        List<Triangle> expected = new ArrayList<>();
        expected.add(new Triangle("name", 7, 7,7));
        expected.add(new Triangle("name", 9, 9,9));
        assertEquals(expected.toString(), actual.toString());
    }

    @Test
    void getArgsTestPartlyInvalidStringArgsGiven() {
        Task3Arguments task3Arguments = new Task3Arguments(new String[]{"name,7,7,,,","name,9,9,9"});
        List<Triangle> actual = task3Arguments.getArgs();
        List<Triangle> expected = new ArrayList<>();
        expected.add(new Triangle("name", 9, 9,9));
        assertEquals(expected.toString(), actual.toString());
    }

    @Test
    void getArgsTestInvalidStringArgsGiven() {
        Task3Arguments task3Arguments = new Task3Arguments(new String[]{"name,7,7,,,","naml,.,,,9,9,...,9"});
        List<Triangle> actual = task3Arguments.getArgs();
        assertEquals("[]", actual.toString());
    }

}