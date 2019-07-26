package career.softserveinc.com.softserve.Model.task3;

import career.softserveinc.com.softserve.Model.RunnableTasks;
import career.softserveinc.com.softserve.View.Reader;
import career.softserveinc.com.softserve.View.Writer;

import java.util.Set;

public class Task3Runner implements RunnableTasks {

    private String[] args;
    public Task3Runner(String[] args){
        this.args = args;
    }

    @Override
    public void run() {
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
        Writer.writeResultsOfTask(invokeTask3(validArguments));
    }


    private static  StringBuilder invokeTask3(ITask3Arguments arguments){
        Set<Triangle> triangles = arguments.getArgs();
        StringBuilder sb = new StringBuilder("============= Triangles list: ===============\n");
        for (Triangle t : triangles) {
            sb.append(t.toString()).append("\n");
        }
        return sb;
    }


}
