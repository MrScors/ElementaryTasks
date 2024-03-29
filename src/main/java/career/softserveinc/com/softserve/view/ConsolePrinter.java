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

package main.java.career.softserveinc.com.softserve.view;

public class ConsolePrinter {


    public static void writeResultsOfTask(StringBuilder sb) {
        System.out.println(sb);
    }

    public static void writeInvalidArgsErrorMessage() {
        System.out.println("Some arguments are invalid enter all arguments again please");
    }

    // task_1

    public static void tellYouAboutTask1() {
        System.out.println("You've chose task1");
    }

    public static void askToWriteSomeArgumentsForTask1() {
        System.out.println("Please, enter arguments to use in task1 (must be 2 integer numbers that > 0)" +
                "\nEverything except integers will be ignored");
    }

    // task_2

    public static void tellYouAboutTask2() {
        System.out.println("You've chose task2");
    }

    public static void askToWriteSomeArgumentsForTask2() {
        System.out.println("Please, enter arguments to use in task2 (must be 4 double numbers that > 0)" +
                "\nEverything except doubles will be ignored");
    }

    public static void askWhetherDoOnceMore() {
        System.out.println("Do you want to run this task once more?");
    }

    // task_3

    public static void tellYouAboutTask3() {
        System.out.println("You've chose task3");
    }

    public static void askToWriteSomeArgumentsForTask3() {
        System.out.println("Please, enter arguments to use in task3\n" +
                "(must be 1 string in format <String>,<int>,<int>,<int>)");
    }

    // task_4

    public static void tellYouAboutTask4() {
        System.out.println("You've chose task4");
    }

    public static void askToChoseOptionForTask4() {
        System.out.println("Please chose option of FileManager, enter 1 to find and count number of given by you\n" +
                "or 2 to replace given by you string to another one\n" +
                "Option1: Enter 2 strings in format \n\"<filepath>\n<stringToFind>\"\n" +
                "Option2: Enter 3 strings in format \n\"<filepath>\n<stringToFind>\n<newStringToReplacePreviousOne>\"");
    }

    // task_6

    public static void tellYouAboutTask6() {
        System.out.println("You've chose task6");
    }

    public static void askToWriteSomeArgumentsForTask6() {
        System.out.println("Please, enter arguments to use in task6\n" +
                "must be 1 string in format:\n" +
                "<validFilepath> <countOfNumbersInEachTicket> <numbersOfFirstTicket> <numbersOfLastTicket>\n" +
                "numbersOfFirstTickets must be separated by comma \',\'");
    }

    // task_7

    public static void tellYouAboutTask7() {
        System.out.println("You've chose task7");
    }

    public static void askToWriteSomeArgumentsForTask7() {
        System.out.println("Please, enter arguments to use in task7\n" +
                "(must be 1 integer numbers that > 0)" +
                "\nEverything except integers will be ignored");
    }

    // task_8

    public static void tellYouAboutTask8() {
        System.out.println("You've chose task8");
    }

    public static void askToWriteSomeArgumentsForTask8() {
        System.out.println("Please, enter arguments to use in task8\n" +
                "(must be 1 string in format <borderValue1> <borderValue2> or <lengthValue>)" + "\n" +
                "borderValue -> long type; lengthValue < 19;");
    }

    // task_9

    public static void tellYouAboutTask9() {
        System.out.println("You've chose task9");
    }

    public static void askToWriteSomeArgumentsForTask9() {
        System.out.println("Please, enter arguments to use in task9\n" +
                "(must be 1 string in format <integer> <exponent> <opacity>" + "\n" +
                "or <integerAndExponent> <opacity> )");
    }

    public static void askWhetherAddMoreTriangles() {
        System.out.println("Do you want to add more triangles?");
    }

    // main

    public static void writeGreetings() {
        System.out.println(
                "Welcome to program ElementaryTasks_Pavlov" + "\n" +
                        "To run any task just enter its number" + "\n" +
                        "Task1 - print chessboard" + "\n" +
                        "Task2 - check envelopes" + "\n" +
                        "Task3 - calculate triangles' square" + "\n" +
                        "Task4 - find and count/replace substrings in .txt file" + "\n" +
                        "Task6 - count number of lucky tickets" + "\n" +
                        "Task7 - create sequence of natural numbers which square is lower than given number" + "\n" +
                        "Task8 - get subSequence of Fibonacci Numbers of given length or with given borders" + "\n" +
                        "Task9 - effective powering of integer" + "\n" +
                        "Enter 11/exit to exit");
    }
    public static void separateNewTask() {
        System.out.println("---------------------------------------------------------" +
                "\nMake your choice");
    }

    public static void askWhetherPassReceivedArguments() {
        System.out.println("Do you want to pass arguments that were received by this program?");
    }

    public static void writeErrorOfEnteringNumberOfTaskToRun() {
        System.out.println("Invalid number of task to run, try again please" + "\n" +
                "(must be integer that > 0 and < 12");
    }
}
