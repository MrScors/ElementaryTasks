package career.softserveinc.com.softserve.controller;

import career.softserveinc.com.softserve.model.RunnableTasks;
import career.softserveinc.com.softserve.model.task1.Task1Runner;
import career.softserveinc.com.softserve.model.task2.Task2Runner;
import career.softserveinc.com.softserve.model.task3.Task3Runner;
import career.softserveinc.com.softserve.model.task4.Task4Runner;
import career.softserveinc.com.softserve.model.task6.Task6Runner;
import career.softserveinc.com.softserve.model.task7.Task7Runner;
import career.softserveinc.com.softserve.model.task8.Task8Runner;
import career.softserveinc.com.softserve.model.task9.EffectiveMath;
import career.softserveinc.com.softserve.model.task9.Task9Runner;
import career.softserveinc.com.softserve.view.Reader;
import career.softserveinc.com.softserve.view.ConsolePrinter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) {

        NumberOfTaskToRun numberOfTaskToRun;
        RunnableTasks rt;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        ConsolePrinter.writeGreetings();

        do {
            numberOfTaskToRun = getNumberOfTaskToRun(br);
            switch (numberOfTaskToRun.getIntArgs()[0]) {
                case 1: {
                    rt = new Task1Runner(args);
                    try {
                        rt.run(br);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    break;
                }
                case 2: {
                    rt = new Task2Runner(args);
                    try {
                        rt.run(br);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    break;
                }

                case 3: {
                    rt = new Task3Runner(args);
                    try {
                        rt.run(br);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    break;
                }


                case 4: {
                    rt = new Task4Runner(args);
                    try {
                        rt.run(br);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    break;
                }

                case 6: {
                    rt = new Task6Runner(args);
                    try {
                        rt.run(br);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    break;
                }

                case 7: {
                    rt = new Task7Runner(args);
                    try {
                        rt.run(br);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    break;
                }

                case 8: {
                    rt = new Task8Runner(args);
                    try {
                        rt.run(br);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    break;
                }

                case 9: {
                    rt = new Task9Runner(args);
                    try {
                        rt.run(br);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    break;
                }

                case 11: {
                    try {
                        br.close();
                    } catch (IOException e) {
                        System.out.println(e.getMessage());
                    }
                    return;
                }
            }

        } while (true);

    }

    private static NumberOfTaskToRun getNumberOfTaskToRun(BufferedReader br) {
        NumberOfTaskToRun numberOfTaskToRun;
        do {
            ConsolePrinter.separateNewTask();
            try {
                numberOfTaskToRun = new NumberOfTaskToRun(Reader.readWhichTaskRun(br));
                if (numberOfTaskToRun.validate()) break;
                else ConsolePrinter.writeInvalidArgsErrorMessage();
            } catch (IOException | NumberFormatException e) {
                ConsolePrinter.writeErrorOfEnteringNumberOfTaskToRun();
                System.err.println(e.getMessage());
            }
        } while (true);
        return numberOfTaskToRun;
    }

}
