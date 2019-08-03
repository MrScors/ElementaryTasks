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

package main.java.career.softserveinc.com.softserve.model.task4;

import java.io.BufferedReader;
import java.io.File;

public class Task4Arguments implements ITask4Arguments {
    private String[] stringArgs;

    Task4Arguments(String[] stringArgs) {
        this.stringArgs = stringArgs;
    }

    @Override
    public String[] getArgs() {
        return stringArgs;
    }

    @Override
    public boolean validate() {

        File file = new File(stringArgs[0]);
        if (!file.isFile()) return false;

        return stringArgs.length == 2 || stringArgs.length == 3;
    }


}
