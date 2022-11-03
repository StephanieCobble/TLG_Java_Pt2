package com.stephanie.stats;

import org.stats.RatingAnalyzer;

import java.util.*;
import java.util.function.Function;
import static java.util.function.Function.*;
import java.util.stream.Collectors;
import static java.util.stream.Collectors.*;
import java.util.Map.Entry;


public class RatingAnalyzerImpl implements RatingAnalyzer {
    // field
    private int[] ratings = {};

    // ctor
    public RatingAnalyzerImpl(int[] ratings) throws IllegalArgumentException{
        setRatings(ratings);
    }

    // methods
    @Override
    public double mean() {
        return (double) Arrays.stream(ratings).sum() / ratings.length;
    }

    @Override
    public double median() {
        // need to sort
        if(ratings.length % 2 == 0) {
            int mid = ratings.length / 2;
            return (double) (ratings[mid] + ratings[mid - 1]) / 2;
        }
        return ratings[ratings.length / 2];
    }

    @Override
    public int[] mode() {
        Map<Integer, Integer> hMap = new HashMap<>();

        for (int rating : ratings) {
            Integer keysVal = hMap.get(rating);
            if (keysVal == null) {
                hMap.put(rating, 0);
            } else {
                hMap.put(rating, keysVal + 1);
            }
        }

        List<Integer> newArr = new ArrayList<>();

        int maxValInMap = Collections.max(hMap.values());
        int maxVal;
        int maxNum;

        for (Entry<Integer, Integer> pair : hMap.entrySet()) {
            maxVal = pair.getValue();
            maxNum = pair.getKey();
            if (maxVal == maxValInMap) {
                newArr.add(maxNum);
            }
        }

        return newArr.stream()
                .mapToInt(Integer::intValue)
                .sorted()
                .toArray();
    }

    // accessor
    public void setRatings(int[] ratings) {
        if (ratings.length > 0) {
            this.ratings = ratings;
        } else {
            throw new IllegalArgumentException("Array cannot be empty. Please enter number greater than 0");
        }
    }

}