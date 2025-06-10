package ru.practicum.calorieCounter.repository;

import java.util.HashMap;
import java.util.Map;

public class StepTrackerRepositoryImpl implements StepTrackerRepository {
    private final Map<Long, StepTrackerRepository> stepTrackerRepositoryMap = new HashMap<>();

}