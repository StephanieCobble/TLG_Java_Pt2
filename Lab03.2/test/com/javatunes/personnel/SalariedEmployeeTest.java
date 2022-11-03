package com.javatunes.personnel;

import org.junit.Before;
import org.junit.Test;

import java.sql.Date;

import static org.junit.Assert.*;

public class SalariedEmployeeTest {

    // business object(s) under test - called "fixtures"
    private SalariedEmployee emp1; // name, hireDate (Date.valueOf(2007-12-12)), salary (double)
    private SalariedEmployee emp2; // name, hireDate (Date.valueOf(2007-12-12)), salary (double)

    @Before
    public void setUp() {
        System.out.println("setUp");
        emp1 = new SalariedEmployee("Jimmy", Date.valueOf("2013-12-23"), 4500.0);
        emp2 = new SalariedEmployee("Jimmy", Date.valueOf("2013-12-23"), 4500.0);
    }

    @Test
    public void hashCode_shouldReturnSameValue_equalObjects() {
        assertEquals(emp1.hashCode(), emp2.hashCode());
    }

    @Test
    public void equals_shouldReturnFalse_differentName_sameHireDate_sameSalary() {
        emp2.setName("Kimmy");
        assertNotEquals(emp1, emp2);
    }

    @Test
    public void equals_shouldReturnFalse_sameName_differentHireDate_sameSalary() {
        emp2.setHireDate(Date.valueOf("2021-08-30"));
        assertNotEquals(emp1, emp2);
    }

    @Test
    public void equals_shouldReturnFalse_sameName_sameHireDate_differentSalary() {
        emp2.setSalary(500.0);
        assertNotEquals(emp1, emp2);
    }

    @Test
    public void equals_shouldReturnTrue_allPropertiesSame() {
        assertEquals(emp1, emp2); // calls equals() when object passed in
    }

    @Test
    public void name() {
    }

    @Test // cmd n -> (generate) test method
    public void testPay() {
        System.out.println("testPay");
        assertEquals(4500.0, emp1.pay(), 0.001);
    }

    @Test
    public void testPayTaxes() {
        System.out.println("testPayTaxes");
        assertEquals(1350.0, emp1.payTaxes(), 0.001); // 30% of the salary
    }

}