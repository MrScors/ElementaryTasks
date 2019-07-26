package career.softserveinc.com.softserve.controller;

import career.softserveinc.com.softserve.model.RunnableTasks;
import career.softserveinc.com.softserve.model.task1.Task1Runner;
import career.softserveinc.com.softserve.model.task2.Task2Runner;
import career.softserveinc.com.softserve.model.task3.Task3Runner;
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

        do{
            ConsolePrinter.seperateNewTask();
            try {
                numberOfTaskToRun = new NumberOfTaskToRun(Reader.readWhichTaskRun(br));
                if(numberOfTaskToRun.validate()) break;
                else ConsolePrinter.writeInvalidArgsErrorMessage();
            } catch (IOException | NumberFormatException e) {
                System.err.println(e.getMessage());
            }
        } while(true);

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

            case 11: {
                break;
            }
        }

        try {
            br.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }
}
