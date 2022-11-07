package TestPackage;
import org.junit.Test;

import coe318.lab6.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThrows;

import org.junit.*;


public class ResistorTest {
    
    Node n1 = new Node();
    Node n2 = new Node();
    Resistor R = new Resistor(50, n1, n2);

    @Test
    public void TestgetNodes() {
        assertEquals("Passed","R1 0 1 50.0", R.toString());

    }
    @Test
    public void IllegalArgs() {
        assertThrows("Passed",IllegalArgumentException.class, 
        () -> { //lambda (function from js)
            Resistor RNegative = new Resistor(-50, n1, n2);
            Resistor RShorted = new Resistor(0, n1, n2);
        }
    );
    }


}
