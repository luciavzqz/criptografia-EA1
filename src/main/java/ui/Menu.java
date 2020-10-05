package ui;

import core.Operation;
import core.Prime;
import core.RandomNumber;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.Date;
import java.util.Random;

public class Menu {

    private static final int CHECK_RANDOM = 1;
    private static final int CHECK_FROM_USER = 2;
    private static final int OPERATE_RANDOM = 3;
    private static final int OPERATE_FROM_USER = 4;
    //private static final int RANDOM_FROM_USER = 5;

    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public void initMenu() throws IOException {
        while(true) {
            System.out.println("Para verificar si un número aleatorio es primo, presione 1. \n" +
                    "Para verificar si un número ingresado por usted es primo, presione 2. \n" +
                    "Para realizar operaciones aritméticas con 2 números random, presione 3. \n" +
                    "Para realizar operaciones aritméticas con 2 números ingresados por usted, presione 4.");
            System.out.println("");
            System.out.print("Opción: ");
            int input = Integer.parseInt(this.reader.readLine());
            System.out.println("");
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
                System.out.println("Seleccione una de las opciones listadas abajo.\n");
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
        System.out.println("\n");
    }

    private void operateRandom() {
        BigInteger num1 = RandomNumber.generateBigRandomNumber(new Random().nextInt(90-10) + 10);
        BigInteger num2 = RandomNumber.generateBigRandomNumber(new Random().nextInt(90-10) + 10);
        System.out.println("Se trabajará con los números random:");
        System.out.println("\t Numero 1: " + num1);
        System.out.println("\t Numero 2: " + num2);
        System.out.println("");
        doOperations(num1, num2);
    }

    private void checkIfUserInputIsPrime() throws IOException {
        System.out.println("Ingrese su número a chequear: ");
        BigInteger num = new BigInteger(this.reader.readLine());
        Prime prime = new Prime(num);
        if(prime.isPrime()) {
            System.out.println("El número ingresado es primo.");
        } else {
            System.out.println("El número ingresado no es primo");
        }
        System.out.println("\n");
    }

    private void checkIfRandomIsPrime() {
        BigInteger num1 = RandomNumber.generateBigRandomNumber(new Random().nextInt(90-10) + 10);
        Prime prime = new Prime(num1);
        System.out.println("Número random generado: " + num1);
        if(prime.isPrime()) {
            System.out.println("El número aleatorio generado es primo.");
        } else {
            System.out.println("El número aleatorio generado no es primo");
        }
        System.out.println("\n");
    }

    private void generateRandom() throws IOException {
        System.out.print("Ingrese la cantidad de dígitos: ");
        int digits = Integer.parseInt(this.reader.readLine());
        System.out.println("");

        BigInteger num1 = RandomNumber.generateBigRandomNumber(digits);

        System.out.println("Número random generado: " + num1);
        System.out.println("Cantidad de bits del número: " + num1.bitLength());
        System.out.println("Cantidad de digitos del número: " + digits);
        System.out.println("\n");
    }

}
