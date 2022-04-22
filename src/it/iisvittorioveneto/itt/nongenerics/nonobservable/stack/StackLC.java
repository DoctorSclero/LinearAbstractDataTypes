package it.iisvittorioveneto.itt.nongenerics.nonobservable.stack;


import it.iisvittorioveneto.itt.nongenerics.nonobservable.utils.Node;

public class StackLC implements Stack {

    Node head;
    int size;

    /**
     * This constructor initializes a new
     * list based stack with no elements.
     */
    public StackLC() {
        this.head = null;
        this.size = 0;
    }

    /**
     * This constructor initializes a new
     * list based stack with one initial
     * element
     * @param object The first element
     */
    public StackLC(Object object) {
        this();
        this.push(object);
    }

    /**
     * This constructor initializes a new
     * list based stack by copying the
     * content of another stack.
     * @param stack The stack to copy
     */
    public StackLC(Stack stack) {
        Object[] buffer;

        buffer = new Object[stack.size()];
        for (int i = stack.size()-1; i >= 0; i--) {
            buffer[i] = this.pop();
        }
        for (int i = 0; i < stack.size(); i++) {
            this.push(buffer[i]);
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
    public void push(Object obj) {
        this.head = new Node(obj, this.head);
        this.size++;
    }

    /**
     * This method removes an object from the stack and returns it
     *
     * @return The removed object
     */
    @Override
    public Object pop() {
        if (this.isEmpty()) throw new IndexOutOfBoundsException();

        Object res = this.head.getObject();
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
    public Object top() {
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
