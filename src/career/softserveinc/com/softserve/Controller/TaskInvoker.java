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

package career.softserveinc.com.softserve.Controller;

import career.softserveinc.com.softserve.Model.task1.ChessBoard;
import career.softserveinc.com.softserve.Model.task1.ITask1Arguments;
import career.softserveinc.com.softserve.Model.task2.Envelope;
import career.softserveinc.com.softserve.Model.task2.ITask2Arguments;
import career.softserveinc.com.softserve.Model.task3.ITask3Arguments;
import career.softserveinc.com.softserve.Model.task3.Triangle;

import java.util.Set;

class TaskInvoker {
    static StringBuilder invokeTask1(ITask1Arguments arguments) {
        int[] argsAsArray = arguments.getArgs();
        ChessBoard chessBoard = new ChessBoard(argsAsArray[0], argsAsArray[1]);
        return new StringBuilder(chessBoard.createBoard());
    }

    static StringBuilder invokeTask2(ITask2Arguments arguments) {
        double[] argsAsArray = arguments.getArgs();
        Envelope e1 = new Envelope(argsAsArray[0], argsAsArray[1]);
        Envelope e2 = new Envelope(argsAsArray[2], argsAsArray[3]);
        if (e1.compareTo(e2) > 0) {
            return new StringBuilder("Envelope1 can be accommodated in Envelope2");
        } else if (e2.compareTo(e1) > 0) {
            return new StringBuilder("Envelope2 can be accommodated in Envelope1");
        } else {
            return new StringBuilder("This two envelopes do not fit each other");
        }
    }

    static  StringBuilder invokeTask3(ITask3Arguments arguments){
        Set<Triangle> triangles = arguments.getArgs();
        StringBuilder sb = new StringBuilder("============= Triangles list: ===============\n");
        for (Triangle t : triangles) {
            sb.append(t.toString()+"\n");
        }
        return sb;
    }
}
