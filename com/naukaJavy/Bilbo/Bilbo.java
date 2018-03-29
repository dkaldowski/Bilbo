package com.naukaJavy.Bilbo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Bilbo extends Winner {
    public List<Treasure> getTreasuresToShare() {
        return treasuresToShare;
    }

    private List<Treasure> treasures;

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
    @Override
    public List<Treasure> getTreasures() {
        return treasures;
    }

    @Override
    public void setTreasures(List<Treasure> treasures) {
        this.treasures = treasures;
    }

    private List<Treasure> treasuresToShare;
    private List<Dwarf> dwarvesOnBlackList;

    public Map rozdziel(List<Treasure> treasuresToShare, List<Dwarf> dwarves, List<Bag> bags) {
        int i = 0;
        for(Dwarf dwarf:dwarves){
            dwarf.setBag(bags.get(i));
            i++;
        }
        Map<Winner, Treasure> winnersWithTreasures = new HashMap<Winner, Treasure>();
        for (Treasure treasure : treasuresToShare) {
            treasuresToShare.remove(treasure);
            for (Dwarf dwarf : dwarves) {
                if (!dwarvesOnBlackList.contains(dwarf)) {
                    //   float sizeOfAllSharedTreasures = sizeOfAllSharedTreasures(bags,dwarf);
                    if (dwarf.doesGetNextTreasure()) {  //dwarf bierze skarb
                        dwarf.getBag().treasures.add(treasure);  //dodajemy skarb do listy dwarfa
                        if (dwarf.getBag().checkIfOverloaded()) {  //sprawdzamy czy worek przepełniony
                            for (Treasure dwarfsTreasure : dwarf.getBag().treasures) {  //jesli tak to jedziemy po wszystkih skarbach dwarfa
                                treasures.add(dwarfsTreasure); // i dodajemy do skarbow Bilba  ;   czy tu nie powinno być setTreasures?
                                dwarf.getBag().treasures.remove(dwarfsTreasure);
                                dwarvesOnBlackList.add(dwarf); //dwarfa dodajemy do czarnej listy
                            }
                        }
                    } else {
                        for (Treasure treasuresInBag : dwarf.getBag().treasures)
                            dwarf.getTreasures().add(treasuresInBag);  //jesli nie jest przeladowany, dodajemy skarb do listy dwarfa
                        dwarvesOnBlackList.add(dwarf);
                    }
                }
                if (dwarvesOnBlackList.size() == dwarves.size()) {
                    for (Dwarf onBlackList : dwarvesOnBlackList) {
                        dwarvesOnBlackList.remove(onBlackList);  //jesli wszystkie krasnoludy albo wzily skarby, albo oddaly Bilbo, to zaczynamy zabawe od nowa
                    }
                }

            }
        }
        Bilbo bilbo = new Bilbo();
        for (Treasure treasures : getTreasures()) {
            winnersWithTreasures.put(bilbo, treasures);
        }
        for (Dwarf dwarf : dwarves) {
            for (Treasure treasures : dwarf.getTreasures()) {
                winnersWithTreasures.put(dwarf, treasures);
            }
        }
        return winnersWithTreasures;
    }

}
