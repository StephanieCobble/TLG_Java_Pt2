package com.entertainment;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class TelevisionChannelComparatorTest {
    private TelevisionChannelComparator comparator;
    private Television tvA;
    private Television tvB;

    @Before
    public void setUp() {
        comparator = new TelevisionChannelComparator();
        tvA = new Television(); // default channel: 3 (for both)
        tvB = new Television();
    }

    @Test
    public void compare_shouldReturnZero_whenSameChannel() {
        assertEquals(0, comparator.compare(tvA, tvB));
    }

    @Test
    public void compare_shouldReturnNegativeNumber_when1stChannelLessThan2ndChannel() throws InvalidChannelException {
        tvA.changeChannel(1);
        assertTrue(comparator.compare(tvA, tvB) < 0);
    }

    @Test
    public void compare_shouldReturnPositiveNumber_when1stChannelGreaterThan2ndChannel() throws InvalidChannelException {
        tvA.changeChannel(999);
        assertTrue(comparator.compare(tvA, tvB) > 0);
    }

}