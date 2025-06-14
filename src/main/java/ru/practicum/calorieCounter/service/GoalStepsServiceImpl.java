package ru.practicum.calorieCounter.service;

import ru.practicum.calorieCounter.file.GoalStepsFile;
import ru.practicum.calorieCounter.model.GoalSteps;

import java.util.ArrayList;
import java.util.List;

import static ru.practicum.calorieCounter.controller.StepTrackerController.consoleMethods;

public class GoalStepsServiceImpl implements GoalStepsService {
    private final GoalStepsFile goalStepsFile;

    public GoalStepsServiceImpl(GoalStepsFile goalStepsFile) {
        this.goalStepsFile = goalStepsFile;
    }

    public List<GoalSteps> findAll() {
        return new ArrayList<>(goalStepsFile.findAll());
    }

    public void changeStepGoal() {
        //goalByStepsPerDay-он будет менять это значение на то, которое ввёл пользователь.
        int max = 0;
        while (true) {
            System.out.println("Введите новую цель по Шагам в день");
            int goalByStepsPerDay = consoleMethods().getInteger();
            if (goalByStepsPerDay > 0) {
                goalStepsFile.save(new GoalSteps(getNextId(), goalByStepsPerDay));
                System.out.println("Записано");
                break;
            }
        }
    }

    public int goalByStepsPerDay() {
        return goalStepsFile.findById(goalStepsFile.findAll().size()).getGoalSteps();
    }

    private long getNextId() {
        long currentMaxId = goalStepsFile.findAll()
                .stream()
                .mapToLong(GoalSteps::getId)
                .max()
                .orElse(0);
        return ++currentMaxId;
    }
}