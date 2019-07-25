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

package career.softserveinc.com.softserve.Model.task3;

import java.util.Set;
import java.util.TreeSet;

public class Task3Arguments implements ITask3Arguments {
    private Set<Triangle> triangles = new TreeSet<>();

    public Task3Arguments() {

    }

    public Task3Arguments(String[] stringArguments) {
        validate(stringArguments);
    }

    public boolean add(String stringArgument) {
        return validateSingleString(stringArgument);
    }

    public boolean add(String[] stringArguments) {
        return validate(stringArguments);
    }

    @Override
    public Set<Triangle> getArgs() {
        return triangles;
    }

    @Override
    public boolean validate(String[] stringArguments) {
        boolean allTrianglesValid = true;
        for (int i = 0; i < stringArguments.length; i++) {
            allTrianglesValid = validateSingleString(stringArguments[i]);
        }
        return allTrianglesValid;
    }

    private boolean validateSingleString(String stringArgument) {
        int[] sides = new int[3];
        String[] stringArgumentAsArray = stringArgument.split(",");
        if (stringArgumentAsArray.length != 4) return false;
        else {
            try {
                for (int j = 3; j > 0; j--) sides[j - 1] = Integer.parseInt(stringArgumentAsArray[j]);
                if (validateTriangle(sides)) {
                    triangles.add(new Triangle(stringArgumentAsArray[0], sides[0], sides[1], sides[2]));
                } else {
                    return false;
                }
            } catch (NumberFormatException e) {
                return false;
            }
        }
        return true;
    }

    private boolean validateTriangle(int[] sides) {
        double p = (double) sides[0] + sides[1] + sides[2];
        p /= 2;
        return (p - sides[0] > 0 && p - sides[1] > 0 && p - sides[2] > 0);
    }

}
