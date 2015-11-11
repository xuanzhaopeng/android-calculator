package com.dennisideler.calculator.lib.wrapper;

import android.widget.TextView;
import com.dennisideler.calculator.lib.common.CustomAssert;

/**
 * Created by lenovo on 2015/11/11.
 */
public class TextViewWrapper extends ViewWrapper {
    public static TextViewWrapper Create(TextView textView)
    {
        return new TextViewWrapper(textView);
    }

    public TextViewWrapper shouldMaxLinesEqualTo(int expectedMaxLines)
    {
        CustomAssert.AssertEquals(expectedMaxLines, mTextView.getMaxLines(),
                String.format("The Maxlines of textview should be %1$d, but was %2$d", expectedMaxLines, mTextView.getMaxLines()));
        return this;
    }


    private TextViewWrapper(TextView textView)
    {
        mTextView = textView;
    }

    private TextView mTextView;

}
