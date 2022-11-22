package coe318.lab7;

public class Node {

    public int nodeID;
    public static int total_node = 0;

    public Node() {

        this.nodeID = total_node++;
    } 

    @Override
    public String toString() {
        return Integer.toString(nodeID);
    }

}