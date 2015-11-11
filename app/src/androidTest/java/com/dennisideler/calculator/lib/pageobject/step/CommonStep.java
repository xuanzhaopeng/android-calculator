package com.dennisideler.calculator.lib.pageobject.step;
import android.view.View;

import org.hamcrest.Matcher;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;

/**
 * Created by lenovo on 2015/11/11.
 */
public abstract class CommonStep<T> {

    public T IClickOn(Matcher<View> matcher)
    {
        onView(matcher).perform(click());
        return getConcreteSteps();
    }

    protected abstract T getConcreteSteps();


}
