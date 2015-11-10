package com.dennisideler.calculator.utils;

/**
 * Created by lenovo on 2015/11/10.
 */
public class CalculatorOperation {

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
                CalculatorHelper.getInstance().enterNumber(String.valueOf(c));
            }else if(c == '/')
            {
                CalculatorHelper.getInstance().pressDiv();
            }else if(c == '*')
            {
                CalculatorHelper.getInstance().pressMul();
            }else if(c == '+')
            {
                CalculatorHelper.getInstance().pressAdd();
            }else if(c == '-')
            {
                CalculatorHelper.getInstance().pressSub();

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
