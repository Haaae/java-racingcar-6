package racingcar.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import racingcar.entity.car.Car;
import racingcar.validator.Validator;

public class RaceManager {
    private final List<Car> roster;
    private final Map<Car, List<Long>> distancesPerMove;

    public RaceManager(List<Car> roster) {
        this.roster = roster;
        this.distancesPerMove = new LinkedHashMap<>();
        initDistancesPerMove(roster);
    }

    private void initDistancesPerMove(List<Car> roster) {
        roster.forEach(car -> distancesPerMove.put(car, new ArrayList<>()));
    }

    public void moveAll(final RandomRaceNumberGenerator generator, final int moveTryCount, final Validator validator) {
        roster.forEach(car ->
                    moveCar(generator, moveTryCount, validator, car);
        );
    }

    private void moveCar(RandomRaceNumberGenerator generator, int moveTryCount, Validator validator, Car car) {
        List<RaceNumber> numbers = generator.generate(
                moveTryCount,
                validator
        );

        numbers.forEach(
                number -> distancesPerMove.get(car)
                        .add(
                                car.move(number)
                        )
        );
    }

    public Map<String, List<Long>> getDistanceEachCar() {
        Map<String, List<Long>> result = new LinkedHashMap<>();
        distancesPerMove.keySet()
                .forEach(car -> result.put(
                            car.getName(),
                            distancesPerMove.get(car)
                        )
                );
        return Collections.unmodifiableMap(result);
    }

    public List<String> getWinnerRoster() {
        long maxDistance = getMaxDistance();

        return roster.stream()
                .filter(car -> car.getDistance() == maxDistance)
                .map(Car::getName)
                .toList();
    }

    private long getMaxDistance() {
        long maxDistanceOfEmptyRoster = -1;

        return roster.stream()
                .mapToLong(Car::getDistance)
                .max()
                .orElse(maxDistanceOfEmptyRoster);
    }
}
