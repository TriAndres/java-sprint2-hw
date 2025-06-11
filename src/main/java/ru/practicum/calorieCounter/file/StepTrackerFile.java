package ru.practicum.calorieCounter.file;

import ru.practicum.calorieCounter.model.MonthOrder;
import ru.practicum.calorieCounter.model.StepTracker;
import ru.practicum.calorieCounter.repository.StepTrackerRepositoryImpl;

import java.io.*;
import java.util.Collection;

public class StepTrackerFile extends StepTrackerRepositoryImpl {
    private final String file;

    public StepTrackerFile(String file) {
        this.file = file;
    }

    private void saveStepTracker() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
            for (StepTracker stepTracker : findAll()) {
                writer.write(stepTracker.toString());
                writer.write("\n");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Collection<StepTracker> findAll() {
        return super.findAll();
    }

    @Override
    public StepTracker save(StepTracker stepTracker) {
        StepTracker stepTracker1 = super.save(stepTracker);
        saveStepTracker();
        return stepTracker1;
    }

    @Override
    public StepTracker findById(long id) {
        StepTracker stepTracker = super.findById(id);
        saveStepTracker();
        return stepTracker;
    }

    @Override
    public void deleteById(long id) {
        super.deleteById(id);
        saveStepTracker();
    }

    @Override
    public void deleteAll() {
        super.deleteAll();
        saveStepTracker();
    }

    public static StepTrackerFile loadFromFile(String file) {
        StepTrackerFile stepTrackerFile = new StepTrackerFile(file);
        try (BufferedReader reader = new BufferedReader(new BufferedReader(new FileReader(file)))) {
            String line = null;
            while ((line = reader.readLine()) != null) {
                String[] row = line.split("/");
                stepTrackerFile.save(
                        new StepTracker(
                                Long.parseLong(row[0]),
                                MonthOrder.valueOf(row[1]),
                                Integer.parseInt(row[2]),
                                Integer.parseInt(row[3])
                                //Integer.parseInt(row[5])
                        )
                );
            }
        } catch (IOException e) {
            throw new RuntimeException();
        }
        return stepTrackerFile;
    }
}