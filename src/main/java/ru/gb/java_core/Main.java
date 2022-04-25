package ru.gb.java_core;

import java.util.Random;

public class Main {

    public static final int LENGTH = 4;
    public static final int DEPTH = 4;

    public static void main(String[] args) {

        Random rand = new Random();
        String[][] array = new String[4][4];

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                int number = rand.nextInt(100);
                array[i][j] = Integer.toString(number);
                System.out.println(array[i][j]);
            }
        }

        //array[2][2] = "error";

        try {
            try {
                System.out.printf("sum = %d\n", resultSum(array));
            } catch (MySizeArrayException e) {
                System.out.println("Передан массив некорректного размера.");
            }
        }
        catch (MyArrayDataException e) {
            System.out.printf("Некорректное значение в ячейке массива [%d][%d]\n", e.i, e.j);
        }

    }

    public static int resultSum(String[][] array) throws MySizeArrayException, MyArrayDataException {

        if (array.length != LENGTH || array[0].length != DEPTH) {
            throw new MySizeArrayException();
        }

        int sum = 0;

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {

                try {
                    sum += Integer.parseInt(array[i][j]);
                }
                catch (NumberFormatException e) {
                    throw new MyArrayDataException(i, j);
                }

            }
        }

        return sum;
    }
}
