package com.naukaJavy.Bilbo;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        Bilbo bilbo = new Bilbo();
        List<Bag> bags = new ArrayList<Bag>();
        List<Dwarf> dwarves = new ArrayList<Dwarf>();
        List<Treasure> treasures = new ArrayList<Treasure>();

        //testowe dane
        Bag bag1 = new Bag(10);
        Bag bag2 = new Bag(15);
        Dwarf dwarf1 = new DwarfPercent(0.7);
        Dwarf dwarf2 = new DwarfPercent(0.6);
        bags.add(bag1);
        bags.add(bag2);
        dwarves.add(dwarf1);
        dwarves.add(dwarf2);
        for (int i = 0; i < 10; i++) {
            Treasure treasure = new Treasure(i+1);
            treasures.add(treasure);
        }


        System.out.println(bilbo.rozdziel(treasures, dwarves, bags));


        //dwarf z workiem?
        //bag z size
        //treasure z size
    }
}
