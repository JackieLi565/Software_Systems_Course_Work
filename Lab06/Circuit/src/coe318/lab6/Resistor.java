package coe318.lab6;

public class Resistor {//test

    private double resistance;
    private int resistorID;
    public static int total_resistors = 1;
    private Node node1, node2;

    public Resistor (double resistance, Node node1, Node node2) {

        if (resistance < 0) { //resistance can be zero, means branch is shorted
            throw new IllegalArgumentException("Resistance can't be negative");
        }
        if (node1== null || node2 == null) {
            throw new IllegalArgumentException("node1 and node2 can't be null");
        }

        this.resistance = resistance;
        this.node1 = node1;
        this.node2 = node2;
        this.resistorID = total_resistors;
        total_resistors++;
    }

    public Node [] getNodes() {
        Node[] nodes = {node1, node2};
        return nodes;
    }

    public String toString() {
        String out = "R" + resistorID + " " + node1 + " " + node2 + " " + resistance;
        return out;
    }
}
