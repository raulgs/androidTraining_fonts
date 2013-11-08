package com.example.changeappfonts;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class PreferencesActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getTheme().applyStyle(new Preferences(this).getFontStyle().getResId(), true);
        super.onCreate(savedInstanceState);

        setContentView(R.layout.preferences);

        Preferences prefs = new Preferences(this);

        Spinner fontStylesSpinner = (Spinner) findViewById(R.id.font_styles);

        //FontStylesAdapter adapter = new FontStylesAdapter(this,R.layout.font_styles_row, FontStyle.values());
        //fontStylesSpinner.setAdapter(adapter);

        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                                                                             R.array.fonts_array, android.R.layout.simple_spinner_item);
        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        fontStylesSpinner.setAdapter(adapter);

        fontStylesSpinner.setSelection(prefs.getFontStyle().ordinal());
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.preferences, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_done:
                onMenuDone();
                finish();
                return true;
            case R.id.menu_cancel:
                finish();
                return true;
            default:
                return false;
        }
    }

    private void onMenuDone() {
        Preferences prefs = new Preferences(this);

        Spinner fontStylesView = (Spinner) findViewById(R.id.font_styles);
        prefs.setFontStyle((FontStyle) FontStyle.valueOf(FontStyle.class, fontStylesView.getSelectedItem().toString()));
    }
}