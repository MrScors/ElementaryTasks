package career.softserveinc.com.softserve.Controller;

import career.softserveinc.com.softserve.Model.NumberOfTaskToRun;
import career.softserveinc.com.softserve.Model.task1.Task1Arguments;
import career.softserveinc.com.softserve.Model.task2.Task2Arguments;
import career.softserveinc.com.softserve.Model.task3.Task3Arguments;
import career.softserveinc.com.softserve.View.Reader;
import career.softserveinc.com.softserve.View.Writer;

public class Main {

    public static void main(String[] args) {

        NumberOfTaskToRun numberOfTaskToRun;

        Writer.writeGreetings();
        Writer.seperateNewTask();

        numberOfTaskToRun = new NumberOfTaskToRun(Reader.readWhichTaskRun());

        while (!numberOfTaskToRun.validate()) {
            Writer.writeErrorOfEnteringNumberOfTaskToRun();
            numberOfTaskToRun = new NumberOfTaskToRun(Reader.readWhichTaskRun());
        }

        switch (numberOfTaskToRun.getIntArgs()[0]) {
            case 1: {
                int[] consoleArguments;
                Task1Arguments validArguments;
                Writer.tellYouAboutTask1();
                Writer.askWhetherPassReceivedArguments();
                if (Reader.readYesOrNo() && new Task1Arguments(args).validate()) {
                    validArguments = new Task1Arguments(args);
                    Writer.writeResultsOfTask(TaskInvoker.invokeTask1(validArguments));
                } else {
                    do {
                        Writer.askToWriteSomeArgumentsForTask1();
                        consoleArguments = Reader.readTask1Arguments();
                        validArguments = new Task1Arguments(consoleArguments);
                    } while (!validArguments.validate());
                    Writer.writeResultsOfTask(TaskInvoker.invokeTask1(validArguments));
                }
                break;
            }
            case 2: {
                double[] consoleArguments;
                Task2Arguments validArguments;
                Writer.tellYouAboutTask2();
                Writer.askWhetherPassReceivedArguments();
                boolean yesOrNo = Reader.readYesOrNo();
                if (yesOrNo && new Task2Arguments(args).validate()) {
                    validArguments = new Task2Arguments(args);
                    boolean doAgain;
                    do {
                        Writer.writeResultsOfTask(TaskInvoker.invokeTask2(validArguments));
                        doAgain = Reader.readYesOrNo();
                        if (doAgain) {
                            do {
                                Writer.askToWriteSomeArgumentsForTask2();
                                consoleArguments = Reader.readTask2Arguments();
                                validArguments = new Task2Arguments(consoleArguments);
                            } while (!validArguments.validate());
                        } else {
                            break;
                        }
                    } while (true);
                } else {
                    if (yesOrNo) {
                        Writer.writeInvalidArgsErrorMessage();
                    }
                    boolean doAgain;
                    do {
                        do {
                            Writer.askToWriteSomeArgumentsForTask2();
                            consoleArguments = Reader.readTask2Arguments();
                            validArguments = new Task2Arguments(consoleArguments);
                            if (!validArguments.validate()) {
                                Writer.writeInvalidArgsErrorMessage();
                            } else break;
                        } while (true);
                        Writer.writeResultsOfTask(TaskInvoker.invokeTask2(validArguments));
                        Writer.askWhetherDoOnceMore();
                        doAgain = Reader.readYesOrNo();
                    } while (doAgain);

                }
                break;
            }

            case 3: {
                String consoleArguments;
                Task3Arguments validArguments = new Task3Arguments();
                Writer.tellYouAboutTask3();
                Writer.askWhetherPassReceivedArguments();
                if (Reader.readYesOrNo()){
                    if(!validArguments.add(args)){
                        Writer.writeInvalidArgsErrorMessage();
                    }
                }
                Writer.askToWriteSomeArgumentsForTask3();
                do {
                    if(!validArguments.add(Reader.readTask3Arguments())){
                        Writer.writeInvalidArgsErrorMessage();
                    }
                    Writer.askWhetherAddMoreTriangles();
                } while (Reader.readYesOrNo());
                Writer.writeResultsOfTask(TaskInvoker.invokeTask3(validArguments));
                break;
            }

            case 11: {
                break;
            }
        }


    }
}
