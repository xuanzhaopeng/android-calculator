package com.dennisideler.calculator.utils;

import com.dennisideler.calculator.R;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
/**
 * Created by lenovo on 2015/11/10.
 */
public class CalculatorHelper {

    public static CalculatorOperator ADD = new CalculatorOperator().Add();
    public static CalculatorOperator SUB = new CalculatorOperator().Sub();
    public static CalculatorOperator DIV = new CalculatorOperator().Div();
    public static CalculatorOperator MUL = new CalculatorOperator().Mul();

    public static CalculatorHelper getInstance()
    {
        if(instance == null)
        {
            instance = new CalculatorHelper();
        }
        return instance;
    }

    public CalculatorHelper number(String number)
    {
        typeNumber(number);
        return this;
    }

    public CalculatorHelper operator(CalculatorOperator operator)
    {
        onView(withId(operator.getOperator())).perform(click());
        return this;
    }

    public CalculatorHelper add()
    {
        onView(withId(R.id.buttonAdd)).perform(click());
        return this;
    }

    public CalculatorHelper div()
    {
        onView(withId(R.id.buttonDiv)).perform(click());
        return this;
    }

    public CalculatorHelper mul()
    {
        onView(withId(R.id.buttonMul)).perform(click());
        return this;
    }

    public CalculatorHelper sub()
    {
        onView(withId(R.id.buttonSub)).perform(click());
        return this;
    }

    public CalculatorHelper Delete()
    {
        onView(withId(R.id.buttonDel)).perform(click());
        return this;
    }

    public CalculatorHelper shouldCalculatorTextEqualsTo(String expectedValue)
    {
        onView(withId(R.id.textViewAns)).check(matches(withText(expectedValue)));
        return this;
    }

    public void shouldCalculatorResultEqualsTo(String expectedValue)
    {
        onView(withId(R.id.buttonEql)).perform(click());
        onView(withId(R.id.textViewAns)).check(matches(withText(expectedValue)));
    }

    private CalculatorHelper()
    {

    }

    private void typeNumber(String number) {
        for (int i = 0; i < number.length(); i++) {
            onView(withText(String.valueOf(number.charAt(i)))).perform(click());
        }
    }



    private static CalculatorHelper instance;



}
