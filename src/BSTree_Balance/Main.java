/*
 * Copyright(C) 2021 ,FPT UNIVERSITY
 * 
 * DATE        Version         Author          DESCRIPTION
 * 15/08/2021    1.0            Vanhv   
 */
package BSTree_Balance;

/**
 *
 * @author vanhv
 */
public class Main {
    //SEARCH BY ADDRESS NOT WORK
    public static void main(String[] args) {
        String[] name = {"Van 8", "Van 6", "Van 9", "Van 2", "Van 7", "Van 1", "Van 3", "Van 5", "Van 4"};
        int[] age = {1, 2, 3, 4, 5, 6, 8, 9, 10};
        boolean[] gender = {true, false};
        String[] address = {"HN1", "HP2", "QN3", "HD4", "BN5", "NB6", "NB7", "NB8", "NB"};
        String[] phone = {"+84121212", "3434234", "2342343", "23124", "23124", "23124", "1312312", "31634978", "31634978"};
        BSTree t = new BSTree();
        Person p = new Person("Van 8", 1, true, "HN1", "+84121212");
        t.insertMany(name, age, gender, address, phone);
        System.out.println("1. Breath first traversal");
        t.breath(t.root);
//
//        System.out.println("2. Pre-order traversal");
//        t.preOrder(t.root);
//        System.out.println();
//
//        System.out.println("2. In-order traversal");
//        t.inOrder(t.root);
//        System.out.println();
//
//        System.out.println("2. Post-order traversal");
//        t.postOrder(t.root);
//        System.out.println();
//        System.out.println("3. Delete ");
//        t.deleteByCopy("Van 6");

         t.balance();
        t.breath(t.root);
        
        t.visit(t.search(t.root,p));
    }
}
