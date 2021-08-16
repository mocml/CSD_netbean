/*
 * Copyright(C) 2021 ,FPT UNIVERSITY
 * 
 * DATE        Version         Author          DESCRIPTION
 * 11/08/2021    1.0            Vanhv   
 */
package double_LinkedList;

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

        System.out.println("1__Add Last");
        m.clear();
        m.addMany(name, age, gender, address, phone);
        m.traverse();

        System.out.println("2__Add First");
        m.clear();
        m.addMany(name, age, gender, address, phone);
        x = new Person("qXYZABCp", 7, true, "HCM", "0123123");
        m.addFirst(x);
        m.traverse();

        System.out.println("3__Add After");
        m.clear();
        m.addMany(name, age, gender, address, phone);
        x = new Person("qXYZABCp", 7, true, "HCM", "0123123");
        p = m.searchByName("Van 2");
        m.addAfter(p, x);
        m.traverse();
    }
}
