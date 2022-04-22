package it.iisvittorioveneto.itt.nongenerics.observable.iterators;

import it.iisvittorioveneto.itt.nongenerics.observable.utils.Node;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class ListLCIterator implements Iterator<Object>  {
    private Node cursor;

    public ListLCIterator(Node head) {
        this.cursor = head;
    }

    /**
     * Returns {@code true} if the iteration has more elements.
     * (In other words, returns {@code true} if {@link #next} would
     * return an element rather than throwing an exception.)
     *
     * @return {@code true} if the iteration has more elements
     */
    public boolean hasNext() {
        return cursor.getNext() != null;
    }

    /**
     * Returns the next element in the iteration.
     *
     * @return the next element in the iteration
     * @throws NoSuchElementException if the iteration has no more elements
     */
    @Override
    public Object next() {
        this.cursor = this.cursor.getNext();
        return this.cursor.getObject();
    }
}
