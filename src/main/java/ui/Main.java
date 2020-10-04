package ui;

import core.Operation;
import core.Prime;
import core.RandomNumber;

import java.io.IOException;
import java.math.BigInteger;

public class Main {
    public static void main (String args[]) throws IOException {
        /*
        BigInteger num1 = RandomNumber.generateBigRandomNumber(90);
        Prime prime = new Prime(num1); //just put here new BigInteger("number") to test for an specific number
        System.out.println(prime.isPrime());
        System.out.println("Número random generado: " + num1);

        BigInteger number = RandomNumber.generateBigRandomNumber(10);
        System.out.println("Número random generado: " + number);
        System.out.println(Operation.addition(number,new BigInteger("2")));

        number = RandomNumber.generateBigRandomNumber(10);
        System.out.println("Número random generado: " + number);
        System.out.println(Operation.subtraction(number,new BigInteger("2")));

        number = RandomNumber.generateBigRandomNumber(10);
        System.out.println("Número random generado: " + number);
        System.out.println(Operation.multiplication(number,new BigInteger("2")));

        number = RandomNumber.generateBigRandomNumber(10);
        System.out.println("Número random generado: " + number);
        System.out.println(Operation.division(number,new BigInteger("2")));

        number = RandomNumber.generateBigRandomNumber(10);
        System.out.println("Número random generado: " + number);
        System.out.println(Operation.pow(number,2));

        number = RandomNumber.generateBigRandomNumber(10);
        System.out.println("Número random generado: " + number);
        System.out.println(Operation.root(number,3)); */
        new Menu().initMenu();
    }
}
