package career.softserveinc.com.softserve.Controller;

import career.softserveinc.com.softserve.Model.NumberOfTaskToRun;
import career.softserveinc.com.softserve.Model.task1.Task1Arguments;
import career.softserveinc.com.softserve.Model.task2.Task2Arguments;
import career.softserveinc.com.softserve.View.Reader;
import career.softserveinc.com.softserve.View.Writer;

public class Main {

    public static void main(String[] args){

        int[] consoleIntArguments;
        double[] consoleDoubleArguments;
        NumberOfTaskToRun numberOfTaskToRun;

        Writer.writeGreatings();

        numberOfTaskToRun = new NumberOfTaskToRun(Reader.readWhichTaskRun());

        while (!numberOfTaskToRun.validate()) {
            Writer.writeErrorOfEnteringNumberOfTaskToRun();
            numberOfTaskToRun = new NumberOfTaskToRun(Reader.readWhichTaskRun());
        }

        switch (numberOfTaskToRun.getIntArgs()[0]) {
            case 1: {
                Task1Arguments validArguments;
                Writer.tellYouAboutTask1();
                Writer.askWhetherPassReceivedArguments();
                if (Reader.readYesOrNo() && new Task1Arguments(args).validate()) {
                    validArguments = new Task1Arguments(args);
                    Writer.writeResultsOfTask(TaskInvoker.invokeTask1(validArguments));
                } else {
                    do {
                        Writer.askToWriteSomeArgumentsForTask1();
                        consoleIntArguments = Reader.readTask1Arguments();
                        validArguments = new Task1Arguments(consoleIntArguments);
                    } while (!validArguments.validate());
                    Writer.writeResultsOfTask(TaskInvoker.invokeTask1(validArguments));
                }
                break;
            }
            case 2: {
                Task2Arguments validArguments;
                Writer.tellYouAboutTask2();
                Writer.askWhetherPassReceivedArguments();
                boolean yesOrNo = Reader.readYesOrNo();
                if (yesOrNo && new Task2Arguments(args).validate()) {
                    validArguments = new Task2Arguments(args);
                    boolean doAgain;
                    do{
                        Writer.writeResultsOfTask(TaskInvoker.invokeTask2(validArguments));
                        doAgain = Reader.readYesOrNo();
                        if(doAgain){
                            do {
                                Writer.askToWriteSomeArgumentsForTask2();
                                consoleDoubleArguments = Reader.readTask2Arguments();
                                validArguments = new Task2Arguments(consoleDoubleArguments);
                            } while (!validArguments.validate());
                        }else {
                            break;
                        }
                    }while(true);

                } else {
                    if(yesOrNo){
                        Writer.writeInvalidArgsErrorMessage();
                    }
                    do {
                        Writer.askToWriteSomeArgumentsForTask2();
                        consoleDoubleArguments = Reader.readTask2Arguments();
                        validArguments = new Task2Arguments(consoleDoubleArguments);
                        if(!validArguments.validate()){
                            Writer.writeInvalidArgsErrorMessage();
                        } else break;
                    } while (true);
                    Writer.writeResultsOfTask(TaskInvoker.invokeTask2(validArguments));
                }
                break;
            }
            case 11: {
            }
        }


    }
}
