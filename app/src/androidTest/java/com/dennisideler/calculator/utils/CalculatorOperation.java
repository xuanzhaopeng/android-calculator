package com.dennisideler.calculator.utils;

import android.widget.Switch;

import com.dennisideler.calculator.MainActivity;
import com.dennisideler.calculator.R;

/**
 * Created by lenovo on 2015/11/10.
 */
public class CalculatorOperation {

    private Object[] mElements;
    private String mOperationString;

    public CalculatorOperation(String operationString)
    {
        mOperationString = operationString;
    }

    public CalculatorOperation execute()
    {
        for(int i=0; i< mOperationString.length(); i++)
        {
            char c = mOperationString.charAt(i);
            if(Character.isDigit(c))
            {
                CalculatorHelper.getInstance().number(String.valueOf(c));
            }else if(c == '/')
            {
                CalculatorHelper.getInstance().div();
            }else if(c == '*')
            {
                CalculatorHelper.getInstance().mul();
            }else if(c == '+')
            {
                CalculatorHelper.getInstance().add();
            }else if(c == '-')
            {
                CalculatorHelper.getInstance().sub();

            }else if(c == ' ')
            {
                //do nothing
            }
            else
            {
                throw new RuntimeException("Invalid Test data");
            }
        }
        return this;
    }

    public CalculatorOperation checkOperationString(String expectedOperationString)
    {
        CalculatorHelper.getInstance().shouldCalculatorTextEqualsTo(expectedOperationString);
        return this;
    }

    public void resultShouldEqualsTo(String expectedResult)
    {
        CalculatorHelper.getInstance().shouldCalculatorResultEqualsTo(expectedResult);
    }



}
