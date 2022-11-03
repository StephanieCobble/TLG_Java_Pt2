package com.javatunes.billing;

import java.util.HashMap;
import java.util.Map;

public class TaxCalculatorFactory {

    /*
     * We could implement a "cache" of TaxCalculator instances.
     * Every time a new one is created (below), we store it in the cache
     * Then, when are asked for one, we consult the cache first, and
     *  if it's there, we fetch it and return it.
     *  if it's not, we create new, add it to the cache, and then return it.
     */
    private static Map<Location, TaxCalculator> calcMap = new HashMap<>();


    // prevent instantiation - this is an "all-static" class
    private TaxCalculatorFactory() {
    }

    public static TaxCalculator getTaxCalculator(Location location) {
        TaxCalculator calc = null;

        if (calcMap.containsKey(location)) { // there's one already in there
            calc = calcMap.get(location); // fetch it
        } else { // not already in there, so create new & insert
            switch (location) {
                case ONLINE:
                    calc = new OnlineTax();
                    break;
                case USA:
                    calc = new USATax();
                    break;
                case EUROPE:
                    calc = new EuropeTax();
                    break;
            }
            calcMap.put(location, calc);
        }

        return calc;
    }
}