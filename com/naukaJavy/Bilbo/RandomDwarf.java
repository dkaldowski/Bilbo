package com.naukaJavy.Bilbo;

import java.util.Random;

public class RandomDwarf extends Dwarf {
  /*  public RandomDwarf(Bag bag) {
        super(bag);
    }*/

    public boolean doesGetNextTreasure() {
        Random random = new Random();
        return random.nextBoolean(); // po tescie odkomentowac
       // return false; // po tescie zakomentowac
    }
}
