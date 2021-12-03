package vip.daur.calc2.domain;

import androidx.annotation.StringRes;
import androidx.annotation.StyleRes;

import vip.daur.calc2.R;

public enum Theme {
    ONE(R.style.Theme_Calc2, R.string.theme_one),
    TWO(R.style.Theme_Calc2_Fun, R.string.theme_two),
    THREE(R.style.Theme_Calc2_Magic, R.string.theme_three),
    FOUR(R.style.Theme_Calc2_Metal, R.string.theme_four);

    @StyleRes
    private final int theme;

    @StringRes
    private final int name;

    public int getTheme() {
        return theme;
    }

    public int getName() {
        return name;
    }

    Theme(int theme, int name) {
        this.theme = theme;
        this.name = name;
    }
}
