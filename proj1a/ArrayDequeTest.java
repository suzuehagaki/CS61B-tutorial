import static org.junit.Assert.*;

import org.junit.Test;

public class ArrayDequeTest {

    /** test resize, add, remove, size, and isEmpty methods. */
    @Test
    public void majorTest() {
        ArrayDeque<Integer> a = new ArrayDeque<>();
        Integer expected;

        for (int i = 0; i < 9; i++) {
            a.addFirst(i);
        }

        assertTrue(!a.isEmpty());

        for (int i = 8; i >= 0; i--) {
            expected = i;
            assertEquals(expected, a.removeFirst());
        }

        assertTrue(a.isEmpty());

        for (int i = 0; i < 9; i++) {
            a.addFirst(i);
        }

        assertEquals(9, a.size());

        for (int i = 0; i < 9; i++) {
            expected = i;
            assertEquals(expected, a.removeLast());
        }

    }
}
