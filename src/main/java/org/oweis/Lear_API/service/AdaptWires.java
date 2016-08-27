package org.oweis.Lear_API.service;

import java.util.ArrayList;
import org.oweis.Lear_API.model.Wire;

/**
 * Created by user on 25/08/2016.
 */
public class AdaptWires {

    ArrayList<Wire> wiresList = new ArrayList<>();
    ArrayList<Wire> wiresWithSpliceList;
    ArrayList<Wire> wiresWithSameSpliceList = new ArrayList<>();
    ArrayList<String> namesSpliceList = new ArrayList<>();
    String connector, color, pin,splice;

    public AdaptWires(ArrayList<Wire> wiresList) {
        this.wiresList = wiresList;
        this.wiresWithSpliceList = new ArrayList<>();
    }

    public ArrayList<Wire> updateWiresList() {

        wiresWithSpliceList = getWiresWithSplice();
        

        removeWiresWithSpliceListFromWiresList();

        namesSpliceList = getNamesSplice(wiresWithSpliceList);

        for (String newName : namesSpliceList) {

            wiresWithSameSpliceList = getWiresWithSameSplice( newName);

            String nameSpliceA, nameSpliceB;

            nameSpliceA = wiresWithSameSpliceList.get(0).getSplice_A();

            getValuesForOneSide(nameSpliceA);

            wiresWithSameSpliceList.remove(0);

            ArrayList<Wire> newWiresWithSameSplice = new ArrayList<>();
            for (Wire newWire : wiresWithSameSpliceList) {

                nameSpliceA = newWire.getSplice_A();
                nameSpliceB = newWire.getSplice_B();

                if (!assertNameNull(nameSpliceA)) {
                    setPartA(newWire);
                }
                if (!assertNameNull(nameSpliceB)) {
                    setPartB(newWire);
                }
                newWiresWithSameSplice.add(newWire);

            }

            wiresList.addAll(newWiresWithSameSplice);
        }
        return wiresList;
    }

    public ArrayList<Wire> getWiresWithSplice() {
        ArrayList<Wire> wires = new ArrayList<>();
        for (Wire wire : wiresList) {
            if (wire.getConnector_A().equals("") || wire.getConnector_B().equals("")) {
                wires.add(wire);
            }
        }
        System.out.println("Wires With Splice : "+wires.size());
        return wires;
    }

    public void removeWiresWithSpliceListFromWiresList() {
        wiresList.removeAll(wiresWithSpliceList);
    }

    public ArrayList<String> getNamesSplice(ArrayList<Wire> wires) {
        ArrayList<String> nameSplices = new ArrayList<>();
        for (Wire wire : wires) {

            String splice_A = wire.getSplice_A();
            String splice_B = wire.getSplice_B();

            if (!assertNameExist(nameSplices, splice_A) && !assertNameNull(splice_A)) {
                nameSplices.add(splice_B);
            }

            if (!assertNameExist(nameSplices, splice_B) && !assertNameNull(splice_B)) {
                nameSplices.add(splice_B);
            }
        }

        return nameSplices;
    }

    public ArrayList<Wire> getWiresWithSameSplice(String name) {
        ArrayList<Wire> wires = new ArrayList<>();
        for (Wire wire : wiresWithSpliceList) {
            if (wire.getSplice_B().equals(name) || wire.getSplice_B().equals(name))
                wires.add(wire);
        }
        return wires;
    }

    public void getValuesForOneSide(String nameSpliceA){
        if (assertNameNull(nameSpliceA)) {
            setValuesA();

        } else {
            setValuesB();
        }
    }
    public void setValuesA(){
        connector = wiresWithSameSpliceList.get(0).getConnector_A();
        color = wiresWithSameSpliceList.get(0).getColor_A();
        pin = wiresWithSameSpliceList.get(0).getPin_A();
        splice = "";
    }

    public void setValuesB(){
        connector = wiresWithSameSpliceList.get(0).getConnector_B();
        color = wiresWithSameSpliceList.get(0).getColor_B();
        pin = wiresWithSameSpliceList.get(0).getPin_B();
        splice = "";
    }

    public void setPartB(Wire wire) {

        wire.setConnector_B(connector);
        wire.setColor_B(color);
        wire.setPin_B(pin);
        wire.setSplice_B(splice);
        wire.setSplice_A(splice);

    }

    public void setPartA(Wire wire) {

        wire.setConnector_A(connector);
        wire.setColor_A(color);
        wire.setPin_A(pin);
        wire.setSplice_A(splice);
        wire.setSplice_B(splice);

    }

    public boolean assertNameExist(ArrayList<String> nameList, String name) {
        return nameList.contains(name);
    }

    public boolean assertNameNull(String name) {
        return name.equals("");
    }
}

