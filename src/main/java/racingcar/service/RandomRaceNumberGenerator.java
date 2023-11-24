package racingcar.service;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import racingcar.validator.Validator;

public class RandomRaceNumberGenerator {

    public RaceNumber generate(final Validator validator) {
        return RaceNumber.from(
                Randoms.pickNumberInRange(
                        RaceNumberConst.MIN.getValue(),
                        RaceNumberConst.MAX.getValue()
                ),
                validator
        );
    }

    public List<RaceNumber> generate(final int moveTryNumber, final Validator validator) {
        List<RaceNumber> result = new ArrayList<>(moveTryNumber);
        for (int i = 0; i < moveTryNumber; i++) {
            result.add(generate(validator));
        }
        return result;
    }
}
