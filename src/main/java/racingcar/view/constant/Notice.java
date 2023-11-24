package racingcar.view.constant;

public enum Notice {
    CAR_NAME("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)"),
    MOVE_TRY_COUNT("시도할 회수는 몇회인가요?"),
    ;

    private final String notice;

    Notice(final String notice) {
        this.notice = notice;
    }

    public void print() {
        System.out.println(notice);
    }
}
