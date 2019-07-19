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

package career.softserveinc.com.softserve.task2;

public class Envelope implements Comparable<Envelope> {

    private static final double PAPER_THICKNESS = 0.00102;
    private double width;
    private double height;

    public Envelope() { // default European envelope
        width = 1.1;
        height = 2.2;
    }

    public Envelope(double width, double height) {
        this.width = width;
        this.height = height;
    }

    public int compareTo(Envelope envelope) {
        if (((width <= envelope.width - PAPER_THICKNESS * 2) &&
                (height <= envelope.height - PAPER_THICKNESS * 2)) ||
                ((width <= envelope.height - PAPER_THICKNESS * 2) &&
                        (height <= envelope.width - PAPER_THICKNESS * 2))){
            return 1;
        }
        if (((width >= envelope.width - PAPER_THICKNESS * 2) &&
                (height >= envelope.height - PAPER_THICKNESS * 2)) ||
                ((width >= envelope.height - PAPER_THICKNESS * 2) &&
                        (height >= envelope.width - PAPER_THICKNESS * 2))){
            return -1;
        }
        else return 0;
    }

}


