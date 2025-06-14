package ru.practicum.calorieCounter.service;

public interface StepTrackerService {
    void addNewNumberStepsPerDay();

    void printStatistic();

    void setDay();
}