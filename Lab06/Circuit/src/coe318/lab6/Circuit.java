package coe318.lab6;

import java.util.ArrayList;

public class Circuit {

    ArrayList<Resistor> resistors;
    private static Circuit instance = null;

    public static Circuit getInstance() {
        if (instance == null) {
            instance = new Circuit();
        }
        return instance;
    }

    private Circuit() {
        this.resistors = new ArrayList<Resistor>();

    }

    public void add(Resistor r) {
        this.resistors.add(r);

    }

    @Override
    public String toString() {
        String print = "";

        for (Resistor s : resistors) {
            print += s + "\n";
        }
        return print;
    }

}
