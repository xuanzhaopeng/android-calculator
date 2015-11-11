package com.dennisideler.calculator.test.instrumentation;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.test.suitebuilder.annotation.LargeTest;

import com.dennisideler.calculator.lib.CommonTestCase;
import com.dennisideler.calculator.MainActivity;
import com.dennisideler.calculator.R;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.matcher.ViewMatchers.withId;

/**
 * Created by zxuan on 2015/11/9.
 */
@RunWith(AndroidJUnit4.class)
@LargeTest
public class MainActivityInstrumentationTest extends CommonTestCase {

    @Rule
    public ActivityTestRule<MainActivity> mActivityRule = new ActivityTestRule<>(MainActivity.class);

    @Test
    public void AllOperandsShouldDisplay() {
        String expectedResult = "9876543210";
        InMainActivity
                .IEnterNumber(expectedResult);
        ThenInMainActivity
                .shouldFormulaEqualsTo(expectedResult);
    }

    @Test
    public void OperatorAddShouldDisplay() {
        InMainActivity
                .IEnterNumber("1")
                .IPressAdd();
        ThenInMainActivity
                .shouldFormulaEqualsTo("1+");
    }

    @Test
    public void OperatorSubShouldDisplay() {
        InMainActivity
                .IEnterNumber("1")
                .IPressSub();
        ThenInMainActivity
                .shouldFormulaEqualsTo("1−");
    }

    @Test
    public void OperatorDivShouldDisplay() {
        InMainActivity
                .IEnterNumber("1")
                .IPressDiv();
        ThenInMainActivity
                .shouldFormulaEqualsTo("1÷");
    }

    @Test
    public void OperatorMulShouldDisplay() {
        InMainActivity
                .IEnterNumber("1")
                .IPressMul();
        ThenInMainActivity
                .shouldFormulaEqualsTo("1✕");
    }

    @Test
    public void SoftKeyboardShouldNotDisplay() {
        InMainActivity
                .IClickOn(withId(R.id.textViewAns));
        ThenInMainActivity
                .shouldKeyboardNotDisplayed(mActivityRule.getActivity());
    }

    @Test
    public void OperandShouldBeRemoved() {
        InMainActivity
                .IEnterNumber("12")
                .IPressDelete()
                .IPressDelete();
        ThenInMainActivity
                .shouldFormulaEqualsTo("");
    }

    @Test
    public void ZeroAtTheBeginningOfOperandShouldNotDisplay() {
        InMainActivity
                .IEnterNumber("03");
        ThenInMainActivity
                .shouldFormulaEqualsTo("3");
    }

    @Test
    public void MultipleZeroAtTheBeginningOfOperandShouldNotDisplay() {
        InMainActivity
                .IEnterNumber("1")
                .IPressMul()
                .IEnterNumber("003");
        ThenInMainActivity
                .shouldFormulaEqualsTo("1✕3");
    }

    @Test
    public void OperatorShouldNotDisplayedAlong() {
        InMainActivity
                .IPressMul()
                .IPressDiv()
                .IPressAdd()
                .IPressSub();
        ThenInMainActivity
                .shouldFormulaEqualsTo("");
    }

    @Test
    public void OnlyOneOperatorShouldUsedBetweenTwoOperands() {
        InMainActivity
                .IEnterNumber("10")
                .IPressMul()
                .IPressSub()
                .IEnterNumber("2");
        ThenInMainActivity
                .shouldFormulaEqualsTo("10−2")
                .shouldCalculationResultEqualsTo("8");
    }

    @Test
    public void BiggestOperandsShouldWorksCorrect() {
        double[] testValues = {(double) Integer.MAX_VALUE,
                99999999999999999999999999999999999999999999999999999999.0};

        for (double testValue : testValues) {
            double expectedResult = testValue * testValue;
            InMainActivity
                    .IEnterNumber(String.format("%.0f", testValue))
                    .IPressMul()
                    .IEnterNumber(String.format("%.0f", testValue));
            ThenInMainActivity
                    .shouldCalculationResultEqualsTo(String.format("%.0f", expectedResult));
        }
    }

    @Test
    public void PressEqualButtonWithoutOperandsShouldDisplayNothing() {
        InMainActivity
                .IPressEqual()
                .IPressEqual()
                .IPressEqual();
        ThenInMainActivity
                .shouldFormulaEqualsTo("");
    }

    /**
     * Cause no documentation for this function,
     * So I test it as IPhone Calculator :)
     */
    @Test
    public void CalculationResultShouldBeReused() {
        InMainActivity
                .IEnterNumber("10")
                .IPressMul()
                .IEnterNumber("5")
                .IPressEqual();

        ThenInMainActivity
                .shouldFormulaEqualsTo("50");

        InMainActivity
                .IPressAdd()
                .IEnterNumber("6")
                .IPressEqual();

        ThenInMainActivity
                .shouldFormulaEqualsTo("56");
    }

}
