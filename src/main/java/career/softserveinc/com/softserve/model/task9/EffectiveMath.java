package main.java.career.softserveinc.com.softserve.model.task9;

public class EffectiveMath {

    static long pow(long x, long n, long mod) {
        long res = 1;
        for (long p = x; n > 0; n >>= 1, p = (p * p) % mod) {
            if ((n & 1) != 0) {
                res = (int) (res * p % mod);
            }
        }
        return res;
    }
}
