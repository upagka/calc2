package vip.daur.calc2.Storage;

import android.content.Context;
import android.content.SharedPreferences;

import vip.daur.calc2.domain.Theme;

public class ThemeStorage {
    private static final String ARG_SAVED_THEME = "ARG_SAVED_THEME";
    private final Context context;


    public ThemeStorage(Context context) {
        this.context = context;
    }

    public void saveTheme(Theme theme) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("Themes", Context.MODE_PRIVATE);

        sharedPreferences.edit()
                .putInt(ARG_SAVED_THEME, theme.getTheme())
                .apply();
    }

    public Theme getSavedTheme() {
        SharedPreferences sharedPreferences = context.getSharedPreferences("Themes", Context.MODE_PRIVATE);

        int key = sharedPreferences.getInt(ARG_SAVED_THEME, Theme.ONE.getTheme());

        for (Theme theme : Theme.values()) {
            if(key == theme.getTheme()) {
                return theme;
            }
        }
        return Theme.ONE;
    }

}
