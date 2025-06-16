package ru.practicum.calorieCounter.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.practicum.calorieCounter.dto.GoalStepsDTO;
import ru.practicum.calorieCounter.repository.GoalStepsRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static ru.practicum.calorieCounter.mapper.GoalStepsMapper.*;

@Service
@RequiredArgsConstructor
@Slf4j
public class GoalStepsServiceImpl implements GoalStepsService {
    private final GoalStepsRepository goalStepsRepository;

    public List<GoalStepsDTO> findAll() {
        return new ArrayList<>(toListDTOGoalSteps(goalStepsRepository.findAll()));
    }

    //goalByStepsPerDay-он будет менять это значение на то, которое ввёл пользователь.
    public GoalStepsDTO create(GoalStepsDTO goalStepsDTO) {
        if (goalStepsDTO.getChangeStepGoal() > 0) {
            goalStepsRepository.save(toModelGoalSteps(goalStepsDTO));
            log.info("Добавлен в список {}", goalStepsDTO);
            return goalStepsDTO;
        }
        log.info("Меньше нуля.");
        throw new NullPointerException("Меньше нуля.");
    }

    public Optional<GoalStepsDTO> findBiId(long id) {
        log.info("Вывод элемента из списка по id = {}", id);
        return Optional.ofNullable(toDTOGoalSteps(goalStepsRepository.findById(id).orElseThrow()));
    }

    @Override
    public void deleteAll() {
        goalStepsRepository.deleteAll();
    }
}