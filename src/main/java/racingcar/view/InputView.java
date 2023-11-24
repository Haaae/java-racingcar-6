package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import racingcar.exception.Exception;
import racingcar.validator.Validator;
import racingcar.view.constant.Notice;

public class InputView {

    private final Validator validator = Validator.getInstance();

    public List<String> readCarNames() {
        Notice.CAR_NAME.print();

        List<String> carNames =  List.of(
                Console.readLine()
                        .split(",")
        );

        validator.isDuplication(carNames, Exception.INVALID_INPUT);

        return carNames;
    }

    public long readMoveTryCount() {
        Notice.MOVE_TRY_COUNT.print();

        String input = Console.readLine();
        validator.isOnlyNumber(input, Exception.INVALID_INPUT);
        return Long.parseLong(input);
    }
}
