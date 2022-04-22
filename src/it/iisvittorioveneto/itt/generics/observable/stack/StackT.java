package it.iisvittorioveneto.itt.generics.observable.stack;


import java.io.Serializable;

public interface StackT<T> extends Serializable, Cloneable {
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
    void    push(T obj);

    /**
     * This method removes an object from the stack and returns it
     * @return The removed object
     */
    T  pop();

    /**
     * This method returns the object in the top of the stack
     * @return The object in the top of the stack
     */
    T  top();

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
