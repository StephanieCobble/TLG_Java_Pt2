package com.entertainment;

import java.util.Objects;

/*
* Natural order defined by 'brand' (String), then by 'volume' (int) when tied on brand
* This make Television "consistent" with equals. i.e., whatever fields are used in equals and hashCode,
* those same fields are used in compareTo.
 */
public class Television implements Comparable<Television> {
    // fields
    private String brand;
    private int volume;

    private final Tuner tuner = new Tuner();

    // ctors
    public Television() {
        // no arg
    }

    public Television(String brand, int volume) {
        setBrand(brand);
        setVolume(volume);
    }

    // bus methods
    public int getCurrentChannel() {
        return tuner.getChannel();
    }

    public void changeChannel(int channel) {
        tuner.setChannel(channel);
    }

    // accessor methods
    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    @Override
    public int hashCode() {
        // this is a poorly written hash function bc it easily results in
        // "hash collisions" - which is when different objects coincidentally have the same hashcode
//        return getBrand().length() + getVolume();

        // delegate to Objects.hash for a "scientifically correct" hash function
        // that is, one that minimizes the probability of a hash collision
        return Objects.hash(getBrand(), getVolume());
    }

    @Override
    public boolean equals(Object obj) {
        boolean result = false;

        //proceed only if 'obj' is really an instance of Television
        if (this.getClass() == obj.getClass()) { //exact type check, not an IS-A check
            // downcast 'obj' to more specific reference type Television
            Television other = (Television) obj;

            //do the checks - we decide that brand and volume determine equality (sameness)
            // Objects.equals() does a "null-safe" check
            result = Objects.equals(this.getBrand(), other.getBrand()) &&
                    this.getVolume() == other.getVolume();
        }
        return result;
    }

    // Natural order defined by 'brand' (String), then by 'volume' (int) when tied on brand
    @Override
    public int compareTo(Television other) {
        int result = this.getBrand().compareTo(other.getBrand());

        if (result == 0) { // tied on brand, so break tie by volume
            result = Integer.compare(this.getVolume(), other.getVolume());
        }
        return  result;
    }

    @Override
    public String toString() {
        return String.format( "%s: brand = %s, volume = %s, currentChannel = %s",
                getClass().getSimpleName(), getBrand(), getVolume(), getCurrentChannel());
    }
}