package it.iisvittorioveneto.itt.queue;

import java.io.Serializable;

public interface Queue extends Cloneable, Serializable {
    /**
     * This method clears out the queue by removing all the elements
     */
    void    flush();

    /**
     * This method adds an object to the queue.
     * @param obj The object to add to the queue
     */
    void    enQueue(Object obj);

    /**
     * This method removes an object from the queue and returns it
     * @return The removed object
     */
    Object  deQueue();

    /**
     * This method returns the object in the head of the queue
     * @return The object in the top of the stack
     */
    Object  read();

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
