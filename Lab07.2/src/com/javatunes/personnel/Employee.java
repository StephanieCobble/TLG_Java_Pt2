/*
 * This code is sample code, provided as-is, and we make no
 * warranties as to its correctness or suitability for
 * any purpose.
 *
 * We hope that it's useful to you.  Enjoy.
 * Copyright LearningPatterns Inc.
 */
package com.javatunes.personnel;

import com.fastjava.annotation.Fast;

/**
 * all methods in this class should run 25% faster.
 */
@Fast(performanceBoostValue = 0.25)
public class Employee {

    /**
     * this method needs to run 50% faster.
     * OSHA regulations require extra logging about the performance improvement,
     * as well as a description of why we're using this technology from FastJava.com.
     */
    @Fast(performanceBoostValue = 0.50, logInformation = true, description = "Needs to run 50% faster & log performance.")
    public void work() {
        System.out.println("Employee working hard");
    }

    public void pay() {
        System.out.println("Employee paid well");
    }
}