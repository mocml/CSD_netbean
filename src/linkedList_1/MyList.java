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
     * <code> vai trò của head trong new Node ??</code>
     *
     * @param person
     */
    //sau khi traverse thì khởi tạo 1 thằng Node(person , head) next -->> head
    //tạo 1 node mới nối vào head, đồng thời trỏ head vào node mới
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
        //Tạo 1 node find = head để check từ đầu đến node q nếu 
        //Nếu tìm thấy node q thì lấy ra node find.next(q.prev) để add after
        Node find = head;
        //Nếu node find != null và F.NEXT != Q thì tiếp tục next 
        while (find != null && find.next != q) {
            find = find.next;
        }
        //khi find not found q break;
        if (find == null) {
            return;
        }
        //Nếu đúng thì add to after q by find = find.next
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
        while (f != null && f.next != q) {
            f = f.next;
        }
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
        Node q  = searchByName(xName);
        remove(q);
    }

    // (8)
    void remove(int xAge) {
        Node q = searchByAge(xAge);
        remove(q);
    }

    // (9)
    void removeAll(int xAge) {
    }

    // (10)
    Node pos(int k) {
        return (null);
    }

    // (11)
    void removePos(int k) {
    }

    // (12)
    void sortByName() {
    }

    // (13)
    void sortByAge() {
    }

    // (14)
    int size() {
        return (0);
    }

    // (15)
    Person[] toArray() {
        return (null);
    }

    // (16)
    void reverse() {
    }

    // (17) 
    Node findMaxAge() {
        return (null);
    }

    // (18) 
    Node findMinAge() {
        return (null);
    }

    // (19) 
    void setData(Node p, Person x) {
    }

    // (20) 
    void sortByAge(int k, int h) {
    }

    // (21) 
    void reverse(int k, int h) // reverse from k to h 
    {
    }
}
