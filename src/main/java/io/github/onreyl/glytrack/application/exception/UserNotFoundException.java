package io.github.onreyl.glytrack.application.exception;

public class UserNotFoundException extends NotFoundException {
    public UserNotFoundException(Long id) {
        super("User bulunamadı: id=" + id);
    }
}
