package com.demo.miscdemo.home;

import com.demo.miscdemo.R;

import android.media.AudioManager;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.method.ScrollingMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by raulg on 12/17/13.
 */
public class ScrollingTextFragment extends Fragment {

    private AudioManager mMAudioManager;
    private int maxVolume;
    private int originalVolume;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_scrolling_text, container, false);

        TextView scrollingTextView = (TextView) rootView.findViewById(R.id.scrolling_textview);
        Button scrollingButton = (Button) rootView.findViewById(R.id.scrolling_button);

        scrollingTextView.setMovementMethod(new ScrollingMovementMethod());
        scrollingButton.setMovementMethod(new ScrollingMovementMethod());

        return rootView;
    }
}