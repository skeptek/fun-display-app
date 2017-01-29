package com.skeptek.fundisplayapp;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.skeptek.fundisplayapp.utils.Constant;

/**
 * Created by tor611 on 1/28/17.
 */
public class DisplayTextFragment extends Fragment{
    private DisplayText mDisplayText;
    private String mDisplayTextString;
    private TextView mDisplayTextView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        mDisplayTextString = getArguments().getString(Constant.DISPLAY_TEXT);

        View v = inflater.inflate(R.layout.fragment_display_output, container, false);

        mDisplayTextView = (TextView) v.findViewById(R.id.display_text);
        mDisplayTextView.setText(mDisplayTextString);

        return v;
    }
}
