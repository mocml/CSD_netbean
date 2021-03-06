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
public class MyList {

    Node head, tail;

    public MyList() {
        head = tail = null;
    }

    boolean isEmpty() {
        return head == null;
    }

    void clear() {
        head = tail = null;
    }

//Add all person by person of list to last
    void addLast(Person x) {
        //initialization the object of Note
        Node q = new Node(x);
        // if node empty head = tail = new Node
        if (isEmpty()) {
            head = tail = q;
            return;
        }
        //else tail.next = new Node
        //tail = new Node
        tail.next = q;
        tail = q;
    }

    void searchAllAge(int age) {
        Node p = head;
        while (p != null) {
            if (p.person.age == age) {
                visit(p);
            }
            p = p.next;
        }
    }

    //if Node exist object p , print p
    void visit(Node p) {
        if (p != null) {
            System.out.println(p.person);
        }
    }

    void traverse() {
        //Node p = head, run to index 0 , and visit while Node at index+1 != null
        Node p = head;
        while (p != null) {
            visit(p);
            p = p.next;
        }
        System.out.println();
    }

    //Add all person by add last
    void addMany(String[] name, int[] age, boolean[] gender, String[] address, String[] phone) {
        int n = name.length;
        for (int i = 0; i < n; i++) {
            addLast(new Person(name[i], age[i], gender[i % 2], address[i], phone[i]));
        }
    }

    Node searchByName(String name) {
        Node p = head;
        while (p != null) {
            if (p.person.name.equals(name)) {
                return p;
            }
            p = p.next;
        }
        return null;
    }

    Node searchByAge(int age) {
        Node p = head;
        while (p != null) {
            if (p.person.age == age) {
                return p;
            }
            p = p.next;
        }
        return null;
    }
//Add first

    /**
     * <code> vai tr?? c???a head trong new Node ??</code>
     *
     * @param person
     */
    //sau khi traverse th?? kh???i t???o 1 th???ng Node(person , head) next -->> head
    //t???o 1 node m???i n???i v??o head, ?????ng th???i tr??? head v??o node m???i
    void addFirst(Person person) {
        Node q = new Node(person, head);
        head = q;
        //
        if (tail == null) {
            tail = head;
        }
    }
//insert After

    void insertAfter(Node q, Person person) {
        if (q == null) {
            return;
        }
        Node qNext = q.next;
        Node pNew = new Node(person, qNext);
        q.next = pNew;
        if (tail == q) {
            tail = pNew;
        }
    }

    /**
     *
     * @param q Node search to add
     * @param person
     */
    void insertBefore(Node q, Person person) {
        if (q == null) {
            return;
        }
        if (q == head) {
            addFirst(person);
            return;
        }
        //T???o 1 node find = head ????? check t??? ?????u ?????n node q n???u 
        //N???u t??m th???y node q th?? l???y ra node find.next(q.prev) ????? add after
        Node find = head;
        //N???u node find != null v?? F.NEXT != Q th?? ti???p t???c next 
        while (find != null && find.next != q) {
            find = find.next;
        }
        //khi find not found q break;
        if (find == null) {
            return;
        }
        //N???u ????ng th?? add to after q by find = find.next
        insertAfter(find, person);
    }

    void removeFirst() {
        if (isEmpty()) {
            return;
        }
        head = head.next;
        if (head == null) {
            tail = null;
        }
    }

    // (6)
    void remove(Node q) {
        if (q == null) {
            return;
        }
        if (q == head) {
            removeFirst();
            return;
        }
        Node f = head;
        //N???u node f != null v?? F.NEXT != Q th?? ti???p t???c next 
        while (f != null && f.next != q) {
            f = f.next;
        }
        //khi f not found q break;
        if (f == null) {
            return;
        }
        Node q1 = q.next;
        f.next = q1;
        if (f.next == null) {
            tail = f;
        }
    }

    // (7)
    void remove(String xName) {
        Node q = searchByName(xName);
        remove(q);
    }

    // (8)
    void remove(int xAge) {
        Node q = searchByAge(xAge);
        remove(q);
    }

