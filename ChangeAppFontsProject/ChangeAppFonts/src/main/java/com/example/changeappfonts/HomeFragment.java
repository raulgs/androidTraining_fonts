package com.example.changeappfonts;

import com.example.changeappfonts.utils.FontsOverride;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by raulg on 11/7/13.
 */
public class HomeFragment extends Fragment {

    /**
     * The fragment argument representing the section number for this fragment.
     */
    private static final String ARG_SECTION_NUMBER = "section_number";

    /**
     * Returns a new instance of this fragment for the given section number.
     */
    public static HomeFragment newInstance(int sectionNumber) {

        HomeFragment fragment = new HomeFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_SECTION_NUMBER, sectionNumber);
        fragment.setArguments(args);
        return fragment;
    }

    public HomeFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.home_fragment, container, false);

        TextView textView = (TextView) rootView.findViewById(R.id.section_label);
        textView.setText(Integer.toString(getArguments().getInt(ARG_SECTION_NUMBER)));

        Button overrideFontsButton = (Button) rootView.findViewById(R.id.home_override_fonts);
        overrideFontsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                FontsOverride.setDefaultFont(getActivity(), "DEFAULT", FontsOverride.FONT_ARAB_TYPE);
                FontsOverride.setDefaultFont(getActivity(), "DEFAULT_BOLD", FontsOverride.FONT_ARAB_TYPE);
                FontsOverride.setDefaultFont(getActivity(), "MONOSPACE", FontsOverride.FONT_ARAB_TYPE);
                FontsOverride.setDefaultFont(getActivity(), "SANS_SERIF", FontsOverride.FONT_ARAB_TYPE);
                FontsOverride.setDefaultFont(getActivity(), "SERIF", FontsOverride.FONT_ARAB_TYPE);
                FontsOverride.setDefaultFont(getActivity());
                ReOpenActivity();
            }
        });

        Button returnFontsButton = (Button) rootView.findViewById(R.id.home_return_fonts);
        returnFontsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                FontsOverride.setOriginalFonts();
                ReOpenActivity();
            }
        });

        return rootView;
    }

    private void ReOpenActivity(){
        Intent intent = new Intent(getActivity(), MainActivity.class);
        //intent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
    }

}
