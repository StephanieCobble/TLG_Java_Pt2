package com.crisp;

import java.util.Comparator;

class RadishTailLengthComparator implements Comparator<Radish> {
    @Override
    public int compare(Radish r1, Radish r2) {
        return Double.compare(r1.getTailLength(), r2.getTailLength());
    }
}