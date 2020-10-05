package core;

import java.math.BigInteger;
import java.net.BindException;
import java.security.SecureRandom;
import java.util.Random;

public class RandomNumber {

    public static BigInteger generateBigRandomNumber(int digits){
        SecureRandom rng = new SecureRandom();
        BigInteger random = getBigRandomNumber(digits,rng);
        return random;
    }

    public static BigInteger getBigRandomNumber(int digCount, Random rnd){
        final char[] bigNumber = new char[digCount];
        for(int i = 0; i < digCount; i++)
            bigNumber[i] = (char) ('0' + (i == 0 ? rnd.nextInt(9) + 1 : rnd.nextInt(10)));
        return new BigInteger(new String(bigNumber));
    }

    public static BigInteger generateBigRandomNumberFromBits(int digits){
        int bitsize = (int)(digits * 3.3);
        SecureRandom rng = new SecureRandom();
        BigInteger random = createRandomForBitSize(bitsize, rng);
        return random;
    }

    private static BigInteger createRandomForBitSize(int bitsize, Random rng) {
        BigInteger random = new BigInteger(bitsize - 1, rng);
        BigInteger lowestNumberBitSize = BigInteger.valueOf(2).pow(bitsize - 1);
        BigInteger randomBitSize = lowestNumberBitSize.add(random);
        return randomBitSize;
    }
}
