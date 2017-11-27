package com.android.exercise;

import android.os.Bundle;
import android.os.Vibrator;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivitySumCalculator extends AppCompatActivity {

    private EditText add1EditText;
    private EditText add2EditText;
    private TextView resultTextView;
    private Vibrator mVibrator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_sum_calculator);

        mVibrator = (Vibrator) this.getSystemService(VIBRATOR_SERVICE);

        add1EditText = (EditText)findViewById(R.id.et_input_1);
        add2EditText = (EditText)findViewById(R.id.et_input_2);
        resultTextView = (TextView)findViewById(R.id.tv_result);

//        Button eqButton = (Button) findViewById(R.id.bu_equals);
//        eqButton.performHapticFeedback(HapticFeedbackConstants.CONTEXT_CLICK);
//        eqButton.setHapticFeedbackEnabled( true );

        // set background color
        getWindow().getDecorView().setBackgroundColor(ContextCompat.getColor(this, R.color.my_yellow));
//        View rootView = add1EditText.getRootView();
//        rootView.setBackgroundColor(getResources().getColor(R.color.my_yellow));
    }

    public void print(View view) {
        // add Haptic Feedback
        mVibrator.vibrate(50);

//        view.setHapticFeedbackEnabled( true );
//        view.performHapticFeedback(HapticFeedbackConstants.CONTEXT_CLICK);

        String add1 = add1EditText.getText().toString();
        String add2 = add2EditText.getText().toString();
        String result = String.valueOf(Integer.parseInt(add1) + Integer.parseInt(add2));

        resultTextView.setText(result);
        Log.d("antlap", "print: result = " + add1 );
        Log.d("antlap", "print: result = " + add2 );
        Log.d("antlap", "print: result = " + result );
    }
}
