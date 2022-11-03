/*
 * This code is sample code, provided as-is, and we make no
 * warranties as to its correctness or suitability for
 * any purpose.
 *
 * We hope that it's useful to you.  Enjoy.
 * Copyright LearningPatterns Inc.
 */
package com.javatunes.personnel;

import java.sql.Date;
import java.util.Map;

public class EmployeeFactory {

    // ctor - prevent direct instantiation - this is an all-static factory class
    private EmployeeFactory() {
    }

    /**
     * given the input map, create and return the correct object (with its properties set).
     * If the input map's "type" value is not "HE" (hourly emp) or "SE" (salaried emp,
     * throw IllegalArgumentException with a suitable message.
     */
    public static Employee createEmployee(Map<String, String> inputMap) throws IllegalArgumentException {
        // return value
        Employee emp = null;

        // read the type indicator out of the map so we know what to do
        String type = inputMap.get("type");

        // if it's not SE, and it's not HE, bail immediately
        if (!validType(type)) { // did a refactor -> extract. Make sure your logic still works
            throw new IllegalArgumentException(String.format("Invalid Type: %s. Must be SE or HE\n", type));
        }

        // common properties bc SE and HE both need them
        String name = inputMap.get("name");
        Date hireDate = Date.valueOf(inputMap.get("hireDate"));

        if ("SE".equals(type)) {
            Double salary = Double.valueOf(inputMap.get("salary"));
            emp = new SalariedEmployee(name, hireDate, salary);
        }
        else if ("HE".equals(type)) {
            // Double getRate, getHours
            Double rate = Double.valueOf(inputMap.get("rate"));
            Double hours = Double.valueOf(inputMap.get("hours"));
            emp = new HourlyEmployee(name, hireDate, rate, hours);
        }
        return emp;
    }

    private static boolean validType(String type) {
        return "SE".equals(type) || "HE".equals(type);
    }
}