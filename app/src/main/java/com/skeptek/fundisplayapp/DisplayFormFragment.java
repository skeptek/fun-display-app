package com.skeptek.fundisplayapp;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by tor611 on 1/22/17.
 */
public class DisplayFormFragment extends Fragment {
    private DisplayText mDisplayText;
    private EditText mDisplayTextField;
    private Button mSubmitButton;
    private OnTextFormSubmittedListener mCallback;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
        mDisplayText = new DisplayText();
    }

    //next pg. 139 onCreateView
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_display_form, container, false);

        mDisplayTextField = (EditText) v.findViewById(R.id.display_text_form_field);
        mSubmitButton = (Button) v.findViewById(R.id.display_text_form_submit_button);

        mSubmitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(getActivity(), mDisplayTextField.getText().toString(), Toast.LENGTH_SHORT).show();

                mDisplayText.setmDisplayText(mDisplayTextField.getText().toString());
                mCallback.onTextFormSubmitted(mDisplayText);

            }
        });

        return v;
    }

    // Container Activity must implement this interface
    public interface OnTextFormSubmittedListener {
        public void onTextFormSubmitted(DisplayText displayText);
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);

        // This makes sure that the container activity has implemented
        // the callback interface. If not, it throws an exception
        try {
            mCallback = (OnTextFormSubmittedListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString()
                    + " must implement OnTextFormSubmittedListener");
        }
    }
}
