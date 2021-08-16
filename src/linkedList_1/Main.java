/*
 * Copyright(C) 2021 ,FPT UNIVERSITY
 * 
 * DATE        Version         Author          DESCRIPTION
 * 09/08/2021    1.0            Vanhv   
 */
package linkedList_1;

/**
 *
 * @author vanhv
 */
public class Main {

    public static void main(String[] args) {
        MyList m = new MyList();
        Node p, q;
        Person x;
        int k;
        String[] name = {"Van", "Van 1", "Van 2", "Van 3", "Van 4", "Van 5"};
        int[] age = {1, 2, 3, 4, 5, 6};
        boolean[] gender = {true, false};
        String[] address = {"HN", "HP", "QN", "HD", "BN", "NB"};
        String[] phone = {"+84121212", "3434234", "2342343", "23124", "1312312", "31634978"};
//Add Last
        System.out.println("\n.Add Last");
        m.clear();
        m.addMany(name, age, gender, address, phone);
        m.traverse();

//Search 
        //search
        System.out.println("\n.Search By Name");
        m.clear();
        m.addMany(name, age, gender, address, phone);
        m.traverse();
        p = m.searchByName("Van 2");
        if (p == null) {
            System.out.println("Not found");
        } else {
            System.out.println("The person is ");
            m.visit(p);
            System.out.println();
        }
        //age
        System.out.println("\n.Search By Age");
        m.clear();
        m.addMany(name, age, gender, address, phone);
        m.traverse();
        p = m.searchByAge(5);
        if (p == null) {
            System.out.println("Not found");
        } else {
            System.out.println("The person is ");
            m.visit(p);
            System.out.println();
        }

        System.out.println("\n3. Test addFirst");
        m.clear();
        m.addMany(name, age, gender, address, phone);
        m.traverse(); //  (A,9) (C,5) (B,17) (E,5) (D,8)
        x = new Person("X", 30, true, "HN", "+832132");
        m.addFirst(x);
        m.traverse(); // (X,30) (A,9) (C,5) (B,17) (E,5) (D,8)

        System.out.println("\n4. Test insertAfter");
        m.clear();
        m.addMany(name, age, gender, address, phone);
        m.traverse(); // (A,9) (C,5) (B,17) (E,5) (D,8)
        x = new Person("X", 30, true, "HN", "+832132");
        q = m.searchByName("Van 2");
        m.insertAfter(q, x);
        m.traverse(); // (A,9) (C,5) (B,17) (X,30) (E,5) (D,8)

        System.out.println("\n5. Test insertBefore");
        m.clear();
        m.addMany(name, age, gender, address, phone);
        m.traverse(); // (A,9) (C,5) (B,17) (E,5) (D,8)
        x = new Person("X", 30, true, "HN", "+832132");
        q = m.searchByName("Van 2");
        m.insertBefore(q, x);
        m.traverse(); // (A,9) (C,5) (X,30) (B,17) (E,5) (D,8)

        System.out.println("\n6. Test remove(Node q)");
        m.clear();
        m.addMany(name, age, gender, address, phone);
        m.traverse(); // (A,9) (C,5) (B,17) (E,5) (D,8)
        q = m.searchByName("Van 2");
        m.remove(q);
        m.traverse(); // (A,9) (C,5) (E,5) (D,8)

        System.out.println("\n7. Test remove(String xName)");
        m.clear();
        m.addMany(name, age, gender, address, phone);
        m.traverse(); // (A,9) (C,5) (B,17) (E,5) (D,8)
        m.remove("Van 3");
        m.traverse(); // (A,9) (C,5) (E,5) (D,8)

        System.out.println("\n8. Test remove(int xAge)");
        m.clear();
        m.addMany(name, age, gender, address, phone);
        m.traverse(); // (A,9) (C,5) (B,17) (E,5) (D,8)
        m.remove(5);
        m.traverse(); // (A,9) (B,17) (E,5) (D,8)

        System.out.println("\n9. Test removeAll(int xAge)");
        m.clear();
        m.addMany(name, age, gender, address, phone);
        m.traverse(); // (A,9) (C,5) (B,17) (E,5) (D,8)
        m.removeAll(5);
        m.traverse(); // (A,9) (B,17) (D,8)

        System.out.println("\n10. Test pos(int k)");
        m.clear();
        m.addMany(name, age, gender, address, phone);
        m.traverse(); // (A,9) (C,5) (B,17) (E,5) (D,8)
        p = m.pos(2);
        System.out.println("The person at position 2 is ");
        m.visit(p); // The person at position 2 is  (B,17)
        System.out.println();

        System.out.println("\n11. Test removePos(int k)");
        m.clear();
        m.addMany(name, age, gender, address, phone);
        m.traverse(); // (A,9) (C,5) (B,17) (E,5) (D,8)
        m.removePos(2);
        m.traverse(); // (A,9) (C,5) (E,5) (D,8)

        System.out.println("\n12. Test sortByName()");
        m.clear();
        m.addMany(name, age, gender, address, phone);
        m.traverse(); // (A,9) (C,5) (B,17) (E,5) (D,8)
        m.sortByName();
        m.traverse(); // (A,9) (B,17) (C,5) (D,8) (E,5)

        System.out.println("\n13. Test sortByAge()");
        m.clear();
        m.addMany(name, age, gender, address, phone);
        m.traverse(); // (A,9) (C,5) (B,17) (E,5) (D,8)
        m.sortByAge();
        m.traverse(); // (C,5) (E,5) (D,8) (A,9) (B,17)

        System.out.println("\n14. Test size()");
        m.clear();
        m.addMany(name, age, gender, address, phone);
        m.traverse(); // (A,9) (C,5) (B,17) (E,5) (D,8)
        k = m.size();
        System.out.println("Size = " + k);

        System.out.println("\n15. Test toArray()");
        m.clear();
        m.addMany(name, age, gender, address, phone);
        m.traverse(); // (A,9) (C,5) (B,17) (E,5) (D,8)
        Person[] u = m.toArray();
        if (u != null) {
            for (Person u1 : u) {
                System.out.print(u1); // (A,9) (C,5) (B,17) (E,5) (D,8)
            }
            System.out.println();
        }

        System.out.println("\n16. Test reverse()");
        m.clear();
        m.addMany(name, age, gender, address, phone);
        m.traverse(); // (A,9) (C,5) (B,17) (E,5) (D,8)
        m.reverse();
        m.traverse(); // (D,8) (E,5) (B,17) (C,5) (A,9)

        System.out.println("\n17. Test findMaxAge()");
        m.clear();
        m.addMany(name, age, gender, address, phone);
        m.traverse(); // (A,9) (C,5) (B,17) (E,5) (D,8)
        p = m.findMaxAge();
        System.out.println("The person with maximum age:");
        m.visit(p);
        System.out.println();

        System.out.println("\n18. Test findMinAge()");
        m.clear();
        m.addMany(name, age, gender, address, phone);
        m.traverse(); // (A,9) (C,5) (B,17) (E,5) (D,8)
        p = m.findMinAge();
        System.out.println("The person with minimum age:");
        m.visit(p);
        System.out.println();

        System.out.println("\n19. Test setData()");
        m.clear();
        m.addMany(name, age, gender, address, phone);
        m.traverse(); // (A,9) (C,5) (B,17) (E,5) (D,8)
        p= m.searchByName("Van 2");
        x = new Person("X", 30, true, "HN", "+832132");
        m.setData(p, x);
        m.traverse(); // (D,8) (E,5) (XX,99) (C,5) (A,9)

        String[] c = {"A", "B", "C", "D", "E", "F", "G", "H", "I"};
        int[] d = {9, 8, 7, 6, 15, 4, 3, 2, 1};
        System.out.println("\n20. Test sortByAge(3, 6)");
        m.clear();
        m.addMany(name, age, gender, address, phone);
        m.traverse(); // (A,9) (B,8) (C,7) (D,6) (E,15) (F,4) (G,3) (H,2) (I,1)
        m.sortByAge(3, 6);
        m.traverse(); // (A,9) (B,8) (C,7) (G,3) (F,4) (D,6) (E,15) (H,2) (I,1) 

        System.out.println("\n21. Test reverse(3, 6)");
        m.clear();
        m.addMany(name, age, gender, address, phone);
        m.traverse(); // (A,9) (B,8) (C,7) (D,6) (E,15) (F,4) (G,3) (H,2) (I,1)
        m.reverse(3, 6);
        m.traverse(); // (A,9) (B,8) (C,7) (G,3) (F,4) (E,15) (D,6) (H,2) (I,1) 

        System.out.println();
    }
}
