package com.dennisideler.calculator.utils;

import com.dennisideler.calculator.R;

/**
 * Created by zxuan on 2015/11/10.
 */
public class CalculatorOperator
{
    public CalculatorOperator Add()
    {
        mOperator = R.id.buttonAdd;
        return this;
    }

    public CalculatorOperator Div()
    {
        mOperator = R.id.buttonDiv;
        return this;
    }

    public CalculatorOperator Sub()
    {
        mOperator = R.id.buttonSub;
        return this;
    }

    public CalculatorOperator Mul()
    {
        mOperator = R.id.buttonMul;
        return this;
    }

    public int getOperator()
    {
        return mOperator;
    }

    private int mOperator;



}