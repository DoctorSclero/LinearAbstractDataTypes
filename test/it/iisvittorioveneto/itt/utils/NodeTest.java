package it.iisvittorioveneto.itt.utils;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NodeTest {

    private Node test;
    private Node next;

    @BeforeEach
    void setUp() {
        String input = "Hello";
        this.test = new Node(input, null);
        this.next = new Node(input, null);
    }

    @Test
    void SetAndGetNext() {
        this.test.setNext(this.next);
        assertEquals(this.next, this.test.getNext());
    }

    @Test
    void SetAndGetObject() {
        String input = "HELLO";
        this.test.setObject(input);
        assertEquals(input, this.test.getObject());
    }
}