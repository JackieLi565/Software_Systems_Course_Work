package coe318.lab6;


public class Node {

    private int nodeID;
    private static int total_node = 0;

    public Node() {//test
        this.nodeID = total_node;
        total_node++;
    } 

    @Override
    public String toString() {
        return Integer.toString(nodeID);
    }

}
