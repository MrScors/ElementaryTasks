package main.java.career.softserveinc.com.softserve.model.task7;

import java.util.ArrayList;
import java.util.List;

public class IntegerSequenceCreator {

    static IntegerSequence createSequenceOfIntegersWhichSquareIsLowerThan(int limit){
        List<Integer> integerSequence = new ArrayList<>();
        for (int i = 0; Math.pow(i, 2) < limit; i++) {
            integerSequence.add(i);
        }
        return new IntegerSequence(integerSequence);
    }

}
