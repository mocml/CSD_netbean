package LinkedList_2;

public class MyList {

    Node head, tail;

    MyList() {
        head = tail = null;
    }

    boolean isEmpty() {
        return (head == null);
    }

    void clear() {
        head = tail = null;
    }

    // (1) 
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
            System.out.print(p.info);
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

    void addMany(String[] a, int[] b) {
        int n, i;
        n = a.length;
        for (i = 0; i < n; i++) {
            addLast(new Person(a[i], b[i]));
        }
    }

    // (2)
    Node searchByName(String xName) {
        Node p = head;
        while (p != null) {
            if (p.info.name.equals(xName)) {
                return (p);
            }
            p = p.next;
        }
        return (null);
    }

    Node searchByAge(int age) {
        Node p = head;
        while (p != null) {
            if (p.info.age == (age)) {
                return (p);
            }
            p = p.next;
        }
        return (null);
    }

    void searchAllAge(int age) {
        Node p = head;
        while (p != null) {
            if (p.info.age == age) {
                visit(p);
            }
            p = p.next;
        }
    }

    // (3)
    void addFirst(Person x) {
        head = new Node(x, head);
        if (tail == null) {
            tail = head;
        }
    }

    // (4)
    void insertAfter(Node q, Person x) {
        if (q == null) {
            return;
        }
        Node qNext = q.next;
        Node pNew = new Node(x, qNext);
        q.next = pNew;
        if (tail == q) {
            tail = pNew;
        }
    }

    // (5)
    void insertBefore(Node q, Person person) {
        if (q == null) {
            return;
        }
        if (q == head) {
            addFirst(person);
            return;
        }
        //Tạo 1 node F = head để check từ đầu đến node q nếu 
        // Nếu tìm thấy node q thì lấy ra node f.next(q.prev) để add after
        Node f = head;
        //Nếu node f != null và F.NEXT != Q thì tiếp tục next 
        while (f != null && f.next != q) {
            f = f.next;
        }
        //khi f not found q break;
        if (f == null) {
            return;
        }
        //Nếu đúng thì add to after q by f.next
        insertAfter(f, person);
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
        //Nếu node f != null và F.NEXT != Q thì tiếp tục next 
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
                if (pi.info.name.compareTo(pj.info.name) > 0) {
                    x = pj.info;
                    pj.info = pi.info;
                    pi.info = x;
                }
            }
        }
    }
//sort 3 first element 

    public void sortThird() {
        Node pi, pj;
        pi = head;
        int count = 0;
        while (pi != null) {
            count++;
            pj = pi.next;
            int count1 = 0;
            while (pj != null) {
                count1++;
                if (pi.info.name.compareToIgnoreCase(pj.info.name) < 0) {
                    Person t = pi.info;
                    pi.info = pj.info;
                    pj.info = t;
                }
                pj = pj.next;
                if (count1 == 3 - count) {
                    break;
                }
            }
            pi = pi.next;
            if (count == 2) {
                break;
            }
        }
    }

    // (13)
    void sortByAge() {
        Node pi, pj;
        Person x;
        for (pi = head; pi != null; pi = pi.next) {
            for (pj = pi.next; pj != null; pj = pj.next) {
                if (pi.info.age > pj.info.age) {
                    x = pj.info;
                    pj.info = pi.info;
                    pi.info = x;
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
            a[i++] = new Person(p.info.name, p.info.age);
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
            h.addFirst(new Person(p.info.name, p.info.age));
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
        x = p.info.age;
        p = p.next;
        while (p != null) {
            if (p.info.age > x) {
                q = p;
                x = p.info.age;
            }
            p = p.next;
        }
        return (q);
    }

    // (18) 
    Node findMinAge() {
        if (isEmpty()) {
            return null;
        }
        Node q = null;
        Node p = head;
        int x;
        x = p.info.age;
        p = p.next;
        while (p != null) {
            if (p.info.age < x) {
                q = p;
                x = p.info.age;
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
        p.info = x;
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
                if (pi.info.age > pj.info.age) {
                    x = pj.info;
                    pj.info = pi.info;
                    pi.info = x;
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
