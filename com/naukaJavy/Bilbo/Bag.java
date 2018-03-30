package com.naukaJavy.Bilbo;

import java.util.ArrayList;
import java.util.List;


public class Bag {
    private float size;

    public List<Treasure> getTreasures() {
        return treasures;
    }

    private List<Treasure> treasures = new ArrayList<Treasure>(); //lista skarbow w worku, to powinno być w klasie Bilbo private


    public Bag(float size, List<Treasure> treasures) {
        this.size = size;
        this.treasures = treasures;
    }

    public float getSize() {
        return size;
    }

    //poziom wypelnienia worka
    public float fillLevel() {
        float sumSizeOfTreasure = 0;
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
    }


 /*   public Dwarf getDwarf() {
        return dwarf;
    }

    public void setDwarf(Dwarf dwarf) {
        this.dwarf = dwarf;
    }*/
}
