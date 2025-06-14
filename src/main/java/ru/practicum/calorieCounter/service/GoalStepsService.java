package ru.practicum.calorieCounter.service;

import ru.practicum.calorieCounter.model.GoalSteps;

import java.util.List;

public interface GoalStepsService {
    List<GoalSteps> findAll();

    void changeStepGoal();

    int goalByStepsPerDay();
}