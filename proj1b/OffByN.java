public class OffByN implements CharacterComparator {

    private int diff;

    /**
     * A single argument constructor which takes an integer
     * @param N for rules of equalChars(char x, char y)
     */
    public OffByN(int N) {
        diff = N;
    }

    /**
     * Returns true for characters that are different by N.
     */
    @Override
    public boolean equalChars(char x, char y) {
        return Math.abs(x - y) == diff;
    }
}
