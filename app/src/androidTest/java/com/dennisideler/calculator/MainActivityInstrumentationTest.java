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
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static junit.framework.Assert.assertFalse;

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
    public void AllOperandsShouldDisplay() {
        String expectedResult = "9876543210";
        CalculatorHelper.getInstance()
                .number(expectedResult)
                .shouldCalculatorTextEqualsTo(expectedResult);
    }

    @Test
    public void OperatorAddShouldDisplay() {
        CalculatorHelper.getInstance()
                .number("1")
                .add()
                .shouldCalculatorTextEqualsTo("1" + MainActivity.ADD);
    }

    @Test
    public void OperatorSubShouldDisplay() {
        CalculatorHelper.getInstance()
                .number("1")
                .sub()
                .shouldCalculatorTextEqualsTo("1" + MainActivity.SUB);
    }

    @Test
    public void OperatorDivShouldDisplay() {
        CalculatorHelper.getInstance()
                .number("1")
                .div()
                .shouldCalculatorTextEqualsTo("1" + MainActivity.DIV);
    }

    @Test
    public void OperatorMulShouldDisplay() {
        CalculatorHelper.getInstance()
                .number("1")
                .mul()
                .shouldCalculatorTextEqualsTo("1" + MainActivity.MUL);
    }

    @Test
    public void SoftKeyboardShouldNotDisplay() {
        onView(withId(R.id.textViewAns)).perform(click());
        InputMethodManager inputMethodManager = (InputMethodManager) mActivityRule.getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
        assertFalse("The keyboard should not be displayed", inputMethodManager.isAcceptingText());
    }

    @Test
    public void OperandShouldBeRemoved() {
        CalculatorHelper.getInstance().number("12")
                .Delete()
                .Delete()
                .shouldCalculatorTextEqualsTo("");
    }

    @Test
    public void ZeroAtTheBeginningOfOperandShouldNotDisplay()
    {
        CalculatorHelper.getInstance()
                .number("03")
                .shouldCalculatorTextEqualsTo("3");
    }

    @Test
    public void MultipleZeroAtTheBeginningOfOperandShouldNotDisplay()
    {
        CalculatorHelper.getInstance()
                .number("1")
                .mul()
                .number("003")
                .shouldCalculatorTextEqualsTo("1" + MainActivity.MUL + "3");
    }

    @Test
    public void OperatorShouldNotDisplayedAlong(){
        CalculatorHelper.getInstance()
                .mul()
                .div()
                .add()
                .sub()
                .shouldCalculatorTextEqualsTo("");
    }

    @Test
    public void OnlyOneOperatorShouldUsedBetweenTwoOperands()
    {
        CalculatorHelper.getInstance()
                .number("10")
                .mul()
                .sub()
                .number("2")
                .shouldCalculatorTextEqualsTo("10" + MainActivity.SUB + "2")
                .shouldCalculatorResultEqualsTo("8");
    }





}
