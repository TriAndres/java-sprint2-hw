package ru.practicum.calorieCounter.model;

public class StepTracker {
    private Long id;
    private Integer year;
    private Integer month;
    private Integer day;
    private Integer step;
    private Integer goalSteps;

    public StepTracker(Long id,
                       Integer year,
                       Integer month,
                       Integer day,
                       Integer step,
                       Integer goalSteps) {
        this.id = id;
        this.year = year;
        this.month = month;
        this.day = day;
        this.step = step;
        this.goalSteps = goalSteps;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getMonth() {
        return month;
    }

    public void setMonth(Integer month) {
        this.month = month;
    }

    public Integer getDay() {
        return day;
    }

    public void setDay(Integer day) {
        this.day = day;
    }

    public Integer getStep() {
        return step;
    }

    public void setStep(Integer step) {
        this.step = step;
    }

    public Integer getGoalSteps() {
        return goalSteps;
    }

    public void setGoalSteps(Integer goalSteps) {
        this.goalSteps = goalSteps;
    }

    @Override
    public String toString() {
        return id +
                "/" + year +
                "/" + month +
                "/" + day +
                "/" + step +
                "/" + goalSteps;
    }
}
