package com.dennisideler.calculator.lib.pageobject.check;

import android.app.Activity;
import android.content.Context;
import android.view.inputmethod.InputMethodManager;

import com.dennisideler.calculator.lib.common.CustomAssert;

import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.matcher.ViewMatchers.withId;

/**
 * Created by lenovo on 2015/11/11.
 */
public abstract class CommonCheck<T> {

    public T shouldKeyboardNotDisplayed(Activity activity)
    {
        InputMethodManager inputMethodManager = (InputMethodManager) activity.getSystemService(Context.INPUT_METHOD_SERVICE);
        CustomAssert.AssertEquals(false, inputMethodManager.isAcceptingText(), "Keyboard should not display");
        return getConcreteCheck();
    }

    protected abstract T getConcreteCheck();
}
