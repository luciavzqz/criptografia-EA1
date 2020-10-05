package core;

import java.math.BigInteger;
import java.net.BindException;
import java.security.SecureRandom;
import java.util.Random;

public class RandomNumber {

    public static BigInteger generateBigRandomNumber(int digits){
        BigInteger random = generateBigRandomNumberFromBits(digits);
        return random;
    }

    public static BigInteger generateBigRandomNumberFromBits(int digits){
        int bitsize = (int)(digits * 3.3);
        SecureRandom rng = new SecureRandom();
        BigInteger random = new BigInteger(bitsize - 1,rng);
        return random;
    }
}
