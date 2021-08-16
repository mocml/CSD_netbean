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
class Node {

    Person person;
    Node next;

    Node() {
    }

    Node(Person person) {
        this(person, null);
    }

    Node(Person person, Node next) {
        this.person = person;
        this.next = next;
    }

}
