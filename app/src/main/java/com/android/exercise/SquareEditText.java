package com.android.exercise;

import android.content.Context;
import android.support.v7.widget.AppCompatEditText;
import android.util.AttributeSet;

/**
 * Created by antlap on 17/10/2017.
 */

public class SquareEditText extends AppCompatEditText {
    public SquareEditText(Context context) {
        super(context);
    }

    public SquareEditText(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    // This is used to make square buttons.
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, widthMeasureSpec);
    }
}
