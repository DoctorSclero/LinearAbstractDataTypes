package it.iisvittorioveneto.itt.generics.observable.stack;


import it.iisvittorioveneto.itt.generics.observable.utils.TemplateNode;

import java.util.ArrayList;

public class ObservableStackLCT<T> implements StackT<T> {

    TemplateNode<T> head;
    int size;

    /**
     * This constructor initializes a new
     * list based stack with no elements.
     */
    public ObservableStackLCT() {
        this.head = null;
        this.size = 0;
    }

    /**
     * This constructor initializes a new
     * list based stack with one initial
     * element
     * @param object The first element
     */
    public ObservableStackLCT(T object) {
        this();
        this.push(object);
    }

    /**
     * This constructor initializes a new
     * list based stack by copying the
     * content of another stack.
     * @param stack The stack to copy
     */
    public ObservableStackLCT(StackT<T> stack) {
        Object[] buffer;

        buffer = new Object[stack.size()];
        for (int i = stack.size()-1; i >= 0; i--) {
            buffer[i] = this.pop();
        }
        for (int i = 0; i < stack.size(); i++) {
            this.push((T) buffer[i]);
        }
    }

    /**
     * This method returns the size of the stack
     *
     * @return The stack size
     */
    @Override
    public int size() {
        return this.size;
    }

    /**
     * This method clears out the stack by removing all the elements
     */
    @Override
    public void flush() {
        this.head = null;
        this.size = 0;
    }

    /**
     * This method adds an object to the stack.
     *
     * @param obj The object to add to the stack
     */
    @Override
    public void push(T obj) {
        this.head = new TemplateNode<>(obj, this.head);
        this.size++;
        ArrayList<Object> buffer = new ArrayList<>();
    }

    /**
     * This method removes an object from the stack and returns it
     *
     * @return The removed object
     */
    @Override
    public T pop() {
        if (this.isEmpty()) throw new IndexOutOfBoundsException();

        T res = this.head.getObject();
        this.head = this.head.getNext();
        this.size--;
        return res;
    }

    /**
     * This method returns the object in the top of the stack
     *
     * @return The object in the top of the stack
     */
    @Override
    public T top() {
        return this.head.getObject();
    }

    /**
     * This method returns true if the stack is empty
     *
     * @return (True) If the stack is empty
     */
    @Override
    public boolean isEmpty() {
        return this.head == null;
    }

    /**
     * This method returns true if the stack is empty
     *
     * @return (True) If the stack is empty
     */
    @Override
    public boolean isFull() {
        return false;
    }

    /**
     * String representation of the class
     * @return String representation of the class
     */
    @Override
    public String toString() {
        return "StackLC{" +
                "head=" + head +
                ", size=" + size +
                '}';
    }
}
