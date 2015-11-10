package com.dennisideler.calculator;

import android.support.test.rule.ActivityTestRule;
import android.test.suitebuilder.annotation.LargeTest;

import com.dennisideler.calculator.utils.CalculatorHelper;
import com.dennisideler.calculator.utils.CalculatorOperator;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.runners.Parameterized.Parameters;


import java.util.Arrays;
import java.util.Objects;

/**
 * Created by lenovo on 2015/11/10.
 */
@RunWith(Parameterized.class)
@LargeTest
public class CalculatorParameterizedTest {

    @Rule
    public ActivityTestRule<MainActivity> mActivityRule = new ActivityTestRule<>(
            MainActivity.class);

    @Parameters
    public static Iterable<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {new Object[]{"3", CalculatorHelper.ADD, "2"}, "5"},
                {new Object[]{"0", CalculatorHelper.SUB, "3"}, "-3"},
                {new Object[]{"10", CalculatorHelper.MUL, "3"}, "30"},
                {new Object[]{"30", CalculatorHelper.DIV, "3"}, "10"},
                {new Object[]{"2", CalculatorHelper.ADD}, "incorrect format"},
                {new Object[]{"2", CalculatorHelper.DIV}, "incorrect format"},
                {new Object[]{"2", CalculatorHelper.SUB}, "incorrect format"},
                {new Object[]{"2", CalculatorHelper.MUL}, "incorrect format"},
                {new Object[]{"2", CalculatorHelper.DIV, CalculatorHelper.SUB,}, "incorrect format"},
                {new Object[]{"2", CalculatorHelper.MUL, CalculatorHelper.ADD, "1"}, "3"},
                {new Object[]{"3", CalculatorHelper.ADD, "2", CalculatorHelper.SUB, "1"}, "4"},
                {new Object[]{"3", CalculatorHelper.ADD, "2", CalculatorHelper.MUL, "3"}, "9"},
                {new Object[]{"6", CalculatorHelper.DIV, "2", CalculatorHelper.SUB, "1"}, "2"},
                {new Object[]{"100", CalculatorHelper.DIV, "10", CalculatorHelper.MUL, "10"}, "100"},
                {new Object[]{"5", CalculatorHelper.DIV, "5", CalculatorHelper.ADD, "5", CalculatorHelper.DIV, "5" }, "2"},
                {new Object[]{"30", CalculatorHelper.DIV, "0"}, "∞"},
                {new Object[]{"0", CalculatorHelper.DIV, "100"}, "0"},
        });
    }

    private final Object[] mOperation;
    private final String mExpectedResult;

    public CalculatorParameterizedTest(Object[] operation, String expectedResult) {
        mOperation = operation;
        mExpectedResult = expectedResult;
    }

    @Test
    public void runOperationAndCheckResult() {
        for (Object op : mOperation) {
            if (op instanceof CalculatorOperator) {
                CalculatorHelper.getInstance()
                        .operator(((CalculatorOperator) op));
            } else {
                CalculatorHelper.getInstance()
                        .number(op.toString());
            }
        }
        CalculatorHelper.getInstance().shouldEqualsTo(mExpectedResult);
    }


}
