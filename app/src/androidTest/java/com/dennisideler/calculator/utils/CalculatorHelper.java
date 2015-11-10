package com.dennisideler.calculator.utils;

import com.dennisideler.calculator.R;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
/**
 * Created by lenovo on 2015/11/10.
 */
public class CalculatorHelper {
    public static CalculatorHelper getInstance()
    {
        if(instance == null)
        {
            instance = new CalculatorHelper();
        }
        return instance;
    }

    public CalculatorHelper enterNumber(String number)
    {
        typeNumber(number);
        return this;
    }

    public CalculatorHelper pressAdd()
    {
        onView(withId(R.id.buttonAdd)).perform(click());
        return this;
    }

    public CalculatorHelper pressDiv()
    {
        onView(withId(R.id.buttonDiv)).perform(click());
        return this;
    }

    public CalculatorHelper pressMul()
    {
        onView(withId(R.id.buttonMul)).perform(click());
        return this;
    }

    public CalculatorHelper pressSub()
    {
        onView(withId(R.id.buttonSub)).perform(click());
        return this;
    }

    public CalculatorHelper pressDelete()
    {
        onView(withId(R.id.buttonDel)).perform(click());
        return this;
    }

    public CalculatorHelper shouldCalculatorTextEqualsTo(String expectedValue)
    {
        onView(withId(R.id.textViewAns)).check(matches(withText(expectedValue)));
        return this;
    }

    public void shouldCalculatorResultEqualsTo(String expectedValue)
    {
        onView(withId(R.id.buttonEql)).perform(click());
        onView(withId(R.id.textViewAns)).check(matches(withText(expectedValue)));
    }

    private CalculatorHelper()
    {

    }

    private void typeNumber(String number) {
        for (int i = 0; i < number.length(); i++) {
            onView(withText(String.valueOf(number.charAt(i)))).perform(click());
        }
    }


    private static CalculatorHelper instance;
}
