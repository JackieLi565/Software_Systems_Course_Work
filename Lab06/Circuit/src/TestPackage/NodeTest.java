package TestPackage;

import coe318.lab6.*;
import org.junit.Test;
import org.junit.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class NodeTest {
    static Node n1 = new Node();
    static Node n2 = new Node();
    static Node n3 = new Node();

    @Test
    public void TestNode() { 
        assertEquals("Passed",0, n1.nodeID);
        assertEquals("Passed",1, n2.nodeID);
        assertEquals("Passed",2, n3.nodeID);
    } 
}
