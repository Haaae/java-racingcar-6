package racingcar.repoitory;

import racingcar.entity.car.Car;

public class CarRepository extends Repoitory<Car> {

    private static final CarRepository instance = new CarRepository();

    private CarRepository() {
    }

    public static CarRepository getInstance() {
        return instance;
    }
}
