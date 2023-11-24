package racingcar.entity;

import java.util.Objects;
import racingcar.exception.Exception;
import racingcar.validator.Validator;

public class Car extends Entity {

    public static final int MAXIMUM_NAME_SIZE = 5;
    public static final int MINIMUM_NAME_SIZE = 1;

    private final Long id;
    private final String name;

    public Car(final String name, final Validator validator) {
        validator.isValidSize(name, MAXIMUM_NAME_SIZE, MINIMUM_NAME_SIZE, Exception.INVALID_INPUT);

        this.name = name;
        this.id = getNextId();
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
