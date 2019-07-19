/*
 *          xXx_key-combinations_xXx
 *
 * replace line of code up or down --> ALT + Shift
 * replace block of code up or down --> CTRL + Shift
 *
 * one line comment --> CTRL + /
 * multi-line comment --> CTRL + SHIFT + /
 *
 * copy-paste line or marked scope of code --> CTRL + D
 * delete line --> CTRL + Y
 *
 * make your code look fine --> CTRL + ALT + L
 *
 * surround with some for, if, switch, etc. --> CTRL+ + ALT + T
 * try to solve error / make cod better --> ALT + ENTER
 *
 *              xXx_shortcuts_xXx
 *
 * psvm + TAB <-- main function
 * sout + TAB <-- System.out.println();
 * serr + TAB <-- System.err.println();
 * iter + TAB <-- for (String arg : args)
 * fori + TAB <-- for(int i=0; i< ; i++)
 * I + TAB <-- for (Object o :)
 * see more on CTRL + J
 *
 */

package career.softserveinc.com.softserve.service;

import career.softserveinc.com.softserve.task1.ChessBoard;
import career.softserveinc.com.softserve.task2.Envelope;
import career.softserveinc.com.softserve.task3.Triangle;
import career.softserveinc.com.softserve.task4.FileManager;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class Invoker {
    public static void invokeTask1(String[] args) {
        int[] params = Validator.validateTask1(args);
        ChessBoard board = new ChessBoard(params[0], params[1]);
        System.out.println(board.createBoard());
    }

    public static void invokeTask2(String[] args) {
        Scanner sc = new Scanner(System.in);
        do {
            int[] params = Validator.validateTask2(args);
            Envelope en1 = new Envelope(params[0], params[1]);
            Envelope en2 = new Envelope(params[2], params[3]);
            if (en1.compareTo(en2)>1) {
                System.out.println("Envelope1 can be accommodated in Envelope2");
            } else if (en1.compareTo(en2)<0) {
                System.out.println("Envelope2 can be accommodated in Envelope1");
            } else System.out.println("These two envelopes do not fit each other");
            System.out.println("Do you want to compare two envelopes again?");
        } while (Validator.checkAnswer(sc.nextLine()));
    }

    public static void invokeTask3(String[] args) {
        Set<Triangle> triangles = Validator.validateTask3(args);
        System.out.println("============= Triangles list: ===============");
        for (Triangle triangle: triangles) {
            System.out.println(triangle.toString());
        }
    }

    public static void invokeTask4(String[] args) throws IOException {
        String[] validArgs = Validator.validateTask4(args);
        if(validArgs.length == 2){
            FileManager fm = new FileManager(validArgs[0]);
            System.out.println("Matches found: " + fm.countNumberOfSubstrings(validArgs[1]));
        } else {
            FileManager fm = new FileManager(validArgs[0]);
            fm.changeSubstringsToAnother(validArgs[1], validArgs[2]);
        }
    }

    public static void invokeTask5(String[] args) {

    }

    public static void invokeTask6(String[] args) {

    }

    public static void invokeTask7(String[] args) {

    }

    public static void invokeTask8(String[] args) {

    }

    public static void invokeTask9(String[] args) {

    }

    public static void invokeTask10(String[] args) {

    }

}
