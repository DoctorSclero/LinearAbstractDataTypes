package it.iisvittorioveneto.itt.generics.observable.list;

import it.iisvittorioveneto.itt.generics.observable.iterators.ListLCTIterator;

import java.util.Iterator;

public class ListLCTI<T> extends ListLCT implements ListTAggregate<T> {


    /**
     * Returns an iterator over elements of type {@code T}.
     *
     * @return an Iterator.
     */
    @Override
    public Iterator<Object> iterator() {
        return new ListLCTIterator(this.head);
    }
}
