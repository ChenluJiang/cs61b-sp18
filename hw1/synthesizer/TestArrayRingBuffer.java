package synthesizer;
import org.junit.Test;
import static org.junit.Assert.*;

/** Tests the ArrayRingBuffer class.
 *  @author Josh Hug
 */

public class TestArrayRingBuffer {
    @Test
    public void someTest() {
        ArrayRingBuffer arb = new ArrayRingBuffer(10);
//        arb.dequeue();
//        arb.peek();
        arb.enqueue(1);
        arb.enqueue(2);
        arb.enqueue(3);
        assertEquals(arb.dequeue(), 1);
        assertEquals(arb.dequeue(), 2);
        assertEquals(arb.peek(), 3);
        assertEquals(arb.dequeue(), 3);
        assertTrue(arb.isEmpty());
    }

    /** Calls tests for ArrayRingBuffer. */
    public static void main(String[] args) {
        jh61b.junit.textui.runClasses(TestArrayRingBuffer.class);
    }
} 
