package main.java.career.softserveinc.com.softserve.model.task4;

import main.java.career.softserveinc.com.softserve.model.task3.Task3Arguments;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Task4ArgumentsTest {

    @ParameterizedTest
    @ValueSource(strings = {"name,7,7,7, true",
            "name,7,7,2fdsh, false",
            "name,7,7,2222, false",
            "name,7,7,7, name,9,9,9, true",
            "name,7,7,7, name,9,9,dfg9, false",
            "name,7,7,7, name,9,9,9999, false",
            "name,9,239,9, name,sdf9,9,9, false"})
    void addParametrizedTestReturnValue(String string) {
        String[] splintedArgs = string.split(", ");
        String[] splintedActualArgs = new String[splintedArgs.length-1];
        System.arraycopy(splintedArgs, 0, splintedActualArgs, 0, splintedActualArgs.length);
        Task4Arguments args = new Task4Arguments();
        boolean actual = args.add(splintedActualArgs);
        boolean expected = Boolean.parseBoolean(splintedArgs[splintedArgs.length-1]);
        assertEquals(expected, actual);
    }

    @ParameterizedTest
    @ValueSource(strings = {"name,7,7,7, 1",
            "name,7,7,2fdsh, 0",
            "name,7,7,2222, 0",
            "name,7,7,7, name,9,9,9, 2",
            "name,7,7,7, name,9,9,dfg9, 1",
            "name,7,7,7, name,9,9,9999, 1",
            "name,9,239,9, name,sdf9,9,9, 0"})
    void addParametrizedTestWorkingOrNot(String string) { // we use add() to add new Triangles
        String[] splintedArgs = string.split(", ");
        Task3Arguments args = new Task3Arguments();
        for (int i = 0; i < splintedArgs.length-1; i++) args.add(splintedArgs[i]);
        int actual = args.getArgs().size();
        int expected = Integer.parseInt(splintedArgs[splintedArgs.length-1]);
        assertEquals(expected, actual);
    }

    @ParameterizedTest
    @ValueSource(strings = {"name,7,7,7, 1",
            "name,7,7,2fdsh, 0",
            "name,7,7,2222, 0",
            "name,7,7,7, name,9,9,9, 2",
            "name,7,7,7, name,9,9,dfg9, 1",
            "name,7,7,7, name,9,9,9999, 1",
            "name,9,239,9, name,sdf9,9,9, 0"})
    void getArgsParametrizedTest(String string) { // we use constructor to add Triangles
        String[] splintedArgs = string.split(", ");
        String[] splintedActualArgs = new String[splintedArgs.length-1];
        System.arraycopy(splintedArgs, 0, splintedActualArgs, 0, splintedActualArgs.length);
        Task3Arguments args = new Task3Arguments(splintedActualArgs);
        int actual = args.getArgs().size();
        int expected = Integer.parseInt(splintedArgs[splintedArgs.length-1]);
        assertEquals(expected, actual);
    }
}