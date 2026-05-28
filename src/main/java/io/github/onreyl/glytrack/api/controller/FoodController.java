package io.github.onreyl.glytrack.api.controller;

import io.github.onreyl.glytrack.application.dto.FoodResponse;
import io.github.onreyl.glytrack.application.service.FoodService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/foods")
public class FoodController {

    private final FoodService foodService;

    public FoodController(FoodService foodService) {
        this.foodService = foodService;
    }

    @GetMapping
    public List<FoodResponse> getFoods(@RequestParam(required = false) String search) {
        if (search != null && !search.isBlank()) {
            return foodService.searchFoods(search);
        }
        return foodService.getAllFoods();
    }

    @GetMapping("/{id}")
    public FoodResponse getFood(@PathVariable Long id) {
        return foodService.getFoodById(id);
    }
}