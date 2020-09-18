import static org.junit.Assert.*;

import org.junit.Test;

public class FilkTest {

    @Test
    public void testIsSameNumber() {
        Integer a = 127;
        Integer b = 127;
        Integer c = 128;
        Integer d = 128;
        Integer e = 512;
        assertTrue(Flik.isSameNumber(a, b));
        assertTrue(Flik.isSameNumber(c, d));
        assertFalse(Flik.isSameNumber(a, e));
    }

}
