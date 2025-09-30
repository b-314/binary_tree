public class BNodeChar {
    char letter;
    int depth;
    BNodeChar left, right;
    public BNodeChar (char letter, int depth) {
        this.letter = letter;
        left = null;
        right = null;
        this.depth = depth;
    }
}