package racingcar.service;

import java.util.List;
import racingcar.entity.car.Car;
import racingcar.repoitory.CarRepository;
import racingcar.validator.Validator;

public class RaceService {

    private final CarRepository carRepository = CarRepository.getInstance();
    private final Validator validator = Validator.getInstance();
    private final RandomRaceNumberGenerator generator;

    public RaceService(final RandomRaceNumberGenerator generator) {
        this.generator = generator;
    }

    /**
     * 자동차 이름 리스트에 따라 자동차 객체 생성하여 저장소에 저장
     * @param carNames
     */
    public void createCars(final List<String> carNames) {
        carRepository.save(
                carNames.stream()
                        .map(name -> new Car(name, validator))
                        .toList()
        );
    }

    public RaceResult doRace(final int moveTryCount) {
        RaceManager manager = new RaceManager(carRepository.finaAll());
        manager.moveAll(generator, moveTryCount, validator);

        return new RaceResult(
                manager.getDistanceEachCar(),
                manager.getWinnerRoster()
        );
    }
}
