package main.java.career.softserveinc.com.softserve.model.task3;

import main.java.career.softserveinc.com.softserve.model.RunnableTasks;
import main.java.career.softserveinc.com.softserve.arguments_input.Reader;
import main.java.career.softserveinc.com.softserve.view.ConsolePrinter;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;

public class Task3Runner implements RunnableTasks {

    private String[] args;

    public Task3Runner(String[] args) {
        this.args = args;
    }

    @Override
    public void run(BufferedReader br) throws IOException {
        Task3Arguments validArguments = new Task3Arguments();
        ConsolePrinter.tellYouAboutTask3();
        ConsolePrinter.askWhetherPassReceivedArguments();
        boolean useArgs = Reader.readYesOrNo(br);
        if (useArgs) {
            if (!validArguments.add(args)) {
                ConsolePrinter.writeInvalidArgsErrorMessage();
            }
            ConsolePrinter.askWhetherAddMoreTriangles();
            if(Reader.readYesOrNo(br)) addMoreTriangles(validArguments, br);
        } else {
            addMoreTriangles(validArguments, br);
        }
        ConsolePrinter.writeResultsOfTask(invokeTask3(validArguments));
    }

    private static void addMoreTriangles(Task3Arguments validArguments, BufferedReader br) throws IOException {
        do {
            ConsolePrinter.askToWriteSomeArgumentsForTask3();
                if (!validArguments.add(Reader.readTask3Arguments(br))) {
                    ConsolePrinter.writeInvalidArgsErrorMessage();
                }
            ConsolePrinter.askWhetherAddMoreTriangles();
        } while (Reader.readYesOrNo(br));
    }


    private static StringBuilder invokeTask3(ITask3Arguments arguments) {
        List<Triangle> triangles = arguments.getArgs();
        StringBuilder sb = new StringBuilder("============= Triangles list: ===============\n");
        for (Triangle t : triangles) {
            sb.append(t.toString()).append("\n");
        }
        return sb;
    }


}
