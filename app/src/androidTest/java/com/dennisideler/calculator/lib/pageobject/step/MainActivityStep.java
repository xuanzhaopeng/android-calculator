package com.dennisideler.calculator.lib.pageobject.step;

import com.dennisideler.calculator.R;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
/**
 * Created by lenovo on 2015/11/10.
 */
public class MainActivityStep extends CommonStep<MainActivityStep> {

    private MainActivityStep()
    {

    }

    public static MainActivityStep getInstance()
    {
        if(instance == null)
        {
            instance = new MainActivityStep();
        }
        return instance;
    }

    public MainActivityStep IEnterNumber(String number)
    {
        typeNumber(number);
        return this;
    }

    public MainActivityStep IPressAdd()
    {
        onView(withId(R.id.buttonAdd)).perform(click());
        return this;
    }

    public MainActivityStep IPressDiv()
    {
        onView(withId(R.id.buttonDiv)).perform(click());
        return this;
    }

    public MainActivityStep IPressMul()
    {
        onView(withId(R.id.buttonMul)).perform(click());
        return this;
    }

    public MainActivityStep IPressSub()
    {
        onView(withId(R.id.buttonSub)).perform(click());
        return this;
    }

    public MainActivityStep IPressDelete()
    {
        onView(withId(R.id.buttonDel)).perform(click());
        return this;
    }

    public MainActivityStep IPressEqual()
    {
        onView(withId(R.id.buttonEql)).perform(click());
        return this;
    }

    public MainActivityStep IEntre(CalculatorFormula formula)
    {
        for(int i=0; i< formula.getFormula().length(); i++)
        {
            char c = formula.getFormula().charAt(i);
            if(Character.isDigit(c))
            {
                IEnterNumber(String.valueOf(c));
            }else if(c == '/')
            {
                IPressDiv();
            }else if(c == '*')
            {
                IPressMul();
            }else if(c == '+')
            {
                IPressAdd();
            }else if(c == '-')
            {
                IPressSub();

            }else if(c == ' ')
            {
                //do nothing
            }
            else
            {
                throw new RuntimeException("Invalid Test data");
            }
        }
        return this;
    }

    private void typeNumber(String number) {
        for (int i = 0; i < number.length(); i++) {
            onView(withText(String.valueOf(number.charAt(i)))).perform(click());
        }
    }


    private static MainActivityStep instance;

    @Override
    protected MainActivityStep getConcreteSteps() {
        return this;
    }
}
