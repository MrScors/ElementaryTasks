package career.softserveinc.com.softserve.model.task7;

import java.util.List;

public class IntegerSequence {
    private List<Integer> integers;

    IntegerSequence(List<Integer> integers) {
        this.integers = integers;
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        for(Integer integer: integers){
            sb.append(integer.toString()).append(",").append(" ");
        }
        sb.delete(sb.lastIndexOf(","), sb.lastIndexOf(" "));
        return sb.toString();
    }
}
