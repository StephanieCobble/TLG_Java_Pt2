package com.entertainment;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class TelevisionBrandChannelComparatorTest {
    private TelevisionBrandChannelComparator comparator;
    private Television tvA;
    private Television tvB;


    @Before
    public void setUp() {
        comparator = new TelevisionBrandChannelComparator();
        tvA = new Television("Samsung", 32, DisplayType.LED); // default channel: 3 (for both)
        tvB = new Television("Samsung", 32, DisplayType.LED); // default channel: 3
    }

    @Test
    public void compare_shouldReturnZero_whenSame() {
        assertTrue(comparator.compare(tvA, tvB) == 0);
    }

    @Test
    public void compare_shouldBePos_whenChannelAGreaterThanChannelB() throws InvalidChannelException {
        tvA.changeChannel(5); // tvA channel: 5 > tvB channel: 3, Samsung = Samsung, 5 > 3
        assertTrue(comparator.compare(tvA, tvB) > 0);
//        System.out.println(comparator.compare(tvA, tvB));
    }

    @Test
    public void compare_shouldBeNeg_whenBrandALessThanBrandB() {
        tvA.setBrand("RCA");
        assertTrue(comparator.compare(tvA, tvB) < 0); // RCA < Samsung
        System.out.println(comparator.compare(tvA, tvB));
    }
}