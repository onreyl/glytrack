package io.github.onreyl.glytrack.domain.model;

import java.time.LocalDate;
import java.util.Objects;

public class Day {

    private final Long id;
    private final User user;
    private final LocalDate date;

    public Day(Long id, User user, LocalDate date) {
        if (user == null) {
            throw new IllegalArgumentException("User boş olamaz");
        }
        if (date == null) {
            throw new IllegalArgumentException("Date boş olamaz");
        }
        this.id = id;
        this.user = user;
        this.date = date;
    }

    public Long getId() {
        return id;
    }

    public User getUser() {
        return user;
    }

    public LocalDate getDate() {
        return date;
    }

    public boolean belongsTo(User u) {
        return Objects.equals(this.user.getId(), u.getId());
    }

    public boolean isFuture() {
        return date.isAfter(LocalDate.now());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Day day)) return false;
        return id != null && id.equals(day.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}