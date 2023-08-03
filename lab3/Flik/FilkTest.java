import static org.junit.Assert.*;

import org.junit.Test;

public class FilkTest {

    @Test
    public void testisSameNumber(){
        int a = 129;
        int b = 129;
        assertTrue(Flik.isSameNumber(a,b));
    }
}
