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
                {new CalculatorOperation(""),"",""},
                {new CalculatorOperation("+"),"",""},
                {new CalculatorOperation("+2*3"),"6","2✕3"},
                {new CalculatorOperation("3+2"), "5", "3+2"},
                {new CalculatorOperation("0-3"), "-3", "0−3"},
                {new CalculatorOperation("10*3"), "30", "10✕3"},
                {new CalculatorOperation("30/3"), "10", "30÷3"},
                {new CalculatorOperation("5/2"), "2.5", "5÷2"},
                {new CalculatorOperation("2+"), "incorrect format", "2+"},
                {new CalculatorOperation("2/"), "incorrect format", "2÷"},
                {new CalculatorOperation("2-"), "incorrect format", "2−"},
                {new CalculatorOperation("2*"), "incorrect format", "2✕"},
                {new CalculatorOperation("2/-"), "incorrect format", "2−"},
                {new CalculatorOperation("2*+1"), "3", "2+1"},
                {new CalculatorOperation("3+2-1"), "4", "3+2−1"},
                {new CalculatorOperation("3+2*3"), "9", "3+2✕3"},
                {new CalculatorOperation("6/2-1"), "2", "6÷2−1"},
                {new CalculatorOperation("100/10*10"), "100", "100÷10✕10"},
                {new CalculatorOperation("5/5+5/5"), "2", "5÷5+5÷5"},
                {new CalculatorOperation("30/0"), "∞", "30÷0"},
                {new CalculatorOperation("0/100"), "0", "0÷100"},
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
