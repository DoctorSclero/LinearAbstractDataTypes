package it.iisvittorioveneto.itt.nongenerics.list;

import it.iisvittorioveneto.itt.nongenerics.observable.list.ListAggregate;
import it.iisvittorioveneto.itt.nongenerics.observable.list.ListLCI;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IterableListLCTest {

    ListAggregate listLC;

    @BeforeEach
    void init() {
        listLC = new ListLCI();
        for (int i = 0; i < 10; i++) {
            listLC.insert(i);
        }
        this.listLC.seek(0);
    }

    @Test
    void forEachTest() {
        int i = 0;
        for (Object object : listLC ) {
            assertEquals(i++, object);
        }
    }

}