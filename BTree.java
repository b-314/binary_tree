//Create Arraylist of numbers (user input)
//Iterate through the Arraylist and place values into the Binary Tree
//Print Tree

import java.util.*;
import java.io.*;

public class BTree {
    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        ArrayList<Integer> list = new ArrayList<Integer> ();
        BList tree = new BList();
        boolean quit = false;
        while(!quit) {
            System.out.println("Input an integer value or type Q to quit.");
            String input = kb.nextLine();
            if(input.equals("Q")) quit=true;
            else list.add(Integer.parseInt(input));
        }
        
        for(int i=0; i<list.size(); i++) {
            tree.addNode(list.get(i));
        }
        System.out.print("\nThe tree is: ");
        tree.show(tree.root);
        
        BListDepth treeDepth = new BListDepth();
        for(int i=0; i<list.size(); i++) {
            treeDepth.addNode(list.get(i));
        }
        System.out.println("\nThe tree with depth is:\n" + treeDepth.toString(treeDepth.root));
        System.out.println("The maximum depth is: " + treeDepth.maxDepth(treeDepth.root));
        System.out.println("The IPL is: " + treeDepth.calcIPL(treeDepth.root));
        System.out.println("The EPL is: " + treeDepth.calcEPL(treeDepth.root));
        System.out.println("\nInput a number for depth");
        int depth = kb.nextInt();
        System.out.println(treeDepth.nodesAtDepth(treeDepth.root, depth));

    }
}