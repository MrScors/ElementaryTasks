package main.java.career.softserveinc.com.softserve.model.task6;

public class CounterOfLuckyTickets {

    public static double countLuckyTickets(Double n, Double m) {
        Double N = 1_000_000 * (1.0 + ((n / 2.0) * (m - 1.0)));
        Double x;
        Double sum = 0.0;
        Double a = 0.0000001;
        for (Double i = 0.0; i < N; i++) {
            x = a + i * Math.PI / N;
            sum += f(x, n, m);
        }
        return sum / N / Math.PI;
    }

    private static Double f(Double x, Double n, Double m) {
        return Math.abs(Math.pow((Math.sin(m * x) / Math.sin(x)), n));
    }

}
