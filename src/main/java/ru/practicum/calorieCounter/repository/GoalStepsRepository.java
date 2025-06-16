package ru.practicum.calorieCounter.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.practicum.calorieCounter.model.GoalSteps;

public interface GoalStepsRepository extends JpaRepository<GoalSteps, Long> {
}