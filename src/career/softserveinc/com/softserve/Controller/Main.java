package career.softserveinc.com.softserve.Controller;

import career.softserveinc.com.softserve.Model.NumberOfTaskToRun;
import career.softserveinc.com.softserve.Model.RunnableTasks;
import career.softserveinc.com.softserve.Model.task1.Task1Runner;
import career.softserveinc.com.softserve.Model.task2.Task2Runner;
import career.softserveinc.com.softserve.Model.task3.Task3Runner;
import career.softserveinc.com.softserve.View.Reader;
import career.softserveinc.com.softserve.View.Writer;

public class Main {

    public static void main(String[] args) {

        NumberOfTaskToRun numberOfTaskToRun;
        RunnableTasks rt;
        Writer.writeGreetings();
        Writer.seperateNewTask();

        numberOfTaskToRun = new NumberOfTaskToRun(Reader.readWhichTaskRun());

        while (!numberOfTaskToRun.validate()) {
            Writer.writeErrorOfEnteringNumberOfTaskToRun();
            numberOfTaskToRun = new NumberOfTaskToRun(Reader.readWhichTaskRun());
        }

        switch (numberOfTaskToRun.getIntArgs()[0]) {
            case 1: {
                rt = new Task1Runner(args);
                rt.run();
                break;
            }
            case 2: {
                rt = new Task2Runner(args);
                rt.run();
                break;
            }

            case 3: {
                rt = new Task3Runner(args);
                rt.run();
                break;
            }

            case 11: {
                break;
            }
        }


    }
}
