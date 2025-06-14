package ru.practicum.calorieCounter.menu;

import static ru.practicum.calorieCounter.controller.StepTrackerController.*;
import static ru.practicum.calorieCounter.menu.Command.from;

public class StepTrackerMenu extends Menu {
    @Override
    String menu() {
        System.out.println("\t\nВыбирите команду:" +
                "\n\t1 - ввести количество шагов за определённый день" +
                "\n\t2 - изменить цель по количеству шагов в день" +
                "\n\t3 - напечатать статистику за определённый месяц" +
                "\n\t4 - выйти из приложения");
        return consoleMethods().getString();
    }

    @Override
    public void select(String line) {
        switch (from(line)) {
            case COMMAND1:
                stepTrackerService().addNewNumberStepsPerDay();
                break;
            case COMMAND2:
                goalStepsService().changeStepGoal();
                break;
            case COMMAND3:
                stepTrackerService().printStatistic();
                break;
            case COMMAND5:
                out();
                break;
            case NULL:
                System.out.println("Неизвестная команда.");
                break;
        }
    }

    @Override
    void out() {
        System.out.println("Выход из программы.");
    }
}
