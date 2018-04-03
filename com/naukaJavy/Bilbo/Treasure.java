package com.naukaJavy.Bilbo;

public class Treasure {
    private double size;

    public double getSize() {
        return size;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append(getSize());
        return result.toString();
    }

    public void setSize(double size) {
        this.size = size;
        if(this.size<=0) throw new IllegalArgumentException("Treasure size has to be greater than 0!");
    }

    public Treasure() {
    }

    public Treasure(double size) {
        this.size = size;
        if(this.size<=0) throw new IllegalArgumentException("Treasure size has to be greater than 0!");
    }
}
