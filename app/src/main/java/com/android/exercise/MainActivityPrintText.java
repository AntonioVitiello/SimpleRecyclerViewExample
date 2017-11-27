package com.android.exercise;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivityPrintText extends AppCompatActivity {

    private TextView printEditText;
    private EditText inputEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_print_text);
        inputEditText = (EditText)findViewById(R.id.et_input_string);
        printEditText = (TextView)findViewById(R.id.et_print_string);
    }

    public void print(View view) {
        CharSequence text = inputEditText.getText().toString();
        printEditText.append(text);
    }
}
