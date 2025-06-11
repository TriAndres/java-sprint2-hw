package ru.practicum.calorieCounter.repository;

import ru.practicum.calorieCounter.model.GoalSteps;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class GoalStepsRepositoryImpl implements GoalStepsRepository {
    private final Map<Long, GoalSteps> goalStepsMap = new HashMap<>();

    @Override
    public Collection<GoalSteps> findAll() {
        return goalStepsMap.values();
    }

    @Override
    public GoalSteps save(GoalSteps goalSteps) {
        return goalStepsMap.put(goalSteps.getId(), goalSteps);
    }

    @Override
    public GoalSteps findById(long id) {
        return goalStepsMap.get(id);
    }

    @Override
    public void deleteById(long id) {
        goalStepsMap.remove(id);
    }

    @Override
    public void deleteAll() {
        goalStepsMap.clear();
    }
}
