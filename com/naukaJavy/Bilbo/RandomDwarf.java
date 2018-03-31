package com.naukaJavy.Bilbo;

import java.util.List;
import java.util.Random;

public class RandomDwarf extends Dwarf {
  /*  public RandomDwarf(Bag bag) {
        super(bag);
    }*/

    public boolean doesGetNextTreasure(List<Treasure> sharedTreasures) {
        Random random = new Random();
        return random.nextBoolean(); // po tescie odkomentowac
       // return false; // po tescie zakomentowac
    }
}
