package ru.job4j.kiss.fool;

import java.util.Scanner;

public class Fool {

    public static void main(String[] args) {
        System.out.println("Игра FizzBuzz.");
        int startAt = 1;
        var input = new Scanner(System.in);
        while (startAt < 100) {
            System.out.println(returnText(startAt));
            startAt++;
            var answer = input.nextLine();
            if (!check(startAt, answer)) {
                System.out.println("Ошибка. Начинай снова.");
                startAt = 0;
            }
            startAt++;
        }
    }

    public static boolean check(int number, String answer) {
        return returnText(number).equals(answer);
    }

    public static String returnText(int number) {
        if (number % 3 == 0 && number % 5 == 0) {
            return "FizzBuzz";
        } else if (number % 3 == 0) {
            return "Fizz";
        } else if (number % 5 == 0) {
            return "Buzz";
        } else {
            return String.valueOf(number);
        }
    }
}
