package ru.practicum.calorieCounter.service;
/*
Преобразование шагов в килокалории и километры
 */
public class ConverterService {
    //1 шаг = 75 см;
    private final double stepLength = 0.75;
    // 1 шаг =  50 кал;   1 ккал =  1000 кал
    private final double stepCalories = 0.5;

    //int convertToKm(int steps): метод, который переводит количество шагов в километры;
    public int convertToKm(int steps) {
        return (int) (steps * stepLength / 1000);
    }

    //int convertStepsToKilocalories(int steps): метод, который переводит количество шагов в килокалории.
    public int convertStepsToKilocalories(int steps) {
        return (int) (steps * stepCalories / 10);
    }

}
