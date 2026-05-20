-- Users
CREATE TABLE users
(
    id              BIGSERIAL PRIMARY KEY,
    email           VARCHAR(255)     NOT NULL UNIQUE,
    password_hash   VARCHAR(255)     NOT NULL,
    target_calories DOUBLE PRECISION NOT NULL,
    target_carbs    DOUBLE PRECISION NOT NULL,
    target_gl       DOUBLE PRECISION NOT NULL
);

-- Foods catalog
CREATE TABLE foods
(
    id               BIGSERIAL PRIMARY KEY,
    name             VARCHAR(255)     NOT NULL UNIQUE,
    carbs_per100g    DOUBLE PRECISION NOT NULL,
    protein_per100g  DOUBLE PRECISION NOT NULL,
    calories_per100g DOUBLE PRECISION NOT NULL,
    gi               INTEGER          NOT NULL CHECK (gi >= 0 AND gi <= 100)
);

-- Days
CREATE TABLE days
(
    id      BIGSERIAL PRIMARY KEY,
    user_id BIGINT NOT NULL REFERENCES users (id),
    date    DATE   NOT NULL,
    CONSTRAINT uk_days_user_date UNIQUE (user_id, date)
);

-- Meals
CREATE TABLE meals
(
    id     BIGSERIAL PRIMARY KEY,
    day_id BIGINT      NOT NULL REFERENCES days (id),
    type   VARCHAR(20) NOT NULL,
    CONSTRAINT uk_meals_day_type UNIQUE (day_id, type)
);

CREATE TABLE entries
(
    id              BIGSERIAL PRIMARY KEY,
    day_id          BIGINT           NOT NULL REFERENCES days (id),
    meal_id         BIGINT REFERENCES meals (id),
    grams           DOUBLE PRECISION NOT NULL,
    food_id         BIGINT REFERENCES foods (id),
    manual_name     VARCHAR(255),
    manual_carbs    DOUBLE PRECISION,
    manual_protein  DOUBLE PRECISION,
    manual_calories DOUBLE PRECISION,
    manual_gi       INTEGER CHECK (manual_gi IS NULL OR (manual_gi >= 0 AND manual_gi <= 100))
);