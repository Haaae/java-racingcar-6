package racingcar.controller;

import java.util.List;
import racingcar.service.RaceResult;
import racingcar.service.RaceService;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RaceController {

    private final InputView inputView;
    private final OutputView outputView;
    private final RaceService raceService;

    public RaceController(InputView inputView, OutputView outputView, RaceService raceService) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.raceService = raceService;
    }

    public void run() {
        createCarFromUserInput();
        RaceResult raceResult = moveForUserInput();
        outputView.printResult(raceResult);
    }

    private void createCarFromUserInput() {
        raceService.createCars(
                inputView.readCarNames()
        );
    }

    private RaceResult moveForUserInput() {
        return raceService.doRace(
                inputView.readMoveTryCount()
        );
    }
}
