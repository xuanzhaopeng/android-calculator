package com.dennisideler.calculator;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.test.suitebuilder.annotation.LargeTest;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

/**
 * Created by zxuan on 2015/11/9.
 */
@RunWith(AndroidJUnit4.class)
@LargeTest
public class MainActivityInstrumentationTest {

    @Rule
    public ActivityTestRule<MainActivity> mActivityRule = new ActivityTestRule<>(
            MainActivity.class);


    @Test
    public void showCorrectNumberInCalculator()
    {
        StringBuilder expectedResult = new StringBuilder();
        for(int i=9; i>= 0; i--)
        {
            String number = String.valueOf(i);
            onView(withText(String.valueOf(number))).perform(click());
            expectedResult.append(number);
        }
        onView(withId(R.id.textViewAns)).check(matches(withText(expectedResult.toString())));
    }


}
