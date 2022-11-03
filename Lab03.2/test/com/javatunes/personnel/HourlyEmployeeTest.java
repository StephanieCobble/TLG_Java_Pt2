package com.javatunes.personnel;

import org.junit.Before;
import org.junit.Test;

import java.sql.Date;

import static org.junit.Assert.*;

public class HourlyEmployeeTest {
    private HourlyEmployee emp;

    @Before
    public void setUp() {
        System.out.println("setUp");
        emp = new HourlyEmployee("Bonny", Date.valueOf("2021-12-23"), 15.0, 40.0);
    }

    @Test
    public void testPay() {
        System.out.println("testPay");
        assertEquals(15.0 * 40.0, emp.pay(), 0.001);
    }

    @Test
    public void testPayTaxes() {
        System.out.println("testPayTaxes");
        assertEquals(150.0, emp.payTaxes(), 0.001); //25% of (rate * hours)
    }

}