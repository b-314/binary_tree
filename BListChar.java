public class BListChar {
    public BNodeChar root;
    public BListChar () {
        root = null;
    }
    
    public void addRoot (char letter) {
        BNodeChar newHead = new BNodeChar(letter, 0);
        root = newHead;
    }
    
    public void addNode (char letter) {
        if(root==null) addRoot(letter);
        else {
            BNodeChar current = root;
            boolean placed = false;
            while(!placed) {
                if((int)letter<=(int)current.letter) {
                    if(current.left==null) {
                        BNodeChar newNode = new BNodeChar(letter, current.depth + 1);
                        current.left = newNode;
                        placed=true;
                    }
                    else current = current.left;
                }
                else {
                    if(current.right==null) {
                        BNodeChar newNode = new BNodeChar(letter, current.depth + 1);
                        current.right = newNode;
                        placed = true;
                    }
                    else current = current.right;
                }
            }    
        }
    }
    
    public String toString(BNodeChar node) {
        String tree = "";
        if(node==null) {
            return "";
        }
        else {
            tree += toString(node.left);
            tree += (node.letter + " - " + node.depth + "\n");
            tree += toString(node.right);
            return tree;
        }
    }
    
    public void show1Child(BNodeChar node) { 
        if(node!=null) {
            show1Child(node.left);
            if(node.right==null&&node.left!=null||node.left==null&&node.right!=null) 
                System.out.println(node.letter + " ");
            show1Child(node.right);
        }
    }
    
    public int countNulls(BNodeChar node) {
        int nulls = 0;
        if(node==null) return 0;
        else {
            nulls += countNulls(node.left);
            if(node.left==null) nulls++;
            if(node.right==null) nulls++;;
            nulls += countNulls(node.right);
            return nulls;
        }
    }
    
    public int duplicateAtDepth (BNodeChar node) {
        int duplicateMaxDepth = 0;
        if(node==null) return 0;
        else {
            if(duplicateAtDepth(node.left)!=0) duplicateMaxDepth = duplicateAtDepth(node.left);
            if(node.letter==root.letter&&node.depth>duplicateMaxDepth) {
                duplicateMaxDepth = node.depth;
            }
            if(duplicateAtDepth(node.right)!=0) duplicateMaxDepth = duplicateAtDepth(node.right);
            return duplicateMaxDepth;
        }
    }
    
}