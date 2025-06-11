package ru.practicum.calorieCounter.service.methods;

import java.util.Scanner;

public class ConsoleMethods {
    private final Scanner scanner;

    public ConsoleMethods() {
        scanner = new Scanner(System.in);
    }

    public int getInteger() {
        int num = 0;
        while (true) {
            if (scanner.hasNextInt()) {
                num = scanner.nextInt();
                break;
            } else if (scanner.hasNextLine()) {
                System.err.println("Введите цифру");
                scanner.nextLine();
            } else {
                scanner.nextLine();
            }
        }
        return num;
    }

    public String getString() {
        return scanner.next();
    }
}
