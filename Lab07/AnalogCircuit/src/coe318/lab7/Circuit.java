package coe318.lab7;
import java.util.ArrayList;

public class Circuit {

    ArrayList<Object> componets;//polymorph resistor and voltage are child class to the obj class

    private static Circuit instance = null;

    public static Circuit getInstance() {
        if (instance == null) {
            instance = new Circuit();
        }
        return instance;
    }

    private Circuit() {
        this.componets = new ArrayList<>();

    }

    public void Radd(Resistor r) {
        this.componets.add(r);
    }

    public void Vadd(VoltageSource v) {
        this.componets.add(v);
    }

    @Override
    public String toString() {
        
        String print = "";

        for (Object s : componets) {
            print += s + "\n";
        }
        return print;
          
    }

}
