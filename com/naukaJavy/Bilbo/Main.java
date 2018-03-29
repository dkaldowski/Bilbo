package com.naukaJavy.Bilbo;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        Bilbo bilbo = new Bilbo();
        List<Bag> bags = new ArrayList<Bag>();
        List<Dwarf> dwarves = new ArrayList<Dwarf>();
        List<Treasure> treasures = new ArrayList<Treasure>();
        System.out.println(bilbo.rozdziel(treasures,dwarves,bags));


        //dwarf z workiem?
        //bag z size
        //treasure z size
    }
}
