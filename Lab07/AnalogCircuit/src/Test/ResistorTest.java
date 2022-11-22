package Test;
import coe318.lab7.*;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import org.junit.*;

public class ResistorTest {
    
    Node n1 = new Node();
    Node n2 = new Node();
    Resistor R = new Resistor(50, n1, n2);

    @Test
    public void TestToString() {
        assertEquals("Passed","R1 0 1 50.0", R.toString());

    }
    @Test
    public void IllegalArgs() {
        Circuit crkt = Circuit.getInstance();
        assertThrows("Passed",IllegalArgumentException.class, 
        () -> { 
            Resistor RNegative = new Resistor(-50, null, n2);
            crkt.Radd(RNegative);
        }
        );
    }
    @Test
    public void testGetNodes() {
        Resistor R = new Resistor(50, n1, n2);
        Node[] expResult = {n1,n2};
        Node[] result = R.getNodes();
        assertArrayEquals(expResult, result);
    
    }
}
