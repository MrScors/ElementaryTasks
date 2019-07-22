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

package career.softserveinc.com.softserve.task8;

public class FibonacciManager {

    private int findLengthOfSubSequence(int start, int end) {
        int length = 0;
        int i = 1;
        int prevI = 0;
        while (i < end) {
            if (i >= start) {
                length++;
            }
            int temp = i;
            i += prevI;
            prevI = temp;
        }
        length++;
        return length;
    }

    public int[] findSubSequence(int start, int end) {

        if (start > end) { // swap instead of incorrect work
            System.out.println("Elements were swapped because start point was lower then end one");
            int temp = start;
            start = end;
            end = temp;
        }

        int length = findLengthOfSubSequence(start, end);
        int[] subsequence = new int[length];
        int subsequenceCounter = 0;
        int i = 1;
        int prevI = 0;
        while (i < end) {
            if (i >= start) {
                subsequence[subsequenceCounter++] = i;
            }
            int temp = i;
            i += prevI;
            prevI = temp;
        }
        subsequence[subsequenceCounter] = i;
        return subsequence;
    }

    public int[] findSubSequence(int length) {
        int[] subsequence = new int[length];
        int subsequenceCounter = 0;
        int prevElement = 0;
        int element = 1;
        subsequence[subsequenceCounter++] = prevElement;
        for (int i = 1; i < length - 1; i++) {
            int temp = element;
            element += prevElement;
            prevElement = temp;
            subsequence[subsequenceCounter++] = prevElement;
        }
        subsequence[subsequenceCounter] = element;
        return subsequence;
    }

    public static boolean isNotFibonacci(int elem) {
        int i = 1;
        int prevI = 0;
        while (i < 1836311903) {
            if (elem == i) {
                return false;
            }
            int temp = i;
            i += prevI;
            prevI = temp;
        }
        return elem != i;
    }

}
