package ru.practicum.calorieCounter.repository;

import ru.practicum.calorieCounter.model.MonthData;
import ru.practicum.calorieCounter.model.StepTracker;

import java.util.Collection;

public interface MonthDataRepository {
    Collection<MonthData> findAll();

    MonthData save(MonthData monthData);

    MonthData findById(long id);

    void deleteById(long id);

    void deleteAll();
}
