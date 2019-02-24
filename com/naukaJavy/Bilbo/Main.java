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
        Bag bag1 = new Bag(4);
        Bag bag2 = new Bag(9);
        Dwarf dwarf1 = new DwarfPercent(0.5);
        Dwarf dwarf2 = new DwarfStat();
        bags.add(bag1);
        bags.add(bag2);
        dwarves.add(dwarf1);
        dwarves.add(dwarf2);
        for (int i = 1; i <= 6; i++) {
            Treasure treasure = new Treasure(i);
            treasures.add(treasure);
        }


     //   System.out.println(bilbo.rozdziel(treasures, dwarves, bags));

      //  bilbo.rozdziel(treasures, dwarves, bags).forEach(System.out.println());

        System.out.println(bilbo.rozdziel(treasures, dwarves, bags));
       // System.out.println(Collections.singletonList(bilbo.rozdziel(treasures, dwarves, bags)));

        System.out.println("master commit");

        //dwarf z workiem?
        //bag z size
        //treasure z size
    }
}
