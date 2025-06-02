package ru.practicum;

import java.util.Scanner;

class StepTracker {
    private Scanner scanner;
    private int goalByStepsPerDay = 10_000;
    private final int SIZE = 12;
    MonthData[] monthToData = new MonthData[SIZE];

    StepTracker(Scanner scan) {
        scanner = scan;

        for (int month = 0; month < monthToData.length; month++) {
            monthToData[month] = new MonthData();
        }
    }

    public void addNewNumberStepsPerDay() {
        // ввод и проверка номера месяца
        System.out.println("Введите номер месяца от 1 до 12");
        int month = 0;
        while (true) {
            month = getInteger();
            if (month >= 1 && month <= 12) {
                break;
            } else {
                System.out.println("Неверный формат ввода");
            }
        }
        // ввод и проверка дня
        System.out.println("Введите день от 1 до 30 (включительно)");
        int day = 0;
        while (true) {
            day = getInteger();
            if (day >= 1 && day <= 30) {
                break;
            } else {
                System.out.println("Неверный формат ввода");
            }
        }
        // ввод и проверка количества шагов
        System.out.println("Введите количество шагов");
        int step = 0;
        while (true) {
            step = getInteger();
            if (step > -1) {
                break;
            } else {
                System.out.println("Неверный формат ввода");
            }
        }
        // получение соответствующего объекта MonthData из массива
        MonthData monthData = monthToData[month - 1];
        // сохранение полученных данных
        monthData.days[day - 1] = step;
        System.out.println("Записано.");
    }

    public void changeStepGoal() {
        //goalByStepsPerDay-он будет менять это значение на то, которое ввёл пользователь.
        System.out.println("Введите новую цель по Шагам в день");
        while (true) {
            goalByStepsPerDay = getInteger();
            if (goalByStepsPerDay > 0) {
                System.out.println("Записано");
                break;
            } else {
                System.out.println("Неверный формат ввода");
            }
        }
    }

    public void printStatistic() {
        Converter converter = new Converter();
        System.out.println("Введите номер месяца");
        // ввод и проверка номера месяца
        int month = 0;
        while (true) {
            month = getInteger();
            if (month >= 1 && month <= 12) {
                month -= 1;
                break;
            } else {
                System.out.println("Неверный формат ввода");
            }
        }

        //* monthData = // получение соответствующего месяца
        MonthData monthData = monthToData[month];
        // получение суммы шагов за месяц
        int sumSteps = monthData.sumStepsFromMonth();
        // вывод общей статистики по дням
        monthData.printDaysAndStepsFromMonth();
        // вывод суммы шагов за месяц
        System.out.println("вывод суммы шагов за месяц : " + sumSteps);
        // вывод максимального пройденного количества шагов за месяц
        System.out.println("вывод максимального пройденного количества шагов за месяц : " + monthData.maxSteps());
        // вывод среднего пройденного количества шагов за месяц
        System.out.println("вывод среднего пройденного количества шагов за месяц : " + (sumSteps / monthData.days.length));
        // вывод пройденной за месяц дистанции в километрах
        System.out.println("вывод пройденной за месяц дистанции в километрах : " + converter.convertToKm(sumSteps));
        // вывод количества сожжённых килокалорий за месяц
        System.out.println("вывод количества сожжённых килокалорий за месяц : " + converter.convertStepsToKilocalories(sumSteps));
        // вывод лучшей серии
        System.out.println("вывод лучшей серии : " + monthData.bestSeries(goalByStepsPerDay));
        System.out.println(); // дополнительный перенос строки
    }

    public int getInteger() {
        int num = 0;
        while (true) {
            if (scanner.hasNextInt()) {
                num = scanner.nextInt();
                break;
            } else if(scanner.hasNextLine()){
                System.err.println("Введите цифру");
                scanner.nextLine();
            } else {
                scanner.nextLine();
            }
        }
        return num;
    }
}