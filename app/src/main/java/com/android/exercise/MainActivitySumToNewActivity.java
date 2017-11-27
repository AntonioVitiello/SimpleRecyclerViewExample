package com.android.exercise;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivitySumToNewActivity extends AppCompatActivity {

    public static final String RESULT_KEY = "result";
//    private static final int PICK_CONTACT_REQUEST = 1;
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
        View rootView = add1EditText.getRootView();
        rootView.setBackgroundColor(getResources().getColor(R.color.my_yellow));
    }

    public void print(View view) {
        String add1 = add1EditText.getText().toString();
        String add2 = add2EditText.getText().toString();
        String result = String.valueOf(Integer.parseInt(add1) + Integer.parseInt(add2));

        resultTextView.setText(result);
        Log.d("antlap", "print: result = " + add1 );
        Log.d("antlap", "print: result = " + add2 );
        Log.d("antlap", "print: result = " + result );

        Intent intent = new Intent(this, GetSumFromIntentActivity.class);
        intent.putExtra(RESULT_KEY, result);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);

//        Intent pickContactIntent = new Intent(Intent.ACTION_PICK, Uri.parse("content://contacts"));
//        pickContactIntent.setType(ContactsContract.CommonDataKinds.Phone.CONTENT_TYPE);
//        startActivityForResult(pickContactIntent, PICK_CONTACT_REQUEST);
    }

//    @Override
//    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
//        Log.d("antlap", "onActivityResult: resultCode = " + resultCode + ", requestCode = " + requestCode);
//        if (requestCode == PICK_CONTACT_REQUEST) {
//            if (resultCode == RESULT_OK) {
//                Log.d("antlap", "onActivityResult: " + data);
//            }
//        }
//    }

}
