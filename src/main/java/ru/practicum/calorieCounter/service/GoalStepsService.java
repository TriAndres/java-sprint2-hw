package ru.practicum.calorieCounter.service;

import ru.practicum.calorieCounter.dto.GoalStepsDTO;

import java.util.List;
import java.util.Optional;

public interface GoalStepsService {
    List<GoalStepsDTO> findAll();

    //goalByStepsPerDay-он будет менять это значение на то, которое ввёл пользователь.
    GoalStepsDTO create(GoalStepsDTO goalStepsDTO);

    Optional<GoalStepsDTO> findBiId(long id);

    public void deleteAll();
}