package ru.practicum.calorieCounter.controller;

import ru.practicum.calorieCounter.file.GoalStepsFile;
import ru.practicum.calorieCounter.file.StepTrackerFile;
import ru.practicum.calorieCounter.service.methods.ConsoleMethods;
import ru.practicum.calorieCounter.service.GoalStepsServiceImpl;
import ru.practicum.calorieCounter.service.StepTrackerServiceImpl;

import static ru.practicum.calorieCounter.file.GoalStepsFile.loadFromFilegoalSteps;
import static ru.practicum.calorieCounter.file.StepTrackerFile.loadFromFileStepTracker;

public class StepTrackerController {
    private static final String fileStepTracker = "src\\main\\java\\ru\\practicum\\calorieCounter\\file\\StepTrackerFile.txt";
    private static final StepTrackerFile stepTrackerFile = loadFromFileStepTracker(fileStepTracker);
    private static final String fileGoalSteps = "src\\main\\java\\ru\\practicum\\calorieCounter\\file\\GoalStepsFile.txt";
    private static final GoalStepsFile goalStepsFile = loadFromFilegoalSteps(fileGoalSteps);

    public static ConsoleMethods consoleMethods() {
        return new ConsoleMethods();
    }
    public static StepTrackerServiceImpl stepTrackerService() {
        return new StepTrackerServiceImpl(stepTrackerFile);
    }

    public static GoalStepsServiceImpl goalStepsService() {
        return  new GoalStepsServiceImpl(goalStepsFile);
    }
}
