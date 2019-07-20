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

package career.softserveinc.com.softserve.service;

import career.softserveinc.com.softserve.task3.Triangle;
import career.softserveinc.com.softserve.task4.FileManager;

import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class Validator {

    static int[] validateTask1(String[] args) {
        int height;
        int width;
        try {
            if (args.length == 2 && (Integer.parseInt(args[0]) > 0) && Integer.parseInt(args[1]) > 0) {
                height = Integer.parseInt(args[0]); // height
                width = Integer.parseInt(args[1]); // width
                return new int[]{height, width};
            } else {
                System.out.println("You gave incorrect number of arguments/they were < 0");
                return Reader.read1();
            }
        } catch (NumberFormatException e) {
            System.out.println("Your arguments were not integers");
            return Reader.read1();
        }
    }

    static int[] validateTask2(String[] args) {
        int[] params = new int[4];
        try {
            if (args.length == 4 && (Integer.parseInt(args[0]) > 0) && Integer.parseInt(args[1]) > 0 &&
                    Integer.parseInt(args[2]) > 0 && Integer.parseInt(args[3]) > 0) {
                for (int i = 0; i < 4; i++) {
                    params[i] = Integer.parseInt(args[i]);
                }
                return params;
            } else {
                System.out.println("You gave incorrect number of arguments/they were < 0");
                return Reader.read2();
            }
        } catch (NumberFormatException e) {
            System.out.println("Your arguments were not integers");
            return Reader.read2();
        }
    }

    static Set<Triangle> validateTask3(String[] args) {
        Set<Triangle> triangles = new TreeSet<>();
        try {
            for (String arg : args) {
                String name;
                int[] sides = new int[3];
                String[] argAsArray = arg.split(",");
                if (argAsArray.length == 4) {
                    for (int i = 2; i >= 0; i--) {
                        sides[i] = Integer.parseInt(argAsArray[i + 1]);
                    }
                    name = argAsArray[0];
                    if (validateTriangle(sides)) {
                        triangles.add(new Triangle(name, sides[0], sides[1], sides[2]));
                    } else {
                        System.out.println("Invalid triangle");
                    }
                } else {
                    System.out.println("Invalid argument");
                }
            }

        } catch (NumberFormatException e) {
            System.out.println("Invalid number");
            Reader.read3(triangles);
        }
        Reader.read3(triangles);
        return triangles;
    }

    static String[] validateTask4(String[] args) {
        if (args.length == 2) {
            if (FileManager.checkFilePath(args[0])) {
                return args;
            } else {
                String path;
                Scanner sc = new Scanner(System.in);
                do {
                    System.out.println("Enter valid filepath, please:");
                    path = sc.nextLine();
                } while (!FileManager.checkFilePath(path));
                return Reader.read4(path);
            }
        } else if (args.length == 3) {
            if (FileManager.checkFilePath(args[0])) {
                return args;
            } else {
                String path;
                Scanner sc = new Scanner(System.in);
                do {
                    System.out.println("Enter valid filepath, please:");
                    path = sc.nextLine();
                } while (!FileManager.checkFilePath(path));
                return Reader.read4(path);
            }
        } else {
            String path;
            Scanner sc = new Scanner(System.in);
            do {
                System.out.println("Enter valid filepath, please:");
                path = sc.nextLine();
            } while (!FileManager.checkFilePath(path));
            return Reader.read4(path);
        }
    }

    public static void validateTask5() {

    }

    public static void validateTask6() {

    }

    public static void validateTask7() {

    }

    public static void validateTask8() {

    }

    public static void validateTask9() {

    }

    public static void validateTask10() {

    }

    public static boolean checkUserAnswer(String answer) {
        answer = answer.toLowerCase();
        return (answer.equals("yes") || answer.equals("y"));
    }

    static boolean validateTriangle(int[] s) throws IndexOutOfBoundsException {
        return (((s[0] + s[1] + s[2]) / 2 >= s[0]) && ((s[0] + s[1] + s[2]) / 2 >= s[1]) && ((s[0] + s[1] + s[2]) / 2 >= s[2]));
    }

}

