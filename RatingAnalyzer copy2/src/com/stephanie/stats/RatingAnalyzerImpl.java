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
        return (double) Arrays.stream(ratings).sum()/ratings.length;
    }

    @Override
    public double median() {
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
//------------------------------------------------------------------------------------------------------------

//        HashMap<Integer,Integer> hm = new HashMap<Integer,Integer>();
//        int max  = 1;
//        int[] temp = {};
//
//        for(int i = 0; i < ratings.length; i++) {
//
//            if (hm.get(ratings[i]) != null) {
//
//                int count = hm.get(ratings[i]);
//                count++;
//                hm.put(ratings[i], count);
//
//                if(count > max) {
//                    max  = count;
//                    temp = ratings[i];
////                    temp = new int[]{ratings};
//                }
//            }
//
//            else
//                hm.put(ratings[i],1);
//        }
//        return temp;

//--------------------------------------------------------------------------------------------

//        List<Integer> newArr = new ArrayList<>();
//        int maxCount = 0;
//        for (int i = 0; i < ratings.length; i++) {
//            int counter = 0;
//            for (int j = 0; j < ratings.length; j++) {
//                if (ratings[j] == ratings[i]) {
//                    counter++;
//                }
//            }
//            if (counter > maxCount) {
//                maxCount = counter;
//                newArr.clear();
//                newArr.add(ratings[i]);
//            } else if ( counter == maxCount) {
//                newArr.add( ratings[i]);
//            }
//        }
//        // Integer[] intArray = newArr.toArray(new Integer[0]);
//        return newArr.stream().mapToInt(Integer::intValue).toArray();
////        int[] finalArr = Arrays.stream(ratings).toArray();
////        int[] finalArr = newArr.stream().mapToInt(Integer::intValue).toArray();
////        System.out.println(finalArr);
////        return finalArr;

//----------------------------------------------------------------------------------------------

//        List<Integer> modes = new ArrayList<>(  );
//        int maxCount=0;
//        for (int i = 0; i < ratings.length; ++i){
//            int count = 0;
//            for (int j = 0; j < ratings.length; ++j){
//                if (ratings[j] == ratings[i]) ++count;
//            }
//            if (count > maxCount){
//                maxCount = count;
//                modes.clear();
//                modes.add( ratings[i] );
//            } else if ( count == maxCount ){
//                modes.add( ratings[i] );
//            }
//        }
////        return modes.toArray(new Integer[modes.size()]);
////        int[] boop = modes.stream().mapToInt(i -> i).toArray();
////        return boop;
////        return modes.toArray(new Integer[modes.size()]);
//        return ratings;


//--------------------------------------------------------------------------------------------

//        List<Integer> newArr = new ArrayList<>();
//        int maxCount = 0;
//        for (int i = 0; i < ratings.length; i++) {
//            int counter = 0;
//            for (int j = 0; j < ratings.length; j++) {
//                if (ratings[j] == ratings[i]) {
//                    counter++;
//                }
//            }
//            if (counter > maxCount) {
//                maxCount = counter;
//                newArr.clear();
//                newArr.add(ratings[i]);
//            } else if ( counter == maxCount) {
//                newArr.add( ratings[i]);
//            }
//        }
//        Integer[] intArray = newArr.toArray(new Integer[newArr.size()]);
//        int[] thingy = Arrays.stream(intArray).mapToInt(Integer::intValue).toArray();
//        return thingy;
//
////        int[] intArray = Arrays.stream(ratings).mapToInt(Integer::intValue).toArray();
////        Integer[] stuff = newArr.toArray(new Integer[newArr.size()]);
////        return stuff.intValue();
////        return newArr.toArray(new Integer[newArr.size()]);

//-------------------------------------------------------------------------------------------------------

//        List<Integer> newArr = new ArrayList<>();
////        int[] newArr = {};
////        int num = 0;
//        int freq = 0;
//
//        for (int rating : ratings) {
//            int counter = 0;
//            for (int i : ratings) {
//                if (rating == i) {
//                    counter++;
//                }
//                if (counter > freq) {
//                    newArr.clear();
//                    newArr.add(rating);
////                    newArr = new int[]{rating};
////                    freq = counter;
//                }
////                if (counter == freq) {
////                    newArr = new int[rating+1];
////                    freq = counter;
////                }
//            }
//        }
////        System.out.println(Arrays.toString(newArr));
////        return newArr.stream().toArray();
//        return newArr.stream().mapToInt(Integer::intValue).sorted().toArray();
//
//        //        return modeVals.stream().mapToInt(Integer::intValue)
////                .sorted().toArray();

//---------------------------------------------------------------------------------------------

//        List<Long> modeResult = new ArrayList<>();
//
//        Map<Integer, Long> modeMap = Arrays.stream(ratings)
//                .boxed() // Returns a Stream consisting of the elements of this stream, each boxed to an Integer.
//                .collect(groupingBy(identity(), counting()));
//
//        int maxValueInMap = (Collections.max(modeMap.values())).intValue();
//
//        for (Map.Entry<Integer, Long> entry : modeMap.entrySet()) {
//            if (maxValueInMap > 1 && entry.getValue() == maxValueInMap) {
//                modeResult.add(Long.valueOf(entry.getKey()));
//            }
//        }
//
//        return modeResult.stream()
//                .sorted(Comparator.comparingInt(Math::toIntExact))
//                .mapToInt(Math::toIntExact).toArray();


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