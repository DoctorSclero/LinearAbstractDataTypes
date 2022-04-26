package it.iisvittorioveneto.itt.nongenerics.utils;

import iis.itt.as2021.ObjectCloner;

public class Node {
    protected Node next;
    protected Object object;

    public Node(Object object, Node next) {
        if (object == null) throw new NullPointerException("Object cannot be null");

        this.object = ObjectCloner.deepCopy(object);
        this.next = next;
    }

    public Node(Object object) {
        this(object, null);
    }

    public Node(Node node) {
        this(node.object, node.next);
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public Object getObject() {
        return ObjectCloner.deepCopy(this.object);
    }

    public void setObject(Object object) {
        this.object = ObjectCloner.deepCopy(object);
    }

    @Override
    public String toString() {
        return "Node{" +
                "next=" + next +
                ", object=" + object +
                '}';
    }
}