package ru.practicum.calorieCounter.service;


import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.practicum.calorieCounter.dto.StepTrackerDTO;
import ru.practicum.calorieCounter.exception.NullPointerExceptionn;
import ru.practicum.calorieCounter.model.MonthOrder;
import ru.practicum.calorieCounter.model.StepTracker;
import ru.practicum.calorieCounter.repository.StepTrackerRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import static ru.practicum.calorieCounter.mapper.StepTrackerMapper.toListDTOStepTracker;

@Service
@AllArgsConstructor
@Slf4j
public class StepTrackerServiceImpl implements StepTrackerService {
    private final StepTrackerRepository stepTrackerRepository;
    private final ConverterService converterService;
    private final GoalStepsServiceImpl goalStepsService;



    public List<StepTrackerDTO> findAll() {
        return new ArrayList<>(toListDTOStepTracker(stepTrackerRepository.findAll()));
    }

    public StepTracker addNewNumberStepsPerDay(StepTracker stepTracker) {
        if (stepTrackerRepository.findAll().isEmpty()) {
            setDay();
        }
        // ввод и проверка номера месяца
        if (Integer.parseInt(String.valueOf(MonthOrder.from(String.valueOf(stepTracker.getMonth())))) < 1 ||
                Integer.parseInt(String.valueOf(MonthOrder.from(String.valueOf(stepTracker.getMonth())))) > 12) {
            throw new NullPointerExceptionn("month < 1 || month > 12");
        }
        MonthOrder monthOrder = MonthOrder.from(String.valueOf(stepTracker.getMonth()));
        // ввод и проверка дня
        if (stepTracker.getDay() <= 0 || stepTracker.getDay() > Objects.requireNonNull(monthOrder).getDay()) {
            throw new NullPointerExceptionn("day <= 0 || day > (monthOrder).getDay()");
        }
        // получение соответствующего объекта StepTracker из массива
        long idDay = 0;
        for (StepTracker tracker : stepTrackerRepository.findAll()) {
            if (tracker.getMonth() == monthOrder && Objects.equals(tracker.getDay(), stepTracker.getDay())) {
                idDay = tracker.getId();
            }
        }
        Optional<StepTracker> tracker = stepTrackerRepository.findById(idDay);
        // ввод и проверка количества шагов
        if (stepTracker.getStep() < 0) {
            throw new NullPointerExceptionn("step < 0");
        }
        // сохранение полученных данных
        stepTrackerRepository.save(stepTracker);
        log.info("Записано.");
        return stepTracker;
    }


    public String printStatistic(int month) {
        if (stepTrackerRepository.findAll().isEmpty()) {
            setDay();
        }
        String line;
        // ввод и проверка номера месяца
        if (month < 1 || month > 12) {
            throw new NullPointerExceptionn("month < 1 || month > 12");
        }
        List<StepTracker> trackerList = new ArrayList<>();
        for (StepTracker tracker1 : stepTrackerRepository.findAll()) {
            if (tracker1.getMonth().equals(MonthOrder.from(String.valueOf(month)))) {
                trackerList.add(tracker1);
            }
        }
        //* monthData = // получение соответствующего месяца
        MonthDateService monthData = new MonthDateService(trackerList);
        // вывод общей статистики по дням
        line = monthData.printDaysAndStepsFromMonth();
        // получение суммы шагов за месяц
        int sumSteps = monthData.sumStepsFromMonth();
        // вывод суммы шагов за месяц
        line += "вывод суммы шагов за месяц : " + sumSteps + "\n";
        // вывод максимального пройденного количества шагов за месяц
        line += "вывод максимального пройденного количества шагов за месяц : " + monthData.maxSteps() + "\n";
        // вывод среднего пройденного количества шагов за месяц
        line += "вывод среднего пройденного количества шагов за месяц : " + (sumSteps / monthData.getTrackerList().size()) + "\n";
        // вывод пройденной за месяц дистанции в километрах
        line += "вывод пройденной за месяц дистанции в километрах : " + converterService.convertToKm(sumSteps) + "\n";
        // вывод количества сожжённых килокалорий за месяц
        line += "вывод количества сожжённых килокалорий за месяц : " + converterService.convertStepsToKilocalories(sumSteps) + "\n";
        // вывод лучшей серии
        if (!goalStepsService.findAll().isEmpty()) {
            line += "вывод лучшей серии : " + monthData.bestSeries(Integer.parseInt(String.valueOf(goalStepsService.findBiId(goalStepsService.findAll().size())))) + "\n";
        }
        return line;
    }

    public void setDay() {
        int month = 1;
        do {
            for (int day = 1; day <= Objects.requireNonNull(MonthOrder.from(String.valueOf(month))).getDay(); day++) {
                stepTrackerRepository.save(new StepTracker(null, MonthOrder.from(String.valueOf(month)), day, 0));
            }
            ++month;
        } while (month <= 12);
    }
}