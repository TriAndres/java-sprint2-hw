package ru.practicum.calorieCounter.file;

import ru.practicum.calorieCounter.model.MonthData;
import ru.practicum.calorieCounter.repository.MonthDataRepositoryImpl;

import java.io.*;
import java.util.Collection;

public class MonthDataFile extends MonthDataRepositoryImpl {
    private final String file;

    public MonthDataFile(String file) {
        this.file = file;
    }

    private void saveMonthData() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
            for (MonthData monthData : findAll()) {
                writer.write(monthData.toString());
                writer.write("\n");
            }
        } catch (IOException e) {
            throw new RuntimeException();
        }
    }

    @Override
    public Collection<MonthData> findAll() {
        return super.findAll();
    }

    @Override
    public MonthData save(MonthData monthData) {
        MonthData monthData1 = super.save(monthData);
        saveMonthData();
        return monthData1;
    }

    @Override
    public MonthData findById(long id) {
        MonthData monthData = super.findById(id);
        saveMonthData();
        return monthData;
    }

    @Override
    public void deleteById(long id) {
        super.deleteById(id);
        saveMonthData();
    }

    @Override
    public void deleteAll() {
        super.deleteAll();
        saveMonthData();
    }

    public static MonthDataFile loadFromFile(String file) {
        MonthDataFile monthDataFile = new MonthDataFile(file);
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line = null;
            while ((line = reader.readLine()) != null) {
                String[] row = line.split("/");
                monthDataFile.save(
                        new MonthData(
                                Long.parseLong(row[0]),
                                Integer.parseInt(row[1]),
                                Integer.parseInt(row[2]),
                                Integer.parseInt(row[3]),
                                Integer.parseInt(row[4]),
                                row[5],
                                Integer.parseInt(row[6]),
                                Integer.parseInt(row[7]),
                                Integer.parseInt(row[8])
                        )
                );
            }
        } catch (IOException e) {
            throw new RuntimeException();
        }
        return monthDataFile;
    }
}