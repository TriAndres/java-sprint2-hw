package ru.practicum.calorieCounter.mapper;

import ru.practicum.calorieCounter.dto.StepTrackerDTO;
import ru.practicum.calorieCounter.model.StepTracker;

import java.util.ArrayList;
import java.util.List;

public class StepTrackerMapper {
    public static StepTrackerDTO toDTOStepTracker(StepTracker stepTracker) {
        return StepTrackerDTO.builder()
                .id(stepTracker.getId())
                .month(stepTracker.getMonth())
                .day(stepTracker.getDay())
                .step(stepTracker.getStep())
                .build();
    }

    public static List<StepTrackerDTO> toListDTOStepTracker(List<StepTracker> stepTrackers) {
        return stepTrackers.stream().map(StepTrackerMapper::toDTOStepTracker).toList();
    }

    public static StepTracker toModelStepTracker(StepTrackerDTO stepTrackerDTO) {
        return StepTracker.builder()
                .id(stepTrackerDTO.getId())
                .month(stepTrackerDTO.getMonth())
                .day(stepTrackerDTO.getDay())
                .step(stepTrackerDTO.getStep())
                .build();
    }

    public static List<StepTracker> toListModelStepTracker(List<StepTrackerDTO> stepTrackerDTOS) {
        List<StepTracker> stepTrackerList = new ArrayList<>();
        for (StepTrackerDTO dto : stepTrackerDTOS) {
            stepTrackerList.add(toModelStepTracker(dto));
        }
        return stepTrackerList;
    }
}
