package io.github.onreyl.glytrack.domain.model;

import java.util.Objects;

public class User {

    private final Long id;
    private final String email;
    private final String passwordHash;

    private double targetCalories;
    private double targetCarbs;
    private double targetGl;

    public User(Long id, String email, String passwordHash,
                double targetCalories, double targetCarbs, double targetGl) {
        if (email == null || email.isBlank()) {
            throw new IllegalArgumentException("Email boş olamaz");
        }
        if (passwordHash == null || passwordHash.isBlank()) {
            throw new IllegalArgumentException("Password hash boş olamaz");
        }
        validateTargets(targetCalories, targetCarbs, targetGl);

        this.id = id;
        this.email = email;
        this.passwordHash = passwordHash;
        this.targetCalories = targetCalories;
        this.targetCarbs = targetCarbs;
        this.targetGl = targetGl;
    }

    public void updateTargets(double calories, double carbs, double gl) {
        validateTargets(calories, carbs, gl);
        this.targetCalories = calories;
        this.targetCarbs = carbs;
        this.targetGl = gl;
    }

    private static void validateTargets(double calories, double carbs, double gl) {
        if (calories <= 0 || carbs <= 0 || gl <= 0) {
            throw new IllegalArgumentException("Hedefler pozitif olmalı");
        }
    }


    public Long getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getPasswordHash() {
        return passwordHash;
    }

    public double getTargetCalories() {
        return targetCalories;
    }

    public double getTargetCarbs() {
        return targetCarbs;
    }

    public double getTargetGl() {
        return targetGl;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User user)) return false;
        return id != null && id.equals(user.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}