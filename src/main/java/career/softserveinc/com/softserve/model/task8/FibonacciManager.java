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

class FibonacciManager {

    static private int findLengthOfSubSequence(long start, long end) {
        int length = 0;
        long i = 1;
        long prevI = 0;
        while (i < end) {
            if (i >= start) {
                length++;
            }
            long temp = i;
            i += prevI;
            prevI = temp;
        }
        return length;
    }

    static long[] findSubSequence(long start, long end) {

        if (start > end) { // swap instead of incorrect work
            long temp = start;
            start = end;
            end = temp;
        }

        int length = findLengthOfSubSequence(start, end);
        long[] subSequence = new long[length];
        int subSequenceCounter = 0;
        long i = 1;
        long prevI = 0;
        while (i < end) {
            if (i >= start) {
                subSequence[subSequenceCounter++] = i;
            }
            long temp = i;
            i += prevI;
            prevI = temp;
        }
        return subSequence;
    }

    static long[] findSubSequence(long length) {
        long[] subSequence = new long[(int) length];
        int subSequenceCounter = 0;
        long prevElement = 0;
        long element = 1;
        subSequence[subSequenceCounter++] = prevElement;
        for (int i = 1; i < length - 1; i++) {
            long temp = element;
            element += prevElement;
            prevElement = temp;
            subSequence[subSequenceCounter++] = prevElement;
        }
        subSequence[subSequenceCounter] = element;
        return subSequence;
    }



}
