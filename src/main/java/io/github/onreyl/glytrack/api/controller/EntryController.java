package io.github.onreyl.glytrack.api.controller;

import io.github.onreyl.glytrack.application.dto.CreateEntryRequest;
import io.github.onreyl.glytrack.application.dto.EntryResponse;
import io.github.onreyl.glytrack.application.service.EntryService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/entries")
public class EntryController {

    private final EntryService entryService;

    public EntryController(EntryService entryService) {
        this.entryService = entryService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public EntryResponse createEntry(
            @RequestParam Long userId,
            @Valid @RequestBody CreateEntryRequest request) {
        return entryService.createEntry(userId, request);
    }
}
