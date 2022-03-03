package it.iisvittorioveneto.itt.stack;


import java.io.Serializable;

public interface Stack extends Serializable, Cloneable {
    /**
     * This method returns the size of the stack
     * @return The stack size
     */
    int     size();

    /**
     * This method clears out the stack by removing all the elements
     */
    void    flush();

    /**
     * This method adds an object to the stack.
     * @param obj The object to add to the stack
     */
    void    push(Object obj);

    /**
     * This method removes an object from the stack and returns it
     * @return The removed object
     */
    Object  pop();

    /**
     * This method returns the object in the top of the stack
     * @return The object in the top of the stack
     */
    Object  top();

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
