package com.dennisideler.calculator.test.unit;

import android.support.test.rule.ActivityTestRule;
import android.test.suitebuilder.annotation.LargeTest;

import com.dennisideler.calculator.lib.CommonTestCase;
import com.dennisideler.calculator.MainActivity;
import com.dennisideler.calculator.lib.pageobject.step.CalculatorFormula;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.runners.Parameterized.Parameters;


import java.util.Arrays;

/**
 * Created by lenovo on 2015/11/10.
 */
@RunWith(Parameterized.class)
@LargeTest
public class MainActivityParameterizedTest extends CommonTestCase {

    @Rule
    public ActivityTestRule<MainActivity> mActivityRule = new ActivityTestRule<>(
            MainActivity.class);

    @Parameters
    public static Iterable<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {new CalculatorFormula(""),"",""},
                {new CalculatorFormula("+"),"",""},
                {new CalculatorFormula("+2*3"),"6","2✕3"},
                {new CalculatorFormula("3+2"), "5", "3+2"},
                {new CalculatorFormula("0-3"), "-3", "0−3"},
                {new CalculatorFormula("10*3"), "30", "10✕3"},
                {new CalculatorFormula("30/3"), "10", "30÷3"},
                {new CalculatorFormula("5/2"), "2.5", "5÷2"},
                {new CalculatorFormula("2+"), "incorrect format", "2+"},
                {new CalculatorFormula("2/"), "incorrect format", "2÷"},
                {new CalculatorFormula("2-"), "incorrect format", "2−"},
                {new CalculatorFormula("2*"), "incorrect format", "2✕"},
                {new CalculatorFormula("2/-"), "incorrect format", "2−"},
                {new CalculatorFormula("2*+1"), "3", "2+1"},
                {new CalculatorFormula("3+2-1"), "4", "3+2−1"},
                {new CalculatorFormula("3+2*3"), "9", "3+2✕3"},
                {new CalculatorFormula("6/2-1"), "2", "6÷2−1"},
                {new CalculatorFormula("100/10*10"), "100", "100÷10✕10"},
                {new CalculatorFormula("5/5+5/5"), "2", "5÷5+5÷5"},
                {new CalculatorFormula("30/0"), "∞", "30÷0"},
                {new CalculatorFormula("0/100"), "0", "0÷100"},
        });
    }

    private final CalculatorFormula mFormula;
    private final String mExpectedResult;
    private final String mExpectedFormulaString;

    public MainActivityParameterizedTest(CalculatorFormula formula, String expectedResult, String expectedFormulaString) {
        mFormula = formula;
        mExpectedResult = expectedResult;
        mExpectedFormulaString = expectedFormulaString;
    }

    @Test
    public void runOperationAndCheckResult() {
        InMainActivity
                .IEntre(mFormula);
        ThenInMainActivity
                .shouldFormulaEqualsTo(mExpectedFormulaString)
                .shouldCalculationResultEqualsTo(mExpectedResult);
    }


}
