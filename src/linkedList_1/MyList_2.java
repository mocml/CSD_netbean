/*
 * Copyright(C) 2021 ,FPT UNIVERSITY
 * 
 * DATE        Version         Author          DESCRIPTION
 * 10/08/2021    1.0            Vanhv   
 */
package linkedList_1;

/**
 *
 * @author vanhv
 */
public class MyList_2 {

    Node head, tail;

    public MyList_2() {
        head = tail = null;
    }

    boolean isEmpty() {
        return head == null;
    }

    void clear() {
        head = tail = null;
    }

    void addLast(Person x) {
        Node q = new Node(x);
        if (isEmpty()) {
            head = tail = q;
            return;
        }

        tail.next = q;
        tail = q;
    }

    void visit(Node p) {
        if (p != null) {
            System.out.println(p.person);
        }
    }

    void traverse() {
        Node p = head;
        while (p != null) {
            visit(p);
            p = p.next;
        }
        System.out.println();
    }

    void addMany(String[] name, int[] age, boolean[] gender, String[] address, String[] phone) {
        int n = name.length;
        for (int i = 0; i < n; i++) {
            addLast(new Person(name[i], age[i], gender[i % 2], address[i], phone[i]));
        }
    }

    void addFirst(Person x) {
        Node pNew = new Node(x, head);
        head = pNew;
        if (tail == null) {
            tail = head;
        }
    }
    void insertAfter(Node q,Person x){
        if(q==null){
            return;
        }
        Node qNext = q.next;
        Node pNew = new Node(x, qNext);
        q.next = pNew;
        if(tail ==q){
            tail = pNew;
        }
    }
}
