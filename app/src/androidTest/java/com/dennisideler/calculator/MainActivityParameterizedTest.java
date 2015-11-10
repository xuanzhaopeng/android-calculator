package com.dennisideler.calculator;

import android.support.test.rule.ActivityTestRule;
import android.test.suitebuilder.annotation.LargeTest;

import com.dennisideler.calculator.utils.CalculatorHelper;
import com.dennisideler.calculator.utils.CalculatorOperation;

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
public class MainActivityParameterizedTest {

    @Rule
    public ActivityTestRule<MainActivity> mActivityRule = new ActivityTestRule<>(
            MainActivity.class);

    @Parameters
    public static Iterable<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {new CalculatorOperation(),"",""},
                {new CalculatorOperation(CalculatorHelper.ADD),"",""},
                {new CalculatorOperation(CalculatorHelper.ADD, "2", CalculatorHelper.MUL, "3"),"6","2✕3"},
                {new CalculatorOperation("3", CalculatorHelper.ADD, "2"), "5", ""},
                {new CalculatorOperation("0", CalculatorHelper.SUB, "3"), "-3", ""},
                {new CalculatorOperation("10", CalculatorHelper.MUL, "3"), "30", ""},
                {new CalculatorOperation("30", CalculatorHelper.DIV, "3"), "10", ""},
                {new CalculatorOperation("5", CalculatorHelper.DIV, "2"), "2.5", ""},
                {new CalculatorOperation("2", CalculatorHelper.ADD), "incorrect format", ""},
                {new CalculatorOperation("2", CalculatorHelper.DIV), "incorrect format", ""},
                {new CalculatorOperation("2", CalculatorHelper.SUB), "incorrect format", ""},
                {new CalculatorOperation("2", CalculatorHelper.MUL), "incorrect format", ""},
                {new CalculatorOperation("2", CalculatorHelper.DIV, CalculatorHelper.SUB), "incorrect format", "2−"},
                {new CalculatorOperation("2", CalculatorHelper.MUL, CalculatorHelper.ADD, "1"), "3", "2+1"},
                {new CalculatorOperation("3", CalculatorHelper.ADD, "2", CalculatorHelper.SUB, "1"), "4", ""},
                {new CalculatorOperation("3", CalculatorHelper.ADD, "2", CalculatorHelper.MUL, "3"), "9", ""},
                {new CalculatorOperation("6", CalculatorHelper.DIV, "2", CalculatorHelper.SUB, "1"), "2", ""},
                {new CalculatorOperation("100", CalculatorHelper.DIV, "10", CalculatorHelper.MUL, "10"), "100", ""},
                {new CalculatorOperation("5", CalculatorHelper.DIV, "5", CalculatorHelper.ADD, "5", CalculatorHelper.DIV, "5"), "2", ""},
                {new CalculatorOperation("30", CalculatorHelper.DIV, "0"), "∞", ""},
                {new CalculatorOperation("0", CalculatorHelper.DIV, "100"), "0", ""},
        });
    }

    private final CalculatorOperation mOperation;
    private final String mExpectedResult;
    private final String mOperationString;

    public MainActivityParameterizedTest(CalculatorOperation operation, String expectedResult, String operationString) {
        mOperation = operation;
        mExpectedResult = expectedResult;
        mOperationString = operationString;
    }

    @Test
    public void runOperationAndCheckResult() {
        mOperation.execute()
                .checkOperationString(mOperationString)
                .resultShouldEqualsTo(mExpectedResult);
    }


}
