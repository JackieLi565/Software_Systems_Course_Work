package TestPackage;
import org.junit.Test;

import coe318.lab6.*;
import org.junit.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class NodeTest {
    static Node n1 = new Node();
    static Node n2 = new Node();
    static Node n3 = new Node();

    @Test
    public void TestNode() { 
        assertEquals(0, n1.nodeID);
        assertEquals(1, n2.nodeID);
        assertEquals(2, n3.nodeID);
    }
    
}
