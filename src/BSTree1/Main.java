/*
 * Copyright(C) 2021 ,FPT UNIVERSITY
 * 
 * DATE        Version         Author          DESCRIPTION
 * 15/08/2021    1.0            Vanhv   
 */
package BSTree1;

/**
 *
 * @author vanhv
 */
public class Main {

    public static void main(String[] args) {
        int[] a = {6, 2, 7, 1, 3, 5, 4};
        BSTree t = new BSTree();

        t.insertMany(a);
        System.out.println("1. Breath first traversal");
        t.breath(t.root);

        System.out.println("2. Pre-order traversal");
        t.preOrder(t.root);
        System.out.println();

        System.out.println("2. In-order traversal");
        t.inOrder(t.root);
        System.out.println();

        System.out.println("2. Post-order traversal");
        t.postOrder(t.root);
        System.out.println();

    }
}
