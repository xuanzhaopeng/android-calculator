package com.dennisideler.calculator.lib.wrapper;

import android.widget.Button;

import com.dennisideler.calculator.lib.common.CustomAssert;

/**
 * Created by lenovo on 2015/11/10.
 */
public class ButtonWrapper extends ViewWrapper{

    public static ButtonWrapper Create(Button button)
    {
        return new ButtonWrapper(button);
    }


    public ButtonWrapper shouldTextEqualsTo(String expectedText) {
        String actualText = mButton.getText().toString();
        CustomAssert.AssertEquals(expectedText,actualText,
                String.format("The text of button id=%1$d expected : %2$s,but was %3$s", mButton.getId(),expectedText,  actualText));
        return this;
    }

    public ButtonWrapper shouldBeClickAble()
    {
        CustomAssert.AssertEquals(true,mButton.isClickable(),
                String.format("The button id=%1%d should be click", mButton.getId()));
        return this;
    }


    private ButtonWrapper(Button button)
    {
        mButton = button;
    }

    private Button mButton;
}
