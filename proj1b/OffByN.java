public class OffByN implements CharacterComparator {

    private int n;

    public OffByN(int offset) {
        this.n = offset;
    }

    @Override
    public boolean equalChars(char x, char y) {
        //x = Character.toLowerCase(x);
        //y = Character.toLowerCase(y);
        return Math.abs(x - y) == n;
    }
}
