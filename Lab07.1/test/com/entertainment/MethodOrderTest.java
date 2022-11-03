/*
 * This code is sample code, provided as-is, and we make no
 * warranties as to its correctness or suitability for
 * any purpose.
 *
 * We hope that it's useful to you.  Enjoy.
 * Copyright LearningPatterns Inc.
 */
package com.entertainment;

import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.junit.runners.MethodSorters;

/**
 * TODO: use an annotation(s) in this class to apply some control over the order of test execution.
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
//@FixMethodOrder(MethodSorters.JVM)
public class MethodOrderTest {

    @Rule
    public TestName testName = new TestName();

    @Test
    public void shouldIOrderTheExceutionOfMyTests() {
//        System.out.println("shouldIOrderTheExceutionOfMyTests");
        System.out.println(testName.getMethodName());
    }

    @Test
    public void testSomething() {
//        System.out.println("testSomething");
        System.out.println(testName.getMethodName());
    }

    @Test
    public void businessMethodShouldWorkCorrectly() {
//        System.out.println("businessMethodShouldWorkCorrectly");
        System.out.println(testName.getMethodName());
    }

    @Test
    public void throwsExceptionIfUserDoesNotHaveSufficientPrivileges() {
//        System.out.println("throwsExceptionIfUserDoesNotHaveSufficientPrivileges");
        System.out.println(testName.getMethodName());
    }
}