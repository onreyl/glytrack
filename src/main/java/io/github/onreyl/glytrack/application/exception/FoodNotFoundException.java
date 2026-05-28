package io.github.onreyl.glytrack.application.exception;

public class FoodNotFoundException extends NotFoundException {
    public FoodNotFoundException(Long id) {
        super("Food bulunamadı: id=" + id);
    }
}