public class BNodeDepth extends BNode {
    int depth;
    BNodeDepth left, right;
    public BNodeDepth (int value, int depth) {
        super(value); 
        left = null;
        right = null;
        this.depth = depth;
    }
}