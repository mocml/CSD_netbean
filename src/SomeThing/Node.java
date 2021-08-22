/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SomeThing;

/**
 *
 * @author vanhv
 */
public class Node {

    Person info; //data of Node
    Node next;

    //create a new Node 
    Node(Person info, Node next) {
        this.info = info;
        this.next = next;
    }

    Node(Person info) {
        this(info, null);
    }
}
