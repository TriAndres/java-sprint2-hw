package ru.practicum.calorieCounter.repository;

import ru.practicum.calorieCounter.model.StepTracker;

import java.util.Collection;

public interface StepTrackerRepository {
    Collection<StepTracker> findAll();

    StepTracker save(StepTracker stepTracker);

    StepTracker findById(long id);

    void deleteById(long id);

    void deleteAll();
}
