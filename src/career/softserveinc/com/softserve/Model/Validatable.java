package career.softserveinc.com.softserve.Model;

public interface Validatable {
    int[] getIntArgs();
    double[] getDoubleArgs();
    boolean validate();
}
