package com.dennisideler.calculator.lib;

import com.dennisideler.calculator.lib.pageobject.step.MainActivityStep;
import com.dennisideler.calculator.lib.pageobject.check.MainActivityCheck;


/**
 * Created by zxuan on 2015/11/11.
 */
public class CommonTestCase {

    public MainActivityStep InMainActivity = MainActivityStep.getInstance();
    public MainActivityCheck ThenInMainActivity = MainActivityCheck.getInstance();


}
