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

package career.softserveinc.com.softserve.model.task8;

import java.io.BufferedReader;
import java.math.BigInteger;

public class Task8Arguments implements ITask8Arguments {
    private long[] longArgs;

    Task8Arguments(String[] stringArgs){
        try{
            longArgs = new long[stringArgs.length];
            for (int i = 0; i < stringArgs.length; i++) {
                longArgs[i] = Long.parseLong(stringArgs[i]);
            }
        }catch (NumberFormatException e){
            longArgs = null;
            longArgs = null;
        }
    }

    Task8Arguments(long[] longArgs) {
        this.longArgs = longArgs;
    }

    @Override
    public long[] getArgs() {
        return longArgs;
    }

    @Override
    public boolean validate() {

        if(longArgs.length == 1 && longArgs[0] < 94) return true;
        return longArgs.length == 2;

    }


}
