import static org.junit.Assert.*;
import org.junit.Test;

public class TestArrayDequeGold {

    @Test
    public void randomTest() {
        StudentArrayDeque<Integer> actual = new StudentArrayDeque<>();
        ArrayDequeSolution<Integer> excepted = new ArrayDequeSolution<>();
        double addOrRemove, firstOrLast;
        Integer x, y;
        String msg = "";
        for (int i = 0; i < 100; i += 1) {
            addOrRemove = StdRandom.uniform();
            firstOrLast = StdRandom.uniform();
            if (excepted.size() == 0 || addOrRemove < 0.5) {
                if (firstOrLast < 0.5) {
                    actual.addFirst(i);
                    excepted.addFirst(i);
                    msg += "addFirst(" + i + ")\n";
                } else {
                    actual.addLast(i);
                    excepted.addLast(i);
                    msg += "addLast(" + i + ")\n";
                }
                //assertEquals(msg, excepted, actual);
            } else {
                if (firstOrLast > 0.5) {
                    x = actual.removeFirst();
                    y = excepted.removeFirst();
                    msg += "removeFirst()\n";
                } else {
                    x = actual.removeLast();
                    y = excepted.removeLast();
                    msg += "removeLast()\n";
                }
                assertEquals(msg, y, x);
            }
        }
    }

}
