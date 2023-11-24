package racingcar.entity;

import java.util.Objects;

public class Car extends Entity {

    private final Long id;

    public Car() {
        id = getNextId();
    }

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null || getClass() != object.getClass()) {
            return false;
        }
        Car other = (Car) object;
        return Objects.equals(id, other.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
