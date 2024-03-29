package main.java.career.softserveinc.com.softserve.model.task4;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.Mockito;

import static org.mockito.Mockito.*;

import java.io.BufferedReader;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class FileManagerTest {
    private static final int OLD_STRING_INDEX = 0;
    private static final int NEW_STRING_INDEX = 1;
    private static final int OLD_FILE_CONTENT_INDEX = 2;
    private static final int NEW_FILE_CONTENT_INDEX = 3;

    private static final String param1 = "test;" +
            "NOT_A_TEST;" +
            "tsts\ntest\nt\ne\ns\nt\ntest tesst tettsetest\nt\nest;";
    private static final String param2 = "interfaces;" +
            "INTERFACES;" +
            "   The core collection interfaces encapsulate different types of collections,\n" +
            "which are shown in the figure below. These interfaces allow collections to be manipulated\n" +
            "independently of the details of their representation. Core collection interfaces are\n" +
            "the foundation of the Java Collections Framework. As you can see in the \n" +
            "following figure, the core collection interfaces form a hierarchy.;";
    private static final String param3 = "anonymous class;" +
            "ANONYMOUS CLASS;"+
            "   One issue with anonymous classes is that if the implementation of your anonymous\n" +
            "class is very simple, such as an interface that contains only one method, then the\n" +
            "syntax of anonymous classes may seem unwieldy and unclear. In these cases,\n" +
            "you're usually trying to pass functionality as an argument to another method,\n" +
            "such as what action should be taken when someone clicks a button. Lambda\n" +
            "expressions enable you to do this, to treat functionality as method argument, or\n" +
            "code as data.;";

    @ParameterizedTest
    @ValueSource(strings = {param1 + "5", param2 + "4", param3 + "3"})

    void countNumberOfSubstringsParametrizedTest(String string) throws IOException {
        String[] splintedParams = string.split(";");
        BufferedReader mockedBufferedReader = Mockito.mock(BufferedReader.class);
        when(mockedBufferedReader.readLine()).thenReturn(splintedParams[OLD_FILE_CONTENT_INDEX]).thenReturn(null);
        FileManager fm = new FileManager("resources/testingSugar.txt", mockedBufferedReader);
        int actual = fm.countNumberOfSubstrings(splintedParams[OLD_STRING_INDEX]);
        int expected = Integer.parseInt(splintedParams[NEW_FILE_CONTENT_INDEX]);
        assertEquals(expected, actual);
    }

    @ParameterizedTest
    @ValueSource(strings = {param1  +
            "tsts\nNOT_A_TEST\nt\ne\ns\nt\nNOT_A_TEST tesst tettseNOT_A_TEST\nt\nest",
            param2 + "   The core collection INTERFACES encapsulate different types of collections,\n" +
            "which are shown in the figure below. These INTERFACES allow collections to be manipulated\n" +
            "independently of the details of their representation. Core collection INTERFACES are\n" +
            "the foundation of the Java Collections Framework. As you can see in the \n" +
            "following figure, the core collection INTERFACES form a hierarchy.",
            param3  +
            "   One issue with ANONYMOUS CLASSes is that if the implementation of your ANONYMOUS\n" +
            "CLASS is very simple, such as an interface that contains only one method, then the\n" +
            "syntax of ANONYMOUS CLASSes may seem unwieldy and unclear. In these cases,\n" +
            "you're usually trying to pass functionality as an argument to another method,\n" +
            "such as what action should be taken when someone clicks a button. Lambda\n" +
            "expressions enable you to do this, to treat functionality as method argument, or\n" +
            "code as data."})

    void changeSubstringsToAnotherInFileParametrizedTest(String string) throws IOException {
        String[] splintedParams = string.split(";");
        BufferedReader mockedBufferedReader = Mockito.mock(BufferedReader.class);
        when(mockedBufferedReader.readLine()).thenReturn(splintedParams[OLD_FILE_CONTENT_INDEX]).thenReturn(null);
        FileManager fm = new FileManager("resources/testingSugar.txt", mockedBufferedReader);
        String actual = fm.changeSubstringsToAnotherInFile(splintedParams[OLD_STRING_INDEX], splintedParams[NEW_STRING_INDEX]);
        String expected = splintedParams[NEW_FILE_CONTENT_INDEX];
        assertEquals(expected, actual);
    }

}