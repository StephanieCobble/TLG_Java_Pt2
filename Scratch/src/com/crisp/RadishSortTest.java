package com.crisp;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

class RadishSortTest {
    public static void main(String[] args) {
        List<Radish> radishes = new ArrayList<>();
        radishes.add(new Radish("red", 2.5, 1.1, 0));
        radishes.add(new Radish("pink", 0.75, 3.5, 5));
        radishes.add(new Radish("black", 1.0, 0.0, 3));
        radishes.add(new Radish("white", 2.2, 0.0, 0));

        // List has a sort method that will arrange them in natural order
        radishes.sort(null); // passing null means natural order

        dump(radishes);

        System.out.println();

        // sort by tail length
//        radishes.sort(new RadishTailLengthComparator());
        // using Lambda
        radishes.sort((r1, r2) -> Double.compare(r1.getTailLength(), r2.getTailLength()));
        dump(radishes);

        System.out.println();

        // sort by color
//        radishes.sort(new RadishColorComparator());
        // using lambda
        radishes.sort((r1, r2) -> r1.getColor().compareTo(r2.getColor()));
        dump(radishes);

        System.out.println();

        //sort by guys on top (anon)
        radishes.sort(new Comparator<Radish>() {
            @Override
            public int compare(Radish r1, Radish r2) {
                return Integer.compare(r1.getGuysOnTop(), r2.getGuysOnTop());
            }
        });
        dump(radishes);
    }

    private static void dump(List<Radish> radishList) {
        for (Radish radish : radishList) {
            System.out.println(radish);
        }
    }
}