    // (9)
    void removeAll(int xAge) {
        Node q;
        while (true) {
            q = searchByAge(xAge);
            if (q == null) {
                break;
            }
            remove(q);
        }
    }

    // (10)
    Node pos(int k) {
        int i = 0;
        Node p = head;
        while (p != null) {
            if (i == k) {
                return p;
            }
            p = p.next;
            i++;
        }
        return (null);
    }

    // (11)
    void removePos(int k) {
        Node q = pos(k);
        remove(q);
    }

    // (12)
    void sortByName() {
        Node pi, pj;
        Person x;
        for (pi = head; pi != null; pi = pi.next) {
            for (pj = pi.next; pj != null; pj = pj.next) {
                if (pi.person.name.compareTo(pj.person.name) > 0) {
                    x = pj.person;
                    pj.person = pi.person;
                    pi.person = x;
                }
            }
        }
    }

    // (13)
    void sortByAge() {
        Node pi, pj;
        Person x;
        for (pi = head; pi != null; pi = pi.next) {
            for (pj = pi.next; pj != null; pj = pj.next) {
                if (pi.person.age > pj.person.age) {
                    x = pj.person;
                    pj.person = pi.person;
                    pi.person = x;
                }
            }
        }
    }

    // (14)
    int size() {
        int i = 0;
        Node p = head;
        while (p != null) {
            i++;
            p = p.next;
        }
        return (i);
    }

    // (15)
    Person[] toArray() {
        int n, i;
        n = size();
        Person[] a = new Person[n];
        Node p = head;
        i = 0;
        while (p != null) {
            a[i++] = new Person(p.person.name, p.person.age);
            p = p.next;
        }
        return (a);
    }

    // (16)
    //Last in -first out , first out - first in
    void reverse() {
        MyList h = new MyList();
        Node p = head;
        while (p != null) {
            h.addFirst(new Person(p.person.name, p.person.age));
            p = p.next;
        }
        head = h.head;
        tail = h.tail;
    }

    // (17) 
    Node findMaxAge() {
        if (isEmpty()) {
            return null;
        }
        Node q = null;
        Node p = head;
        int x;
        x = p.person.age;
        p = p.next;
        while (p != null) {
            if (p.person.age > x) {
                q = p;
                x = p.person.age;
            }
            p = p.next;
        }
        return (q);
    }

    // (18) 
    Node findMinAge() {
        if (isEmpty()) {
            System.out.println("NULL");
            return null;
        }
        Node q = null;
        Node p = head;
        int x;
        x = p.person.age;
        p = p.next;
        while (p != null) {
            if (p.person.age < x) {
                q = p;
                x = p.person.age;
            }
            p = p.next;
        }
        return (q);
    }

    // (19) 
    void setData(Node p, Person x) {
        if (p == null) {
            return;
        }
        p.person = x;
    }

    // (20) 
    void sortByAge(int k, int h) {
        int n = size();
        if (k >= h) {
            return;
        }
        if (k < 0) {
            k = 0;
        }
        if (h > n - 1) {
            h = n - 1;
        }
        Node pi, pj;
        Person x;
        Node u = pos(k);
        Node v = pos(h + 1);
        for (pi = u; pi != v; pi = pi.next) {
            for (pj = pi.next; pj != v; pj = pj.next) {
                if (pi.person.age > pj.person.age) {
                    x = pj.person;
                    pj.person = pi.person;
                    pi.person = x;
                }
            }
        }
    }

    // (21) 
    void reverse(int k, int h) // reverse from k to h 
    {
        int n = size();
        if (k >= h) {
            return;
        }
        if (k < 0) {
            return;
        }
        if (h > n - 1) {
            return;
        }
        Person[] a = toArray();
        int i, j;
        Person x;
        i = k;
        j = h;
        while (i < j) {
            x = a[i];
            a[i] = a[j];
            a[j] = x;
            i++;
            j--;
        }
        clear();
        for (i = 0; i < n; i++) {
            addLast(a[i]);
        }
    }
}
