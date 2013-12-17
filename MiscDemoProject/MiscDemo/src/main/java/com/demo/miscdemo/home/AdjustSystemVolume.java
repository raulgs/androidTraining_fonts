package com.demo.miscdemo.home;

import com.demo.miscdemo.R;

import android.media.AudioManager;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * Created by raulg on 12/17/13.
 */
public class AdjustSystemVolume extends Fragment {

    private AudioManager mMAudioManager;
    private int maxVolume;
    private int originalVolume;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_adjust_volume, container, false);

        Button buttonMaxVolume = (Button) rootView.findViewById(R.id.volume_max);
        Button buttonMinVolume = (Button) rootView.findViewById(R.id.volume_min);
        Button buttonRaiseVolume = (Button) rootView.findViewById(R.id.volume_raise);
        Button buttonDecreaseVolume = (Button) rootView.findViewById(R.id.volume_decrease);
        Button buttonOriginalVolume = (Button) rootView.findViewById(R.id.volume_original);

        mMAudioManager = (AudioManager) getActivity().getSystemService(getActivity().AUDIO_SERVICE);
        maxVolume = mMAudioManager.getStreamMaxVolume(AudioManager.STREAM_MUSIC);
        originalVolume = mMAudioManager.getStreamVolume(AudioManager.STREAM_MUSIC);

        //mMAudioManager.setStreamVolume(AudioManager.STREAM_MUSIC, maxVolume, AudioManager.FLAG_PLAY_SOUND);
        //mMAudioManager.setStreamVolume(AudioManager.STREAM_MUSIC, maxVolume, AudioManager.FLAG_SHOW_UI);
        //mMAudioManager.setStreamVolume(AudioManager.STREAM_MUSIC, maxVolume, AudioManager.FLAG_VIBRATE);

        buttonMaxVolume.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mMAudioManager.setStreamVolume(AudioManager.STREAM_MUSIC, maxVolume,
                                               AudioManager.FLAG_PLAY_SOUND | AudioManager.FLAG_VIBRATE | AudioManager.FLAG_SHOW_UI);
            }
        });

        buttonMinVolume.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mMAudioManager.setStreamVolume(AudioManager.STREAM_MUSIC, 0,
                                               AudioManager.FLAG_PLAY_SOUND | AudioManager.FLAG_VIBRATE | AudioManager.FLAG_SHOW_UI);
            }
        });

        buttonRaiseVolume.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mMAudioManager.setStreamVolume(AudioManager.STREAM_MUSIC, AudioManager.ADJUST_RAISE,
                                               AudioManager.FLAG_PLAY_SOUND | AudioManager.FLAG_VIBRATE | AudioManager.FLAG_SHOW_UI);
            }
        });

        buttonDecreaseVolume.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mMAudioManager.setStreamVolume(AudioManager.STREAM_MUSIC, AudioManager.ADJUST_LOWER,
                                               AudioManager.FLAG_PLAY_SOUND | AudioManager.FLAG_VIBRATE | AudioManager.FLAG_SHOW_UI);
            }
        });

        buttonOriginalVolume.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mMAudioManager.setStreamVolume(AudioManager.STREAM_MUSIC, originalVolume,
                                               AudioManager.FLAG_PLAY_SOUND | AudioManager.FLAG_VIBRATE | AudioManager.FLAG_SHOW_UI);
            }
        });

        return rootView;
    }
}