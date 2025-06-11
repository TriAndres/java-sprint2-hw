package ru.practicum.calorieCounter.repository;

import ru.practicum.calorieCounter.model.StepTracker;

import java.util.*;

public class StepTrackerRepositoryImpl implements StepTrackerRepository {
    private final Map<Long, StepTracker> stepTrackerMap = new HashMap<>();

    @Override
    public Collection<StepTracker> findAll() {
        return new ArrayList<>(stepTrackerMap.values());
    }

    @Override
    public StepTracker save(StepTracker stepTracker) {
        return stepTrackerMap.put(stepTracker.getId(), stepTracker);
    }

    @Override
    public StepTracker findById(long id) {
        return stepTrackerMap.get(id);
    }

    @Override
    public void deleteById(long id) {
        stepTrackerMap.remove(id);
    }

    @Override
    public void deleteAll() {
        stepTrackerMap.clear();
    }
}