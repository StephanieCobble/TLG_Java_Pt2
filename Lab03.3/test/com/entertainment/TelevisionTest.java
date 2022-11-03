package com.entertainment;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

//public static final int MIN_VOLUME = 0; test -1
//public static final int MAX_VOLUME = 100; test 101
//public static final int MIN_CHANNEL = 1; (inclusive) test 0
//public static final int MAX_CHANNEL = 999; (inclusive) test 1000

public class TelevisionTest {
    private Television tvA;
    private Television tvB;

    @Before
    public void setUp() {
        tvA = new Television("Samsung", 32, DisplayType.LED); // (String brand, int volume, DisplayType display)
        tvB = new Television("Samsung", 32, DisplayType.LED); // (String brand, int volume, DisplayType display)
    }

//    VOLUME TESTING

    @Test(expected = IllegalArgumentException.class)
    public void setVolume_shouldThrowIllegalArgException_whenInvalidValue_lowerBound() {
        tvA.setVolume(-1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void setVolume_shouldThrowIllegalArgException_whenInvalidValue_upperBound() {
        tvA.setVolume(101);
    }

    @Test
    public void setVolume_shouldStoreValue_whenValid_lowerBound() {
        tvA.setVolume(0);
        assertEquals(0, tvA.getVolume());
    }

    @Test
    public void setVolume_shouldStoreValue_whenValid_upperBound() {
        tvA.setVolume(100);
        assertEquals(100, tvA.getVolume());
    }

//    CHANNEL TESTING

    @Test
    public void changeChannel_shouldStoreValue_whenValidValue_lowerBound() throws InvalidChannelException { // checked
        tvA.changeChannel(1);
        assertEquals(1, tvA.getCurrentChannel());
    }

    @Test
    public void changeChannel_shouldStoreValue_whenValidValue_upperBound() throws InvalidChannelException { // checked
        tvA.changeChannel(999);
        assertEquals(999, tvA.getCurrentChannel());
    }

    @Test
    public void changeChannel_shouldThrowInvalidChannelException_invalidValue_lowerBound() {
        try {
            tvA.changeChannel(0);
            fail("Should have thrown InvalidChannelException");
        }
        catch (InvalidChannelException e) {
            assertEquals("Invalid channel: 0. Allowed range: [1,999].", e.getMessage());
        }
    }

    @Test
    public void changeChannel_shouldThrowInvalidChannelException_invalidValue_upperBound() {
        try {
            tvA.changeChannel(1000);
            fail("Should have thrown InvalidChannelException");
        }
        catch (InvalidChannelException e) {
            assertEquals("Invalid channel: 1000. Allowed range: [1,999].", e.getMessage());
        }
    }

//    COMPARE TO TESTING

    @Test
    public void compareTo_shouldReturnNegativeNumber_when1stBrandLessThan2ndBrand() {
        tvA.setBrand("a less than");
        tvB.setBrand("b greater than");
        assertTrue(tvA.compareTo(tvB) < 0);
    }

    @Test
    public void compareTo_shouldReturnZero_whenSameBrand() {
        assertTrue(tvA.compareTo(tvB) == 0);
    }

    //    HASHCODE TESTING

    @Test
    public void hashCode_shouldReturnSameValue_equalObjects() {
        assertEquals(tvA.hashCode(), tvB.hashCode());
    }

//    EQUALS TESTING

    @Test
    public void equals_shouldReturnSameValue_equalObjects() {
        assertEquals(tvA, tvB);
    }

    @Test
    public void equals_shouldReturnFalse_sameBrand_sameVol_differentDisplay() {
        tvA.setDisplay(DisplayType.PLASMA);
        assertNotEquals(tvA, tvB);
    }

    @Test
    public void equals_shouldReturnFalse_sameBrand_diffVol_sameDisplay() {
        tvA.setVolume(34);
        assertNotEquals(tvA, tvB);
    }

    @Test
    public void equals_shouldReturnFalse_diffBrand_sameVol_sameDisplay() {
        tvA.setBrand("Other");
        assertNotEquals(tvA, tvB);
    }

}