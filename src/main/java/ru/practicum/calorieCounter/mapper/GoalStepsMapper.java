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
    public static GoalStepsDTO toDTOGoalSteps(GoalSteps goalSteps) {
        return GoalStepsDTO.builder()
                .id(goalSteps.getId())
                .changeStepGoal(goalSteps.getChangeStepGoal())
                .build();
    }

    public static List<GoalStepsDTO> toListDTOGoalSteps(List<GoalSteps> goalSteps) {
        return goalSteps.stream().map(GoalStepsMapper::toDTOGoalSteps).toList();
    }

    public static GoalSteps toModelGoalSteps(GoalStepsDTO goalStepsDTO) {
        return GoalSteps.builder()
                .id(goalStepsDTO.getId())
                .changeStepGoal(goalStepsDTO.getChangeStepGoal())
                .build();
    }

    public static List<GoalSteps> toListModelGoalSteps(List<GoalStepsDTO> goalStepsDTO) {
        List<GoalSteps> goalStepsList = new ArrayList<>();
        for (GoalStepsDTO dto : goalStepsDTO) {
            goalStepsList.add(toModelGoalSteps(dto));
        }
        return goalStepsList;
    }
}