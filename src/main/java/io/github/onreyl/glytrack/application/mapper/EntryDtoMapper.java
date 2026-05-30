package io.github.onreyl.glytrack.application.mapper;

import io.github.onreyl.glytrack.application.dto.EntryResponse;
import io.github.onreyl.glytrack.domain.model.Entry;
import io.github.onreyl.glytrack.domain.model.FoodSource;
import io.github.onreyl.glytrack.domain.model.Meal;
import org.springframework.stereotype.Component;

@Component
public class EntryDtoMapper {

    public EntryResponse toResponse(Entry entry) {
        FoodSource source = entry.getSource();
        return new EntryResponse(
            entry.getId(),
            entry.getDay().getDate(),
            entry.getMeal().map(Meal::getType).orElse(null),
            source.displayName(),
            source.grams(),
            source.carbs(),
            source.protein(),
            source.calories(),
            source.gi(),
            entry.glycemicLoad()
        );
    }
}
