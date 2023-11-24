package racingcar.validator;

import java.util.List;
import racingcar.exception.Exception;
import racingcar.view.constant.Regex;

public class Validator {

    private final static Validator instance = new Validator();

    private Validator() {
    }

    public static Validator getInstance() {
        return instance;
    }

    /**
     * 0~9 중 하나로 이루어져 있지 않다면 예외 발생
     */
    public void isOnlyNumber(final String target, Exception e) {
        if (!Regex.NUMBER.matches(target)) {
            e.throwNew();
        }
    }

    /**
     * 리스트에 중복된 요소가 있다면 예외 발생
     */
    public void isDuplication(final List<?> target, Exception e) {
        long count = target.stream()
                .distinct()
                .count();

        if (count != target.size()) {
            e.throwNew();
        }
    }

    /**
     * 리스트 길이가 최대값보다 크다면 예외 발생
     */
    public void isOverSize(final List<?> target, final int maximumSize, final Exception e) {
        if (target.size() > maximumSize) {
            e.throwNew();
        }
    }

    /**
     * 특정 요소가 포함되어 있지 않다면 예외가 발생. List.contains()를 사용한다.
     */
    public <E> void contains(List<E> target, E element, Exception e) {
        if (!target.contains(element)) {
            e.throwNew();
        }
    }

    /**
     * 리스트가 오직 특정한 요소들로 이루어져 있는지 확인. 만약 특정한 요소 외의 것이 포함되어 있다면 예외 발생.
     * @param target 검증할 리스트
     * @param validElements 유효한 요소 요소
     */
    public <E> void containsOnly(List<E> target, List<E> validElements, Exception e) {
        long countOfValidElementsInTarget = target.stream()
                .filter(validElements::contains)
                .count();

        if (countOfValidElementsInTarget != target.size()) {
            e.throwNew();
        }
    }

    /**
     * 검증 대상이 특정 요소를 특정 개수보다 많이 포함하고 있다면 예외 발생
     * @param target 검증 대상 리스트
     * @param element 개수를 확인할 특정 요소
     * @param maximumCount 최대 허용 개수
     */
    public <E> void containsOver(List<E> target, E element, long maximumCount, Exception e) {
        long countOfElementInTarget = target.stream()
                .filter(element::equals)
                .count();

        if (countOfElementInTarget < maximumCount) {
            e.throwNew();
        }
    }

    /**
     * 리스트 길이가 최대값보다 크다면 예외 발생
     */
    public void isOverSize(final String target, final int maximumSize, final Exception e) {
        if (target.length() > maximumSize) {
            e.throwNew();
        }
    }

    /**
     * 문자열에 중복된 문자가 있다면 예외 발생
     */
    public void isDuplication(final String target, Exception e) {
        isDuplication(
                converToList(target),
                e
        );
    }

    /**
     * 특정 문자가 포함되어 있지 않다면 예외가 발생. List.contains()를 사용한다.
     */
    public void contains(String target, String element, Exception e) {
        contains(
                converToList(target),
                element,
                e
        );
    }

    /**
     * 특정 문자열이 정해진 문자들로만 이루어져 있지 않다면 예외 발생
     * @param target 검증 대상 문자열
     * @param validElements 유효한 구성 문자 리스트
     */
    public void containsOnly(String target, List<Character> validElements, Exception e) {
        containsOnly(
                converToList(target),
                validElements.stream()
                        .map(String::valueOf)
                        .toList(),
                e
        );
    }

    /**
     * 문자열이 특정 요소를 특정 개수보다 많이 포함하고 있다면 예외 발생.
     * @param target 검증 대상 문자열
     * @param element 개수를 확인할 특정 요소
     * @param maximumCount 최대 허용 개수
     */
    public void containsOver(String target, char element, long maximumCount, Exception e) {
        containsOver(
                converToList(target),
                String.valueOf(element),
                maximumCount,
                e
        );
    }

    private List<String> converToList(String target) {
        return target.chars()
                .mapToObj(String::valueOf)
                .toList();
    }
}
