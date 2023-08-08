import org.junit.Test;
import static org.junit.Assert.assertTrue;

public class TestOffByOne {

    // You must use this CharacterComparator and not instantiate
    // new ones, or the autograder might be upset.
    static CharacterComparator offByOne = new OffByOne();

    // Your tests go here.
    @Test
    public void testEqualChars() {
        char c1 = 'a';
        char c2 = 'b';
        char c3 = 'a';
        assertTrue(offByOne.equalChars(c1, c2));
        assertTrue(!offByOne.equalChars(c1, c3));
        assertTrue(offByOne.equalChars(c2, c3));
        assertTrue(offByOne.equalChars('&', '%'));
    }
}
