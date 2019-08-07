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

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

class FibonacciManager {

    static List<BigInteger> findSubSequence(BigInteger start, BigInteger end) {
        if(start.compareTo(end)>0){
            BigInteger temp = start;
            start = end;
            end = temp;
        }
        return getBigIntegersInGivenBorders(start, end);
    }

    static List<BigInteger> findSubSequence(int length) throws java.lang.ArithmeticException {
        final BigInteger TEN_AS_BIG_INTEGER = new BigInteger("10");
        BigInteger max = TEN_AS_BIG_INTEGER.pow(length);
        BigInteger min = TEN_AS_BIG_INTEGER.pow(length - 1);
        return getBigIntegersInGivenBorders(min, max);
    }

    private static List<BigInteger> getBigIntegersInGivenBorders(BigInteger start, BigInteger end) {
        BigInteger prevElement = new BigInteger("0");
        BigInteger element = new BigInteger("1");
        List<BigInteger> subSequence = new ArrayList<>();
        for (int i = 1; element.compareTo(end) < 0; i++) {
            BigInteger temp = element;
            element = element.add(prevElement);
            prevElement = temp;
            if (element.compareTo(start) > 0 && element.compareTo(end) < 0) {
                subSequence.add(element);
            }
        }
        return subSequence;
    }


}
