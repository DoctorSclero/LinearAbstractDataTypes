package it.iisvittorioveneto.itt.nongenerics.list;

public interface List {
    /**
     * This method clears out the list by removing all the elements
     */
    void flush();

    /**
     * This method inserts a new node in the position next to the
     * node pointed by the cursor.
     */
    boolean insert(Object object);

    /**
     * This method reads the current element and returns it
     * @return The current element
     */
    Object read();

    /**
     * This method removes the current element and returns it
     * @return The current element
     */
    Object extract();

    /**
     * This method calculates the number of elements in the list
     * @return The number of elements
     */
    int size();

    /**
     * This method sets the cursor to the element 0 in the list
     */
    void reset();

    /**
     * This method moves the cursor to the next element
     * @return (true) if successful
     */
    boolean moveNext();

    /**
     * This method checks if the cursor isn't pointing to the
     * last element
     * @return (true) if the cursor isn't pointing to the last element
     */
    boolean hasNext();

    /**
     * This method checks if there are no elements in the list
     * @return (true) if there are no elements
     */
    boolean isEmpty();
    /**
     * This method checks if the list reached the maximum size
     * @return (true) if the list reached its size limit
     */
    boolean isFull();

    /**
     * Moves the cursor to the index(th) element of the list
     * from the beginning of the list
     * @param index The index of the element to select
     * @return (true) if operation is successful
     */
    boolean seek(int index);

    /**
     * This method returns the current position of the cursor
     * @return The position of the cursor
     */
    int peek();
}
