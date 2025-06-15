package ru.practicum.calorieCounter.mapper;

import lombok.Builder;
import lombok.Data;
import ru.practicum.calorieCounter.dto.GoalStepsDTO;
import ru.practicum.calorieCounter.model.GoalSteps;

import java.util.ArrayList;
import java.util.List;

@Data
@Builder
public class GoalStepsMapper {
    public static GoalStepsDTO toDTO(GoalSteps goalSteps) {
        return GoalStepsDTO.builder()
                .id(goalSteps.getId())
                .goalSteps(goalSteps.getGoalSteps())
                .build();
    }

    public static List<GoalStepsDTO> toListDTO(List<GoalSteps> goalSteps) {
        return goalSteps.stream().map(GoalStepsMapper::toDTO).toList();
    }

    public static GoalSteps toModel(GoalStepsDTO goalStepsDTO) {
        return GoalSteps.builder()
                .id(goalStepsDTO.getId())
                .goalSteps(goalStepsDTO.getGoalSteps())
                .build();
    }

    public static List<GoalSteps> toListModel(List<GoalStepsDTO> goalStepsDTO) {
        List<GoalSteps> goalStepsList = new ArrayList<>();
        for (GoalStepsDTO dto : goalStepsDTO) {
            goalStepsList.add(toModel(dto));
        }
        return goalStepsList;
    }
}