public class BListDepth {
    public BNodeDepth root;
    public int maxDepth; 
    public BListDepth () {
        root = null;
    }
    
    public void addRoot (int value) {
        BNodeDepth newHead = new BNodeDepth(value, 0);
        root = newHead;
    }
    
    public void addNode (int value) {
        if(root==null) addRoot(value);
        else {
            BNodeDepth current = root;
            boolean placed = false;
            while(!placed) {
                if(value<=current.value) {
                    if(current.left==null) {
                        BNodeDepth newNode = new BNodeDepth(value, current.depth + 1);
                        current.left = newNode;
                        placed=true;
                    }
                    else current = current.left;
                }
                else {
                    if(current.right==null) {
                        BNodeDepth newNode = new BNodeDepth(value, current.depth + 1);
                        current.right = newNode;
                        placed = true;
                    }
                    else current = current.right;
                }
            }    
        }
    }
    
    public int maxDepth (BNodeDepth node) {
        if(node.left!=null) maxDepth(node.left);
        if(node.depth>maxDepth) maxDepth = node.depth;
        if(node.right!=null) maxDepth(node.right);
        return maxDepth;
    }
    
    public String nodesAtDepth(BNodeDepth node, int depth) { 
        String nodes = "";
        if(node==null) return "";
        else {
            nodes += nodesAtDepth(node.left, depth);
            if(node.depth==depth) return node.value + " ";
            nodes += nodesAtDepth(node.right, depth);
            if(!nodes.equals("")) return nodes;
            else return "No nodes at that depth";
        }
    }

    public String toString(BNodeDepth node) {
        String tree = "";
        if(node==null) {
            return "";
        }
        else {
            tree += toString(node.left);
            tree += (node.value + " - " + node.depth + "\n");
            tree += toString(node.right);
            return tree;
        }
    }
    
    public int calcIPL (BNodeDepth node) { 
        int IPL = 0;
        if(node==null) return 0;
        else {
            IPL += calcIPL(node.left);
            IPL += node.depth;
            IPL += calcIPL(node.right);
            return IPL;
        }
    }
    
    public int calcEPL (BNodeDepth node) {
        int EPL = 0;
        if(node==null) return 0;
        else {
            EPL += calcEPL(node.left);
            if(node.left==null) EPL += node.depth;
            if(node.right==null) EPL += node.depth;
            EPL += calcEPL(node.right);
            return EPL;
        }
    }

}