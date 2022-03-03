package it.iisvittorioveneto.itt.queue;

import iis.itt.as2021.ObjectCloner;
import it.iisvittorioveneto.itt.utils.Node;

/**
 * This class represents a list based Queue
 * all the content has
 *
 * @author pietro.ballarin
 */
public class QueueLC implements Queue {

    protected Node head;
    protected Node tail;
    protected int  size;

    /**
     * This constructor initializes a new list based Queue
     * with no nodes.
     */
    public QueueLC() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    /**
     * This constructor initializes a new list based Queue
     * with a new node with $object content
     * @param object The first node content
     */
    public QueueLC(Object object) {
        this();
        this.enQueue(object);
    }

    /**
     * This constructor initializes a queue
     * from another queue by copying its content
     * @param queue The queue to copy
     */
    public QueueLC(Queue queue) {
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
    public void enQueue(Object obj) {
        Node newNode = new Node(obj);

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
    public Object deQueue() {
        Object res = this.read();
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
    public Object read() {
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
