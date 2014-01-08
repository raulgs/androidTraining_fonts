package com.demo.miscdemo.home;

import com.demo.miscdemo.R;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by raulg on 1/7/14.
 */
public class ThreadsNameFragment extends Fragment {

    private String TAG = "ThreadsNameFragment";
    private boolean threadStatus = true;

    private Button stopButton;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_threads_name, container, false);

        stopButton = (Button) rootView.findViewById(R.id.threads_name_stop_button);

        Runnable task = new Runnable() {
            @Override
            public void run() {

                while (threadStatus) {
                    Log.v(TAG, "ThreadName: " + Thread.currentThread().getName());
                    sleep(1000);
                }
            }
        };

        String commonName = "BackgroundCheckServerFromMonitor";
        for (int i = 0; i < 10; i++) {
            String name = i % 2 == 0 ? commonName : commonName + (i + 1);
            Thread thread = new Thread(null, task, name);
            thread.start();
        }

        stopButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                threadStatus = false;
            }
        });

        return rootView;
    }

    @Override
    public void onPause() {

        super.onPause();
        threadStatus = false;
    }

    public void sleep(int ms) {

        try {
            Thread.sleep(ms);
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
