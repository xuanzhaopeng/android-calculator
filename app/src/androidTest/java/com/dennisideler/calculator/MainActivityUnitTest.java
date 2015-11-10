package com.dennisideler.calculator;

import org.junit.Test;
import org.junit.internal.builders.AllDefaultPossibilitiesBuilder;

import android.support.test.runner.AndroidJUnitRunner;
import android.content.Intent;
import android.test.ActivityUnitTestCase;
import android.test.suitebuilder.annotation.LargeTest;
import android.test.suitebuilder.annotation.MediumTest;

import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;


/**
 * Created by zxuan on 2015/11/9.
 */
@LargeTest
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
        assertThat(getActivity(), notNullValue());
    }


}
