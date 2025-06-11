package ru.practicum.calorieCounter.controller;

import ru.practicum.calorieCounter.file.StepTrackerFile;
import ru.practicum.calorieCounter.service.StepTrackerService;

import static ru.practicum.calorieCounter.file.StepTrackerFile.loadFromFile;

public class Controller {
    private static final String file = "src\\main\\java\\ru\\practicum\\calorieCounter\\file\\StepTrackerFile.txt";
    private static final StepTrackerFile stepTrackerFile = loadFromFile(file);

    public static StepTrackerService stepTrackerService() {
        return new StepTrackerService(stepTrackerFile);
    }
}
