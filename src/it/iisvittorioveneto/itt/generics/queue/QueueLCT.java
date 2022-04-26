package it.iisvittorioveneto.itt.generics.queue;

import iis.itt.as2021.ObjectCloner;
import it.iisvittorioveneto.itt.generics.utils.TemplateNode;

/**
 * This class represents a list based Queue
 * all the content has
 *
 * @author pietro.ballarin
 */
public class QueueLCT<T> implements QueueT<T> {

    protected TemplateNode<T> head;
    protected TemplateNode<T> tail;
    protected int  size;

    /**
     * This constructor initializes a new list based Queue
     * with no nodes.
     */
    public QueueLCT() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    /**
     * This constructor initializes a new list based Queue
     * with a new node with $object content
     * @param object The first node content
     */
    public QueueLCT(T object) {
        this();
        this.enQueue(object);
    }

    /**
     * This constructor initializes a queue
     * from another queue by copying its content
     * @param queue The queue to copy
     */
    public QueueLCT(QueueT<T> queue) {
        if (queue == null) throw new NullPointerException("Queue cannot be null");

        queue = (QueueT<T>) ObjectCloner.deepCopy(queue);

        if (queue instanceof QueueVCT<T> queueVCT) {
            for (int i = 0; i < queue.size(); i++) {
                this.enQueue(queueVCT.deQueue());
            }
        }
        if (queue instanceof QueueVT<T> queueVT) {
            for (int i = 0; i < queue.size(); i++) {
                this.enQueue(queueVT.deQueue());
            }
        }
        if (queue instanceof QueueLCT<T> queueLCT) {
            for (int i = 0; i < queue.size(); i++) {
                this.enQueue(queueLCT.deQueue());
            }
        }
    }

    /**
     * This method clears out the queue by removing all the elements
     */
    @Override
    public void flush() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    /**
     * This method adds an object to the queue.
     *
     * @param obj The object to add to the queue
     */
    @Override
    public void enQueue(T obj) {
        TemplateNode<T> newNode = new TemplateNode<>(obj);

        if (this.head != null) {
            this.tail.setNext(newNode);
        } else {
            this.head = newNode;
        }
        this.tail = newNode;
        this.size++;
    }

    /**
     * This method removes an object from the queue and returns it
     *
     * @return The removed object
     */
    @Override
    public T deQueue() {
        T res = this.read();
        this.head = this.head.getNext();
        this.size--;
        return res;
    }

    /**
     * This method returns the object in the head of the queue
     *
     * @return The object in the top of the stack
     */
    @Override
    public T read() {
        if (isEmpty()) throw new IndexOutOfBoundsException("Queue is empty");
        return this.head.getObject();
    }

    /**
     * This method returns the number of Objects contained in
     * the queue.
     *
     * @return The number of Objects contained
     */
    @Override
    public int size() {
        return this.size;
    }

    /**
     * This method returns true if the stack is empty
     *
     * @return (True) If the stack is empty
     */
    @Override
    public boolean isEmpty() {
        return (this.head == null);
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
        return "QueueLC{" +
                "head=" + head +
                ", tail=" + tail +
                '}';
    }
}
