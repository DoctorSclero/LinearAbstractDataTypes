package it.iisvittorioveneto.itt.nongenerics.list;

import it.iisvittorioveneto.itt.nongenerics.iterators.ListLCIterator;

import java.util.Iterator;

public class ListLCI extends ListLC implements ListAggregate {


    /**
     * Returns an iterator over elements of type {@code T}.
     *
     * @return an Iterator.
     */
    @Override
    public Iterator<Object> iterator() {
        return new ListLCIterator(this.head);
    }

}
