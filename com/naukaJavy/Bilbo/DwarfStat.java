package com.naukaJavy.Bilbo;

import java.util.List;

public class DwarfStat extends Dwarf {

    private double expectedValue(List<Treasure> sharedTreasures) {
        int numberOfTreasures = sharedTreasures.size();
        double sumOfSize = 0;
        if (sharedTreasures.isEmpty())
            return 0;
        else {
            for (Treasure treasures : sharedTreasures) {
                sumOfSize += treasures.getSize();
            }
        } return sumOfSize/numberOfTreasures/this.getBag().getSize();
    }


    @Override
    public boolean doesGetNextTreasure(List<Treasure> sharedTreasures) {
        if (getBag().fillLevel()+expectedValue(sharedTreasures) > 1)
            return false;
        else return true;
    }

}
