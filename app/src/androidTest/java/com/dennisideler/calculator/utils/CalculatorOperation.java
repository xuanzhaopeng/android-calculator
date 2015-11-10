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

    public CalculatorOperation(Object... params) {
        mElements = params;
    }

    public CalculatorOperation execute() {
        StringBuilder expectedOperationString = new StringBuilder();
        for (Object op : mElements) {
            if (op instanceof CalculatorOperator) {
                CalculatorHelper.getInstance()
                        .operator(((CalculatorOperator) op));
                switch (((CalculatorOperator) op).getOperator()) {
                    case R.id.buttonAdd:
                        expectedOperationString.append(MainActivity.ADD);
                        break;
                    case R.id.buttonDiv:
                        expectedOperationString.append(MainActivity.DIV);
                        break;
                    case R.id.buttonMul:
                        expectedOperationString.append(MainActivity.MUL);
                        break;
                    case R.id.buttonSub:
                        expectedOperationString.append(MainActivity.SUB);
                        break;
                    default:
                        break;
                }
            } else {
                CalculatorHelper.getInstance()
                        .number(op.toString());
                expectedOperationString.append(op.toString());
            }
        }
        mOperationString = expectedOperationString.toString();
        return this;
    }

    public CalculatorOperation checkOperationString(String operationString)
    {
        if(operationString != null && !operationString.isEmpty())
        {
            mOperationString = operationString;
        }
        CalculatorHelper.getInstance().shouldCalculatorTextEqualsTo(mOperationString);
        return this;
    }

    public void resultShouldEqualsTo(String expectedResult)
    {
        CalculatorHelper.getInstance().shouldCalculatorResultEqualsTo(expectedResult);
    }



}
