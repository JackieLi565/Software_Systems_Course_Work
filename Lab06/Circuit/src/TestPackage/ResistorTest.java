package TestPackage;
import org.junit.Test;

import coe318.lab6.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import org.junit.*;


public class ResistorTest {
    
    Node n1 = new Node();
    Node n2 = new Node();
    Resistor R = new Resistor(50.0, n1, n2);

    @Test
    public void TestgetNodes() {
        assertEquals(50.0, R.resistance);
    }
}
