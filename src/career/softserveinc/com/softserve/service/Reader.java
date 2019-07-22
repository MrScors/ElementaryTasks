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
import career.softserveinc.com.softserve.task8.FibonacciManager;

import java.util.Scanner;
import java.util.Set;

class Reader {
    static int[] read1() {
        int h = -1;
        int w = -1;
        Scanner sc = new Scanner(System.in);
        while (true) {
            if (h <= 0) {
                System.out.println("Enter height (must be integer and > 0)");
                while (!sc.hasNextInt()) {
                    System.out.println("That's not an integer number");
                    sc.next();
                }
                h = sc.nextInt();
                if (h < 0) {
                    System.out.println("That's not positive number");
                }
            }
            if (w <= 0) {
                System.out.println("Enter width (must be integer and > 0)");
                while (!sc.hasNextInt()) {
                    System.out.println("That's not an integer number");
                    sc.next();
                }
                w = sc.nextInt();
                if (w < 0) {
                    System.out.println("That's not positive number");
                }
            }
            if ((h > 0) && (w > 0)) {
                return new int[]{h, w};
            }
        }
    }

    static int[] read2() {
        int[] params = new int[4];
        Scanner sc = new Scanner(System.in);
        while (true) {
            for (int i = 0; i < 4; i++) {
                if (params[i] <= 0) {
                    System.out.println("Enter param" + i + "(must be integer and > 0)");
                    while (!sc.hasNextInt()) {
                        System.out.println("That's not an integer number");
                        sc.next();
                    }
                    params[i] = sc.nextInt();
                    if (params[i] < 0) {
                        System.out.println("That's not positive number");
                        break;
                    }
                }
            }
            if (params[0] > 0 && params[1] > 0 && params[2] > 0 && params[3] > 0) {
                return params;
            }
        }
    }

    static void read3(Set<Triangle> triangles) {
        String[] argAsArray;
        String name;
        int[] sides = new int[3];
        Scanner sc = new Scanner(System.in);
        boolean allFine;
        do {
            allFine = true;
            label1:
            {
                System.out.println("Enter values of triangle in format <name>,<side1>,<side2>,<side3>");
                argAsArray = sc.nextLine().split(",");
                if (argAsArray.length == 4) {
                    for (int i = 2; i >= 0; i--) {
                        try {
                            sides[i] = Integer.parseInt(argAsArray[i + 1]);
                        } catch (NumberFormatException e) {
                            System.out.println("Invalid value");
                            allFine = false;
                            break label1;
                        }
                    }
                    name = argAsArray[0];
                    if (Validator.validateTriangle(sides)) {
                        triangles.add(new Triangle(name, sides[0], sides[1], sides[2]));
                        System.out.println("Do you want to enter one more triangle?");
                    } else {
                        System.out.println("Invalid triangle");
                        allFine = false;
                    }

                } else {
                    allFine = false;
                    System.out.println("Invalid value");
                }
            }
        } while (!allFine || Validator.checkUserAnswer(sc.nextLine()));

    }

    static String[] read4(String path) {
        Scanner sc = new Scanner(System.in);
        String answer;
        do {
            System.out.println("Chose option");
            System.out.println("1. Count number of some strings in .txt file");
            System.out.println("2. Replace some strings with another ones in .txt file");
            answer = sc.nextLine();
            if (!answer.equals("1") && !answer.equals("2")) {
                System.out.println("Enter 1 or 2");
                continue;
            }
            break;
        } while (true);

        if (answer.equals("1")) {
            System.out.println("Enter string to find");
            String find = sc.nextLine();
            return new String[]{path, find};
        } else if (answer.equals("2")) {
            System.out.println("Enter string to find");
            String find = sc.nextLine();
            System.out.println("Enter new string to replace previous");
            String replaceWIth = sc.nextLine();
            return new String[]{path, find, replaceWIth};
        }

        return new String[0];
    }

    static int[] read8() {
        int params[] = new int[0];
        Scanner sc = new Scanner(System.in);
        boolean allFine;
        do {
            allFine = true;
            String s = sc.nextLine();
            String[] splintered = s.split(" ");
            if (splintered.length == 1) {
                try {
                    params = new int[]{Integer.parseInt(splintered[0])};
                    if(FibonacciManager.isNotFibonacci(params[0])){
                        allFine = false;
                        System.out.println("That's not a Fibonacci number");
                    }
                } catch (NumberFormatException e) {
                    allFine = false;
                    System.out.println("That is not an integer number");
                }

            } else if (splintered.length == 2) {
                try {
                    params = new int[]{Integer.parseInt(splintered[0]), Integer.parseInt(splintered[1])};
                    if(FibonacciManager.isNotFibonacci(params[0]) || FibonacciManager.isNotFibonacci(params[1])){
                        allFine = false;
                        System.out.println("That's not a Fibonacci number");
                    }
                } catch (NumberFormatException e) {
                    allFine = false;
                    System.out.println("That is not an integer number");
                }
            } else {
                allFine = false;
                System.out.println("Invalid number of inputs");
            }
        } while (!allFine);
        return params;
    }

}
