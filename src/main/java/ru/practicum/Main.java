package ru.practicum;

import java.util.Scanner;
/*
Вывод меню и выбор пункта
 */
class Main {
    private final Scanner scanner;
    private final StepTracker stepTracker;

    public Main() {
        scanner = new Scanner(System.in);
        stepTracker = new StepTracker(scanner);
    }

    public static void main(String[] args) {
        new Main().game();
    }

    public void game() {
        while (true) {
            printMenu();
            String line = printMenu();
            select(line);
            if (line.equals("4")) {
                break;
            }
        }
    }

    public String printMenu() {
        System.out.println("\t\nВыбирите команду:" +
                "\n\t1 - ввести количество шагов за определённый день" +
                "\n\t2 - изменить цель по количеству шагов в день" +
                "\n\t3 - напечатать статистику за определённый месяц;" +
                "\n\t4 - выйти из приложения"
        );
        return scanner.next();
    }

    public void select(String line) {
        switch (Command.from(line)) {
            case COMMAND1:
                stepTracker.addNewNumberStepsPerDay();
                break;
            case COMMAND2:
                stepTracker.changeStepGoal();
                break;
            case COMMAND3:
                stepTracker.printStatistic();
                break;
            case COMMAND4:
                System.out.println("Выход из программы.");
                break;
            case NULL:
                System.out.println("Неизвестная команда.");
                break;
        }
    }

    enum Command {
        COMMAND1, COMMAND2, COMMAND3, COMMAND4, NULL;

        public static Command from(String line) {
            switch (line.toUpperCase()) {
                case "1":
                    return COMMAND1;
                case "2":
                    return COMMAND2;
                case "3":
                    return COMMAND3;
                case "4":
                    return COMMAND4;
                default:
                    return NULL;
            }
        }
    }
}