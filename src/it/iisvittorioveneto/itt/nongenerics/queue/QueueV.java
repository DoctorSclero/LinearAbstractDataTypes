package it.iisvittorioveneto.itt.nongenerics.queue;


import iis.itt.as2021.ObjectCloner;

import java.util.Arrays;

public class QueueV implements Queue {

    public static final int DEFAULT_LENGTH = 100;

    protected Object[] queue;
    protected int tail;

    /**
     * This constructor initializes a queue
     * with default length
     */
    public QueueV() {
        this.queue = new Object[DEFAULT_LENGTH];
    }

    /**
     * This constructor initializes a queue
     * with the max length passed as parameter
     * @param length Max length of the queue
     */
    public QueueV(int length) {
        this.queue = new Object[length];
        this.tail = 0;
    }

    /**
     * This constructor initializes a queue
     * from another queue by copying its content
     * @param queue The queue to copy
     */
    public QueueV(Queue queue) {
        if (queue == null) throw new NullPointerException("Queue cannot be null");

        queue = (Queue) ObjectCloner.deepCopy(queue);

        if (queue instanceof QueueVC queueVC) {
            for (int i = 0; i < queue.size(); i++) {
                this.enQueue(queueVC.deQueue());
            }
        }
        if (queue instanceof QueueV queueV) {
            for (int i = 0; i < queue.size(); i++) {
                this.enQueue(queueV.deQueue());
            }
        }
        if (queue instanceof QueueLC queueLC) {
            for (int i = 0; i < queue.size(); i++) {
                this.enQueue(queueLC.deQueue());
            }
        }
    }

    /**
     * This method clears out the queue by removing all the elements
     */
    @Override
    public void flush() {
        while (this.tail > 0) {
            this.queue[--this.tail] = null;
        }
    }

    /**
     * This method adds an object to the queue.
     *
     * @param obj The object to add to the queue
     */
    @Override
    public void enQueue(Object obj) {
        if (obj == null) throw new NullPointerException("Object cannot be null");
        if (this.isFull()) throw new IndexOutOfBoundsException("Queue is full");
        this.queue[tail++] = ObjectCloner.deepCopy(obj);
    }

    /**
     * This method removes an object from the queue and returns it
     *
     * @return The removed object
     */
    @Override
    public Object deQueue() {
        if (this.isEmpty()) throw new IndexOutOfBoundsException("Queue is empty");
        Object res = this.read();
        this.compress();
        return res;
    }

    /**
     * This method returns the object in the head of the queue
     *
     * @return The object in the top of the stack
     */
    @Override
    public Object read() {
        return ObjectCloner.deepCopy(this.queue[0]);
    }

    /**
     * This method returns the number of Objects contained in
     * the queue.
     *
     * @return The number of Objects contained
     */
    @Override
    public int size() {
        return this.tail;
    }

    /**
     * This method returns the max quantity of Objects that
     * the queue is able to store.
     * @return The max quantity of items
     */
    public int maxSize() {
        return this.queue.length;
    }

    /**
     * This method returns true if the stack is empty
     *
     * @return (True) If the stack is empty
     */
    @Override
    public boolean isEmpty() {
        return this.tail == 0;
    }

    /**
     * This method returns true if the stack is empty
     *
     * @return (True) If the stack is empty
     */
    @Override
    public boolean isFull() {
        return this.tail == this.queue.length;
    }

    /**
     * Compress the free positions at the start of the queue
     */
    private void compress() {
        for (int i = 1; i < this.tail; i++) {
            this.queue[i-1] = this.queue[i];
        }

        if (this.tail > 0) {
            this.queue[--this.tail] = null;
        }
    }

    /**
     * String representation of the class
     * @return String representation of the class
     */
    @Override
    public String toString() {
        return "QueueV{" +
                "queue=" + Arrays.toString(queue) +
                ", tail=" + tail +
                '}';
    }
}
