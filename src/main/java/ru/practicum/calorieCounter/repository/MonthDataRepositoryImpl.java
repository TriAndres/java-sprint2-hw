package ru.practicum.calorieCounter.repository;

import ru.practicum.calorieCounter.model.MonthData;

import java.util.HashMap;
import java.util.Map;

public class MonthDataRepositoryImpl implements MonthDataRepository {
    private final Map<Long, MonthData> monthDataMap = new HashMap<>();
}
