package coe318.lab7;

public class VoltageSource {
    public Node [] nodes = new Node [2];
    public double voltage;
    private int voltageID;
    public static int total_vs = 1;
    

    public VoltageSource (double voltage, Node node1, Node node2) {
        if (voltage == 0) {
            throw new IllegalArgumentException("Voltage source can't be zero");
        }
        if (node1== null || node2 == null) {
            throw new IllegalArgumentException("Voltage source must be connected to two nodes");
        }

        this.voltage = voltage;
        this.nodes[0] = node1;
        this.nodes[1] = node2;
        this.voltageID = total_vs++;
        
    }

    public Node [] getNodes() {
        return nodes;
    }

    @Override
    public String toString() {
        String print = "V" + voltageID + " " + nodes[0] + " " + nodes[1] + " " + voltage;
        return print;
    }
        
}
