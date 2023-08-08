import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class TestOffByN {

    @Test
    public void testEqualChars() {
        CharacterComparator offByN = new OffByN(2);
        assertTrue(offByN.equalChars('r', 't'));
        assertTrue(!offByN.equalChars('a', 'b'));
        assertTrue(offByN.equalChars('a', 'c'));
    }
}
