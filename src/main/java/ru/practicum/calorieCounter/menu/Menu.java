package ru.practicum.calorieCounter.menu;

public abstract class Menu {

    public void game() {
        while (true) {
            String line = menu();
            select(line);
            if (line.equals("5")) {
                break;
            }
        }
    }

    abstract String menu();

    abstract void select(String line);

    abstract void out();
}
