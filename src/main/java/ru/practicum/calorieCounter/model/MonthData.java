package ru.practicum.calorieCounter.model;

public class MonthData {
    private Long id;
    private Integer year;
    private Integer month;
    private Integer sumStepsFromMonth;
    private Integer maxSteps;
    private String bestSeries;
    private Integer avgSumSteps;
    private Integer convertToKm;
    private Integer convertStepsToKilocalories;

    public MonthData(Long id,
                     Integer year,
                     Integer month,
                     Integer sumStepsFromMonth,
                     Integer maxSteps,
                     String bestSeries,
                     Integer avgSumSteps,
                     Integer convertToKm,
                     Integer convertStepsToKilocalories) {
        this.id = id;
        this.year = year;
        this.month = month;
        this.sumStepsFromMonth = sumStepsFromMonth;
        this.maxSteps = maxSteps;
        this.bestSeries = bestSeries;
        this.avgSumSteps = avgSumSteps;
        this.convertToKm = convertToKm;
        this.convertStepsToKilocalories = convertStepsToKilocalories;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Integer getMonth() {
        return month;
    }

    public void setMonth(Integer month) {
        this.month = month;
    }

    public Integer getSumStepsFromMonth() {
        return sumStepsFromMonth;
    }

    public void setSumStepsFromMonth(Integer sumStepsFromMonth) {
        this.sumStepsFromMonth = sumStepsFromMonth;
    }

    public Integer getMaxSteps() {
        return maxSteps;
    }

    public void setMaxSteps(Integer maxSteps) {
        this.maxSteps = maxSteps;
    }

    public String getBestSeries() {
        return bestSeries;
    }

    public void setBestSeries(String bestSeries) {
        this.bestSeries = bestSeries;
    }

    public Integer getAvgSumSteps() {
        return avgSumSteps;
    }

    public void setAvgSumSteps(Integer avgSumSteps) {
        this.avgSumSteps = avgSumSteps;
    }

    public Integer getConvertToKm() {
        return convertToKm;
    }

    public void setConvertToKm(Integer convertToKm) {
        this.convertToKm = convertToKm;
    }

    public Integer getConvertStepsToKilocalories() {
        return convertStepsToKilocalories;
    }

    public void setConvertStepsToKilocalories(Integer convertStepsToKilocalories) {
        this.convertStepsToKilocalories = convertStepsToKilocalories;
    }

    @Override
    public String toString() {
        return id +
                "/" + year +
                "/" + month +
                "/" + sumStepsFromMonth +
                "/" + maxSteps +
                "/" + bestSeries +
                "/" + avgSumSteps +
                "/" + convertToKm +
                "/" + convertStepsToKilocalories;
    }
}
