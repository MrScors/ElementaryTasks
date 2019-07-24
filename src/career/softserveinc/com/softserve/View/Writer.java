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

package career.softserveinc.com.softserve.View;

public class Writer {
    public static void writeGreatings() {
        System.out.println(
                "Welcome to program ElementaryTasks_Pavlov" + "\n" +
                        "To run any task just enter its number" + "\n" +
                        "Task1 - print chessboard" + "\n" +
                        "Task2 - check envelopes" + "\n" +
                        "Task3 - calculate triangles' square" + "\n" +
                        "Task4 - find and count/replace substrings in .txt file" + "\n" +
                        "Enter 11/exit to exit");
    }

    public static void writeErrorOfEnteringNumberOfTaskToRun() {
        System.out.println("Invalid number of task to run, try again please");
        System.out.println("(must be integer that < 12 and > 0" +
                "\nEverything except integers will be ignored");
    }

    public static void writeResultsOfTask(StringBuilder sb) {
        System.out.println(sb);
    }

    public static void writeInvalidArgsErrorMessage(){
        System.out.println("Arguments are invalid");
    }

    public static void tellYouAboutTask1() {
        System.out.println("You've chose task1");
    }

    public static void tellYouAboutTask2() {
        System.out.println("You've chose task2");
    }

    public static void askWhetherPassReceivedArguments() {
        System.out.println("Do you want to pass arguments that were received by this program?");
    }

    public static void askToWriteSomeArgumentsForTask1() {
        System.out.println("Please, enter arguments to use in task1 (must be 2 integer numbers that > 0)" +
                "\nEverything except integers will be ignored");
    }

    public static void askToWriteSomeArgumentsForTask2() {
        System.out.println("Please, enter arguments to use in task2 (must be 4 integer numbers that > 0)" +
                "\nEverything doubles will be ignored");
    }

}
