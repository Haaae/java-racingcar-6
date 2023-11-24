package racingcar.service;

import java.util.List;
import java.util.Map;

public record RaceResult(Map<String, List<Long>> distanceEachCar, List<String> winnerRoster) {
}
