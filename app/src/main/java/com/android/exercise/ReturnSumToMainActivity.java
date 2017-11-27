package com.android.exercise;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class ReturnSumToMainActivity extends AppCompatActivity {

    private EditText add1EditText;
    private EditText add2EditText;
    private TextView resultTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_sum_calculator);

        add1EditText = (EditText)findViewById(R.id.et_input_1);
        add2EditText = (EditText)findViewById(R.id.et_input_2);
        resultTextView = (TextView)findViewById(R.id.tv_result);

        // set background color
        getWindow().getDecorView().setBackgroundColor(Color.YELLOW);
//        View rootView = add1EditText.getRootView();
//        rootView.setBackgroundColor(getResources().getColor(R.color.my_yellow));
    }

    public void calculate(View view) {
        String add1 = add1EditText.getText().toString();
        String add2 = add2EditText.getText().toString();
        String result = String.valueOf(Integer.parseInt(add1) + Integer.parseInt(add2));
        resultTextView.setText(result);

        Intent intent = new Intent();
        intent.putExtra(MainActivitySumFromIntent.RESULT_KEY, result);
        setResult(RESULT_OK, intent);
        finish();
    }

}
