package com.naukaJavy.Bilbo;

import java.util.ArrayList;
import java.util.List;


public class Bag {
    private double size;

    public List<Treasure> getTreasures() {
        return treasures;
    }

    private List<Treasure> treasures = new ArrayList<Treasure>(); //lista skarbow w worku, to powinno być w klasie Bilbo private

    public Bag(double size, List<Treasure> treasures) {
        this.size = size;
        this.treasures = treasures;

            if(this.size<=0) throw new IllegalArgumentException("Bag size has to be greater than 0!");


    }

    public double getSize() {
        return size;
    }

    //poziom wypelnienia worka
    public double fillLevel() {
        double sumSizeOfTreasure = 0.0;
        for (Treasure treasure : getTreasures()) sumSizeOfTreasure += treasure.getSize();
        return (sumSizeOfTreasure / this.getSize());
    }

    //czy przeladowany
    public boolean checkIfOverloaded() {
        if (this.fillLevel() > 1)
            return true;
        else return false;
    }

    public Bag(float size) {
        this.size = size;
        if(this.size<=0) throw new IllegalArgumentException("Bag size has to be greater than 0!");
    }

}
