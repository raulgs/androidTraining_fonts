package com.example.changeappfonts;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by raulg on 11/7/13.
 */
public class Preferences {
    private final static String FONT_STYLE = "FONT_STYLE";

    private final Context context;

    public Preferences(Context context) {
        this.context = context;
    }

    protected SharedPreferences open() {
        return context.getSharedPreferences("prefs", Context.MODE_PRIVATE);
    }

    protected SharedPreferences.Editor edit() {
        return open().edit();
    }

    public FontStyle getFontStyle() {
        return FontStyle.valueOf(open().getString(FONT_STYLE,
                                                  FontStyle.Medium.name()));
    }

    public void setFontStyle(FontStyle style) {
        edit().putString(FONT_STYLE, style.name()).commit();
    }
}
