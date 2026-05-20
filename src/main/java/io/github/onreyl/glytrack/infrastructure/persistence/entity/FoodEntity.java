package io.github.onreyl.glytrack.infrastructure.persistence.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "foods")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class FoodEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String name;

    @Column(nullable = false)
    private double carbsPer100g;

    @Column(nullable = false)
    private double proteinPer100g;

    @Column(nullable = false)
    private double caloriesPer100g;

    @Column(nullable = false)
    private int gi;
}