package coe318.lab7;

public class Resistor {

    private Node [] nodes = new Node [2];
    public double resistance;
    private int resistorID;
    public static int total_resistors = 1;

    public Resistor (double resistance, Node node1, Node node2) {

        if (resistance < 0) { 
            throw new IllegalArgumentException("Resistance can't be negative");
        }
        if (resistance == 0) {
            throw new IllegalArgumentException("Resistor is not connected to voltage source"); // voltage / current = 0, when voltage is zero
        }
        if (node1== null || node2 == null) {
            throw new IllegalArgumentException("Resistor Must be connected to two nodes");
        }

        this.resistance = resistance;
        this.nodes[0] = node1;
        this.nodes[1] = node2;
        this.resistorID = total_resistors++;
        
    }

    public Node [] getNodes() {
        return nodes;
    }

    @Override
    public String toString() {
        String print = "R" + resistorID + " " + nodes[0] + " " + nodes[1] + " " + resistance;
        return print;
    }
}
