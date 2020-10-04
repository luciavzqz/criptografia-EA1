package ui;

import core.Prime;
import core.RandomNumber;

import java.math.BigInteger;

public class Main {
    public static void main (String args[]) {
        BigInteger num1 = RandomNumber.generateBigRandomNumber(90);
        Prime prime = new Prime(num1); //just put here new BigInteger("number") to test for an specific number
        System.out.println(prime.isPrime());
        System.out.println("Número random generado: " + num1);
    }
}
