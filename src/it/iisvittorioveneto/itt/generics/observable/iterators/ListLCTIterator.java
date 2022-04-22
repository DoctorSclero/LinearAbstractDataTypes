package it.iisvittorioveneto.itt.generics.observable.iterators;

import it.iisvittorioveneto.itt.generics.observable.utils.TemplateNode;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class ListLCTIterator<T> implements Iterator<Object>  {
    private TemplateNode<T> cursor;

    public ListLCTIterator(TemplateNode<T> head) {
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
    public T next() {
        this.cursor = this.cursor.getNext();
        return this.cursor.getObject();
    }
}
