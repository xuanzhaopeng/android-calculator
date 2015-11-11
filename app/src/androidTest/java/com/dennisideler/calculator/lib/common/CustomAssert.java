package com.dennisideler.calculator.lib.common;

/**
 * Created by lenovo on 2015/11/10.
 */
public class CustomAssert {

    public static void AssertEquals(Object expected, Object actual, String errorMessage)
    {
        if((expected == null && actual != null) || (expected != null && ! expected.equals(actual)))
        {
            throw new RuntimeException(errorMessage);
        }
    }
}
