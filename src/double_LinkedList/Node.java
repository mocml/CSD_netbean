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
public class Node {

    Person info;
    Node prev, next;

    Node() {
    }

    Node(Person person) {
        this(person, null, null);
    }

    Node(Person info, Node prev, Node next) {
        this.info= info;
        this.prev = prev;
        this.next = next;
    }

}
