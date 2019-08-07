package main.java.career.softserveinc.com.softserve.model.task6;

import javax.swing.*;
import java.math.BigDecimal;
import java.math.BigInteger;

public class CounterOfLuckyTickets {

    public static BigDecimal countLuckyTickets(BigDecimal n, BigDecimal m) {
        BigDecimal N = new BigDecimal("1000000").
                multiply(new BigDecimal("1").
                        add(n.divide(new BigDecimal("2").multiply(m.add(new BigDecimal("-1"))))));
        BigDecimal x;
        BigDecimal sum = new BigDecimal("0.0");
        BigDecimal a = new BigDecimal("0.00000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000001");
        for (BigDecimal i = new BigDecimal("0"); i.compareTo(N)<0; i = i.add(new BigDecimal("1"))) {
            x = a.add(i.multiply(new BigDecimal(Double.toString(Math.PI))).divide(N));
            sum = sum.add(f(x, n, m)) ;
        }
        return sum.divide(N).divide(new BigDecimal(Double.toString(Math.PI)));
    }

    private static BigDecimal f(BigDecimal x, BigDecimal n, BigDecimal m) {
        return new BigDecimal((Double.toString(
                        Math.sin(m.multiply(x).doubleValue())))).divide(new BigDecimal(Double.toString(Math.sin(x.doubleValue())))).pow(n.intValue()).abs();
    }

}
