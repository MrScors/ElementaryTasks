package career.softserveinc.com.softserve.Model.task3;

import java.util.Set;

public interface ITask3Arguments {
    Set<Triangle> getArgs();
    boolean validate(String[] stringArguments);
}
