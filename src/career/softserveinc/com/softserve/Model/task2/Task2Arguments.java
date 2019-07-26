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

package career.softserveinc.com.softserve.Model.task2;

public class Task2Arguments implements ITask2Arguments {
    private double[] doubleArguments;
    private String[] stringArguments;

    Task2Arguments(double[] doubleArguments) {
        this.doubleArguments = doubleArguments;
    }

    Task2Arguments(String[] stringArguments) {
        this.stringArguments = stringArguments;
    }

    @Override
    public double[] getArgs() {
        return doubleArguments;
    }

    @Override
    public boolean validate() {
        if (stringArguments == null) {
            return doubleArguments.length == 4 && doubleArguments[0] > 0 && doubleArguments[1] > 0
                    && doubleArguments[2] > 0 && doubleArguments[3] > 0;
        } else {
            try {
                giveStringArgumentsToIntArguments();
            } catch (NumberFormatException e) {
                return false;
            }
            return doubleArguments.length == 4 && doubleArguments[0] > 0 && doubleArguments[1] > 0
                    && doubleArguments[2] > 0 && doubleArguments[3] > 0;
        }
    }

    private void giveStringArgumentsToIntArguments() throws NumberFormatException {
        doubleArguments = new double[stringArguments.length];
        for (int i = 0; i < stringArguments.length; i++) {
            doubleArguments[i] = Double.parseDouble(stringArguments[i]);
        }
    }

}
