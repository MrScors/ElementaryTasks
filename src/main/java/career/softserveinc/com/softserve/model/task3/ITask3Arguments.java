package main.java.career.softserveinc.com.softserve.model.task3;

import java.util.List;

public interface ITask3Arguments {
    List<Triangle> getArgs();
    boolean validate(String[] stringArguments);
}
