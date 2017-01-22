package com.skeptek.fundisplayapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class DisplayFormActivity extends AppCompatActivity {

    private DisplayText mDisplayText;
    private EditText mDisplayTextField;
    private Button mSubmitButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_form);

        mDisplayTextField = (EditText) findViewById(R.id.display_text_form_field);
        mSubmitButton = (Button) findViewById(R.id.display_text_form_submit_button);

        mSubmitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(DisplayFormActivity.this, mDisplayTextField.getText().toString(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
