package ui;

import core.Operation;
import core.Prime;
import core.RandomNumber;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Menu {

    private static final int CHECK_RANDOM = 1;
    private static final int CHECK_FROM_USER = 2;
    private static final int OPERATE_RANDOM = 3;
    private static final int OPERATE_FROM_USER = 4;

    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public void initMenu() throws IOException {
        while(true) {
            System.out.println("Para verificar si un número aleatorio es random, presione 1 \n" +
                    "Para verificar si un número ingresado por usted es random, presione 2 \n" +
                    "Para realizar operaciones aritméticas con 2 números random, presione 3 \n" +
                    "Para realizar operaciones aritméticas con 2 números ingresados por usted, presione 4");
            int input = Integer.parseInt(this.reader.readLine());
            evaluateInput(input);
        }
    }

    private void evaluateInput(int input) throws IOException {
        switch(input) {
            case CHECK_RANDOM:
                checkIfRandomIsPrime();
                break;

            case CHECK_FROM_USER:
                checkIfUserInputIsPrime();
                break;

            case OPERATE_RANDOM:
                operateRandom();
                break;

            case OPERATE_FROM_USER:
                operateFromUser();
                break;

            default:
                System.out.println("Seleccione una de las opciones listadas arriba.");
        }
    }

    private void operateFromUser() throws IOException {
        System.out.println("Ingrese el 1er número: ");
        BigInteger num1 = new BigInteger(this.reader.readLine());
        System.out.println("Ingrese el 2do número: ");
        BigInteger num2 = new BigInteger(this.reader.readLine());
        doOperations(num1, num2);
    }

    private void doOperations(BigInteger num1, BigInteger num2) {
        System.out.println("La suma de ambos da: " + Operation.addition(num1, num2));
        System.out.println("La resta de ambos da: " +  Operation.subtraction(num1, num2));
        System.out.println("La división de el 1ro por el 2do da: " + Operation.division(num1, num2));
        System.out.println("La multiplicación de ambos da: " +  Operation.multiplication(num1, num2));
    }

    private void operateRandom() {
        BigInteger num1 = RandomNumber.generateBigRandomNumber(RandomNumber.generateBigRandomNumber(2).intValue());
        BigInteger num2 = RandomNumber.generateBigRandomNumber(RandomNumber.generateBigRandomNumber(2).intValue());
        System.out.println("Se trabajará con los números random: " +  num1 + "\n" +
                            "y " + num2);
        doOperations(num1, num2);
    }

    private void checkIfUserInputIsPrime() throws IOException {
        System.out.println("Ingrese su número a chequear: ");
        BigInteger num = new BigInteger(this.reader.readLine());
        Prime prime = new Prime(num);
        if(prime.isPrime()) {
            System.out.println("El número aleatorio generado es primo.");
        } else {
            System.out.println("El número aleatorio generado no es primo");
        }
    }

    private void checkIfRandomIsPrime() {
        BigInteger num1 = RandomNumber.generateBigRandomNumber(RandomNumber.generateBigRandomNumber(2).intValue());
        Prime prime = new Prime(num1);
        System.out.println("Número random generado: " + num1);
        if(prime.isPrime()) {
            System.out.println("El número aleatorio generado es primo.");
        } else {
            System.out.println("El número aleatorio generado no es primo");
        }
    }

}
