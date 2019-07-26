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

package career.softserveinc.com.softserve.model.task3;

public class Triangle implements Comparable<Triangle> {
    private int a;
    private int b;
    private int c;
    private String name;

    public Triangle() { // default triangle
        a = 3;
        b = 3;
        c = 3;
        name = "Default";
    }

    Triangle(String name, int a, int b, int c) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.name = name;
    }

    private double calculateSquare() {
        double p = (double) (a + b + c);
        p /= 2;
        return Math.sqrt(p * (p - a) * (p - b) * (p - c));
    }


    public String toString() {
        return "[" + name + "]: " + calculateSquare() + " cm";
    }

    @Override
    public int compareTo(Triangle triangle) {
        return Double.compare(calculateSquare(), triangle.calculateSquare());
    }
}
