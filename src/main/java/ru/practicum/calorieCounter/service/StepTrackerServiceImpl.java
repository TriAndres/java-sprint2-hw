package ru.practicum.calorieCounter.service;

import ru.practicum.calorieCounter.file.StepTrackerFile;
import ru.practicum.calorieCounter.model.MonthOrder;
import ru.practicum.calorieCounter.model.StepTracker;
import ru.practicum.calorieCounter.service.methods.ConverterMethods;
import ru.practicum.calorieCounter.service.methods.MonthDataMethods;

import java.util.Objects;

import static ru.practicum.calorieCounter.controller.StepTrackerController.consoleMethods;
import static ru.practicum.calorieCounter.model.MonthOrder.*;

public class StepTrackerServiceImpl implements StepTrackerService {
    private final StepTrackerFile stepTrackerFile;
    private MonthDataMethods monthDataService;
    private final ConverterMethods converter;

    public StepTrackerServiceImpl(StepTrackerFile stepTrackerFile) {
        this.stepTrackerFile = stepTrackerFile;
        monthDataService = new MonthDataMethods();
        converter = new ConverterMethods();
        if (stepTrackerFile.findAll().isEmpty()) {
            setDay();
        }
    }

    public void addNewNumberStepsPerDay() {
        // ввод и проверка номера месяца
        int month = 0;
        do {
            System.out.println("Введите номер месяца от 1 до 12");
            month = consoleMethods().getInteger();
        } while (month < 1 || month > 12);

        MonthOrder monthOrder = from(String.valueOf(month));
        // ввод и проверка дня
        int day = 0;
        do {
            System.out.println("Введите день от 1 до " + Objects.requireNonNull(monthOrder).getDay());
            day = consoleMethods().getInteger();
        } while (day <= 0 || day > Objects.requireNonNull(monthOrder).getDay());
        // получение соответствующего объекта StepTracker из массива
        long idDay = 0;
        for (StepTracker tracker : stepTrackerFile.findAll()) {
            if (tracker.getMonth() == monthOrder && tracker.getDay() == day) {
                idDay = tracker.getId();
            }
        }
        StepTracker tracker = stepTrackerFile.findById(idDay);
        // ввод и проверка количества шагов
        int step = 0;
        do {
            System.out.println("Введите количество шагов");
            step = consoleMethods().getInteger();
        } while (step <= -1);
        tracker.setStep(step);
        // сохранение полученных данных
        stepTrackerFile.save(tracker);
        System.out.println("Записано.");
    }




    public void printStatistic() {
        // ввод и проверка номера месяца
        int month = 0;
        do {
            System.out.println("Введите номер месяца от 1 до 12");
            month = consoleMethods().getInteger();
        } while (month < 1 || month > 12);

        for (StepTracker tracker1 : stepTrackerFile.findAll()) {
            if (tracker1.getMonth().equals(from(String.valueOf(month)))) {
                System.out.println("id " + tracker1.getId() + ", месяц " + tracker1.getMonth() +
                        ", день " + tracker1.getDay() + ", шаги " + tracker1.getStep());
            }
        }
//        //* monthData = // получение соответствующего месяца
//        MonthDataService monthData = monthToData[month];
//        // получение суммы шагов за месяц
//        int sumSteps = monthData.sumStepsFromMonth();
//        // вывод общей статистики по дням
//        monthData.printDaysAndStepsFromMonth();
//        // вывод суммы шагов за месяц
//        System.out.println("вывод суммы шагов за месяц : " + sumSteps);
//        // вывод максимального пройденного количества шагов за месяц
//        System.out.println("вывод максимального пройденного количества шагов за месяц : " + monthData.maxSteps());
//        // вывод среднего пройденного количества шагов за месяц
//        System.out.println("вывод среднего пройденного количества шагов за месяц : " + (sumSteps / monthData.days.length));
//        // вывод пройденной за месяц дистанции в километрах
//        System.out.println("вывод пройденной за месяц дистанции в километрах : " + converter.convertToKm(sumSteps));
//        // вывод количества сожжённых килокалорий за месяц
//        System.out.println("вывод количества сожжённых килокалорий за месяц : " + converter.convertStepsToKilocalories(sumSteps));
//        // вывод лучшей серии
//        System.out.println("вывод лучшей серии : " + monthData.bestSeries(goalByStepsPerDay));
//        System.out.println(); // дополнительный перенос строки
    }

    private void setDay() {
        int month = 1;
        do {
            for (int day = 1; day <= Objects.requireNonNull(from(String.valueOf(month))).getDay(); day++) {
                stepTrackerFile.save(new StepTracker(getNextId(), from(String.valueOf(month)), day, 0));
            }
            ++month;
        } while (month <= 12);
    }

    private long getNextId() {
        long nextMaxId = stepTrackerFile.findAll()
                .stream()
                .mapToLong(StepTracker::getId)
                .max()
                .orElse(0);
        return ++nextMaxId;
    }
}