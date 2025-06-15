package ru.practicum.calorieCounter.dto;

import lombok.Builder;
import lombok.Data;
import ru.practicum.calorieCounter.model.MonthOrder;

@Data
@Builder
public class StepTrackerDTO {
    private Long id;
    private MonthOrder month;
    private Integer day;
    private Integer step;
}