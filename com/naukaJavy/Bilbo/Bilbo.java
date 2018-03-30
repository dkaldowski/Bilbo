package com.naukaJavy.Bilbo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Bilbo extends Winner {
    public List<Treasure> getTreasuresToShare() {
        return treasuresToShare;
    }

    private List<Treasure> treasures = new ArrayList<>();

    /*    public float sizeOfTreasuresInBags(List<Bag> bags) {
            float size = 0;
            for (Bag bag : bags) {
                size += bag.fillLevel() * bag.getSize();
            }
            return size;
        }

        public float sizeOfDwarfsTreasures(List<Dwarf> dwarf) {
            float size = 0;
            for (Dwarf dwarff : dwarf) {
                for (Treasure treasure : dwarff.getTreasures())
                    size += treasure.getSize();
            }
            return size;
        }

        public float sizeOfBilbosTreasures() {
            float size = 0;
            for (Treasure treasure : treasures) {
                size += treasure.getSize();
            }
            return size;
        }

        public float sizeOfAllSharedTreasures(List<Bag> bags, List<Dwarf> dwarf){
            return sizeOfBilbosTreasures()+sizeOfDwarfsTreasures(dwarf)+sizeOfTreasuresInBags(bags);
        }
    */


    private List<Treasure> treasuresToShare;
    private List<Dwarf> dwarvesOnBlackList = new ArrayList<Dwarf>();


    public Map rozdziel(List<Treasure> treasuresToShare, List<Dwarf> dwarves, List<Bag> bags) {
        int i = 0;
        for (Dwarf dwarf : dwarves) {
            dwarf.setBag(bags.get(i));
            i++;
        }
        Map<Winner, List<Treasure>> winnersWithTreasures = new HashMap<>();
        for (Treasure treasure : treasuresToShare) {
            for (Dwarf dwarf : dwarves) {
                if (!dwarvesOnBlackList.contains(dwarf)) {
                    //   float sizeOfAllSharedTreasures = sizeOfAllSharedTreasures(bags,dwarf);
                    Bag bag = dwarf.getBag();
                    if (dwarf.doesGetNextTreasure()) {  //dwarf bierze skarb
                        bag.getTreasures().add(treasure);  //dodajemy skarb do listy dwarfa
                        if (bag.checkIfOverloaded()) {  //sprawdzamy czy worek przepełniony
                            treasures.addAll(bag.getTreasures());   // przerzucamy skarby do Bilbo
                            bag.getTreasures().clear(); //czyścimy worek Bilba
                            dwarvesOnBlackList.add(dwarf); //dwarfa dodajemy do czarnej listy
                        }
                        break;
                    } else {
                        for (Treasure treasuresInBag : bag.getTreasures()) {
                            dwarf.getTreasures().add(treasuresInBag);  //jesli nie jest przeladowany, dodajemy skarb do listy dwarfa
                        }
                        bag.getTreasures().clear();
                        dwarvesOnBlackList.add(dwarf);
                    }
                }
            }
            if (dwarvesOnBlackList.size() == dwarves.size()) {
                if(!treasures.contains(treasure)) {
                    treasures.add(treasure);
                }
                dwarvesOnBlackList.clear();  //jesli wszystkie krasnoludy albo wzily skarby, albo oddaly Bilbo, to zaczynamy zabawe od nowa
            }
        }

        winnersWithTreasures.put(this, treasures);

        for (Dwarf dwarf : dwarves) {

            winnersWithTreasures.put(dwarf, dwarf.getTreasures());
        }

        return winnersWithTreasures;
    }

}
