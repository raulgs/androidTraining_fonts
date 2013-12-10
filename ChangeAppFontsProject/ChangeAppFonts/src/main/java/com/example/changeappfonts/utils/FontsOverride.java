package com.example.changeappfonts.utils;

import android.content.Context;
import android.graphics.Typeface;

import java.lang.reflect.Field;

public final class FontsOverride {

//    public static Typeface ORIGINAL_DEFAULT = Typeface.DEFAULT;
//    public static Typeface ORIGINAL_DEFAULT_BOLD = Typeface.DEFAULT_BOLD;
//    public static Typeface ORIGINAL_MONOSPACE = Typeface.MONOSPACE;
//    public static Typeface ORIGINAL_SANS_SERIF = Typeface.SANS_SERIF;
//    public static Typeface ORIGINAL_SERIF = Typeface.SERIF;

    public static Typeface ORIGINAL_DEFAULT;
    public static Typeface ORIGINAL_DEFAULT_BOLD;
    public static Typeface ORIGINAL_MONOSPACE;
    public static Typeface ORIGINAL_SANS_SERIF;
    public static Typeface ORIGINAL_SERIF;

    static Typeface[] original_sDefaults;

    public static final String FONT_MOLOT = "Molot.otf";
    public static final String FONT_ARAB_TYPE = "arabtype.ttf";

    private static final String DEFAULT_BOLD_FONT_FILENAME = FONT_MOLOT;
    private static final String DEFAULT_ITALIC_FONT_FILENAME = FONT_MOLOT;
    private static final String DEFAULT_BOLD_ITALIC_FONT_FILENAME = FONT_MOLOT;
    private static final String DEFAULT_NORMAL_FONT_FILENAME = FONT_MOLOT;

    public static void setDefaultFont(Context context,
                                      String staticTypefaceFieldName, String fontAssetName) {

        final Typeface regular = Typeface.createFromAsset(context.getAssets(),
                                                          fontAssetName);
        replaceFont(staticTypefaceFieldName, regular);
    }

    protected static void replaceFont(String staticTypefaceFieldName,
                                      final Typeface newTypeface) {

        try {
            final Field StaticField = Typeface.class
                    .getDeclaredField(staticTypefaceFieldName);
            StaticField.setAccessible(true);
            StaticField.set(null, newTypeface);
        }
        catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
        catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    protected static void replaceFieldValue(String staticTypefaceFieldName, final Typeface[] newTypefaces) {

        try {
            final Field StaticField = Typeface.class
                    .getDeclaredField(staticTypefaceFieldName);
            StaticField.setAccessible(true);
            StaticField.set(null, newTypefaces);
        }
        catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
        catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    protected static Object getFieldValue(String staticTypefaceFieldName) {
        try {
            Field StaticField = Typeface.class.getDeclaredField(staticTypefaceFieldName);
            StaticField.setAccessible(true);
            return StaticField.get(Typeface.class);
        }
        catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
        catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }


    static {
        ORIGINAL_DEFAULT = (Typeface) getFieldValue("DEFAULT");
        ORIGINAL_DEFAULT_BOLD = (Typeface) getFieldValue("DEFAULT_BOLD");
        ORIGINAL_MONOSPACE = (Typeface) getFieldValue("MONOSPACE");
        ORIGINAL_SANS_SERIF = (Typeface) getFieldValue("SANS_SERIF");
        ORIGINAL_SERIF = (Typeface) getFieldValue("SERIF");
        original_sDefaults = (Typeface[]) getFieldValue("sDefaults");
    }

    public static void setDefaultFont(Context context) {

        try {
            final Typeface bold = Typeface.createFromAsset(context.getAssets(), DEFAULT_BOLD_FONT_FILENAME);
            final Typeface italic = Typeface.createFromAsset(context.getAssets(), DEFAULT_ITALIC_FONT_FILENAME);
            final Typeface boldItalic = Typeface.createFromAsset(context.getAssets(), DEFAULT_BOLD_ITALIC_FONT_FILENAME);
            final Typeface regular = Typeface.createFromAsset(context.getAssets(), DEFAULT_NORMAL_FONT_FILENAME);

            Field DEFAULT = Typeface.class.getDeclaredField("DEFAULT");
            DEFAULT.setAccessible(true);
            DEFAULT.set(null, regular);

            Field DEFAULT_BOLD = Typeface.class.getDeclaredField("DEFAULT_BOLD");
            DEFAULT_BOLD.setAccessible(true);
            DEFAULT_BOLD.set(null, bold);

            Field sDefaults = Typeface.class.getDeclaredField("sDefaults");
            sDefaults.setAccessible(true);
            sDefaults.set(null, new Typeface[]{
                    regular, bold, italic, boldItalic
            });

        }
        catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
        catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        catch (Throwable e) {
            //cannot crash app if there is a failure with overriding the default font!
            e.printStackTrace();
        }
    }

    public static void setOriginalFonts() {

        replaceFont("DEFAULT", ORIGINAL_DEFAULT);
        replaceFont("DEFAULT_BOLD", ORIGINAL_DEFAULT_BOLD);
        replaceFont("MONOSPACE", ORIGINAL_MONOSPACE);
        replaceFont("SANS_SERIF", ORIGINAL_SANS_SERIF);
        replaceFont("SERIF", ORIGINAL_SERIF);

//        try {
//            Field sDefaults = Typeface.class.getDeclaredField("sDefaults");
//            sDefaults.setAccessible(true);
//            sDefaults.set(null, new Typeface[]{
//                    ORIGINAL_DEFAULT,
//                    ORIGINAL_DEFAULT_BOLD,
//                    Typeface.create((String) null, Typeface.ITALIC),
//                    Typeface.create((String) null, Typeface.BOLD_ITALIC),
//            });
//        }
//        catch (NoSuchFieldException e) {
//            e.printStackTrace();
//        }
//        catch (IllegalAccessException e) {
//            e.printStackTrace();
//        }

        replaceFieldValue("sDefaults", original_sDefaults);

    }
}