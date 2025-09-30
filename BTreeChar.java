import java.util.Scanner;

public class BTreeChar {
    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        BListChar charTree = new BListChar();
        System.out.println("Input a word");
        String word = kb.nextLine();
        
        for(int i=0; i<word.length(); i++) {
            charTree.addNode(word.charAt(i));
        }
        
        System.out.println("\n" + charTree.toString(charTree.root));
        System.out.println("\nNodes with 1 child: ");
        charTree.show1Child(charTree.root);
        System.out.println("\nNumber of empties: " + charTree.countNulls(charTree.root));
        if(charTree.duplicateAtDepth(charTree.root)!=0)
            System.out.println("\nDuplicate at depth: "+ charTree.duplicateAtDepth(charTree.root));
        else System.out.println("\nNO DUPLICATES");
        
        
    }
}