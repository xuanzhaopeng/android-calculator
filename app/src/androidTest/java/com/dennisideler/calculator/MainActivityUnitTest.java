package com.dennisideler.calculator;

import android.app.Instrumentation;
import android.content.Intent;
import android.support.test.annotation.UiThreadTest;
import android.support.test.runner.AndroidJUnit4;
import android.test.ActivityUnitTestCase;
import android.test.suitebuilder.annotation.*;

import org.junit.runner.RunWith;;

/**
 * Created by zxuan on 2015/11/9.
 */
@RunWith(AndroidJUnit4.class)
public class MainActivityUnitTest extends ActivityUnitTestCase<MainActivity> {

    private Intent mLaunchIntent;


    public MainActivityUnitTest() {
        super(MainActivity.class);
    }

    @Override
    public void setUp() throws Exception
    {
        super.setUp();
        mLaunchIntent = new Intent(getInstrumentation().getTargetContext(), MainActivity.class);
    }

    @MediumTest
    public void testPreconditions()
    {
        startActivity(mLaunchIntent, null, null);
        assertNotNull("The Main Activity is null", getActivity());
    }

    @MediumTest
    public void testActivityOnResume()
    {
        Instrumentation instrumentation = getInstrumentation();
        MainActivity activity = getActivity();
        instrumentation.callActivityOnStart(activity);
        instrumentation.callActivityOnResume(activity);
        instrumentation.callActivityOnPause(activity);
        instrumentation.callActivityOnStop(activity);
        assertTrue(isFinishCalled());
    }
}
