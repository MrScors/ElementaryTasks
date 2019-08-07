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

package main.java.career.softserveinc.com.softserve.model.task8;

import java.io.BufferedReader;
import java.math.BigInteger;

public class Task8Arguments implements ITask8Arguments {
    private BigInteger[] bigIntegerArgs;

    Task8Arguments(String[] stringArgs) {
        try {
            bigIntegerArgs = new BigInteger[stringArgs.length];
            for (int i = 0; i < stringArgs.length; i++) {
                bigIntegerArgs[i] = new BigInteger(stringArgs[i]);
            }
        } catch (NumberFormatException e) {
            bigIntegerArgs = null;
            bigIntegerArgs = null;
        }
    }

    Task8Arguments(BigInteger[] longArgs) {
        this.bigIntegerArgs = longArgs;
    }

    @Override
    public BigInteger[] getArgs() {
        return bigIntegerArgs;
    }

    @Override
    public boolean validate() {

        if (bigIntegerArgs.length == 1) {
            if (bigIntegerArgs[0].compareTo(new BigInteger("2147483648")) < 0 &&
                    bigIntegerArgs[0].intValue() > 0) {
                try {
                    BigInteger TEN_AS_BIG_INTEGER = new BigInteger("10");
                    BigInteger test = TEN_AS_BIG_INTEGER.pow(bigIntegerArgs[0].intValue());
                    return true;
                } catch (java.lang.ArithmeticException e) {
                    return false;
                }
            } else return false;
        } else
            return bigIntegerArgs.length == 2 &&
                    bigIntegerArgs[0].intValue() > 0 &&
                    bigIntegerArgs[1].intValue() > 0;
    }


}
