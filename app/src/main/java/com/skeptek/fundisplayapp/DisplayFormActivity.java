package com.skeptek.fundisplayapp;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

import com.skeptek.fundisplayapp.utils.Constant;

public class DisplayFormActivity extends FragmentActivity
        implements DisplayFormFragment.OnTextFormSubmittedListener {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_form);

        FragmentManager fm = getSupportFragmentManager();
        Fragment fragment = fm.findFragmentById(R.id.fragment_container);

        if (fragment == null) {
            fragment = new DisplayFormFragment();
            fm.beginTransaction()
                    .add(R.id.fragment_container, fragment)
                    .commit();
        }

    }

    public void onTextFormSubmitted(DisplayText displayText) {
        // Callback pattern for fragment comm per
        // https://developer.android.com/training/basics/fragments/communicating.html#Deliver


        Fragment fragment = new DisplayTextFragment();
        Bundle args = new Bundle();
        args.putString(Constant.DISPLAY_TEXT, displayText.getmDisplayText());
        fragment.setArguments(args);

        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.fragment_container, fragment);
        transaction.addToBackStack(null);
        transaction.commit();

    }
}
