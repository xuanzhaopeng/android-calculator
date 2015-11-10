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
                .enterNumber(expectedResult)
                .shouldCalculatorTextEqualsTo(expectedResult);
    }

    @Test
    public void OperatorAddShouldDisplay() {
        CalculatorHelper.getInstance()
                .enterNumber("1")
                .pressAdd()
                .shouldCalculatorTextEqualsTo("1" + MainActivity.ADD);
    }

    @Test
    public void OperatorSubShouldDisplay() {
        CalculatorHelper.getInstance()
                .enterNumber("1")
                .pressSub()
                .shouldCalculatorTextEqualsTo("1" + MainActivity.SUB);
    }

    @Test
    public void OperatorDivShouldDisplay() {
        CalculatorHelper.getInstance()
                .enterNumber("1")
                .pressDiv()
                .shouldCalculatorTextEqualsTo("1" + MainActivity.DIV);
    }

    @Test
    public void OperatorMulShouldDisplay() {
        CalculatorHelper.getInstance()
                .enterNumber("1")
                .pressMul()
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
        CalculatorHelper.getInstance().enterNumber("12")
                .pressDelete()
                .pressDelete()
                .shouldCalculatorTextEqualsTo("");
    }

    @Test
    public void ZeroAtTheBeginningOfOperandShouldNotDisplay()
    {
        CalculatorHelper.getInstance()
                .enterNumber("03")
                .shouldCalculatorTextEqualsTo("3");
    }

    @Test
    public void MultipleZeroAtTheBeginningOfOperandShouldNotDisplay()
    {
        CalculatorHelper.getInstance()
                .enterNumber("1")
                .pressMul()
                .enterNumber("003")
                .shouldCalculatorTextEqualsTo("1" + MainActivity.MUL + "3");
    }

    @Test
    public void OperatorShouldNotDisplayedAlong(){
        CalculatorHelper.getInstance()
                .pressMul()
                .pressDiv()
                .pressAdd()
                .pressSub()
                .shouldCalculatorTextEqualsTo("");
    }

    @Test
    public void OnlyOneOperatorShouldUsedBetweenTwoOperands()
    {
        CalculatorHelper.getInstance()
                .enterNumber("10")
                .pressMul()
                .pressSub()
                .enterNumber("2")
                .shouldCalculatorTextEqualsTo("10" + MainActivity.SUB + "2")
                .shouldCalculatorResultEqualsTo("8");
    }

    @Test
    public void BiggestOperandsShouldWorksCorrect()
    {
        double expectedResult = ((double)(Integer.MAX_VALUE)) *((double)(Integer.MAX_VALUE));
        CalculatorHelper.getInstance()
                .enterNumber(String.valueOf(Integer.MAX_VALUE))
                .pressMul()
                .enterNumber(String.valueOf(Integer.MAX_VALUE))
                .shouldCalculatorResultEqualsTo(String.format("%.0f",expectedResult));

        double value = 99999999999999999999999999999999999999999999999999999999.0;
        expectedResult = value * value;
        CalculatorHelper.getInstance()
                .enterNumber(String.format("%.0f", value))
                .pressMul()
                .enterNumber(String.format("%.0f", value))
                .shouldCalculatorResultEqualsTo(String.format("%.0f", expectedResult));
    }

}
