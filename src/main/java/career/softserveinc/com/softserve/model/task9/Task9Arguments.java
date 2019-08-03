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

package main.java.career.softserveinc.com.softserve.model.task9;

public class Task9Arguments implements ITask9Arguments {
    private int[] intArgs;

    Task9Arguments(String[] stringArgs){
        try{
            intArgs = new int[stringArgs.length];
            for (int i = 0; i < stringArgs.length; i++) {
                intArgs[i] = Integer.parseInt(stringArgs[i]);
            }
        }catch (NumberFormatException e){
            intArgs = null;
        }
    }

    Task9Arguments(int[] intArgs) {
        this.intArgs = intArgs;
    }

    @Override
    public int[] getArgs() {
        return intArgs;
    }

    @Override
    public boolean validate() {
        if(intArgs.length != 3 && intArgs.length != 2) return false;
        for (int intArg : intArgs) if (intArg <= 0) return false;
        return true;
    }


}
