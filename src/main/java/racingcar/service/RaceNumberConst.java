package racingcar.service;

import racingcar.exception.Exception;
import racingcar.validator.Validator;

public enum RaceNumberConst {
    MAX(9),
    MIN(0),
    CAN_MOVE(4),
    ;


    private final int value;

    RaceNumberConst(final int value) {
        this.value = value;
    }

    public static void isValidRange(final int number, final Validator validator) {
        validator.isValidRange(number, MIN.value, MAX.value, Exception.INVALID_INPUT);
    }

    public static boolean canMove(final int number) {
        return CAN_MOVE.value <= number;
    }

    public int getValue() {
        return value;
    }
}
