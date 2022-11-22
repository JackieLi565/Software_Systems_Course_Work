package Test;

import coe318.lab7.*;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

import org.junit.*;

public class VoltageTest {
    
    Node n1 = new Node();
    Node n2 = new Node();
    VoltageSource V = new VoltageSource(50, n1, n2);

    @Test
    public void TestToString() {
        assertEquals("Passed","V1 0 1 50.0", V.toString());

    }
    @Test
    public void IllegalArgs() {
        Circuit crkt = Circuit.getInstance();
        assertThrows("Passed",IllegalArgumentException.class, 
        () -> { 
            VoltageSource VNegative = new VoltageSource(0, null, n2);
            crkt.Vadd(VNegative);
        }
        );
    }
    @Test
    public void testGetNodes() {
        VoltageSource V = new VoltageSource(50, n1, n2);
        Node[] expResult = {n1,n2};
        Node[] result = V.getNodes();
        assertArrayEquals(expResult, result);
    
    }
}
