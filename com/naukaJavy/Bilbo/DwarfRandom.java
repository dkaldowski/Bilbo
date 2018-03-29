package com.naukaJavy.Bilbo;

import java.util.Random;

public class DwarfRandom extends Dwarf {
  /*  public DwarfRandom(Bag bag) {
        super(bag);
    }*/

    public boolean doesGetNextTreasure(){
        Random random = new Random();
        return random.nextBoolean();};
}
