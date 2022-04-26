package it.iisvittorioveneto.itt.nongenerics.stack;

import iis.itt.as2021.ObjectCloner;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.Arrays;

/**
 * A vector based implementation of the
 * Stack structure.
 * @author Pietro Ballarin
 */

public class StackV implements Stack {


    public static final int DEFAULT_LENGTH = 100;
    protected Object[]  stack;
    protected int       head;

    //****************************************************
    //**                   Constructors                 **
    //****************************************************

    /**
     * This constructor initializes a new
     * vector based stack with the default
     * length.
     */
    public StackV() {
        this(DEFAULT_LENGTH);
    }

    /**
     * This constructor initializes a new
     * vector based stack with the specified
     * length.
     * @param length The length of the stack
     */
    public StackV(int length) {
        this.stack = new Object[length];
    }

    /**
     * This constructor initializes a new
     * list based stack by copying the
     * content of another stack.
     * @param stack The stack to copy
     */
    public StackV(Stack stack) {
        Object[] buffer;

        buffer = new Object[stack.size()];
        for (int i = stack.size()-1; i >= 0; i--) {
            buffer[i] = this.pop();
        }
        for (int i = 0; i < stack.size(); i++) {
            this.push(buffer[i]);
        }
    }

    //******************************************************
    //**            Stack Methods Implementation          **
    //******************************************************

    /**
     * This method adds an object to the stack.
     * @param obj The object to add to the stack
     */
    @Override
    public void push(Object obj) {
        if (obj == null) throw new NullPointerException("Object cannot be null");
        if (this.isFull()) throw new IndexOutOfBoundsException("Stack is full");
        this.stack[head++] = ObjectCloner.deepCopy(obj);
    }

    /**
     * This method removes an object from the stack and returns it
     * @return The removed object
     */
    @Override
    public Object pop() {
        Object res = this.top();
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
    public Object top() {
        if (this.isEmpty()) throw new IndexOutOfBoundsException("Stack is empty");
        return ObjectCloner.deepCopy(this.stack[head-1]);
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
