package com.stephanie.stats;

import org.stats.RatingAnalyzer;

class RatingAnalyzerClient {
    public static void main(String[] args) {

        int[] ratings = {3, 5, 2, 54, 23, 3, 5, 3, 10, 13};
        RatingAnalyzer analyzer = RatingAnalyzer.newInstance(ratings);
        int[] result = analyzer.mode();


        int[] ratings3 = {3, 3, 3, 2, 2, 2, 8, 5, 9};
        RatingAnalyzer analyzer3 = RatingAnalyzer.newInstance(ratings3);
        int[] result3 = analyzer3.mode();
//        System.out.println(result);



        int[] ratings2 = {3, 5, 2, 54, 23};
        RatingAnalyzer analyzer2 = RatingAnalyzer.newInstance(ratings2);
        double result2 = analyzer2.median();
        System.out.println(result2);


    }
}