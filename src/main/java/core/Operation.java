package core;

import java.math.BigInteger;

public class Operation {

    public static BigInteger addition(BigInteger number1, BigInteger number2) {
        return number1.add(number2);
    }

    public static BigInteger subtraction(BigInteger number1, BigInteger number2) {
        return number1.subtract(number2);
    }

    public static BigInteger multiplication(BigInteger number1, BigInteger number2) {
        return number1.multiply(number2);
    }

    public static BigInteger division(BigInteger number1, BigInteger number2) {
        return number1.divide(number2);
    }

    public static BigInteger pow(BigInteger number, int exponent) {
        return number.pow(exponent);
    }

    public static BigInteger root(BigInteger number, int exponent) {
        int n1 = exponent - 1;
        BigInteger n2 = BigInteger.valueOf(exponent);
        BigInteger n3 = BigInteger.valueOf(n1);
        BigInteger c = BigInteger.ONE;
        BigInteger d = n3.add(number).divide(n2);
        BigInteger e = n3.multiply(d).add(number.divide(d.pow(n1))).divide(n2);
        while (!c.equals(d) && !c.equals(e)) {
            c = d;
            d = e;
            e = n3.multiply(e).add(number.divide(e.pow(n1))).divide(n2);
        }
        if (d.compareTo(e) < 0) {
            return d;
        }
        return e;
    }
}
