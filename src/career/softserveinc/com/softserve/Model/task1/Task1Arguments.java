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

package career.softserveinc.com.softserve.Model.task1;

import career.softserveinc.com.softserve.Model.Validatable;

public class Task1Arguments implements Validatable {
    private int[] intArguments;
    private String[] stringArguments;

    public Task1Arguments(int[] intArguments) {
        this.intArguments = intArguments;
    }

    public Task1Arguments(String[] stringArguments) {
        this.stringArguments = stringArguments;
    }

    @Override
    public int[] getIntArgs() {
        return intArguments;
    }

    @Override
    public double[] getDoubleArgs() {
        double[] doubleArguments = new double[intArguments.length];
        for (int i = 0; i < intArguments.length; i++) {
            doubleArguments[i] = intArguments[i];
        }
        return doubleArguments;
    }

    @Override
    public boolean validate() {
        if (stringArguments == null) {
            return intArguments.length == 2 && intArguments[0] > 0 && intArguments[1] > 0;
        } else {
            try {
                giveStringArgumentsToIntArguments();
            } catch (NumberFormatException e) {
                return false;
            }
            return intArguments.length == 2 && intArguments[0] > 0 && intArguments[1] > 0;
        }
    }

    private void giveStringArgumentsToIntArguments() throws NumberFormatException {
        intArguments = new int[stringArguments.length];
        for (int i = 0; i < stringArguments.length; i++) {
            intArguments[i] = Integer.parseInt(stringArguments[i]);
        }
    }

}
