package com.demo.miscdemo.widget;


import com.demo.miscdemo.R;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.EditText;

public class EditTextPlus extends EditText {

    private static final String TAG = "EditTextPlus";

    public EditTextPlus(Context context) {

        super(context);
    }

    public EditTextPlus(Context context, AttributeSet attrs) {

        super(context, attrs);
        setCustomFont(context, attrs);
    }

    public EditTextPlus(Context context, AttributeSet attrs, int defStyle) {

        super(context, attrs, defStyle);
        setCustomFont(context, attrs);
    }

    private void setCustomFont(Context ctx, AttributeSet attrs) {

        TypedArray a = ctx.obtainStyledAttributes(attrs, R.styleable.com_demo_miscdemo_widget_TextViewPlus);
        String customFont = a.getString(R.styleable.com_demo_miscdemo_widget_TextViewPlus_customFont);
        setCustomFont(ctx, customFont);
        a.recycle();
    }

    public boolean setCustomFont(Context ctx, String asset) {

        Typeface tf = null;
        try {
            tf = Typeface.createFromAsset(ctx.getAssets(), asset);
        }
        catch (Exception e) {
            return false;
        }

        setTypeface(tf);
        return true;
    }

}
