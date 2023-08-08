import org.junit.Test;
import static org.junit.Assert.*;

public class TestPalindrome {
    // You must use this palindrome, and not instantiate
    // new Palindromes, or the autograder might be upset.
    static Palindrome palindrome = new Palindrome();

    @Test
    public void testWordToDeque() {
        Deque d = palindrome.wordToDeque("persiflage");
        String actual = "";
        for (int i = 0; i < "persiflage".length(); i++) {
            actual += d.removeFirst();
        }
        assertEquals("persiflage", actual);
    }

    @Test
    public void testIsPalindrome() {
        assertTrue(!palindrome.isPalindrome("cat"));
        assertTrue(palindrome.isPalindrome("level"));
        assertTrue(palindrome.isPalindrome("radar"));
        assertTrue(palindrome.isPalindrome("RADAR"));
        assertTrue(palindrome.isPalindrome("CS6116SC"));
        /**
        assertTrue(!palindrome.isPalindromeRecursive("cat"));
        assertTrue(palindrome.isPalindromeRecursive("level"));
        assertTrue(palindrome.isPalindromeRecursive("radar"));
         */

        OffByOne obo = new OffByOne();
        assertTrue(!palindrome.isPalindrome("cat", obo));
        assertTrue(palindrome.isPalindrome("truss", obo));
        assertTrue(palindrome.isPalindrome("&%", obo));

        OffByN obn = new OffByN(3);
        assertTrue(!palindrome.isPalindrome("mack", obn));
        assertTrue(palindrome.isPalindrome("sheep", obn));
    }

}
