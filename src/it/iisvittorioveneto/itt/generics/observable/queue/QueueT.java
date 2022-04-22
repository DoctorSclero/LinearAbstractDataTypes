package it.iisvittorioveneto.itt.generics.observable.queue;

import java.io.Serializable;

public interface QueueT<T> extends Cloneable, Serializable {
    /**
     * This method clears out the queue by removing all the elements
     */
    void    flush();

    /**
     * This method adds an object to the queue.
     * @param obj The object to add to the queue
     */
    void    enQueue(T obj);

    /**
     * This method removes an object from the queue and returns it
     * @return The removed object
     */
    T  deQueue();

    /**
     * This method returns the object in the head of the queue
     * @return The object in the top of the stack
     */
    T  read();

    /**
     * This method returns the number of Objects contained in
     * the queue.
     * @return The number of Objects contained
     */
    int size();

    /**
     * This method returns true if the stack is empty
     * @return (True) If the stack is empty
     */
    boolean isEmpty();

    /**
     * This method returns true if the stack is empty
     * @return (True) If the stack is empty
     */
    boolean isFull();
}
