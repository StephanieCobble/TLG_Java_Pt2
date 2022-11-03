package com.stephanie.stats;

import org.junit.Before;
import org.junit.Test;
import org.stats.RatingAnalyzer;

import static org.junit.Assert.*;

public class RatingAnalyzerImplTest {
//
//    @Before
//    public void setUp() {
//        int[] ratings = {3, 5, 2, 54, 23, 64, 5, 3, 3, 3, 10, 13};
//        RatingAnalyzer analyzer = RatingAnalyzer.newInstance(ratings);
//    }



    @Test
    public void testMean_shouldReturnAvg_validGiven() {
        int[] ratings = {3, 5, 2, 54, 23, 64, 5, 3, 10, 13};
        RatingAnalyzer analyzer = RatingAnalyzer.newInstance(ratings);
        double meanResult = analyzer.mean();
        assertEquals(18.2, meanResult, .001);
    }

    @Test
    public void testMedian_shouldReturnMedVal_ValidGiven() {
        int[] ratings = {3, 5, 2, 54, 23};
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
        assertArrayEquals(new int[]{3}, result);
//        assertArrayEquals(expected, result);
    }

    @Test
    public void testMode_shouldReturnMostFreqMultiple_validGiven() {
        int[] ratings = {-9, -9, -9, 4, 4, 4, 8, 8, 8, 5, 7};
        RatingAnalyzer analyzer = RatingAnalyzer.newInstance(ratings);
        int[] result = analyzer.mode();
//        int[] expected = {2, 3};
        int[] expected = {-9, 4, 8};
        assertArrayEquals(expected, result);
    }

}