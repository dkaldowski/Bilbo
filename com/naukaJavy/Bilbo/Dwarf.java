package com.naukaJavy.Bilbo;

import java.util.List;

public abstract class Dwarf extends Winner {
    public abstract boolean doesGetNextTreasure();

    private List<Treasure> treasures;
    private Bag bag;

    public List<Treasure> getTreasures() {
        return treasures;
    }

    public void setTreasures(List<Treasure> treasures) {
        this.treasures = treasures;
    }

    public Bag getBag() {
        return bag;
    }

    public void setBag(Bag bag) {
        this.bag = bag;
    }
}
