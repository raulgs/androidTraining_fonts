package com.example.changeappfonts;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by raulg on 11/7/13.
 */
public class HomeFragment extends Fragment {

    /**
     * The fragment argument representing the section number for this fragment.
     */
    private static final String ARG_SECTION_NUMBER = "section_number";

    private View v;

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

        v = rootView;

        RadioButton largeText = ( RadioButton ) v.findViewById(R.id.textSizeLarge);
        largeText.setOnClickListener( new View.OnClickListener() {
            public void onClick( View view ) {
                Toast.makeText(getActivity(), "Large Text Selected", Toast.LENGTH_SHORT).show();
                Intent intent = getActivity().getIntent();
                intent.putExtra( "Theme", "Large" );
                getActivity().finish();
                startActivity(intent);
            }
        } );

        RadioButton smallText = ( RadioButton ) v.findViewById( R.id.textSizeSmall );
        smallText.setOnClickListener( new View.OnClickListener() {
            public void onClick( View view ) {
                Toast.makeText(getActivity(), "Small Text Selected", Toast.LENGTH_SHORT).show();
                Intent intent = getActivity().getIntent();
                intent.putExtra( "Theme", "Small" );
                getActivity().finish();
                startActivity(intent);
            }
        } );

        return rootView;
    }
}
