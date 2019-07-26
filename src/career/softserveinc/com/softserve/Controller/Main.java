package career.softserveinc.com.softserve.Controller;

import career.softserveinc.com.softserve.Model.RunnableTasks;
import career.softserveinc.com.softserve.Model.task1.Task1Runner;
import career.softserveinc.com.softserve.Model.task2.Task2Runner;
import career.softserveinc.com.softserve.Model.task3.Task3Runner;
import career.softserveinc.com.softserve.View.Reader;
import career.softserveinc.com.softserve.View.Writer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) {

        NumberOfTaskToRun numberOfTaskToRun;
        RunnableTasks rt;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Writer.writeGreetings();
        Writer.seperateNewTask();

        do{
            try {
                numberOfTaskToRun = new NumberOfTaskToRun(Reader.readWhichTaskRun(br));
                if(numberOfTaskToRun.validate()) break;
                else Writer.writeInvalidArgsErrorMessage();
            } catch (IOException | NumberFormatException e) {
                System.err.println(e.getMessage());
            }
        } while(true);

        switch (numberOfTaskToRun.getIntArgs()[0]) {
            case 1: {
                rt = new Task1Runner(args);
                rt.run(br);
                break;
            }
            case 2: {
                rt = new Task2Runner(args);
                rt.run(br);
                break;
            }

            case 3: {
                rt = new Task3Runner(args);
                rt.run(br);
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
