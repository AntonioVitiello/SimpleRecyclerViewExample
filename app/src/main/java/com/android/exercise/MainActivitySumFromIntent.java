package com.android.exercise;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class MainActivitySumFromIntent extends AppCompatActivity {

    public static final String RESULT_KEY = "result";
    public static final int CALCULATOR_REQUEST = 1;
    private TextView resultText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sum_from_intent);

        resultText = (TextView)findViewById(R.id.tv_result);

        // set background color
        getWindow().getDecorView().setBackgroundColor(ContextCompat.getColor(this, R.color.my_yellow));
//        getWindow().getDecorView().setBackgroundColor(Color.YELLOW);
//        View rootView = resultText.getRootView();
//        rootView.setBackgroundColor(getResources().getColor(R.color.my_yellow));

    }

    public void calculate(View view) {
        Intent calculatorIntent = new Intent(this, ReturnSumToMainActivity.class);
        calculatorIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivityForResult(calculatorIntent, CALCULATOR_REQUEST);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent intent) {
        Log.d("antlap", "onActivityResult: resultCode = " + resultCode + ", requestCode = " + requestCode);
        if (requestCode == CALCULATOR_REQUEST) {
            if (resultCode == RESULT_OK) {
                Log.d("antlap", "onActivityResult: " + intent);
                String result = intent.getStringExtra(RESULT_KEY);
                resultText.setText(result);
            }
        }
    }

}
