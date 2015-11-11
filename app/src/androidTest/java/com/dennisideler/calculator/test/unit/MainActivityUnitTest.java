package com.dennisideler.calculator.test.unit;

import android.content.Intent;
import android.test.ActivityUnitTestCase;
import android.test.UiThreadTest;
import android.test.suitebuilder.annotation.MediumTest;
import android.widget.Button;
import android.widget.TextView;

import com.dennisideler.calculator.MainActivity;
import com.dennisideler.calculator.R;
import com.dennisideler.calculator.lib.wrapper.ButtonWrapper;
import com.dennisideler.calculator.lib.wrapper.TextViewWrapper;


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
    public void testButtonLabelShows()
    {
        MainActivity activity = startActivity(mLaunchIntent, null,null);

        ButtonWrapper.Create((Button)activity.findViewById(R.id.button0))
                .shouldTextEqualsTo("0")
                .shouldBeClickAble();

        ButtonWrapper.Create((Button)activity.findViewById(R.id.button1))
                .shouldTextEqualsTo("1")
                .shouldBeClickAble();

        ButtonWrapper.Create((Button)activity.findViewById(R.id.button2))
                .shouldTextEqualsTo("2")
                .shouldBeClickAble();

        ButtonWrapper.Create((Button)activity.findViewById(R.id.button3))
                .shouldTextEqualsTo("3")
                .shouldBeClickAble();

        ButtonWrapper.Create((Button)activity.findViewById(R.id.button4))
                .shouldTextEqualsTo("4")
                .shouldBeClickAble();

        ButtonWrapper.Create((Button)activity.findViewById(R.id.button5))
                .shouldTextEqualsTo("5")
                .shouldBeClickAble();

        ButtonWrapper.Create((Button)activity.findViewById(R.id.button6))
                .shouldTextEqualsTo("6")
                .shouldBeClickAble();

        ButtonWrapper.Create((Button)activity.findViewById(R.id.button7))
                .shouldTextEqualsTo("7")
                .shouldBeClickAble();

        ButtonWrapper.Create((Button)activity.findViewById(R.id.button8))
                .shouldTextEqualsTo("8")
                .shouldBeClickAble();

        ButtonWrapper.Create((Button)activity.findViewById(R.id.button9))
                .shouldTextEqualsTo("9")
                .shouldBeClickAble();

        ButtonWrapper.Create((Button)activity.findViewById(R.id.buttonAdd))
                .shouldTextEqualsTo("+")
                .shouldBeClickAble();

        ButtonWrapper.Create((Button)activity.findViewById(R.id.buttonDiv))
                .shouldTextEqualsTo("÷")
                .shouldBeClickAble();

        ButtonWrapper.Create((Button)activity.findViewById(R.id.buttonSub))
                .shouldTextEqualsTo("−")
                .shouldBeClickAble();

        ButtonWrapper.Create((Button)activity.findViewById(R.id.buttonMul))
                .shouldTextEqualsTo("✕")
                .shouldBeClickAble();

        ButtonWrapper.Create((Button)activity.findViewById(R.id.buttonEql))
                .shouldTextEqualsTo("=")
                .shouldBeClickAble();
    }

    @MediumTest
    @UiThreadTest
    public void testLineLimitationOfTextView()
    {
        MainActivity activity = startActivity(mLaunchIntent, null,null);
        TextViewWrapper.Create((TextView)activity.findViewById(R.id.textViewAns))
            .shouldMaxLinesEqualTo(1);
    }

    @MediumTest
    @UiThreadTest
    public void testLifeCycle()
    {
        MainActivity activity = startActivity(mLaunchIntent,null, null);
        getInstrumentation().callActivityOnStart(activity);
        getInstrumentation().callActivityOnResume(activity);
        getInstrumentation().callActivityOnPause(activity);
        getInstrumentation().callActivityOnStop(activity);
    }
}
