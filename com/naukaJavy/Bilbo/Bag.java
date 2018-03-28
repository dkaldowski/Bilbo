package com.naukaJavy.Bilbo;

import java.util.ArrayList;
import java.util.List;


public class Bag {
    private int size;
    public List<Treasure> treasures; //lista skarbow w worku, to powinno być w klasie Bilbo private



    public Bag(int size, List<Treasure> treasures) {
        this.size = size;
        this.treasures = treasures;
    }

    public int getSize() {
        return size;
    }

    //poziom wypelnienia worka
    public double fillLevel() {
        int sumSizeOfTreasure = 0;
        for (Treasure treasure : treasures) {
            sumSizeOfTreasure += treasure.getSize();
        }
        return sumSizeOfTreasure / this.getSize();
    }

    //czy przeladowany
    public boolean checkIfOverloaded() {
        if (this.fillLevel() > 1)
            return true;
        else return false;
    }

    public Bag(int size) {
        this.size = size;
    }


 /*   public Dwarf getDwarf() {
        return dwarf;
    }

    public void setDwarf(Dwarf dwarf) {
        this.dwarf = dwarf;
    }*/
}
