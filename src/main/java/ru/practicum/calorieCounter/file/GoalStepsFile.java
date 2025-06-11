package ru.practicum.calorieCounter.file;

import ru.practicum.calorieCounter.model.GoalSteps;
import ru.practicum.calorieCounter.repository.GoalStepsRepositoryImpl;

import java.io.*;
import java.util.Collection;

public class GoalStepsFile extends GoalStepsRepositoryImpl {
    private final String file;

    public GoalStepsFile(String file) {
        this.file = file;
    }

    private void saveGoalSteps() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
            for (GoalSteps goalSteps : findAll()) {
                writer.write(goalSteps.toString());
                writer.write("\n");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Collection<GoalSteps> findAll() {
        return super.findAll();
    }

    @Override
    public GoalSteps save(GoalSteps goalSteps) {
        GoalSteps goalSteps1 = super.save(goalSteps);
        saveGoalSteps();
        return goalSteps1;
    }

    @Override
    public GoalSteps findById(long id) {
        GoalSteps goalSteps = super.findById(id);
        saveGoalSteps();
        return goalSteps;
    }

    @Override
    public void deleteById(long id) {
        super.deleteById(id);
        saveGoalSteps();
    }

    @Override
    public void deleteAll() {
        super.deleteAll();
        saveGoalSteps();
    }

    public static GoalStepsFile loadFromFilegoalSteps(String file) {
        GoalStepsFile goalStepsFile = new GoalStepsFile(file);
        try (BufferedReader reader = new BufferedReader(new BufferedReader(new FileReader(file)))) {
            String line = null;
            while ((line = reader.readLine()) != null) {
                String[] row = line.split("/");
                goalStepsFile.save(
                        new GoalSteps(
                                Long.parseLong(row[0]),
                                Integer.parseInt(row[1])
                        )
                );
            }
        } catch (IOException e) {
            throw new RuntimeException();
        }
        return goalStepsFile;
    }
}
