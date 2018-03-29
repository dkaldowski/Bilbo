package com.naukaJavy.Bilbo;

public class DwarfPercent extends Dwarf  {
    private double percent;

   /* public DwarfPercent(Bag bag) {
        super(bag);
    }*/

    public DwarfPercent(double percent) {
        this.percent = percent;
    }

    public double getPercent() {
        return percent;
    }

/*    public void setPercent(int percent) {
        this.percent = percent;
    }*/

    public boolean doesGetNextTreasure() {
        if (getBag().fillLevel() > getPercent())
            return false;
        else return true;
    }
}
