package com.dennisideler.calculator;

import android.content.Intent;
import android.test.ActivityUnitTestCase;
import android.test.UiThreadTest;
import android.test.suitebuilder.annotation.MediumTest;


/**
 * Created by zxuan on 2015/11/9.
 */
public class MainActivityUnitTest extends ActivityUnitTestCase<MainActivity> {

    private Intent mLaunchIntent;

    public MainActivityUnitTest() {
        super(MainActivity.class);
    }

    @Override
    public void setUp() throws Exception
    {
        super.setUp();
        mLaunchIntent = new Intent(Intent.ACTION_MAIN);
    }

    @MediumTest
    @UiThreadTest
    public void testPreconditions()
    {
        startActivity(mLaunchIntent, null, null);
        assertNotNull("The main activity is null", getActivity());
    }


}
