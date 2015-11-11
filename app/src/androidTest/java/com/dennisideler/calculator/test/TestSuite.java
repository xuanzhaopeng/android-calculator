package com.dennisideler.calculator.test;

import com.dennisideler.calculator.test.unit.MainActivityParameterizedTest;
import com.dennisideler.calculator.test.instrumentation.MainActivityInstrumentationTest;
import com.dennisideler.calculator.test.unit.MainActivityUnitTest;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * Created by wzxuan on 2015/11/10.
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({MainActivityParameterizedTest.class, MainActivityInstrumentationTest.class, MainActivityUnitTest.class})
public class TestSuite {}