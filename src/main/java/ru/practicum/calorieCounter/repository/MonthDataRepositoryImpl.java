package ru.practicum.calorieCounter.repository;

import ru.practicum.calorieCounter.model.MonthData;

import java.util.*;

public class MonthDataRepositoryImpl implements MonthDataRepository {
    private final Map<Long, MonthData> monthDataMap = new HashMap<>();


    @Override
    public Collection<MonthData> findAll() {
        return new ArrayList<>(monthDataMap.values());
    }

    @Override
    public MonthData save(MonthData monthData) {
        return monthDataMap.put(monthData.getId(), monthData);
    }

    @Override
    public MonthData findById(long id) {
        return monthDataMap.get(id);
    }

    @Override
    public void deleteById(long id) {
        monthDataMap.remove(id);
    }

    @Override
    public void deleteAll() {
        monthDataMap.clear();
    }
}
