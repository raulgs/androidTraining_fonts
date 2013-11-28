package com.demo.miscdemo.hint;

import com.demo.miscdemo.ItemDetailFragment;
import com.demo.miscdemo.R;
import com.demo.miscdemo.home.HomeFragmentList;
import com.demo.miscdemo.pojo.FragmentItem;
import com.demo.miscdemo.widget.EditTextPlus;

import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

/**
 * Created by raulg on 11/28/13.
 */
public class ArabicHintFragment extends Fragment {

    private FragmentItem mItem;
    private EditTextPlus airlineButton;
    private EditTextPlus flightNumberEdit;

    String selectAirlineHintArabic = "حدد الخطوط الجوية";
    String enterFlightHintArabic = "أدخل رقم الرحلة";

    String selectAirlineHintEN = "Select Airline";
    String enterFlightHintEN = "Enter FLight #";
    private CheckBox arabicCheckbox;
    private String mSelectAirlineHint;
    private String mEnterFlightHint;
    private CheckBox checkBuildVersion;

    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        if (getArguments().containsKey(ItemDetailFragment.ARG_ITEM_ID)) {
            // Load the dummy title specified by the fragment
            // arguments. In a real-world scenario, use a Loader
            // to load title from a title provider.
            mItem = HomeFragmentList.ITEM_MAP.get(getArguments().getString(ItemDetailFragment.ARG_ITEM_ID));
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_hint, container, false);

        // Show the title as text in a TextView.
        if (mItem != null) {
            ((TextView) rootView.findViewById(R.id.hint_item_detail)).setText(mItem.title);
        }

        airlineButton = (EditTextPlus) rootView.findViewById(R.id.hintAirlineButton);
        flightNumberEdit = (EditTextPlus) rootView.findViewById(R.id.hintFlightNumberEditText);
        checkBuildVersion = (CheckBox) rootView.findViewById(R.id.hint_checkBuildVersion);
        arabicCheckbox = (CheckBox) rootView.findViewById(R.id.hint_arabic);
        TextView versionText = (TextView) rootView.findViewById(R.id.hint_version);

        versionText.setText(versionText.getText().toString() + Build.VERSION.SDK_INT);

        mSelectAirlineHint = selectAirlineHintArabic;
        mEnterFlightHint = enterFlightHintArabic;

        setHints();

        arabicCheckbox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (arabicCheckbox.isChecked()) {
                    mSelectAirlineHint = selectAirlineHintArabic;
                    mEnterFlightHint = enterFlightHintArabic;
                }
                else {
                    mSelectAirlineHint = selectAirlineHintEN;
                    mEnterFlightHint = enterFlightHintEN;
                }
                setHints();
            }
        });

        return rootView;
    }

    public void setHints() {
        if (checkBuildVersion.isChecked()) {
            if (Build.VERSION.SDK_INT <= Build.VERSION_CODES.HONEYCOMB_MR2) {
                mSelectAirlineHint = "\u0020" + mSelectAirlineHint;
                mEnterFlightHint = "\u0020" + mEnterFlightHint;
            }
        }
        airlineButton.setHint(mSelectAirlineHint);
        flightNumberEdit.setHint(mEnterFlightHint);
    }

}
