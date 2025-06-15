package ru.practicum.calorieCounter.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class GoalStepsDTO {
    private Long id;
    private Integer goalSteps;
}