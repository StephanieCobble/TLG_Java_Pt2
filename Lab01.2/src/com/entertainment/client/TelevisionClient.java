package com.entertainment.client;

import com.entertainment.Television;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

class TelevisionClient {
    public static void main(String[] args) {
//        Television tv1 = new Television();
//        tv1.changeChannel(13);
//        Television tv2 = new Television("RCA", 10);
//        System.out.println(tv1);
//        System.out.println(tv2);

        Television tvA = new Television("Sony", 50);
        Television tvB = new Television("Sony", 50);
        Television tvC = new Television("Sony", 52);
        Television tvD = new Television("Sony", 12);

        System.out.println("tvA hashcode: " + tvA.hashCode());
        System.out.println("tvB hashcode: " +tvB.hashCode());

        System.out.println("tvA==tvB: " + (tvA == tvB));
        System.out.println("tvA.equals(tvB): " + tvA.equals(tvB));

        System.out.println();

//        Set<Television> tvs = new HashSet<>();
//        tvs.add(tvA);
//        tvs.add(tvB);

//        Set<Television> tvs = new HashSet<>(); // no dupes by brand & volume, no specific order (not random)
//        Set<Television> tvs = new LinkedHashSet<>(); // maintains add or insertion order, no dupes;
        Set<Television> tvs = new TreeSet<>(); //natural order (here, alphabetical by brand), no dupes (by brand here bc compareTo());
        // ^^ with the changes to compareTo(), now the set is 3 bc tie is broken by volume
        tvs.add(tvA);
        tvs.add(tvB);
        tvs.add(tvC);
        tvs.add(tvD);
        System.out.printf("The size of the set is: %s\n ", tvs.size()); // "should" be 1, but it's two bc the hashcodes are different! (before method written)
        // ^^ if same, now it's 1 bc of the quick hashcode() & updated method, too. equal Objects, equal hashcodes

        for (Television tv : tvs) {
            System.out.println(tv);
        }
    }
}