package ru.practicum.calorieCounter.model;

public enum MonthOrder {
    JANUARY(31), FEBRUARY(28), MARCH(31), APRIL(30), MAY(31), JUNE(30), JULY(31),
    AUGUST(31), SEPTEMBER(30), OCTOBER(31), NOVEMBER(30), DECEMBER(31);

    private final Integer day;
    MonthOrder(int day) {
        this.day = day;
    }

    public Integer getDay() {
        return day;
    }

    public static MonthOrder from(String order) {
        switch (order) {
            case "1":
                return JANUARY;
            case "2":
                return FEBRUARY;
            case "3":
                return MARCH;
            case "4":
                return APRIL;
            case "5":
                return MAY;
            case "6":
                return JUNE;
            case "7":
                return JULY;
            case "8":
                return AUGUST;
            case "9":
                return SEPTEMBER;
            case "10":
                return OCTOBER;
            case "11":
                return NOVEMBER;
            case "12":
                return DECEMBER;
            default:
                return null;
        }
    }
}