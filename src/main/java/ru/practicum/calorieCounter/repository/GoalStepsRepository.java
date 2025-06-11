package ru.practicum.calorieCounter.repository;

import ru.practicum.calorieCounter.model.GoalSteps;

import java.util.Collection;

public interface GoalStepsRepository {
    Collection<GoalSteps> findAll();

    GoalSteps save(GoalSteps goalSteps);

    GoalSteps findById(long id);

    void deleteById(long id);

    void deleteAll();
}