package com.naukaJavy.Bilbo;

import org.junit.Before;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BagTest {

    //@BeforeAll
    // List<Treasure> treasures = new ArrayList<>();
    //  Bag bag = new Bag(20, treasures);


    @Test
    public void checkFillLevelStandard() {
        List<Treasure> treasures = new ArrayList<>();
        for (int i = 1; i < 4; i++) {
            Treasure treasure = new Treasure(2 * i);
            treasures.add(treasure);
        }
        Bag bag = new Bag(20, treasures);
        Assertions.assertEquals(0.6, bag.fillLevel());
    }

    @Test
    public void checkIllegalArgumentsBag() {
        try {
            Bag bag = new Bag(-20);
            fail("Exception was not thrown");
        } catch (IllegalArgumentException e) {
            assertEquals("Bag size has to be greater than 0!", e.getMessage());
        }
    }

    @Test
    public void checkIllegalArgumentTreasure() {
        try {
            Treasure treasure = new Treasure(-50);
            fail("Exception was not thrown");
        } catch (IllegalArgumentException e) {
            assertEquals("Treasure size has to be greater than 0!", e.getMessage());
        }
    }

    @Test
    public void CheckIllegalArgumentTreasureSet() {
        try {
            Treasure treasure = new Treasure();
            treasure.setSize(-99);
            fail("Exception was not thrown");
        } catch (IllegalArgumentException e) {
            assertEquals("Treasure size has to be greater than 0!", e.getMessage());
        }
    }

    @Test
    public void checkingCheckIfOverloaded() {
        Bag bag = new Bag(20);
        List<Treasure> treasures = new LinkedList<>();
        for (int i = 2; i < 5; i++) {
            Treasure treasure = new Treasure(i * 2);
            treasures.add(treasure);
        }
        bag.checkIfOverloaded();
    }
}