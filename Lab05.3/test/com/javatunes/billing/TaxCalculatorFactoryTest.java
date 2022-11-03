package com.javatunes.billing;

import org.junit.Test;

import static org.junit.Assert.*;

public class TaxCalculatorFactoryTest {

    @Test
    public void getTaxCalculator_shouldReturnSameInstance_sameLocation() {
        TaxCalculator calc1 = TaxCalculatorFactory.getTaxCalculator(Location.USA);
        TaxCalculator calc2 = TaxCalculatorFactory.getTaxCalculator(Location.USA);
        assertSame(calc1, calc2);
    }
}