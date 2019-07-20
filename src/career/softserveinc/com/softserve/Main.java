package career.softserveinc.com.softserve;

import career.softserveinc.com.softserve.service.Invoker;
import career.softserveinc.com.softserve.service.Validator;

import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        String answer;
        Scanner sc = new Scanner(System.in);
        System.out.println(
                "Welcome to program ElementaryTasks_Pavlov" + "\n" +
                        "To run any task just enter its number" + "\n" +
                        "Task1 - print chessboard" + "\n" +
                        "Task2 - check envelopes" + "\n" +
                        "Task3 - calculate triangles' square" + "\n" +
                        "Task4 - find and count/replace substrings in .txt file" + "\n" +
                        "Enter 11/exit to exit");
        while (true) {
            System.out.println("------------------------------------------------------" + "\n" +
                    "Make your choice");
            answer = sc.nextLine().toLowerCase();
            switch (answer) {
                case "1":
                case "task1": {
                    System.out.println("You chose 1st task");
                    if (args.length != 0) {
                        System.out.println("You've passed some arguments to this program do you want to pass " +
                                "them into this task as well?");
                        answer = sc.nextLine();
                        if (Validator.checkUserAnswer(answer)) {
                            Invoker.invokeTask1(args);
                        } else {
                            System.out.println("Then, enter any arguments to pass into this task " +
                                    "(only 2 arguments required)");
                            Invoker.invokeTask1(sc.nextLine().split(" "));
                        }
                    } else {
                        System.out.println("Enter any arguments to pass into this task " +
                                "(only 2 arguments required)");
                        Invoker.invokeTask1(sc.nextLine().split(" "));
                    }
                    break;
                }
                case "2":
                case "task2": {
                    System.out.println("You chose 2nd task");
                    if (args.length != 0) {
                        System.out.println("You've passed some arguments to this program do you " +
                                "want to pass them into this task as well?");
                        answer = sc.nextLine();
                        if (Validator.checkUserAnswer(answer)) {
                            Invoker.invokeTask2(args);
                        } else {
                            System.out.println("Then, enter any arguments to pass into this task " +
                                    "(only 4 arguments required)");
                            Invoker.invokeTask2(sc.nextLine().split(" "));
                        }
                    } else {
                        System.out.println("Enter any arguments to pass into this task " +
                                "(only 4 arguments required)");
                        Invoker.invokeTask2(sc.nextLine().split(" "));
                    }
                    break;
                }
                case "3":
                case "task3": {
                    System.out.println("You chose 3rd task");
                    if (args.length != 0) {
                        System.out.println("You've passed some arguments to this program do you want " +
                                "to pass them into this task as well?");
                        answer = sc.nextLine();
                        if (Validator.checkUserAnswer(answer)) {
                            Invoker.invokeTask3(args);
                        } else {
                            System.out.println("Then, enter any arguments to pass into this task");
                            Invoker.invokeTask3(sc.nextLine().split(" "));
                        }
                    } else {
                        System.out.println("Enter any arguments to pass into this task");
                        Invoker.invokeTask3(sc.nextLine().split(" "));
                    }
                    break;
                }
                case "4":
                case "task4": {
                    System.out.println("You chose 4th task");
                    if (args.length != 0) {
                        System.out.println("You've passed some arguments to this program do you want " +
                                "to pass them into this task as well?");
                        answer = sc.nextLine();
                        if (Validator.checkUserAnswer(answer)) {
                            Invoker.invokeTask4(args);
                        } else {
                            System.out.println("Then, enter any arguments to pass into this task " +
                                    "(2 or 3 argument required)");
                            Invoker.invokeTask4(sc.nextLine().split(" "));
                        }
                    } else {
                        System.out.println("Enter any arguments to pass into this task " +
                                "(only 2 or 3 argument required)");
                        Invoker.invokeTask4(sc.nextLine().split(" "));
                    }
                    break;
                }
                case "5":
                case "task5": {
                    System.out.println("You chose 5th task");
                    Invoker.invokeTask5(args);
                    break;
                }
                case "6":
                case "task6": {
                    System.out.println("You chose 6th task");
                    Invoker.invokeTask6(args);
                    break;
                }
                case "7":
                case "task7": {
                    System.out.println("You chose 7th task");
                    Invoker.invokeTask7(args);
                    break;
                }
                case "8":
                case "task8": {
                    System.out.println("You chose 8th task");
                    Invoker.invokeTask8(args);
                    break;
                }
                case "9":
                case "task9": {
                    System.out.println("You chose 9th task");
                    Invoker.invokeTask9(args);
                    break;
                }
                case "10":
                case "task10": {
                    System.out.println("You chose 10th task");
                    Invoker.invokeTask10(args);
                    break;
                }
                case "11":
                case "exit": {
                    return;
                }
                default: {
                    System.out.println("Invalid option, try again");
                    break;
                }
            }
        }

    }
}
