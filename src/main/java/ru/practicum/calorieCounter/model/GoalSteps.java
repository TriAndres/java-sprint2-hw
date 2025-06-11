package ru.practicum.calorieCounter.model;

public class GoalSteps {
    private Long id;
    private Integer goalSteps;

    public GoalSteps(Long id, Integer goalSteps) {
        this.id = id;
        this.goalSteps = goalSteps;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getGoalSteps() {
        return goalSteps;
    }

    public void setGoalSteps(Integer goalSteps) {
        this.goalSteps = goalSteps;
    }

    @Override
    public String toString() {
        return id + "/" + goalSteps;
    }
}