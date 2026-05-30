package io.github.onreyl.glytrack.application.service;

import io.github.onreyl.glytrack.application.dto.CreateEntryRequest;
import io.github.onreyl.glytrack.application.dto.EntryResponse;
import io.github.onreyl.glytrack.application.exception.FoodNotFoundException;
import io.github.onreyl.glytrack.application.exception.UserNotFoundException;
import io.github.onreyl.glytrack.application.mapper.EntryDtoMapper;
import io.github.onreyl.glytrack.domain.model.*;
import io.github.onreyl.glytrack.domain.repository.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
public class EntryService {

    private final UserRepository userRepository;
    private final DayRepository dayRepository;
    private final MealRepository mealRepository;
    private final FoodRepository foodRepository;
    private final EntryRepository entryRepository;
    private final EntryDtoMapper dtoMapper;

    public EntryService(UserRepository userRepository,
                        DayRepository dayRepository,
                        MealRepository mealRepository,
                        FoodRepository foodRepository,
                        EntryRepository entryRepository,
                        EntryDtoMapper dtoMapper) {
        this.userRepository = userRepository;
        this.dayRepository = dayRepository;
        this.mealRepository = mealRepository;
        this.foodRepository = foodRepository;
        this.entryRepository = entryRepository;
        this.dtoMapper = dtoMapper;
    }

    @Transactional
    public EntryResponse createEntry(Long userId, CreateEntryRequest request) {
        validateSource(request);

        User user = userRepository.findById(userId)
            .orElseThrow(() -> new UserNotFoundException(userId));

        // Find-or-create Day (lazy creation)
        Day day = dayRepository.findByUserIdAndDate(userId, request.date())
            .orElseGet(() -> dayRepository.save(new Day(null, user, request.date())));

        // Find-or-create Meal
        Meal meal = null;
        if (request.mealType() != null) {
            final Day persistedDay = day;
            meal = mealRepository.findByDayIdAndType(day.getId(), request.mealType())
                .orElseGet(() -> mealRepository.save(
                    new Meal(null, persistedDay, request.mealType())));
        }

        FoodSource source = buildSource(request);

        Entry entry = new Entry(null, day, meal, source);
        Entry saved = entryRepository.save(entry);

        return dtoMapper.toResponse(saved);
    }

    private void validateSource(CreateEntryRequest request) {
        boolean hasCatalog = request.foodId() != null;
        boolean hasManual  = request.manualName() != null;
        if (hasCatalog == hasManual) {
            throw new IllegalArgumentException(
                "Ya foodId ya manuel besin bilgisi girilmeli — ikisi birden ya da hiçbiri olamaz");
        }
    }

    private FoodSource buildSource(CreateEntryRequest request) {
        if (request.foodId() != null) {
            Food food = foodRepository.findById(request.foodId())
                .orElseThrow(() -> new FoodNotFoundException(request.foodId()));
            return new CatalogFood(food, request.grams());
        }
        return new ManualFood(
            request.manualName(),
            request.grams(),
            request.manualCarbs(),
            request.manualProtein(),
            request.manualCalories(),
            request.manualGi()
        );
    }
}
