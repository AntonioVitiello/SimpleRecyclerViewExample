package com.android.exercise;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class GetSumFromIntentActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get_sum_from_intent);

        String resultValue = getIntent().getStringExtra(MainActivitySumToNewActivity.RESULT_KEY);

        TextView resultView = (TextView) findViewById(R.id.tv_result);
        resultView.setText(resultValue);

//        resultView.getRootView().setBackgroundColor(ContextCompat.getColor(this, R.color.my_cyan));
        getWindow().getDecorView().setBackgroundColor(Color.CYAN);
    }
}
