package com.dennisideler.calculator;

import android.content.Intent;
import android.test.ActivityUnitTestCase;
import android.test.UiThreadTest;
import android.test.suitebuilder.annotation.MediumTest;
import android.widget.Button;

import com.dennisideler.calculator.wrapper.ButtonWrapper;


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

    @MediumTest
    @UiThreadTest
    public void testButton()
    {
        MainActivity activity = startActivity(mLaunchIntent, null,null);

        ButtonWrapper.Create((Button)activity.findViewById(R.id.button0))
                .shouldTextEqualsTo("0")
                .shouldBeClickAble();

        ButtonWrapper.Create((Button)activity.findViewById(R.id.button1))
                .shouldTextEqualsTo("1")
        .shouldBeClickAble();

    }
}
