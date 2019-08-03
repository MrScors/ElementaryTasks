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

package main.java.career.softserveinc.com.softserve.model.task1;

public class Task1Arguments implements ITask1Arguments {
    private int[] intArguments;

    Task1Arguments(int[] intArguments) {
        this.intArguments = intArguments;
    }

    Task1Arguments(String[] stringArguments) {
        parseStringArgumentsToIntArguments(stringArguments);
    }

    @Override
    public int[] getArgs() {
        return intArguments;
    }

    @Override
    public boolean validate() {
        return intArguments.length == 2 && intArguments[0] > 0 && intArguments[1] > 0;
    }

    private void parseStringArgumentsToIntArguments(String[] stringArguments){
        intArguments = new int[stringArguments.length];
        try {
            for (int i = 0; i < stringArguments.length; i++) {
                intArguments[i] = Integer.parseInt(stringArguments[i]);
            }
        } catch (NumberFormatException e) {
            for (int i = 0; i < stringArguments.length; i++) {
                intArguments[i] = -1;
            }
        }

    }

}
