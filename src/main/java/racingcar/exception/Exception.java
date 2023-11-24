package racingcar.exception;

import java.util.function.Function;

public enum Exception {
    INVALID_INPUT("", IllegalArgumentException::new),
    ;


    private final String message;
    private final Function<String, ? extends RuntimeException> constructorOfException;

    Exception(final String message, Function<String, ? extends RuntimeException> constructorOfException) {
        this.message = message;
        this.constructorOfException = constructorOfException;
    }

    /**
     * 지정된 예외를 메세지와 함께 발생시킨다.
     */
    public void throwNew() {
        throwNew(this.constructorOfException);
    }

    /**
     * RuntimeException을 상속받는 예외 클래스의 생성자를 인자로 받아서, 예외 메세지를 해당 생성자의 인자로 전달해 예외를 발생시킨다.
     *
     * @param constructorOfException 발생시키고 싶은 예외의 생성자
     */
    public void throwNew(Function<String, ? extends RuntimeException> constructorOfException) {
        throw constructorOfException.apply(message);
    }
}
