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

package main.java.career.softserveinc.com.softserve.model.task7;

import java.io.BufferedReader;

public class Task7Arguments implements ITask7Arguments {
    private int intArg;

    Task7Arguments(int intArg) {
        this.intArg = intArg;
    }

    Task7Arguments(String[] stringArg) {
        try{
            intArg = Integer.parseInt(stringArg[0]);
        } catch (NumberFormatException e){
            intArg = -1;
        }
    }

    @Override
    public int getArgs() {
        return intArg;
    }

    @Override
    public boolean validate() {
        return intArg > 0;
    }


}
