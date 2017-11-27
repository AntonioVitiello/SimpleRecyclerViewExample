package com.android.exercise;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivityFullCalculatorWithIntent extends AppCompatActivity {

    private static final String LOG_PREFIX = "_antlap_";
    private static final String LOG_TAG = LOG_PREFIX + MainActivityFullCalculator.class.getSimpleName();

    public static final String RESULT_SUM = "result_sum";
    public static final String RESULT_SUBTRACTION = "result_subtraction";
    public static final String RESULT_MULTIPLICATION = "result_multiplication";
    public static final String RESULT_FACTORIAL = "result_factorial";
    public static final String RESULT_POWER = "result_power";

    private EditText plus1;
    private EditText plus2;
    private TextView plusRes;
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
        setContentView(R.layout.activity_full_calculator_with_intent);

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

    private String buildPresentation(String s1, String s2, String s3, String s4){
        String line;
        if(s4 == null){
            line = s1.trim() + " " + s2.trim() + " = " + s3.trim();
        } else {
            line = s1.trim() + " " + s2.trim() + " " + s3.trim() + " = " + s4.trim();
        }
        return line;
    }

    public String buildSum() {
        String result = "nd";
        String number1 = plus1.getText().toString();
        String number2 = plus2.getText().toString();

        try {
            result = String.valueOf(Integer.parseInt(number1) + Integer.parseInt(number2));
        } catch (NumberFormatException exc) {
            Toast.makeText(this, "ERROR: view log file", Toast.LENGTH_LONG).show();
            Log.e(LOG_TAG, "SUM error!" + exc);
        }
        return buildPresentation(number1, "+", number2, result);
    }

    public String buildSubtraction() {
        String result = "nd";
        String number1 = minus1.getText().toString();
        String number2 = minus2.getText().toString();

        try {
            result = String.valueOf(Integer.parseInt(number1) - Integer.parseInt(number2));
        } catch (NumberFormatException exc) {
            Toast.makeText(this, "ERROR: view log file", Toast.LENGTH_LONG).show();
            Log.e(LOG_TAG, "SUBTRACTION error!" + exc);
        }
        return buildPresentation(number1, "-", number2, result);
    }

    public String buildMultiplication() {
        String result = "nd";
        String number1 = for1.getText().toString();
        String number2 = for2.getText().toString();

        try {
            result = String.valueOf(Integer.parseInt(number1) * Integer.parseInt(number2));
        } catch (NumberFormatException exc) {
            Toast.makeText(this, "ERROR: view log file", Toast.LENGTH_LONG).show();
            Log.e(LOG_TAG, "MULTIPLICATION error!" + exc);
        }
        return buildPresentation(number1, "*", number2, result);
    }

    public String buildFactorial() {
        String result = "nd";
        String number1 = factorial1.getText().toString();

        try {
            result = String.valueOf(factorial (Long.parseLong(number1)));
        } catch (NumberFormatException exc) {
            Toast.makeText(this, "ERROR: view log file", Toast.LENGTH_LONG).show();
            Log.e(LOG_TAG, "FACTORIAL error!" + exc);
        }
        return buildPresentation(number1, "!", result, null);
    }

    public String buildPower() {
        String result = "nd";
        String number1 = power1.getText().toString();
        String number2 = power2.getText().toString();

        try {
            result =  String.valueOf((long)Math.pow(Integer.parseInt(number1), Integer.parseInt(number2)));
        } catch (NumberFormatException exc) {
            Toast.makeText(this, "ERROR: view log file", Toast.LENGTH_LONG).show();
            Log.e(LOG_TAG, "POWER error!" + exc);
        }
        return buildPresentation(number1, "^", number2, result);
    }

    public static long factorial(long n) {
        return iteratefactorial(1, n);
    }

    private static long iteratefactorial(long start, long end) {
        long i;
        if (end <= 16) {
            long r = start;
            for (i = start + 1; i < start + end; i++) r *= i;
            return r;
        }
        i = end / 2;
        return iteratefactorial(start, i) * iteratefactorial(start + i, end - i);
    }

    public void calculateTotal(View view) {
        if(!validate()){
            return;
        }
        Intent intentResults = new Intent(this, ResultFullCalculatorWithIntent.class);
//        intentResults.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);  // launchMode="singleTop"
        intentResults.putExtra(RESULT_SUM, buildSum());
        intentResults.putExtra(RESULT_SUBTRACTION, buildSubtraction());
        intentResults.putExtra(RESULT_MULTIPLICATION, buildMultiplication());
        intentResults.putExtra(RESULT_FACTORIAL, buildFactorial());
        intentResults.putExtra(RESULT_POWER, buildPower());
        startActivity(intentResults);

        Log.d(LOG_TAG, "calculateTotal: operations = " + intentResults.getExtras());
    }

    private boolean validate() {
        boolean allValued = plus1.getText().length() > 0 && plus2.getText().length() > 0
                && minus1.getText().length() > 0 && minus2.getText().length() > 0
                && for1.getText().length() > 0 && for2.getText().length() > 0
                && factorial1.getText().length() > 0
                && power1.getText().length() > 0 && power2.getText().length() > 0;

        if(!allValued) {
            AlertDialog alert = new AlertDialog.Builder(this)
                    .setMessage(R.string.value_all_fields_to_continue)
                    .setCancelable(false)
                    .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            Log.d(LOG_TAG, "Field not all valued");
                        }
                    })
                    .create();
            alert.show();
        }

        return allValued;
    }
}
