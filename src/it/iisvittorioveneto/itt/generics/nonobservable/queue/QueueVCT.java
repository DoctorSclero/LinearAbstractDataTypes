package it.iisvittorioveneto.itt.generics.nonobservable.queue;

import iis.itt.as2021.ObjectCloner;

import java.util.Arrays;

public class QueueVCT<T> extends QueueVT<T> {
    protected int head;

    /**
     * This constructor initializes a circular vector
     * based queue with default max length
     */
    public QueueVCT() {
        this(DEFAULT_LENGTH);
    }

    /**
     * This constructor initializes a circular vector
     * based queue with the specified max length.
     * @param length The max length of the queue
     */
    public QueueVCT(int length) {
        super(length+1);
        this.head = 0;
    }

    /**
     * This constructor initializes a circular vector
     * by copying the content from another queue
     * @param queue The queue to copy
     */
    public QueueVCT(QueueT<T> queue) {
        super(queue.size()); // If queue is null NullPointerException is thrown automatically

        queue = (QueueT<T>) ObjectCloner.deepCopy(queue);

        if (queue instanceof QueueVCT queueVC) {
            for (int i = 0; i < queue.size(); i++) {
                this.enQueue(queueVC.deQueue());
            }
        }
        if (queue instanceof QueueVT queueV) {
            for (int i = 0; i < queue.size(); i++) {
                this.enQueue(queueV.deQueue());
            }
        }
        if (queue instanceof QueueLCT queueLC) {
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
        for (; this.head != this.tail; this.head = moduleIncrement(this.head, this.queue.length))
            this.queue[this.head] = null;
        this.head = this.tail = 0;
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

        this.queue[this.tail] = ObjectCloner.deepCopy(obj);
        this.tail = moduleIncrement(this.tail, this.queue.length);
    }

    /**
     * This method removes an object from the queue and returns it
     *
     * @return The removed object
     */
    @Override
    public T deQueue() {
        T res = this.read();
        this.head = QueueVCT.moduleIncrement(this.head, this.queue.length);
        return res;
    }

    /**
     * This method returns the object in the head of the queue
     *
     * @return The object in the top of the stack
     */
    @Override
    public T read() {
        if (this.isEmpty()) throw new IndexOutOfBoundsException("Queue is empty");
        return (T) ObjectCloner.deepCopy(this.queue[this.head]);
    }

    /**
     * This method returns true if the stack is empty
     *
     * @return (True) If the stack is empty
     */
    @Override
    public boolean isEmpty() {
        return this.tail == this.head;
    }

    /**
     * This method returns true if the stack is empty
     *
     * @return (True) If the stack is empty
     */
    @Override
    public boolean isFull() {
        return QueueVCT.moduleIncrement(this.tail, this.queue.length) == this.head;
    }

    /**
     * This method increments the variable and returns
     * the modulo between the incremented variable and
     * the unit passed as parameter.
     * @param num The variable to increment
     * @param unit The unit of the modulo
     * @return (num+1) mod (unit + 1)
     */
    private static int moduleIncrement(int num, int unit) {
        return (++num) % unit;
    }

    /**
     * This method returns the number of Objects contained in
     * the queue.
     *
     * @return The number of Objects contained
     */
    @Override
    public int size() {
        return (this.tail >= this.head ? this.tail - this.head : this.tail + (this.queue.length - this.head));
    }

    /**
     * String representation of the class
     * @return String representation of the class
     */
    @Override
    public String toString() {
        return "QueueVC {" +
                "queue=" + Arrays.toString(queue) +
                ", tail=" + tail +
                ", head=" + head +
                '}';
    }
}
