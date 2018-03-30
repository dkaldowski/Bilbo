package com.naukaJavy.Bilbo;

public class Treasure {
    private float size;

    public float getSize() {
        return size;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append(getSize());
        return result.toString();
    }

    public Treasure(float size) {
        this.size = size;
    }
}
