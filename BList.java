//repository

public class BList {
    public BNode root; 
    public BList () {
        root = null;
    }
    
    public void addRoot (int value) {
        BNode newHead = new BNode(value);
        root = newHead;
    }
    
    public void addNode (int value) {
        if(root==null) addRoot(value);
        else {
            BNode newNode = new BNode(value);
            BNode current = root; 
            boolean placed = false;
            while(!placed) {
                if(newNode.value<=current.value) {
                    if(current.left==null) {
                        current.left = newNode;
                        placed = true;
                    }
                    else current = current.left;
                }
                else {
                    if(current.right==null) {
                        current.right = newNode;
                        placed = true;
                    }
                    else current = current.right;
                }
            }    
        }
    }
    
    public void show(BNode node) { 
        if(node.left!=null) show(node.left);
        System.out.print(node.value + " ");
        if(node.right!=null) show(node.right);
    }
    
}