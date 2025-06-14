package ru.practicum.calorieCounter.service;

import ru.practicum.calorieCounter.model.StepTracker;

import java.util.List;

/*
Логика по подсчёту статистики за месяц; хранение данных конкретного месяца
 */
public class MonthDateService {
    private final List<StepTracker> trackerList;

    public MonthDateService(List<StepTracker> trackerList) {
        this.trackerList = trackerList;
    }

    public List<StepTracker> getTrackerList() {
        return trackerList;
    }

    public void printDaysAndStepsFromMonth() {
        for (StepTracker tracker : trackerList) {
            // вывод элементов массива в нужном формате
            System.out.println(tracker.getDay() + " день: " + tracker.getStep());
        }
    }

    public int sumStepsFromMonth() {
        int sumSteps = 0;
        for (StepTracker stepTracker : trackerList) {
            sumSteps += stepTracker.getStep();
        }
        return sumSteps;
    }

    public int maxSteps() {
        int maxSteps = 0;
        for (StepTracker day : trackerList) {
            // поиск максимального элемента
            if (maxSteps < day.getStep()) {
                maxSteps = day.getStep();
            }
        }
        return maxSteps;
    }

    public int bestSeries(int goalByStepsPerDay) {
        int currentSeries = 0;
        int finalSeries = 0;
        for (int day = 0; day < trackerList.size(); day++) {
            // поиск максимальной серии
            if (trackerList.get(day).getStep() >= goalByStepsPerDay) {
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