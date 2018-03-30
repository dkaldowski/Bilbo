package com.naukaJavy.Bilbo;

import java.util.ArrayList;
import java.util.List;

public class Winner {

    private static final String DWARF_TREASURES = "'s treasures";

    private List<Treasure> treasures = new ArrayList<>();

    public List<Treasure> getTreasures() {
        return treasures;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + DWARF_TREASURES;
    }


    public void setTreasures(List<Treasure> treasures) {
        this.treasures = treasures;
    }
}
