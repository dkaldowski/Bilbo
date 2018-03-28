package com.naukaJavy.Bilbo;

import java.util.List;

public class Bilbo extends Winner {
    private List<Treasure> treasures;

    public int getSumOfTreasureSize() {
        return sumOfTreasureSize;
    }

    private int sumOfTreasureSize=0;

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


    public void rozdziel(List<Treasure> treasuresToShare, List<Dwarf> dwarves, List<Bag> bags) {
        for (Treasure treasure : treasuresToShare) {
            treasuresToShare.remove(treasure);
            for (Dwarf dwarf : dwarves) {
                if (!dwarvesOnBlackList.contains(dwarf)) {
                    if (dwarf.doesGetNextTreasure()) {  //dwarf bierze skarb
                        dwarf.getBag().treasures.add(treasure);  //dodajemy skarb do listy dwarfa
                        if (dwarf.getBag().checkIfOverloaded()) {  //sprawdzamy czy worek przepełniony
                            for (Treasure dwarfsTreasure : dwarf.getBag().treasures) {  //jesli tak to jedziemy po wszystkih skarbach dwarfa
                                treasures.add(dwarfsTreasure); // i dodajemy do skarbow Bilba
                                dwarf.getBag().treasures.remove(dwarfsTreasure);
                                dwarvesOnBlackList.add(dwarf); //dwarfa dodajemy do czarnej listy
                            }
                        }
                    } else {
                        for(Treasure treasuresInBag:dwarf.getBag().treasures)
                        dwarf.getTreasures().add(treasure);  //jesli nie jest przeladowany, dodajemy skarb do listy dwarfa
                        dwarvesOnBlackList.add(dwarf);
                    }
                }
                if(dwarvesOnBlackList.size() == dwarves.size()){
                    for(Dwarf onBlackList:dwarvesOnBlackList){
                        dwarvesOnBlackList.remove(onBlackList);  //jesli wszystkie krasnoludy albo wzily skarby, albo oddaly Bilbo, to zaczynamy zabawe od nowa
                    }
                }

            }
        }
       // mozna na koncu zrobic jakas tablice z przypisanymi skarbami do Bilbo i krasnoludów
    }

}
