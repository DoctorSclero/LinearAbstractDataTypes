package it.iisvittorioveneto.itt.generics.stack;

import iis.itt.as2021.ObjectCloner;

import java.util.Arrays;

/**
 * ! ATTENZIONE !
 * La classe StackVT ha problemi con i Generics.
 */

/**
 * A vector based implementation of the
 * Stack structure.
 * @author Pietro Ballarin
 */

public class StackVT<T> implements StackT<T> {

    public static final int DEFAULT_LENGTH = 100;
    protected Object[]  stack;
    protected int       head;


    public StackVT() {
        this(DEFAULT_LENGTH);
    }

    public StackVT(int length) {
        this.stack = new Object[length];
    }

    /**
     * This constructor initializes a new
     * list based stack by copying the
     * content of another stack.
     * @param stack The stack to copy
     */
    public StackVT(StackT<T> stack) {
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
     * This method adds an object to the stack.
     * @param obj The object to add to the stack
     */
    @Override
    public void push(T obj) {
        if (obj == null) throw new NullPointerException("Object cannot be null");
        if (this.isFull()) throw new IndexOutOfBoundsException("Stack is full");
        this.stack[head++] = ObjectCloner.deepCopy(obj);
    }

    /**
     * This method removes an object from the stack and returns it
     * @return The removed object
     */
    @Override
    public T pop() {
        T res = this.top();
        this.stack[--head] = null;
        return res;
    }

    /**
     * This method clears out the stack by removing all the elements
     */
    @Override
    public void flush() {
        while (this.head != 0) { this.stack[--head] = null; }
    }

    /**
     * This method returns the object in the top of the stack
     * @return The object in the top of the stack
     */
    @Override
    public T top() {
        if (this.isEmpty()) throw new IndexOutOfBoundsException("Stack is empty");
        return (T) ObjectCloner.deepCopy(this.stack[head-1]);
    }

    /**
     * This method returns the max quantity of Objects that
     * the stack is able to store.
     * @return The max quantity of items
     */
    public int maxSize() {
        return this.stack.length;
    }

    /**
     * This method returns the size of the stack
     * @return The stack size
     */
    @Override
    public int size() {
        return head;
    }

    /**
     * This method returns true if the stack is empty
     * @return (True) If the stack is empty
     */
    @Override
    public boolean isEmpty() {
        return (this.head == 0);
    }
    /**
     * This method returns true if the stack is full
     * @return (True) If the stack is full
     */
    @Override
    public boolean isFull() {
        return (this.head == this.stack.length);
    }


    /**
     * String representation of the class
     * @return String representation of the class
     */
    @Override
    public String toString() {
        return "StackV{" +
                "stack=" + Arrays.toString(stack) +
                ", head=" + head +
                '}';
    }
}
