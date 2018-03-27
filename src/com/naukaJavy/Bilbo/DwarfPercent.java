package com.naukaJavy.Bilbo;

public class DwarfPercent extends Dwarf  {
    private int percent;

    public int getPercent() {
        return percent;
    }

    public void setPercent(int percent) {
        this.percent = percent;
    }

    public boolean doesGetNextTreasure() {
        if (getBag().fillLevel() > getPercent())
            return false;
        else return true;
    }
}
