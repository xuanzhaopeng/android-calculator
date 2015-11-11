package com.dennisideler.calculator.lib.pageobject.check;

import com.dennisideler.calculator.R;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

/**
 * Created by lenovo on 2015/11/11.
 */
public class MainActivityCheck extends CommonCheck<MainActivityCheck>{

    private MainActivityCheck()
    {

    }

    public static MainActivityCheck getInstance()
    {
        if(instance == null)
        {
            instance = new MainActivityCheck();
        }
        return instance;
    }

    public MainActivityCheck shouldFormulaEqualsTo(String expectedValue)
    {
        onView(withId(R.id.textViewAns)).check(matches(withText(expectedValue)));
        return this;
    }

    public void shouldCalculationResultEqualsTo(String expectedValue)
    {
        onView(withId(R.id.buttonEql)).perform(click());
        onView(withId(R.id.textViewAns)).check(matches(withText(expectedValue)));
    }

    private static MainActivityCheck instance;

    @Override
    protected MainActivityCheck getConcreteCheck() {
        return this;
    }
}
