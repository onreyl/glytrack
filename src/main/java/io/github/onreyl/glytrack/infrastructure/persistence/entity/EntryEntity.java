package io.github.onreyl.glytrack.infrastructure.persistence.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "entries")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EntryEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "day_id", nullable = false)
    private DayEntity day;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "meal_id")
    private MealEntity meal;

    @Column(nullable = false)
    private double grams;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "food_id")
    private FoodEntity food;

    @Column(name = "manual_name")
    private String manualName;

    @Column(name = "manual_carbs")
    private Double manualCarbs;

    @Column(name = "manual_protein")
    private Double manualProtein;

    @Column(name = "manual_calories")
    private Double manualCalories;

    @Column(name = "manual_gi")
    private Integer manualGi;
}