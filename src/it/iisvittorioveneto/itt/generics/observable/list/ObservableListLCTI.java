package it.iisvittorioveneto.itt.generics.observable.list;

import it.iisvittorioveneto.itt.generics.iterators.ListLCTIterator;
import it.iisvittorioveneto.itt.generics.list.ListT;

import java.util.Iterator;

public class ObservableListLCTI<T> extends ObservableListLCT<T> implements ListT<T>, Iterable<Object> {


    /**
     * Returns an iterator over elements of type {@code T}.
     *
     * @return an Iterator.
     */
    @Override
    public Iterator<Object> iterator() {
        return new ListLCTIterator<T>(this.head);
    }
}
