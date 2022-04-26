package it.iisvittorioveneto.itt.nongenerics.list;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ListLCTest {

    ListLC listLC;

    @BeforeEach
    void init() {
        listLC = new ListLC();
        for (int i = 0; i < 10; i++) {
            listLC.insert(i);
        }
        this.listLC.seek(0);
    }

    @Test
    void tooString() {
        System.out.println(listLC);
    }


    @Test
    void flush() {
        listLC.flush();

        assertNull(listLC.head.getNext());
        assertEquals(0, listLC.size());
    }

    @Test
    void insert() {
        this.listLC.insert(11);
        assertEquals(11, this.listLC.read());
        assertEquals(11, this.listLC.size());
    }

    @Test
    void read() {
        assertEquals(0, this.listLC.read());
    }

    @Test
    void extract() {
        assertEquals(0, this.listLC.extract());
        assertEquals(1, this.listLC.read());
    }

    @Test
    void size() {
        assertEquals(10, this.listLC.size());
    }

    @Test
    void reset() {
        this.listLC.seek(3);
        this.listLC.reset();
        assertEquals(0, this.listLC.peek());
    }

    @Test
    void moveNext() {
        this.listLC.seek(this.listLC.size()-1);
        assertTrue(this.listLC.moveNext());
        assertFalse(this.listLC.moveNext());
    }

    @Test
    void hasNext() {
        this.listLC.seek(this.listLC.size());

    }

    @Test
    void isEmpty() {
        assertFalse(this.listLC.isEmpty());
        this.listLC.flush();
        assertTrue(this.listLC.isEmpty());
    }

    @Test
    void isFull() {
        assertFalse(this.listLC.isFull());
    }

    @Test
    void seek() {
        this.listLC.seek(0);
        // Check functionalities
        assertEquals(this.listLC.cursor.getNext(), this.listLC.head.getNext());
        // Check functionalities
        this.listLC.seek(1);
        assertEquals(this.listLC.cursor.getNext(), this.listLC.head.getNext().getNext());
        // Check ranges
        assertTrue(this.listLC.seek(0));
        assertFalse(this.listLC.seek(100));
        assertFalse(this.listLC.seek(-2));
    }

    @Test
    void peek() {
        this.listLC.seek(0);
        assertEquals(0, this.listLC.peek());
    }
}