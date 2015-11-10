package com.dennisideler.calculator.suite;

import com.dennisideler.calculator.MainActivityParameterizedTest;
import com.dennisideler.calculator.MainActivityInstrumentationTest;
import com.dennisideler.calculator.MainActivityUnitTest;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * Created by wzxuan on 2015/11/10.
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({MainActivityParameterizedTest.class, MainActivityInstrumentationTest.class, MainActivityUnitTest.class})
public class TestSuite {}