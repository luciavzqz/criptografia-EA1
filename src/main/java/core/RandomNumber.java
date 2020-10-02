package core;

import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.Random;

public class RandomNumber {

    public static BigInteger generateBigRandomNumber(int digits){
        int bitsize = (int)(digits * 3.3);
        SecureRandom rng = new SecureRandom();
        BigInteger random = createRandomForBitSize(bitsize, rng);
        return random;
    }

    private static BigInteger createRandomForBitSize(int bitsize, Random rng) {
        BigInteger randomFromZero = new BigInteger(bitsize - 1, rng);
        BigInteger lowestNumberBitSize = BigInteger.valueOf(2).pow(bitsize - 1);
        BigInteger randomBitSize = lowestNumberBitSize.add(randomFromZero);
        return randomBitSize;
    }
}
