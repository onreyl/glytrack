package io.github.onreyl.glytrack.application.service;

import io.github.onreyl.glytrack.application.dto.FoodResponse;
import io.github.onreyl.glytrack.application.exception.FoodNotFoundException;
import io.github.onreyl.glytrack.application.mapper.FoodDtoMapper;
import io.github.onreyl.glytrack.domain.model.Food;
import io.github.onreyl.glytrack.domain.repository.FoodRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class FoodService {

    private final FoodRepository foodRepository;
    private final FoodDtoMapper dtoMapper;

    public FoodService(FoodRepository foodRepository, FoodDtoMapper dtoMapper) {
        this.foodRepository = foodRepository;
        this.dtoMapper = dtoMapper;
    }

    public List<FoodResponse> getAllFoods() {
        return foodRepository.findAll().stream()
                .map(dtoMapper::toResponse)
                .toList();
    }

    public List<FoodResponse> searchFoods(String query) {
        return foodRepository.findByNameContaining(query).stream()
                .map(dtoMapper::toResponse)
                .toList();
    }

    public FoodResponse getFoodById(Long id) {
        Food food = foodRepository.findById(id)
                .orElseThrow(() -> new FoodNotFoundException(id));
        return dtoMapper.toResponse(food);
    }
}