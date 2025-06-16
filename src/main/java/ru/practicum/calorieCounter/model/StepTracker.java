package ru.practicum.calorieCounter.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.practicum.calorieCounter.validator.NonNull;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tracker")
public class StepTracker {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @NonNull
    @Column(name = "month")
    private MonthOrder month;
    @NonNull
    @Column(name = "day")
    private Integer day;
    @NonNull
    @Column(name = "step")
    private Integer step;
}