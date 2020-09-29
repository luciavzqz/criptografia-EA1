package core;

import java.math.BigInteger;
import java.security.SecureRandom;

public class RandomNumber {

    public static BigInteger generarNumeroAleatorio(){
        return new BigInteger("1");
    }

    private static BigInteger generarSemilla(){
        final SecureRandom secureRandom = new SecureRandom();

        return new BigInteger("1");
    }
}
