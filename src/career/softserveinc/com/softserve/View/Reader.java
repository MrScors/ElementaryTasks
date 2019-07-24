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

import java.util.InputMismatchException;
import java.util.Scanner;

public class Reader {

    public static int readWhichTaskRun(){
        Scanner sc = new Scanner(System.in);
        int answer;
        while(!sc.hasNextInt()){
            sc.next();
        }
        answer = sc.nextInt();
        return answer;
    }

    public static int[] readTask1Arguments(){
        Scanner sc = new Scanner(System.in);
        int[] arguments = new int[4];
        for (int i = 0; i < 4; i++) {
            do{
                arguments[i] = sc.nextInt();
            }while(sc.hasNextInt());

        }
        return arguments;
    }

    public static double[] readTask2Arguments() throws InputMismatchException {
        Scanner sc = new Scanner(System.in);
        double[] arguments = new double[4];
        for (int i = 0; i < 4; i++) {
            while(!sc.hasNextDouble()){
                sc.next();
            }
            arguments[i] = sc.nextDouble();
        }
        return arguments;
    }

    public static boolean readYesOrNo(){
        Scanner sc = new Scanner(System.in);
        String answer = sc.nextLine();
        return answer.toLowerCase().equals("yes")||answer.toLowerCase().equals("y");
    }
}
