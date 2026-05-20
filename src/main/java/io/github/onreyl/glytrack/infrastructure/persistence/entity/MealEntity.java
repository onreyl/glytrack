package io.github.onreyl.glytrack.infrastructure.persistence.entity;

import io.github.onreyl.glytrack.domain.model.MealType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "meals",
        uniqueConstraints = @UniqueConstraint(
                name = "uk_meals_day_type",
                columnNames = {"day_id", "type"}))
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MealEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private MealType type;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "day_id", nullable = false)
    private DayEntity day;
}
