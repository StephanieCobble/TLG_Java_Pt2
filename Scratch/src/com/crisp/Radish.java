package com.crisp;

class Radish implements Comparable<Radish> {
    // properties
    private String color;
    private double size;
    private double tailLength;
    private int guysOnTop;

    // ctors
    public Radish(String color, double size, double tailLength, int guysOnTop) {
        setColor(color);
        setSize(size);
        setTailLength(tailLength);
        setGuysOnTop(guysOnTop);
    }

    // accessor methods
    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getSize() {
        return size;
    }

    public void setSize(double size) {
        this.size = size;
    }

    public double getTailLength() {
        return tailLength;
    }

    public void setTailLength(double tailLength) {
        this.tailLength = tailLength;
    }

    public int getGuysOnTop() {
        return guysOnTop;
    }

    public void setGuysOnTop(int guysOnTop) {
        this.guysOnTop = guysOnTop;
    }

    // natural order is defined by 'size'
    @Override
    public int compareTo(Radish other) {
        return Double.compare(this.getSize(), other.getSize());
    }

    @Override
    public String toString() {
        return String.format("%s: color = %s, size = %s, tailLength = %s, guysOnTop = %s",
                getClass().getSimpleName(), getColor(), getSize(), getTailLength(), getGuysOnTop());
    }
}