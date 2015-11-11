package com.dennisideler.calculator.lib.pageobject.step;

/**
 * Created by zxuan on 2015/11/10.
 */
public class CalculatorFormula {

    private String mFormulaString;

    public CalculatorFormula(String formulaString)
    {
        mFormulaString = formulaString;
    }

    public String getFormula()
    {
        return mFormulaString;
    }

}
