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

package main.java.career.softserveinc.com.softserve.arguments_input;

import java.io.BufferedReader;
import java.io.IOException;
import java.math.BigInteger;

public class Reader {

    public static int readWhichTaskRun(BufferedReader br) throws NumberFormatException, IOException {
        int answer;
        answer = Integer.parseInt(br.readLine());
        return answer;
    }

    public static int[] readTask1Arguments(BufferedReader br) throws NumberFormatException, IOException {
        int[] arguments = new int[2];
        for (int i = 0; i < 2; i++) {
            arguments[i] = Integer.parseInt(br.readLine());
        }
        return arguments;
    }

    public static double[] readTask2Arguments(BufferedReader br) throws NumberFormatException, IOException {
        double[] arguments = new double[4];
        for (int i = 0; i < 4; i++) {
            arguments[i] = Double.parseDouble(br.readLine());
        }
        return arguments;
    }

    public static String readTask3Arguments(BufferedReader br) throws IOException {
        return br.readLine();
    }

    public static String[] readTask4Arguments(BufferedReader br) throws IOException {
        String option = br.readLine();
        String[] args;
        if(option.equals("1")) {
            args = new String[2];
            for (int i = 0; i < 2; i++) {
                args[i] = br.readLine();
            }
        } else if(option.equals("2")){
             args = new String[3];
            for (int i = 0; i < 3; i++) {
                args[i] = br.readLine();
            }
        } else {
            args = new String[]{""};
        }
        return args;
    }

    public static String readTask6Arguments(BufferedReader br) throws IOException {
        return br.readLine();
    }

    public static int readTask7Arguments(BufferedReader br) throws NumberFormatException, IOException {
        String argumentAsString = br.readLine();
        return Integer.parseInt(argumentAsString);
    }

    public static BigInteger[] readTask8Arguments(BufferedReader br) throws NumberFormatException, IOException {
        String arguments = br.readLine();
        String[] argumentsAsArray = arguments.split(" ");
        BigInteger[] argumentsAsLongArray = new BigInteger[argumentsAsArray.length];
        for (int i = 0; i < argumentsAsArray.length; i++) {
            argumentsAsLongArray[i] = new BigInteger(argumentsAsArray[i]);
        }
        return argumentsAsLongArray;
    }

    public static int[] readTask9Arguments(BufferedReader br) throws NumberFormatException, IOException {
        String argumentAsString = br.readLine();
        String[] argumentAsStringsArray = argumentAsString.split(" ");
        int[] arguments = new int[argumentAsStringsArray.length];
        for (int i = 0; i < argumentAsStringsArray.length; i++) {
            arguments[i] = Integer.parseInt(argumentAsStringsArray[i]);
        }
        return arguments;
    }

    public static boolean readYesOrNo(BufferedReader br) throws IOException {
        String answer = br.readLine();
        return answer.toLowerCase().equals("yes") || answer.toLowerCase().equals("y");
    }
}
