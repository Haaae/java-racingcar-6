package racingcar.view.constant;

import java.util.regex.Pattern;

public enum Regex {
    NUMBER("^[0-9]*$"),
    ;

    private final String regex;
    private final Pattern pattern;

    Regex(final String regex) {
        this.regex = regex;
        this.pattern = Pattern.compile(regex);
    }

    public boolean matches(final String value) {
        return pattern.matcher(value)
                .matches();
    }

    public String getRegex() {
        return regex;
    }
}
