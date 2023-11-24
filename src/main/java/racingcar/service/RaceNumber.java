package racingcar.service;


import racingcar.validator.Validator;

public record RaceNumber(int number) {

    public static RaceNumber from(final int number, Validator validator) {
        RaceNumberConst.isValidRange(number, validator);
        return new RaceNumber(number);
    }

    public boolean canMove() {
        return RaceNumberConst.canMove(number);
    }
}
