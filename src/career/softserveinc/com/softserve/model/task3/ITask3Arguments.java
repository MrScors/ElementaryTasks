package career.softserveinc.com.softserve.model.task3;

import java.util.Set;

public interface ITask3Arguments {
    Set<Triangle> getArgs();
    boolean validate(String[] stringArguments);
}
