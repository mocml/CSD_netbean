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
public class MyList {

    Node head, tail;

    MyList() {
        head = tail = null;
    }

    boolean isEmpty() {
        return head == null;
    }

    void clear() {
        head = tail = null;
    }

    void addLast(Person x) {
        if (isEmpty()) {
            head = tail = new Node(x);;
            return;
        }
        Node q = new Node(x, tail, null);
        tail.next = q;
        tail = q;
    }

    void visit(Node p) {
        System.out.println(p.info);
    }

    void traverse() {
        Node p = head;
        System.out.println("Name      Age   Gender  Address  Phone");
        while (p != null) {
            visit(p);
            p = p.next;
        }
        System.out.println();
    }

    void addFirst(Person x) {
        Node p = new Node(x);
        p.next = head;
        p.prev = null;
        if (head != null) {
            head.prev = p;
        }
        head = p;
    }

    Node searchByName(String name) {
        Node p = head;
        while (p != null) {
            if (p.info.name.equals(name)) {
                return p;
            }
            p = p.next;
        }
        return null;
    }

    void addAfter(Node nPrev, Person x) {
        if (nPrev == null) {
            return;
        }
        Node newQ = new Node(x);
        newQ.next = nPrev.next;
        nPrev.next = newQ;
        newQ.prev = nPrev;
        if (newQ.next != null) {
            newQ.next.prev = newQ;
        }
    }

    void addMany(String[] name, int[] age, boolean[] gender, String[] address, String[] phone) {
        int n = name.length;
        for (int i = 0; i < n; i++) {
            addLast(new Person(name[i], age[i], gender[i % 2], address[i], phone[i]));
        }
    }
}
