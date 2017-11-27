package com.android.exercise;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivityFullCalculator extends AppCompatActivity {
    private static final String LOG_PREFIX = "_antlap_";
    private static final String LOG_TAG = LOG_PREFIX + MainActivityFullCalculator.class.getSimpleName();

    private EditText plus1;
    private EditText plus2;
    private TextView plusRes;
    private TextView totalField;
    private EditText minus1;
    private EditText minus2;
    private TextView minusRes;
    private EditText for1;
    private EditText for2;
    private TextView forRes;
    private EditText power1;
    private EditText factorial1;
    private EditText power2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_full_calculator);

        //TOTAL field
        totalField = (TextView) findViewById(R.id.tot_col2);

        //PLUS layout Views
        plus1 = (EditText) findViewById(R.id.plus_col_1);
        plus2 = (EditText) findViewById(R.id.plus_col_2);

        //MINUS layout Views
        minus1 = (EditText) findViewById(R.id.minus_col_1);
        minus2 = (EditText) findViewById(R.id.minus_col_2);

        //FOR layout Views
        for1 = (EditText) findViewById(R.id.for_col_1);
        for2 = (EditText) findViewById(R.id.for_col_2);

        //POWER layout Views
        factorial1 = (EditText) findViewById(R.id.factorial_col1);

        //POWER layout Views
        power1 = (EditText) findViewById(R.id.power_col1);
        power2 = (EditText) findViewById(R.id.power_col2);
    }

    public void calculatePlus(View view) {
        try {
            int result = Integer.parseInt(plus1.getText().toString()) +
                    Integer.parseInt(plus2.getText().toString());
            totalField.setText(String.valueOf(result));
        } catch (NumberFormatException exc) {
            Toast.makeText(this, "ERROR: view log file", Toast.LENGTH_LONG).show();
            Log.e(LOG_TAG, "Plus error!" + exc);
        }
    }

    public void calculateMinus(View view) {
        try {
            int result = Integer.parseInt(minus1.getText().toString()) -
                    Integer.parseInt(minus2.getText().toString());
            totalField.setText(String.valueOf(result));
        } catch (NumberFormatException exc) {
            Toast.makeText(this, "ERROR: view log file", Toast.LENGTH_LONG).show();
            Log.e(LOG_TAG, "Minus error!" + exc);
        }
    }

    public void calculateFor(View view) {
        try {
            int result = Integer.parseInt(for1.getText().toString()) *
                    Integer.parseInt(for2.getText().toString());
            totalField.setText(String.valueOf(result));
        } catch (NumberFormatException exc) {
            Toast.makeText(this, "ERROR: view log file", Toast.LENGTH_LONG).show();
            Log.e(LOG_TAG, "FOR error!" + exc);
        }
    }

    public void calculateFactorial(View view) {
        try {
            long result = factorial (Long.parseLong(factorial1.getText().toString()));
            totalField.setText(String.valueOf(result));
        } catch (NumberFormatException exc) {
            Toast.makeText(this, "ERROR: view log file", Toast.LENGTH_LONG).show();
            Log.e(LOG_TAG, "FACTORIAL error!" + exc);
        }
    }

    public void calculatePower(View view) {
        try {
            double result =  Math.pow(Integer.parseInt(power1.getText().toString()),
                    Integer.parseInt(power2.getText().toString()));
            totalField.setText(Integer.toString((int)result));
        } catch (NumberFormatException exc) {
            Toast.makeText(this, "ERROR: view log file", Toast.LENGTH_LONG).show();
            Log.e(LOG_TAG, "POWER error!" + exc);
        }
    }

    long recfact(long start, long n) {
        long i;
        if (n <= 16) {
            long r = start;
            for (i = start + 1; i < start + n; i++) r *= i;
            return r;
        }
        i = n / 2;
        return recfact(start, i) * recfact(start + i, n - i);
    }

    long factorial(long n) { return recfact(1, n); }}
