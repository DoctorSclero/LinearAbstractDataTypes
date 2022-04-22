package it.iisvittorioveneto.itt.generics.observable.utils;

import iis.itt.as2021.ObjectCloner;

public class TemplateNode<T> {
    protected TemplateNode<T> next;
    protected T object;

    public TemplateNode(T object, TemplateNode<T> next) {
        if (object == null) throw new NullPointerException("Object cannot be null");

        this.object = (T)ObjectCloner.deepCopy(object);
        this.next = next;
    }

    public TemplateNode(T object) {
        this(object, null);
    }

    public TemplateNode(TemplateNode<T> node) {
        this(node.object, node.next);
    }

    public TemplateNode<T> getNext() {
        return next;
    }

    public void setNext(TemplateNode<T> next) {
        this.next = next;
    }

    public T getObject() {
        return (T) ObjectCloner.deepCopy(this.object);
    }

    public void setObject(T object) {
        this.object = (T) ObjectCloner.deepCopy(object);
    }

    @Override
    public String toString() {
        return "Node{" +
                "next=" + next +
                ", object=" + object +
                '}';
    }
}