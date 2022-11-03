package com.stephanie.stats;

import org.junit.Before;
import org.junit.Test;
import org.stats.AnalyzerConfigurationException;
import org.stats.RatingAnalyzer;

import static org.junit.Assert.*;

public class RatingAnalyzerImplTest {

    @Test
    public void setRatingsTest_shouldThrowEx_whenNull() {
        assertThrows(AnalyzerConfigurationException.class, () -> RatingAnalyzer.newInstance(null));
    }

    @Test
    public void testMean_shouldReturnAvg_validGiven() {
        int[] ratings = {3, 5, 2, 54, 23, 64, 5, 3, 10, 13};
        RatingAnalyzer analyzer = RatingAnalyzer.newInstance(ratings);
        double meanResult = analyzer.mean();
        assertEquals(18.2, meanResult, .001);
    }

    // should have 2 tests for median - one for even one for odd
    @Test
    public void testMedian_shouldReturnMedVal_oddGiven() {
        int[] ratings = {3, 5, 2, 54, 23};
        RatingAnalyzer analyzer = RatingAnalyzer.newInstance(ratings);
        double result = analyzer.median();
        assertEquals(2.0, result, .001);
    }

    @Test
    public void testMedian_shouldReturnMedVal_evenGiven() {
        int[] ratings = {3, 5, 2, 2, 54, 23};
        RatingAnalyzer analyzer = RatingAnalyzer.newInstance(ratings);
        double result = analyzer.median();
        assertEquals(2.0, result, .001);
    }

    @Test
    public void testMode_shouldReturnMostFreqSingle_validGiven() {
        int[] ratings = {3, 5, 2, 54, 23, 3, 5, 3, 10, 13};
        RatingAnalyzer analyzer = RatingAnalyzer.newInstance(ratings);
        int[] result = analyzer.mode();
        int[] expected = {3};
        assertArrayEquals(expected, result);
    }

    @Test
    public void testMode_shouldReturnMostFreqMultiple_validGiven() {
        int[] ratings = {-9, -9, -9, 4, 4, 4, 8, 8, 8, 5, 7};
        RatingAnalyzer analyzer = RatingAnalyzer.newInstance(ratings);
        int[] result = analyzer.mode();
        int[] expected = {-9, 4, 8};
        assertArrayEquals(expected, result);
    }

    @Test
    public void testMode_shouldReturnAll_uniqueGiven() {
        int[] ratings = {1, 2, 3, 4, 5};
        RatingAnalyzer analyzer = RatingAnalyzer.newInstance(ratings);
        int[] result = analyzer.mode();
        int[] expected = {1, 2, 3, 4, 5};
        assertArrayEquals(expected, result);
    }
}