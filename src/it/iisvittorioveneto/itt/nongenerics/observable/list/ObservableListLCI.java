package it.iisvittorioveneto.itt.nongenerics.observable.list;

import it.iisvittorioveneto.itt.nongenerics.iterators.ListLCIterator;
import it.iisvittorioveneto.itt.nongenerics.list.List;

import java.util.Iterator;

public class ObservableListLCI extends ObservableListLC implements List, Iterable<Object> {


    /**
     * Returns an iterator over elements of type Object.
     *
     * @return an Iterator.
     */
    @Override
    public Iterator<Object> iterator() {
        return new ListLCIterator(this.head);
    }

}
