package ru.practicum.calorieCounter.service;
/*
Логика по подсчёту статистики за месяц; хранение данных конкретного месяца
 */
public class MonthDataService {
    private final int SIZE = 30;
    int[] days = new int[SIZE];

    public void printDaysAndStepsFromMonth() {
        for (int day = 0; day < days.length; day++) {
            // вывод элементов массива в нужном формате
            System.out.println((day + 1) + " день: " + days[day]);
        }
    }

    public int sumStepsFromMonth() {
        int sumSteps = 0;
        for (int day = 0; day < days.length; day++) {
            // подсчёт суммы элементов массива days[]
            sumSteps += days[day];
        }
        return sumSteps;
    }

    public int maxSteps() {
        int maxSteps = 0;
        for (int day = 0; day < days.length; day++) {
            // поиск максимального элемента
            if (maxSteps < days[day]) {
                maxSteps = days[day];
            }
        }
        return maxSteps;
    }

    public int bestSeries(int goalByStepsPerDay) {
        int currentSeries = 0;
        int finalSeries = 0;
        for (int day = 0; day < days.length; day++) {
            // поиск максимальной серии
            if (days[day] >= goalByStepsPerDay) {
                if (++currentSeries > finalSeries) {
                    finalSeries = currentSeries;
                }
            } else {
                currentSeries = 0;
            }
        }
        return finalSeries;
    }
}
