package ru.practicum.calorieCounter.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.practicum.calorieCounter.model.StepTracker;

public interface StepTrackerRepository extends JpaRepository<StepTracker, Long> {
}