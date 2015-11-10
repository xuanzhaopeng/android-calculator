package com.dennisideler.calculator;

import android.content.Context;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.test.suitebuilder.annotation.LargeTest;
import android.view.inputmethod.InputMethodManager;

import com.dennisideler.calculator.utils.CalculatorHelper;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static junit.framework.Assert.*;

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
    public void displayOperandsCorrect() {
        StringBuilder expectedResult = new StringBuilder();
        for (int i = 9; i >= 0; i--) {
            String number = String.valueOf(i);
            CalculatorHelper.getInstance().number(String.valueOf(i));
            expectedResult.append(number);
        }
        onView(withId(R.id.textViewAns)).check(matches(withText(expectedResult.toString())));
    }

    @Test
    public void displayAddOperator() {
        CalculatorHelper.getInstance().number("1");
        CalculatorHelper.getInstance().add();
        onView(withId(R.id.textViewAns)).check(matches(withText("1" + MainActivity.ADD)));
    }

    @Test
    public void displaySubOperator() {
        CalculatorHelper.getInstance().number("1");
        CalculatorHelper.getInstance().sub();
        onView(withId(R.id.textViewAns)).check(matches(withText("1" + MainActivity.SUB)));
    }

    @Test
    public void displayDivOperator() {
        CalculatorHelper.getInstance().number("1");
        CalculatorHelper.getInstance().div();
        onView(withId(R.id.textViewAns)).check(matches(withText("1" + MainActivity.DIV)));
    }

    @Test
    public void displayMulOperator() {
        CalculatorHelper.getInstance().number("1");
        CalculatorHelper.getInstance().mul();
        onView(withId(R.id.textViewAns)).check(matches(withText("1" + MainActivity.MUL)));
    }

    @Test
    public void softKeyboardIsNotDisplayed() {
        onView(withId(R.id.textViewAns)).perform(click());
        InputMethodManager inputMethodManager = (InputMethodManager) mActivityRule.getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
        assertFalse("The keyboard should not be displayed", inputMethodManager.isAcceptingText());
    }

    @Test
    public void typeTwoNumberAndRemoveAllNumbers() {
        onView(withText("1")).perform(click());
        onView(withText("2")).perform(click());
        onView(withId(R.id.buttonDel)).perform(click());
        onView(withId(R.id.textViewAns)).check(matches(withText("1")));
        onView(withId(R.id.buttonDel)).perform(click());
        onView(withId(R.id.textViewAns)).check(matches(withText("")));
        onView(withId(R.id.buttonDel)).perform(click());
        onView(withId(R.id.textViewAns)).check(matches(withText("")));
    }

    @Test
    public void typeNumberStartWithZero()
    {
        onView(withText("0")).perform(click());
        onView(withText("3")).perform(click());
        onView(withId(R.id.textViewAns)).check(matches(withText("3")));
    }

    @Test
    public void typeNumberStartWithMultipleZero()
    {
        CalculatorHelper.getInstance()
                .number("1")
                .mul()
                .number("0")
                .number("0")
                .number("3");
        onView(withId(R.id.textViewAns)).check(matches(withText("1" + MainActivity.ADD + "3")));
    }





}
