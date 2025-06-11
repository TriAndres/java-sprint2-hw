package ru.practicum.calorieCounter.model;

public class StepTracker {
    private Long id;
    private MonthOrder month;
    private Integer day;
    private Integer step;

    public StepTracker(Long id,
                       MonthOrder month,
                       Integer day,
                       Integer step
    ) {
        this.id = id;
        this.month = month;
        this.day = day;
        this.step = step;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public MonthOrder getMonth() {
        return month;
    }

    public void setMonth(MonthOrder month) {
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

    @Override
    public String toString() {
        return id +
                "/" + month +
                "/" + day +
                "/" + step;
    }
}