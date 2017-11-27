package com.android.exercise;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class ResultFullCalculatorWithIntent extends AppCompatActivity {

    private TextView tvFactorialResult;
    private TextView tvPowerResult;
    private TextView tvProductResult;
    private TextView tvSubtractionResult;
    private TextView tvSumResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result_full_calculator_with_intent);

        Intent intent = getIntent();
        String sumLine = intent.getStringExtra(MainActivityFullCalculatorWithIntent.RESULT_SUM);
        String subtractionLine = intent.getStringExtra(MainActivityFullCalculatorWithIntent.RESULT_SUBTRACTION);
        String multiplicationLine = intent.getStringExtra(MainActivityFullCalculatorWithIntent.RESULT_MULTIPLICATION);
        String factorialLine = intent.getStringExtra(MainActivityFullCalculatorWithIntent.RESULT_FACTORIAL);
        String powerLine = intent.getStringExtra(MainActivityFullCalculatorWithIntent.RESULT_POWER);

        tvSumResult = (TextView) findViewById(R.id.tv_sum_result);
        tvSubtractionResult = (TextView) findViewById(R.id.tv_subtraction_result);
        tvProductResult = (TextView) findViewById(R.id.tv_product_result);
        tvFactorialResult = (TextView) findViewById(R.id.tv_factorial_result);
        tvPowerResult = (TextView) findViewById(R.id.tv_power_result);

        tvFactorialResult.setText(factorialLine);
        tvPowerResult.setText(powerLine);
        tvProductResult.setText(multiplicationLine);
        tvSubtractionResult.setText(subtractionLine);
        tvSumResult.setText(sumLine);
    }
}
